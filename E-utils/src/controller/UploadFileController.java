package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import exception.FileException;

@Controller
public class UploadFileController {

	@Autowired
	private HttpServletRequest request;
	private String outputFileName = "simple_count_";
	//private String outputFileType = ".xls";
	private String perlScriptPath = "/resources/rxnorm_simpl_count_mesh_file_final_parse.pl";
	private String[] validFormat = new String[] { "xls" };
	private String perlPath = "perl";
	//private String perlPath = "C:/Strawberry/perl/bin/perl.exe";

	@RequestMapping(value = "index.html")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping(value = "fileUpload.html")
	public ModelAndView fileHandler(@RequestParam("file") MultipartFile file, @RequestParam("outputFormat") String outputFormat) {
		ModelAndView mav = null;
		if (!file.isEmpty()) {
				if (fileValidation(file)) {
					try {
						File outputFile = processFile(file, outputFormat);
						String path = outputFile.getAbsolutePath();
						String fileName = outputFile.getName();
						mav = new ModelAndView("home");
						mav.addObject("filePath", path);
						mav.addObject("fileName", fileName);
					} catch (Exception e) {
						mav = errorHandle(e);
					}
				} else {
					mav = errorHandle(new FileException("Error: Invalid File Format."));
				}
		} else {
			mav = errorHandle(new FileException("Please select a file."));
		}
		return mav;
	}

	public boolean fileValidation(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		int i = fileName.lastIndexOf('.');
		if (!(i > 0 && Arrays.asList(validFormat).contains(
				fileName.substring(i + 1)))) {
			return false;
		} else {
			// more detail validation
		}
		return true;
	}

	public ModelAndView errorHandle(Exception e) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("error", e.getMessage());
		return mav;
	}

	public File processFile(MultipartFile file, String outputFormat) throws URISyntaxException,
			IllegalStateException, IOException, InterruptedException, Exception {
		String folderPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "upload";
		File f = new File(folderPath);
		if (!(f.exists() && f.isDirectory())) {
			f.mkdir();
		}
		String filePath = folderPath + "/" + file.getOriginalFilename();
		String scriptPath;
		File outputFile;
		String url = this.getClass().getResource(perlScriptPath).toURI()
				.getPath().substring(1);
		scriptPath = url.toString();
		file.transferTo(new File(filePath.toString()));
		/*
		 * BufferedWriter bw = new BufferedWriter(new FileWriter( folderPath +
		 * "/output.txt")); bw.write("success"); bw.flush(); bw.close(); return
		 * new File(folderPath + "/output.txt");
		 */
		String fileName = buildFileName(outputFormat);
		Process proc = Runtime.getRuntime().exec(
				perlPath + " /" + scriptPath + " " + filePath + " " + folderPath
						+ "/" + fileName);
		//System.out.println(perlPath + " " + scriptPath + " " + filePath + " " + folderPath
				//+ "/" + fileName);
		int exitCode;
		exitCode = proc.waitFor();
		
		InputStream is = proc.getErrorStream();
		if (is.available() != 0){
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine = "Error: ";
			String line;
			while ((line = in.readLine()) != null)
				inputLine = inputLine + line;
			in.close();
			throw(new FileException(inputLine));
		}else{
			if (exitCode != 0) {
				outputFile = null;
				throw(new FileException("Error: File processing has encounter an issue."));
			} else {
				outputFile = new File(folderPath + "/" + fileName);
			}
		}

		return outputFile;
	}

	public String buildFileName(String outputFormat) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String dateParsed = format.format(date);
		return outputFileName + dateParsed + "." + outputFormat;
	}

	@RequestMapping(value = "{fileName:.+}")
	public ModelAndView getFile(@PathVariable String fileName,
			HttpServletResponse response) {
		ModelAndView mav = null;
		try {
			String folderPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload";
			InputStream is = new FileInputStream(new File(folderPath + "/"
					+ fileName));
			response.setContentType("application/xls");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			mav = errorHandle(e);
		}
		return mav;
	}
}

<html style="min-height:100%;position:relative">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head> 
<body style="background-color: #215489; font-family: Verdana,Helvetica,Arial,sans-serif; text-align:center;">
<script type="text/javascript">
	$(document).ready(function(){
		var file = '<input type="file" name="file">' ;
		$("[name=clearButton]").click(function(){
			$("[name=file]").replaceWith(file);
		});
	});
</script>
<div style="width: 1100px; margin: 20px auto; display: block; ">
	<div style="display:table-cell; vertical-align:middle; height: 100%;">
		<img src="images/meshBannerNew.jpg" alt="e-utils" style="width: 1100px;"/>
	</div>
	<div style="background-color: #ffffff;">
		<div style=" margin: auto; background-color: #333; padding: 20px; ">
			<strong style="font-size: 12px; color: #ffffff; ">
				* Instruction: This utility will accept an excel spreadsheet with a list of term names in the first column (no column headings). It will output a file to download containing the term names followed by 2 columns for the number of hits in PubMed titles and number of hits in PubMed titles/abstracts.
			</strong>
		</div>
		<div style="background-color: #cbddfe; width: 700px; margin: auto; margin-top: 60px; margin-bottom: 60px;">
			<form action="fileUpload.html" method="post" enctype="multipart/form-data">
			<div style="background-color: #215489; margin-bottom: 30px;">
				<p style="font-size: 12px; text-align: left; display: block; color: #ffffff; padding: 5px;">Step 1 - Select XLS or XLSX file from your file system</p>
			</div>
				<input type="file" name="file">
			<div style="background-color: #215489; margin-top: 30px; margin-bottom: 30px;">
				<p style="font-size: 12px; text-align: left; display: block; color: #ffffff; padding: 5px;">Step 2 - Select output file format</p>
			</div>
				<div style="padding-top: 10px; padding-bottom: 30px">
					<input type="radio" name="outputFormat" value="xls" />
						<font style="font-size: 12px;">XLS</font>&nbsp;&nbsp;&nbsp;
					<input type="radio" name="outputFormat" value="xlsx" />
						<font style="font-size: 12px;">XLSX</font>
					<input type="button" value="Clear" style="width: 80px; margin-left: 20px;" name="clearButton">
					<input type="submit" value="Submit" style="width: 80px; ">
					<c:if test="${not empty error}">
						<h4 style="color: red;">${error}</h4>
					</c:if>
				</div>
			</form>
			<c:if test="${not empty fileName}">
				<div style="background-color: #215489; margin-bottom: 30px;">
					<p style="font-size: 12px; text-align: left; display: block; color: #ffffff; padding: 5px;">Output file</p>
				</div>
				<font style="font-size: 12px;">&nbsp;&nbsp; ${fileName}&nbsp;&nbsp; - <a href="download/${fileName}">Download</a> -</font><br/><br/><br/>
			</c:if>
		</div>
		<hr style="">
		<div style="text-align: center;">
			<FONT size=2 face="helvetica, arial">
				<A href="http://www.nlm.nih.gov/" target=_blank>U.S. National Library of Medicine</A>, 8600 Rockville Pike, Bethesda, MD 20894 
				<BR><A href="http://www.nih.gov/" target=_blank>National Institutes of Health</A>
				<BR><A href="http://www.dhhs.gov/" target=_blank>Department of Health &amp; Human Services</A>
				<BR>
			</FONT>
		</div>
	</div>
</div>
</body>
</html>
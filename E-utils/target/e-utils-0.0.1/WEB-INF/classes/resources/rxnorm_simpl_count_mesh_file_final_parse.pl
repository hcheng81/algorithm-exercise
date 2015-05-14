#!/usr/bin/perl
use strict;
use warnings;
use LWP::Simple;
use Spreadsheet::WriteExcel;
use Spreadsheet::ParseExcel;


# Download PubMed records that are indexed in MeSH for both asthma and
 # # leukotrienes and were also published in 2009.
 #
my  $db = 'pubmed';
my $dir = $ARGV[1] or die "Need to get dir name on the command line\n";
#print $dir;
my $workbook = Spreadsheet::WriteExcel->new($dir);
 $workbook->compatibility_mode();
my $worksheet = $workbook->add_worksheet();

# Create a format for the column headings
 my $header = $workbook->add_format(border=>1, color=>'black');
 $header->set_bold();
 $header->set_font("Arial");
 $header->set_align('center');
 $header->set_align('vcenter');
 $worksheet->set_column(0,0,50);
 $worksheet->set_column(1,1,20);
 $worksheet->set_column(2,2,35);
 my $cell_format = $workbook->add_format(border=>1, color=>'black');
 $cell_format->set_text_wrap();
 my $row = 0;
 my $col = 0;
#Write the column labels.
$worksheet->write_row($row, $col,
    ['STRING','NO_OF_TITLE_HITS','NO_OF_TITLE/ABSTRACT_HITS'],$header);

my $file = $ARGV[0] or die "Need to get file on the command line\n";
#print  $file;
#open(my $data, '<', $file) or die "Could not open '$file' $!\n";
my $parser = Spreadsheet::ParseExcel->new();
           my $workbook1 = $parser->parse("$file");
 if ( !defined $workbook1 ) {
               die $parser->error(), ".\n";
           }

           for my $worksheet1 ( $workbook1->worksheets() ) {

               my ( $row_min, $row_max ) = $worksheet1->row_range();
               my ( $col_min, $col_max ) = $worksheet1->col_range();

               for my $row ( $row_min .. $row_max ) {
                   for my $col ( $col_min .. $col_max ) {

                       my $cell = $worksheet1->get_cell( $row+1, $col );
                       next unless defined $cell;

#                       print "Row, Col    = ($row, $col)\n";
 #                      print "Value       = ", $cell->value(),       "\n";
  #                     print "Unformatted = ", $cell->unformatted(), "\n";
   #                    print "\n";
my $line=$cell->value();
#print $line;
 #                  }
  #             }
   #        }
 chomp $line;
my $query = $line;
      
$query=~ s/ /+/g;
#print $query;
   #assemble the esearch URL
  my $base = 'http://eutils.ncbi.nlm.nih.gov/entrez/eutils/';
  my $url_title = $base . "esearch.fcgi?db=$db&term=$query%5BTitle%5D";
  my $url_abstract = $base . "esearch.fcgi?db=$db&rettype=count&term=$query%5BTitle%2FAbstract%5D"; 
#post the esearch URL
 my $output_title = get($url_title);
die "Couldn't get $url_title" unless defined $output_title;
my $output_abstract = get($url_abstract);
die "Couldn't get $url_abstract" unless defined $output_abstract;

#parse WebEnv and QueryKey
                                my  $title_count= $1 if ($output_title =~ /<Count>(\d+)<\/Count>/);
                                my  $abstract_count= $1 if ($output_abstract =~ /<Count>(\d+)<\/Count>/);
                                my  $result=$line . '|' . $abstract_count . '|' . $title_count . "\n";

foreach($line)
{
                $row++;
                $worksheet->write( $row, 0,$line,$cell_format);
                $worksheet->write( $row, 1,$title_count,$cell_format);
                $worksheet->write( $row, 2,$abstract_count,$cell_format);
}

}


}
}


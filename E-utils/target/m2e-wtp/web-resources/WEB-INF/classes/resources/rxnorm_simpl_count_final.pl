#!/usr/bin/perl
use strict;
use warnings;
use LWP::Simple;
use LWP::UserAgent;


## Download PubMed records that are indexed in MeSH for both asthma and
# # # leukotrienes and were also published in 2009.

  my  $db = 'pubmed';
   unlink '/usr/nlm/rxnorm/TEST/simple_count.csv';
    my $file = $ARGV[0] or die "Need to get input file on the command line\n";
    my $outputfile = $ARGV[1] or die "Need to get output file path on the command line\n";
   open(my $data, '<', $file) or die "Could not open '$file' $!\n";
   while (my $line = <$data>) {
    chomp $line;
     my $query = $line;


    $query=~ s/ /+/g;
    #print $query;
       #assemble the esearch URL
       my  $base = 'http://eutils.ncbi.nlm.nih.gov/entrez/eutils/';
         my    $url_title = $base . "esearch.fcgi?db=$db&term=$query%5BTitle%5D";
           my    $url_abstract = $base . "esearch.fcgi?db=$db&rettype=count&term=$query%5BTitle%2FAbstract%5D";
               #post the esearch URL
               #my $ua = LWP::UserAgent->new;
               #$ua->env_proxy;

            my    $output_title = get($url_title);

               #print "HTTP response code was: ", $output_title->status_line, "\n";

               #print "Content was:\n", $output_title->content, "\n";
                # $output_title = get($url_title);
                #die "Couldn't get $url_title" unless defined $output_title;
                #$output_abstract = get($url_abstract);
                #die "Couldn't get $url_abstract" unless defined $output_abstract;
               # my $ua = LWP::UserAgent->new;
               # $ua->env_proxy;

              my   $output_abstract = get($url_abstract);

 #               print "HTTP response code was: ", $output_abstract->status_line, "\n";
#
  #              print "Content was:\n", $output_abstract->content, "\n";

                #parse WebEnv and QueryKey
       my  $title_count= $1 if ($output_title =~ /<Count>(\d+)<\/Count>/);
       my  $abstract_count= $1 if ($output_abstract =~ /<Count>(\d+)<\/Count>/);
       my  $result=$line . ',' . $abstract_count . ',' . $title_count . "\n";

   open(my $fh, '>>', $outputfile) or die "Could not open file: $!";
    print $fh $result ;
    close $fh;
    }

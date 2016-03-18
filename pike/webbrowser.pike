#! /usr/bin/env pike

// The Very Simple World Wide Web Browser
import Protocols.HTTP;

void handle_url(string this_url)
{
  write("Fetching URL '" + this_url + "'...");
  //Protocols.HTTP.Query web_page;
  Query web_page = Protocols.HTTP.get_url(this_url);
  if(web_page == 0)
  {
    write(" Failed!\n");
    return;
  }
  write(" Done.\n");
  write("This is the contents of '" + this_url + "':\n\n");
  string page_contents = web_page->data();
  write(page_contents + "\n");
} // handle_url

int main(int argc, array(string) argv)
{
  write("Welcome to the Very Simple WWW Browser!\n");
  string url;
  if(argc == 1)
  {
    do
    {
      write("Type the address of the web page:\n");
      url = Stdio.stdin->gets();
    } while(sizeof(url) == 0);
  }
  else if(argc == 2)
  {
    url = argv[1];
  }
  else
  {
    write("Too many arguments. Goodbye. Sorry.\n");
    return 1;
  }
  handle_url(url);
  return 0;
} // main


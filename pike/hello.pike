#! /usr/bin/env pike

int main(int argc, array(string) argv)
{
  write("Welcome to the Very Simple WWW Browser!\n");

  string url;
  if(argc == 2) {
    url = argv[1];
  } else {
    write("Type the address of the web page:\n");
    url = Stdio.stdin->gets();
  }

  write("URL: " + url + "\n");
  return 0;
}

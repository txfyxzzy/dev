#! /usr/bin/env pike

void write_one(int x)
{
  write("Number: " + x + "\n");
}

int main()
{
  array(int) all_of_them = ({ 1, 5, -1, 17, 17 });
  map(all_of_them, write_one);
  return 0;
}

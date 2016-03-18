#include "stdio.h"

int add(int a, int b)
{
  return a+b;
}

int main(int argc, char* argv[])
{
  if (argc >= 2) {
    printf("arv[1] = %s", argv[1]);
    return 0;
  }
  int i = 0;
  int j = add(1,2);
  printf("hello world! %d, %d", i,j);
  return 0;
}



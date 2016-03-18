#include <stdio.h>

bool open_read()
{
	printf("open_read\n");
	return true;
}

bool open_write()
{
	printf("open_write\n");
	return true;
}

int main(int argc, char* argv[])
{
	int i=0, j=0;
	j = i++;
	printf("i=%d,j=%d\n", i, j);
	j = ++i;
	printf("i=%d,j=%d\n", i, j);
	
	i = 2;
	if (i>1) {
		printf("if\n");
	} else if (i > 0) {
		printf("else-if\n");
	} else {
		printf("else\n");
	}
	
	if (open_read() || open_write()) {
		printf("read or write\n");
	}
	
	return 0;
}

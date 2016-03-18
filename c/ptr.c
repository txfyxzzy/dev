#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	char *text = (char*)malloc(20);
	memset(text, 0, 20);
	char *str = "hello world!";
	memcpy(text, str, strlen(str));
	printf("%s\n", text);
	
	char *p = text + 10;
	int len = (int)(p - text);
	printf("%s, %d\n", p, len);

	free(text);
	return 0;
}

.PHONY:all clean

all:socketclient socketserver

socketclient:socketclient.o
	gcc -o socketclient socketclient.o
socketserver:socketserver.o
	gcc -o socketserver socketserver.o

socketclient.o:socketserver.c
	gcc -c socketclient.c
socketserver.o:socketserver.c
	gcc -c socketserver.c

clean:
	rm socketclient socketserver socketclient.o socketserver.o
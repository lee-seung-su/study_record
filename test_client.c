//Âü°í : http://forum.falinux.com/zbxe/index.php?mid=C_LIB&page=2&document_srl=420636
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>

#define BUFF_SIZE 1024
#define SOCKET_ERROR -1
int main(int argc, char** argv){
    int server_socket;

    struct sockaddr_in server_addr;
    char buff[BUFF_SIZE];

    server_socket = socket(PF_INET, SOCK_STREAM, 0);
    if(SOCKET_ERROR == server_socket){
        printf("socket error\n");
        exit(1);
    }
    memset(&server_addr, 0 ,sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(4000);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if(SOCKET_ERROR == connect(server_socket, (struct sockaddr*)&server_addr, sizeof(server_addr))){
        printf("connect error\n");
        exit(1);
    }
    while(1){
	printf("--> ");
        scanf("%s",buff);
        send(server_socket, buff, sizeof(buff),0);
        memset(buff, 0, BUFF_SIZE);
        recv(server_socket, buff, BUFF_SIZE,0);
        printf("server -> %s\n", buff);
        memset(buff, 0, BUFF_SIZE);
    }
    closesocket(server_socket);
    return 0;

}

//Âü°í : http://forum.falinux.com/zbxe/index.php?mid=C_LIB&page=2&document_srl=420636
//#include <WinSock2.h>
#include <stdio.h>

//#pragma comment(lib, "ws2_32.lib")
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <pthread.h>


#define BUFF_SIZE  1024
#define SOCKET_ERROR -1
#define MAX_CLIENT 100

int client_cnt =0;
int client_socks[MAX_CLIENT];
pthread_mutex_t mutx


int main(int argc, char* argv[]){
   // WSADATA was;
   // if(WSAStartup(MAKEWORD(2,2), &wsa) !=0){
   //     printf("not equal version\n");
   //     exit(1);
   // }
    int server_socket;
    int client_socket;
    int client_addr_size;

    char buff_rcv[BUFF_SIZE];
    char buff_snd[BUFF_SIZE];
    
    struct sockaddr_in server_addr;
    struct sockaddr_in client_addr;

    pthread_t t_id;

    if(argc !=2){
	printf("Usage : %s <port>\n", argv[0]);
	exit(1);
    }
    printf("char program\n");
    printf("server port : %s\n", port);
    printf("max connection : %s\n", MAX_CLIENT);

    pthread_mutex_init(&mutx, NULL);

    server_socket = socket(PF_INET, SOCK_STREAM, 0);
    if(SOCKET_ERROR==server_socket){
        printf("socket error\n");
        exit(1);
    }
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[1]));
    server_addr.sin_addr.s_addr=htonl(INADDR_ANY);

    if(SOCKET_ERROR==bind(server_socket, (struct sockaddr* )&server_addr, sizeof(server_addr))){
        printf("bind error\n");
        exit(1);
    }
    if(SOCKET_ERROR == listen(server_socket, 5)){
        printf("listen error\n");
        exit(1);
    }
    while(1){
        client_addr_size = sizeof(client_addr);
        client_socket = accept(server_socket, (struct sockaddr*)&client_addr, &client_addr_size);

        if(SOCKET_ERROR == client_socket){
            printf("accept error\n");
            exit(1);
        }
	pthread_mutex_lock(&mutx);
	client_socks[client_cnt]=client_socket;
	client_cnt++;
	pthread_mutex_unlock(&mutx);

	pthread_create(&t_id, NULL, handle_client, (void*)&client_socket);
	pthread_detach(t_id);

        recv(client_socket, buff_rcv, sizeof(buff_rcv),0);
        printf("client -> %s\n", buff_rcv);
        memset(buff_snd, 0, BUFF_SIZE);
	printf("--> ");
        scanf("%s", buff_snd);
        send(client_socket, buff_snd, sizeof(buff_snd),0);
    }
    closesocket(client_socket);
    closesocket(server_socket);
   // WSACleanup();
    return 0;
}
void * handle_client(void *arg){
	int client_socket=((int*)arg);
	int str_len=0, i;
	char buff_recv[BUFF_SIZE];
	while((str_len==read(client_socket, buff_recv, sizeof(buff_recv)))!=0){
		send(

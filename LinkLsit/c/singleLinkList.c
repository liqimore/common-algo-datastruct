#include <stdio.h>
#include <stdlib.h>


#define MAXLEN 128

typedef struct DATATYE {
	char rank;
	int num;
}DATA;

typedef struct SLNODE {
	DATA data;
	struct SLNODE * next;
}SLNODE;

SLNODE * init_slist();
//slist means the head of the single linked list
int add_elem(SLNODE * slist);
int del_elem(SLNODE * slist, DATA data);
int ins_elem(SLNODE * slist, DATA data, int pos);
int search_elem(SLNODE * slist, DATA data);



//creat an empty head node point to null
SLNODE * init_slist(){
	
	SLNODE * newNode;
	newNode = (SLNODE *)malloc(sizeof(SLNODE));
	if (!newNode) {
		exit(-1);
	}
	//head pointer point to NULL
	newNode->next = NULL;
	
	//the below is to add value to this single linked list
	/*
	int n,temp;
	printf("input the number of elements you what to add:");
	scanf("%d", &n);
	while (n!=0) {
		//statement
	}
	*/
	return newNode;
}

//keep reading elements until manual stop
//return the number of elements that recived
int add_elem(SLNODE * slist){
	int n;
	int flag;
	SLNODE * temp;
	while (flag != 0) {
		temp = (SLNODE *)malloc(sizeof(SLNODE));
		printf("\ninput rank:");
		scanf("%c",&temp->data.rank);
		printf("input num:");
		scanf("%d", &n);
		temp->next = NULL;
		slist->next = temp;
		temp = NULL;
		printf("dou you wand to add more? 0 for stop, 1 for add more");
		scanf("%d", &flag);
	}
	return 0;
}

int del_elem(SLNODE * slist, DATA data){
	SLNODE * temp = slist;

	if (slist->next != NULL) {
		return 0;
	}
	while (temp->next != NULL) {
		
		if (temp->next->data.rank == data.rank && temp->next->data.num == data.num) {
			temp->next = temp->next->next;
			break;
		}
		temp = temp->next;
	}
	return 1;
}

//pos starts from 0
int ins_elem(SLNODE * slist, DATA data, int pos){
		int counter = 0;
		SLNODE * temp = slist;
		SLNODE * dataNode = (SLNODE *)malloc(sizeof(SLNODE));
		dataNode->next = NULL;
		
		if (slist->next != NULL) {
			return 0;
		}
		while (temp->next != NULL) {
			
			if (counter == pos) {
				dataNode->next = temp->next->next;
				temp->next = dataNode;
				break;
			}
			counter++;
			temp = temp->next;
		}
		return 1;
}

int search_elem(SLNODE * slist, DATA data){
	int counter = 0;
	SLNODE * temp = slist;
	SLNODE * dataNode = (SLNODE *)malloc(sizeof(SLNODE));
	dataNode->next = NULL;
	
	if (slist->next != NULL) {
		return 0;
	}
	while (temp->next != NULL) {
		
		if (temp->next->data.rank == data.rank && temp->next->data.num == data.num) {
			return counter;
		}
		counter++;
		temp = temp->next;
	}
	return 1;
}

int main(int argc, char *argv[]) {
	SLNODE * slist = init_slist();
	add_elem(slist);
	
	printf("hello world\n");
}	

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define  MAXLEN 128


//self made data type
typedef struct DATATYPE {
	int Sno;
	char Name[64];
	char Sex;
}NODE;

//ADT
typedef struct SEQLIST {
	int len;
	NODE DATA[MAXLEN];
}SEQLIST;
 
int init_seqlist(SEQLIST * list); //initial seq list
int seqlist_delete(SEQLIST * list, int pos);//delete a NODE by given pos
int seqlist_insert(SEQLIST * list, int pos, NODE * newNode);//insert by given postion and newNode

/* not necessary */
int seqlist_deleteByKey(SEQLIST * list, NODE * nodeDel); // delete by given NODE and seq list
int seqlist_insertByKey(SEQLIST * list, NODE * newNode); // insert a new node without given postion


int seqlist_searchByKey(SEQLIST * list, NODE * nodeKey); //search a node by given node, return where the node is
NODE * seqlist_getValByPos(SEQLIST * list, int pos); // get NODE By a given pos
void showSeqListAll(SEQLIST * list);

/**
* Start implement the functions
*/

//return 1 means success else false
int init_seqlist(SEQLIST * list){
	//allocate memory
	list = (SEQLIST *)malloc(sizeof(SEQLIST));
	if (!list) {
		return 1;
	}
	//set length to 0
	list->len = 0;
	return 0;
}

//return 1 delete success else false
int seqlist_delete(SEQLIST * list, int pos){
	if (list->len == 0) {
		return 0;
	}
	for(int i = pos; i < list->len; i++){
		list->DATA[i] = list->DATA[i+1];
	}
	list->len--;
	return 1;
}

int seqlist_insert(SEQLIST * list, int pos, NODE * newNode){
	if (list->len < pos || pos < 0) {
			return 0;
		}
		for(int i = list->len; i < pos; i--){
			list->DATA[i+1] = list->DATA[i];
		}
		list->len++;
		return 1;
}

//need a seq list for a given pos, return the node
NODE * seqlist_getValByPos(SEQLIST * list, int pos){
	if (pos < 0 || pos > list->len) {
		return NULL;
	}
	return &list->DATA[pos];
}

//for a given list and node, return the pos of the node
int seqlist_searchByKey(SEQLIST * list, NODE * nodeKey){
	if (list->len == 0) {
		return -1;
	}
	for(int i = 0; i < list->len; i++){
		if (list->DATA[i].Sno == nodeKey->Sno && strcmp(list->DATA[i].Name, nodeKey->Name) == 0
			&& list->DATA[i].Sex == nodeKey->Sex ) {
			return i;
		} 
	}
	return -1;
}

//show ele all
void showSeqListAll(SEQLIST * list){
	if (list->len == 0) {
		exit(-1);
	}
	for(int i = 0; i < list->len; i++){
		printf("NODE %d --->> Sno: %d , Name: %s , Sex: %c \n ", i+1, list->DATA[i].Sno, list->DATA[i].Name, list->DATA[i].Sex);
	}
	printf("--------------ALL EMEMENTS------------------");
}

int main(){
	
	SEQLIST * seqListDemo;
	//first, init
	init_seqlist(seqListDemo);

	
	
	
	printf("hello world");
	return 0;
}
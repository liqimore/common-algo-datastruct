import java.util.Scanner;

/**
*	NOTE: this Seq List array starts from 1 
*	which means nodeArray has (MAXLEN +1) nodes
*	but only used MAXLEN nodes
*	the first one abandonded 
*/

//defination of the type of data(a node)
class NODE {
	String key; //key words of each node
	//some make-up data
	String words;
	int number;
}
/**
* Defination of Seq List class
*
*/
class seqType {
	//max length of the seq list
	static final int MAXLEN = 128;
	
	//a list of node
	NODE[] nodeArray = new NODE[MAXLEN + 1];
	//length of the current list
	int len; 
	
	//init a seq list, (set length to 0)
	public void init(seqType sList){
		sList.len = 0;
	}
	
	//return the current number of nodes in this seq list
	public int getLen(seqType sList){
		return sList.len;
	}
	
	//insert a new node to this seq list
	//need pos for position of the newNode
	public boolean insert(seqType sList, int pos, NODE newNode){
		if (sList.len >= MAXLEN) {
			System.out.println("Seq List is already FULL");
			return false;
		}
		if (pos < 1 || pos > sList.len-1) {
			System.out.println("Seq Lsit has no pos for new node");
		}
		
		for (int i = sList.len; i >= pos; i--) {
			//move backward for 1 pos at the array
			//start move from the end to pos need to add 
			sList.nodeArray[i+1] = sList.nodeArray[i];
		}
		//insert new node
		sList.nodeArray[pos] = newNode;
		//set length one more
		sList.len++;
		//return success
		return true;
	}
	
	//add a new node into this list
	//need a seq list and a new node
	public boolean add(seqType sList, NODE newNode){
		if (sList.len >= MAXLEN) {
			System.out.println("Seq List is already FULL");
			return false;
		}
		//len++ and add a new node
		sList.nodeArray[++sList.len] = newNode;
		return true;
	}
	
	//Delete a node 
	//need pos and seq list to delete
	public boolean delete(seqType sList, int pos){
		if (sList.len+1 < pos || pos < 1) {
			System.out.println("Wrong pos value");
			return false;
		}
		for (int i = pos; i < sList.len; i++) {
			//move forward for 1 pos 
			//from the pos't next node, just replace node[pos] 
			//by next value
			sList.nodeArray[i] = sList.nodeArray[i+1];
		}
		//remove 1 node number
		sList.len--;
		return true;
	}
	
	//get node by pos
	//need a Seq List and a pos
	public NODE getNodeByPos(seqType currentList, int pos){
		if (pos > currentList.len+1 || pos < 1) {
			System.out.println("NOT FOUND");
			return null;
		}
		//just return pos's node
		return currentList.nodeArray[pos];
	}
	
	//get node by key
	//need a Seq List and a Key
	public NODE getNodeByKey(seqType currentList, String key){
		if (key.length() == 0) {
			System.out.println("Length of key is 0");
			return null;
		}
		//array starts from 1, so starts from 1 too
		for (int i = 1; i < currentList.len; i++) {
			//compare each key with the answer
			//so it need O(the length of list)
			//compareTo returns 0 if they are the same
			if (currentList.nodeArray[i].key.compareTo(key) == 0) {
				return currentList.nodeArray[i];
			}
		}
		return null;
	}
	
	//show all node in this list
	//need a seq list to show
	public void showAll(seqType sList){
		if (sList.len < 0) {
			System.out.println("The List is empty");
			System.exit(-1);
		}
		//show item in each node one by one
		for (int i = 1; i < sList.len; i++) {
			System.out.printf("NODE: %d ->> Key: %s, Words: %s, Num: %d \n", i, sList.nodeArray[i].key, sList.nodeArray[i].words, sList.nodeArray[i].number);
		}
	}
}

class SeqList {
	public static void main(String[] args) {
		seqType slist = new seqType();
		System.out.println("demo of seq list");
		System.out.println("------------------");
		//init slist
		slist.init(slist);
		Scanner read = new Scanner(System.in);
		//input some node
		do {
			System.out.println("Please input key, words, and number");
			NODE tempNode = new NODE();
			tempNode.key = read.next();
			tempNode.words = read.next();
			tempNode.number = read.nextInt();
			System.out.println("add more? yes or no?");
			String ANS = read.next();
			if (ANS.compareTo("no")==0 || ANS.compareTo("n")==0 ) {
				break;
			}
			slist.add(slist, tempNode);
			
		} while (true);
		
		System.out.println("-------------------");
		System.out.println("show the list node:");
		slist.showAll(slist);
		
		
		System.out.println("-------------------");
		System.out.println("Insert a new Node now");
		System.out.println("Please input position, key, words, and number");
		NODE insertNode = new NODE();
		int insertPos = read.nextInt();
		insertNode.key = read.next();
		insertNode.words = read.next();
		insertNode.number = read.nextInt();
		slist.insert(slist, insertPos, insertNode);
		
		System.out.println("-------------------");
		System.out.println("show the list node:");
		slist.showAll(slist);
		
		System.out.println("-------------------");
		System.out.println("choose one to delete");
		slist.delete(slist, read.nextInt());
		
		System.out.println("-------------------");
		System.out.println("show the list node:");
		slist.showAll(slist);
		
		System.out.println("-------------------");
		System.out.println("getNodeByPos, input a pos:");
		int searchPos = read.nextInt();
		NODE posNode =  slist.getNodeByPos(slist, searchPos);
		System.out.printf("NODE ->> Key: %s, Words: %s, Num: %d \n", posNode.key, posNode.words, posNode.number);
		
		System.out.println("-------------------");
		System.out.println("getNodeByKey, input a key:");
		String searchKey = read.next();
		NODE keyNode =  slist.getNodeByKey(slist, searchKey);
		System.out.printf("NODE ->> Key: %s, Words: %s, Num: %d \n", keyNode.key, keyNode.words, keyNode.number);
		
		System.out.println("----------------End Test----------------------");
		
	}
}
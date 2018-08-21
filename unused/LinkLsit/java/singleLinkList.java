
class DATATYPE{
	String key;
	int int1;
}

class SLNODE {
	//allocate memory while new SLNODE()
	DATATYPE nodeData = new DATATYPE();
	SLNODE nextNode;
	
	/**
	* add a new node at the end of the linked list
	* return the new linked list head
	*/
	public SLNODE add_node(SLNODE listHead, DATATYPE newData){
		SLNODE newNode = new SLNODE();
		SLNODE tempNode; //temp refer to current node
		if (newNode == null) {
			System.out.println("memory allocate failed!");
			return null;
		}
		//setting new node information
		newNode.nodeData = newData;
		newNode.nextNode = null;
		//if listHead refer is null, then let it point to newNode
		//finally return 
		if (listHead == null) {
			listHead = newNode;
			return listHead;
		}
		//if head->null not true, the get tempNode to end
		tempNode = listHead;
		while (tempNode.nextNode != null) {
			tempNode = tempNode.nextNode;
		}
		tempNode.nextNode = newNode;
		return listHead;
	}
	
	/**
	* insert a new node after the head
	* return the head after added
	*/
	public SLNODE insert_head(SLNODE listHead, DATATYPE newData){
		SLNODE headNode = new SLNODE();//indicates the node after head
		if (headNode == null) {
			System.out.println("memory allocate failed!");
			return null;
		}
		headNode.nodeData = newData;
		headNode.nextNode = listHead;//get newNode.nextNode refer to original head.nextNode
		listHead = headNode;//change the listHead to our newNode
		return listHead;
		
	}
	
	/** 
	* search for a particular node 
	* if exist, return the reference of this node
	*/
	public SLNODE searchNode(SLNODE listHead, String key){
		SLNODE currentNode = listHead;
		//loop until find the key, then return 
		while (currentNode != null) {
			if (currentNode.nodeData.key.compareTo(key) == 0) {
				return currentNode;
			}
			currentNode = currentNode.nextNode;
		}
		return null;//fail to find
	}
	
	/**
	* insert by key, aka insert a node after a specific key
	* return the list head
	*/
	public SLNODE insertByKey(SLNODE listHead, String key, DATATYPE newData){
		SLNODE newNode = new SLNODE();
		SLNODE currentNode; //recive the key node
		if (newNode == null) {
			System.out.println("memory allocate failed!");
			return null;
		}
		currentNode = searchNode(listHead, key);
		if (currentNode == null) {
			System.out.println("not find this key");
			return null;
		}
		//setting values in newNode
		newNode.nodeData = newData;
		newNode.nextNode = currentNode.nextNode;//jump one node
		currentNode.nextNode = newNode;
		return listHead;
		
	}
	
	/**
	* delete a node by key
	* return boolean
	*/
	public int deleteByKey(SLNODE listHead, String key){
		SLNODE tempNode = listHead; //node before del
		SLNODE delNode = listHead; // node to delete
		while (delNode != null) {
			if (delNode.nodeData.key.compareTo(key) == 0) {
				tempNode.nextNode = delNode.nextNode;//jump the delNode
				delNode = null;//clear
				return 1;
			}
			else {
				tempNode = delNode;//move to next
				delNode = delNode.nextNode; //same as above
			}
		}
		return 0;//failed
		
	}
	
	/**
	* length of the linked list except head
	*/
	public int getLength(SLNODE listHead){
		SLNODE currentNode = listHead;
		int counter = 0;
		while (currentNode != null) {
			counter++;
			currentNode = currentNode.nextNode;
		}
		return counter;
		//simple as that
	}
	
	/**
	* show all nodes
	*/
	public void showAllNodes(SLNODE listHead){
		SLNODE currentNode = listHead;
		DATATYPE showData;
		int counter = 0;
		while (currentNode != null) {
			showData = currentNode.nodeData;
			System.out.printf("The %d Node: key -->> %s, int1 -->> %d \n", counter, showData.key, showData.int1);
			currentNode = currentNode.nextNode;
			counter++;
		}
		System.out.println("-----------------------------------------");
		System.out.println("                          --->> " + getLength(listHead) + " total.");
	}
	
	
}



class singleLinkList {
	public static void main(String[] args) {
		SLNODE test = new SLNODE();
		test.showAllNodes(test);
		System.out.println("--------------END TEST-------------");
	}
}
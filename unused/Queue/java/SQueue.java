/*
** sequential queue
*/

/**
* Datatype
*/
class DATATYPE{
	String key;
	int int1;
}

class SQtype{
	static final int MAXLEN = 128;
	DATATYPE[] data = new DATATYPE[MAXLEN];
	int head; //head of queue
	int tail;
	
	//usage :
	//SQtype sq = SQtype.init();
	//this create a new queue 
	//static method is better
	public static SQtype init(){
		SQtype temp = new SQtype();
		if (temp != null) {
			//elements start from 0
			//so, head and tail = -1 is empty queue
			temp.head = -1;
			temp.tail = -1;
			return temp;
		}
		return null;
	}
	
	//check empty
	//return boolean
	public static boolean isEmpty(SQtype sq){
		return sq.head == sq.tail;
	}
	
	//check full
	//return boolean
	public static boolean isFull(SQtype sq){
		return sq.tail == MAXLEN;
	}
	
	//remove all elements
	public void clearSQ(SQtype sq){
		if (sq != null) {
			sq = null;
		}
	}
	
	//in queue
	//return status boolean
	public boolean inQueue(SQtype sq, DATATYPE inData){
		if (sq.isFull(sq)) {
			System.out.println("Queue Full, In Queue Failed.");
			return false;
		}
		sq.data[++sq.tail] = inData;// 1. tail++  2. sq.data[tail]=inData
		return true;
	}
	
	//out queue
	public DATATYPE outQueue(SQtype sq){
		if (sq.isEmpty(sq)) {
			System.out.println("Queue Empty, Out Queue Failed.");
			return null;
		}
		int headNow = sq.head;
		sq.head++;
		return sq.data[headNow];
	}
	
	//read data at the next out element
	public DATATYPE readNode(SQtype sq){
		if (sq.isEmpty(sq)) {
			System.out.println("Queue Empty, Out Queue Failed.");
			return null;
		}
		return sq.data[sq.tail];
	}
	
	public int getLen(SQtype sq){
		return sq.tail - sq.head;
	}
	
	
	
	
}


class SQueue {
	public static void main(String[] args) {
		
		//init a seq queue
		SQtype sq = SQtype.init();
		if (sq.isEmpty(sq)) {
			System.out.println("Seq Queue is Empty.");
		}
		
	}
}
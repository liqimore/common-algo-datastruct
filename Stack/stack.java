/**
* Datatype
*/
class DATATYPE{
	String key;
	int int1;
}

class StackType{
	static final int MAXLEN = 128;
	//data array starts from 0, so top default is -1
	DATATYPE[] data = new DATATYPE[MAXLEN];
	int top; //top of stack
	
	//init a stack
	//return the stack
	public StackType initStack(){
		StackType temp = new StackType();
		if (temp != null) {
			//memory allocate success
			temp.top = -1;
			return temp;
		}
		return null;
	}
	
	//check if stack is empty
	//return boolean
	public boolean isEmpty(StackType stack){
		return stack.top == -1;
	}
	
	//check if stack is full
	//return boolean
	public boolean isFull(StackType stack){
		return stack.top == MAXLEN -1;
	}
	
	//clear a stack to empty
	public void clearStack(StackType stack){
		stack.top = -1;
	}
	
	//free refer to stack
	public void freeStack(StackType stack){
		if (stack != null) {
			stack = null;
		}
	}
	
	//push
	//return boolean
	public boolean push(StackType stack, DATATYPE newData){
		//check status of stack
		if (isFull(stack)) {
			System.out.println("Stack is full, push failed.");
			return false;
		}
		stack.data[++stack.top] = newData;
		return true;
	}
	
	//pop 
	//return datatype
	public DATATYPE pop(StackType stack){
		if (isEmpty(stack)) {
			System.out.println("Stack is empty, pop failed.");
			return null;
		}
		int topNow = stack.top;
		stack.top--;
		return stack.data[topNow];
	}
	
	//read top node , not pop it
	//return datatype
	public DATATYPE readStack(StackType stack){
		if (isEmpty(stack)) {
			System.out.println("Stack is empty, pop failed.");
			return null;
		}
		return stack.data[stack.top];
	}
	
	
	
}


class Stack {
	public static void main(String[] args) {
		
		//create a stack
		StackType stack = new StackType();
		stack = stack.initStack();
		StackType st = stack.initStack(); //another stack
		
		if (stack.isEmpty(stack)) {
			System.out.println("Stack is Empty");
		}
		
	}
}
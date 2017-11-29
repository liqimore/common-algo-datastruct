//???
/**
* Datatype
*/
class DATATYPE{
	String key;
	int int1;
}

/**
* linked binTree
* with parent node pointer
*/
class TreeNode{
	DATATYPE data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	/**
	* init a tree 
	* renturn root
	*/
	TreeNode init(){
		TreeNode root = new TreeNode();
		if (root != null) {
			//init data
			root.data = new DATATYPE();
			//set pointer
			root.left = null;
			root.right = null;
			root.parent = null;
			//return root node
			return root;
		}
		return null;	
	}
	
	/** 
	* add a new node
	* default add it to left node
	*/
	boolean addNode(TreeNode root, DATATYPE newData){
		TreeNode newNode = new TreeNode();
		if (newNode != null) {
			//set data
			newNode.data.key = newData.key;
			newNode.data.int1 = newData.int1;
			//set new node pointers
			newNode.left = null;
			newNode.right = null;
			newNode.parent = 
		}
	}
}



class binTree {
	public static void main(String[] args) {
		
	}
}
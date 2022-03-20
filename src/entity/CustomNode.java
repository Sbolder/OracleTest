package entity;

import java.util.ArrayList;

public class CustomNode {

	String key;
	ArrayList<String> childs;
	CustomNode left, right;

	public CustomNode(String key, ArrayList<String> childs, CustomNode left, CustomNode right) {
		super();
		this.key = key;
		this.childs = childs;
		this.left = left;
		this.right = right;
	}

	/*public CustomNode newNode(String key, CustomNode left, CustomNode right, ArrayList<Integer> childs) {
		CustomNode temp = new CustomNode();
		temp.key = key;
		temp.setLeft(null);
		temp.setRight(null);
		temp.setChilds(null);
	
		if (key.equals(OperatorEnum.SUM) || key.equals(OperatorEnum.MOLTIPLICATION)) {
			if (childs == null || (left == null && right == null)) {
				System.out.println("[ERROR]: in definition of expression");
				throw new RuntimeException("[ERROR]: in definition of expression");
			}
			temp.childs = childs;
	
		}
	
		else if (key.equals(OperatorEnum.MINUS) || key.equals(OperatorEnum.DIVIDE)) {
			if (left == null || right == null) {
				System.out.println("[ERROR]: in definition of expression");
				throw new RuntimeException("[ERROR]: in definition of expression");
			}
			temp.right = right;
			temp.left = left;
	
		} else if (key.equals(OperatorEnum.ABS)) {
			//TODO 
		} else {
			temp.key = key;
		}
		return temp;
	}*/

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ArrayList<String> getChilds() {
		return this.childs;
	}

	public void setChilds(ArrayList<String> childs) {
		this.childs = childs;
	}

	public CustomNode getLeft() {
		return this.left;
	}

	public void setLeft(CustomNode left) {
		this.left = left;
	}

	public CustomNode getRight() {
		return this.right;
	}

	public void setRight(CustomNode right) {
		this.right = right;
	}

}

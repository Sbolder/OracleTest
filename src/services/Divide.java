package services;

import entity.CustomNode;

public class Divide implements IServices {

	@Override
	public int calculate(CustomNode root) {
		if (root.getLeft() == null || root.getRight() == null) {
			System.out.println("error");
		}

		int left = Integer.valueOf(root.getLeft().getKey());
		int right = Integer.valueOf(root.getRight().getKey());
		int tmp = left / right;
		root.setKey(Integer.valueOf(tmp).toString());
		return left / right;

	}

}
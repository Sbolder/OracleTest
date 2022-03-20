package services;

import entity.CustomNode;

public class Abs implements IServices {

	@Override
	public int calculate(CustomNode root) {
		int toCalculate = 0;
		if (root.getLeft() == null || root.getRight() == null) {
			System.out.println("error");
		} else if (root.getLeft() != null && root.getRight() == null) {
			toCalculate = Integer.valueOf(root.getLeft().getKey());
		} else if (root.getLeft() == null && root.getRight() != null) {
			toCalculate = Integer.valueOf(root.getRight().getKey());
		} else {
			System.out.println("ERROR");
		}

		int result = Math.abs(toCalculate);
		root.setKey(Integer.valueOf(result).toString());
		return result;

	}

}

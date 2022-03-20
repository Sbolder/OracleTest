package services;

import entity.CustomNode;

public class Sum implements IServices {

	@Override
	public int calculate(CustomNode root) {

		int result = 0;
		if (root.getChilds() == null) {
			int left = Integer.valueOf(root.getLeft().getKey());
			int right = Integer.valueOf(root.getRight().getKey());

			result = left + right;
		} else {
			for (int index = 0; index < root.getChilds().size(); index++) {

				int tmpValue = Integer.valueOf(root.getChilds().get(index).trim()).intValue();
				result = result + tmpValue;
			}
		}

		root.setKey(Integer.valueOf(result).toString());
		return result;
	}

}

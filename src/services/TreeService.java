package services;

import java.util.ArrayList;
import java.util.List;

import entity.CustomNode;
import entity.OperatorEnum;

public class TreeService {

	Sum serviceSum = new Sum();
	Mult serviceMultiplication = new Mult();
	Minus serviceMinus = new Minus();
	Divide serviceDivide = new Divide();
	Abs serviceAbs = new Abs();
	ArrayList<String> symbol = new ArrayList<>();

	private static int toInt(String s) {
		int num = 0;
		Boolean flag = Character.isDigit(s.charAt(0));
		if (!flag) {
			System.out.println("LETTERA TROVATA");
		}

		// Check if the integral value is
		// negative or not
		// If it is not negative, generate
		// the number normally
		if (s.charAt(0) != '-') {
			for (int i = 0; i < s.length(); i++) {
				num = num * 10 + (s.charAt(i) - 48);
			}
		} else {
			for (int i = 1; i < s.length(); i++) {
				num = num * 10 + ((s.charAt(i)) - 48);
			}
			num = num * -1;
		}
		return num;
	}

	private static String checkIsString(CustomNode n) {
		if ((n.getKey().equals(OperatorEnum.SUM.toString()) ||
				n.getKey().equals(OperatorEnum.MINUS.toString()) ||
				n.getKey().equals(OperatorEnum.MOLTIPLICATION.toString()) ||
				n.getKey().equals(OperatorEnum.DIVIDE.toString()) ||
				n.getKey().equals(OperatorEnum.ABS.toString()))) {
			return null;
		}

		for (int i = 0; i < n.getKey().length(); i++) {
			Boolean flag = Character.isDigit(n.getKey().charAt(i));
			if (!flag) {
				return n.getKey();
			}

		}
		return null;
	}

	private static String checkIsStringItem(String s) {
		if ((s.equals(OperatorEnum.SUM.toString()) ||
				s.equals(OperatorEnum.MINUS.toString()) ||
				s.equals(OperatorEnum.MOLTIPLICATION.toString()) ||
				s.equals(OperatorEnum.DIVIDE.toString()) ||
				s.equals(OperatorEnum.ABS.toString()))) {
			return null;
		}

		for (int i = 0; i < s.length(); i++) {
			Boolean flag = Character.isDigit(s.charAt(i));
			if (!flag) {
				return s;
			}

		}
		return null;
	}

	public int calc(CustomNode root) {
		if (root == null) {
			return 0;
		}

		// Leaf node i.e, an integer
		if (!(root.getKey().equals(OperatorEnum.SUM.toString()) ||
				root.getKey().equals(OperatorEnum.MINUS.toString()) ||
				root.getKey().equals(OperatorEnum.MOLTIPLICATION.toString()) ||
				root.getKey().equals(OperatorEnum.DIVIDE.toString()) ||
				root.getKey().equals(OperatorEnum.ABS.toString()))) {
			return TreeService.toInt(root.getKey());
		}

		// Evaluate left subtree
		int leftEval = this.calc(root.getLeft());

		// Evaluate right subtree
		int rightEval = this.calc(root.getRight());

		// Check which operator to apply
		if (root.getKey().equals(OperatorEnum.SUM.toString())) {
			return this.serviceSum.calculate(root);
		} else if (root.getKey().equals(OperatorEnum.MOLTIPLICATION.toString())) {
			return this.serviceMultiplication.calculate(root);
		} else if (root.getKey().equals(OperatorEnum.MINUS.toString())) {
			return this.serviceMinus.calculate(root);
		} else if (root.getKey().equals(OperatorEnum.DIVIDE.toString())) {
			return this.serviceDivide.calculate(root);
		} else if (root.getKey().equals(OperatorEnum.ABS.toString())) {
			return this.serviceAbs.calculate(root);
		} else {
			System.out.println("Operator not found, ERROR!!!");
		}

		return 0;
	}

	public List<String> getReferencedSymbols(CustomNode root) {
		if (root == null) {
			return null;
		}
		List<String> result = new ArrayList<>();

		if (root.getLeft() != null) {
			this.getReferencedSymbols(root.getLeft());
		} else {
			String tmp = TreeService.checkIsString(root);
			if (tmp != null) {
				result.add(tmp);
			}
		}

		if (root.getRight() != null) {
			this.getReferencedSymbols(root.getRight());
		} else {
			String tmp = TreeService.checkIsString(root);
			if (tmp != null) {
				result.add(tmp);
			}
		}
		if (root.getRight() == null && root.getLeft() == null && root.getChilds() != null) {
			for (int index = 0; index < root.getChilds().size(); index++) {
				String tmp = TreeService.checkIsStringItem(root.getChilds().get(index));
				if (tmp != null) {
					result.add(tmp);
				}

			}
		}

		this.symbol.addAll(result);

		return this.symbol;

	}

}

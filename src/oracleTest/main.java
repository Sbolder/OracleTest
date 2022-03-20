package oracleTest;

import java.util.ArrayList;
import java.util.List;

import entity.CustomNode;
import entity.OperatorEnum;
import services.TreeService;

class Main {

	public static void main(String[] args) {

		TreeService service = new TreeService();

		//Create root
		CustomNode root = new CustomNode(OperatorEnum.MINUS.toString(), null, null, null);
		//Create left node with only 3 value
		root.setLeft(new CustomNode("3", null, null, null));

		//Create Right node
		ArrayList<String> sumleft = new ArrayList<>();
		sumleft.add("5");
		sumleft.add("10");

		ArrayList<String> sumright = new ArrayList<>();
		sumright.add("10");
		sumright.add("10");
		sumright.add("2");

		root.setRight(new CustomNode(OperatorEnum.MOLTIPLICATION.toString(),
				null,
				new CustomNode(OperatorEnum.SUM.toString(), sumleft, null, null), new CustomNode(OperatorEnum.SUM.toString(), sumright, null, null)));

		List<String> symbolList = service.getReferencedSymbols(root);
		if (symbolList.isEmpty()) {
			System.out.println("Result : " + service.calc(root));
		} else {
			System.out.println("In the expression we have found some symbols : " + symbolList);
		}

	}
}

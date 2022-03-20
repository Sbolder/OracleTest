# OracleTest

in the following repo you should find the query solution under folder "Query"

The solution of java test is on the java projects.
You could open it, and if you want, you could change value of tree in Main.java and run it.

By default, if symbols (i.e "x") is present the programm not invoke calc method but return the list of symbol founded in expression.

If any symbol was not found the program, calculate the result.

Assumption:
- The program accept only numeric value at the last child of tree, if you insert a non-numeric the program dosn't calculate the result of tree, but return the list of non numeric found in expression.
- The operator accepted from elaborator is:
    SUM
	MOLTIPLICATION,
	DIVIDE,
	MINUS,
	ABS
    Any check of operator in input is not implemented, than the program probably crash.
- the programm accept a valid tree in input, no parser is implemeted in this solution


Last question :
 - Is it possible that in some cases calculation is not finite?
    - No, it is not possible in my program.
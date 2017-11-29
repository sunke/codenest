package net.codenest.antlr.calculator;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calculator {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream("1 + 2 - 6 * 3");
		CalculatorLexer lexer = new CalculatorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CalculatorParser parser = new CalculatorParser(tokens);
		ParseTree tree = parser.input();

		CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();
		Double result = visitor.visit(tree);
		System.out.println("Result: " + result);
	}
}

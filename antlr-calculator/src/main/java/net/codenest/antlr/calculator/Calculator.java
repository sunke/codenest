package net.codenest.antlr.calculator;

import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			CalculatorLexer lexer = new CalculatorLexer(new ANTLRInputStream(sc.nextLine()));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CalculatorParser parser = new CalculatorParser(tokens);

			ParseTree tree = parser.expr();
			CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();
			System.out.println(visitor.visit(tree));
		}
	}
}

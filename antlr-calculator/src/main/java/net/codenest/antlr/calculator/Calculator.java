package net.codenest.antlr.calculator;

import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				String input = sc.nextLine();
				
				if (input.equals("q")) {
					System.exit(0);
				} else if (input.trim().equals("") || input.trim().equals("\n")) {
					continue;
				} else {
					CalculatorLexer lexer = new CalculatorLexer(new ANTLRInputStream(input));
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					CalculatorParser parser = new CalculatorParser(tokens);

					ParseTree tree = parser.input();
					CalculatorVisitorImpl visitor = new CalculatorVisitorImpl();
					System.out.println(visitor.visit(tree));
				}
			}
		}
	}
}

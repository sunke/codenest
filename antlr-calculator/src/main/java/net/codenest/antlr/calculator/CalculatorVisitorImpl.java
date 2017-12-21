package net.codenest.antlr.calculator;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {
	
	@Override
	public Double visitMulOrDiv(final CalculatorParser.MulOrDivContext ctx) {
		Double lvalue = visit(ctx.expr(0));
		Double rvalue = visit(ctx.expr(1));
		if (ctx.op.getType() == CalculatorParser.MUL) {
			return lvalue * rvalue;
		} else {
			if (rvalue == 0) {
				throw new RuntimeException("Divide by zero error encountered!");
			}
			return lvalue / rvalue;
		}
	}
	
	@Override
	public Double visitAddOrSub(final CalculatorParser.AddOrSubContext ctx) {
		Double lvalue = visit(ctx.expr(0));
		Double rvalue = visit(ctx.expr(1));
		if (ctx.op.getType() == CalculatorParser.ADD) {
			return lvalue + rvalue;
		} else {
			return lvalue - rvalue;
		}
	}
	
	@Override
	public Double visitBracket(final CalculatorParser.BracketContext ctx) {
		return visit(ctx.expr());
	}
	
	@Override
	public Double visitInteger(final CalculatorParser.IntegerContext ctx) {
		return Double.valueOf(ctx.INT().getText());
	}
	
	@Override
	public Double visitDouble(final CalculatorParser.DoubleContext ctx) {
		return Double.valueOf(ctx.DOUBLE().getText());
	}
}


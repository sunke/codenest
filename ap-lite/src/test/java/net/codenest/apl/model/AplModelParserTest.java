package net.codenest.apl.model;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AplModelParserTest {

	@Test
	public void testEmpty() {
		AplModelParser parser = new AplModelParser(new CommonTokenStream(new AplModelLexer(new ANTLRInputStream(""))));
		
		ParseTreeWalker walker = new ParseTreeWalker();
		
		walker.walk(new AplModelBaseListener() {
			@Override 
			public void enterModelDef(AplModelParser.ModelDefContext ctx) {
				assertEquals(0, ctx.getChildCount());
			}
		}, parser.modelDef());
	}
	
	@Test
	public void testSingleClass() {
		String model = "Globals = CLASS;".toLowerCase();
		AplModelParser parser = new AplModelParser(new CommonTokenStream(new AplModelLexer(new ANTLRInputStream(model))));
		
		ParseTreeWalker walker = new ParseTreeWalker();
		
		walker.walk(new AplModelBaseListener() {
			@Override 
			public void enterModelDef(AplModelParser.ModelDefContext ctx) {
				assertEquals(1, ctx.classDef().size());
				assertEquals("globals", ctx.classDef(0).className().getText());
			}
		}, parser.modelDef());
	}

}

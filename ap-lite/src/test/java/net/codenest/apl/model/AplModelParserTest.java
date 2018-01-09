package net.codenest.apl.model;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import static org.junit.Assert.*;

import java.io.IOException;

public class AplModelParserTest {

	@Test
	public void testEmpty() {
		AplModelParser parser = getParser("");

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
		AplModelParser parser = getParser("Globals = CLASS;");

		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new AplModelBaseListener() {
			@Override
			public void enterModelDef(AplModelParser.ModelDefContext ctx) {
				assertEquals(1, ctx.classDef().size());
				assertEquals("globals", ctx.classDef(0).className().getText());
			}
		}, parser.modelDef());
	}

	@Test
	public void testScoBasic01() throws Exception {
		AplModelParser parser = getParser(getModel("sco-model-basic-01.txt"));

		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new AplModelBaseListener() {
			@Override
			public void enterModelDef(AplModelParser.ModelDefContext ctx) {
				assertEquals(1, ctx.classDef().size());
				assertEquals("products", ctx.classDef(0).className().getText());
			}
			@Override
			public void enterClassDef(AplModelParser.ClassDefContext ctx) {
				assertNull(ctx.childrenDef());
				assertNotNull(ctx.propertiesDef());
				assertNull(ctx.attributesDef());
				assertEquals(4, ctx.auxiliaryDef().size());
			}
		}, parser.modelDef());
	}

	private String getModel(final String path) throws IOException {
		return Resources.toString(Resources.getResource(path), Charsets.UTF_8).toLowerCase();
	}

	private AplModelParser getParser(final String model) {
		return new AplModelParser(new CommonTokenStream(new AplModelLexer(new ANTLRInputStream(model.toLowerCase()))));
	}
}

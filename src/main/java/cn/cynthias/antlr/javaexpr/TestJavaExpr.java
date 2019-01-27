package cn.cynthias.antlr.javaexpr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestJavaExpr {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(extractor, tree);
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "package cn.cynthias.antlr.labeledexpr;\n" +
                "\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "/**\n" +
                " * Created by Shawn on 2019/1/27 0027 下午 3:23.\n" +
                " */\n" +
                "public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {\n" +
                "\n" +
                "    private Map<String, Integer> memory = new HashMap<String, Integer>();\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {\n" +
                "        String id = ctx.ID().getText();\n" +
                "        int value = visit(ctx.expr());\n" +
                "        memory.put(id, value);\n" +
                "        return value;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {\n" +
                "        Integer value = visit(ctx.expr());\n" +
                "        System.out.println(\"visitPrintExpr\" + value);\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitInt(LabeledExprParser.IntContext ctx) {\n" +
                "        return Integer.valueOf(ctx.INT().getText());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitId(LabeledExprParser.IdContext ctx) {\n" +
                "        String id = ctx.ID().getText();\n" +
                "        if (memory.containsKey(id)) {\n" +
                "            return memory.get(id);\n" +
                "        }\n" +
                "\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {\n" +
                "        int left = visit(ctx.expr(0));\n" +
                "        int right = visit(ctx.expr(1));\n" +
                "\n" +
                "        if (ctx.op.getType() == LabeledExprParser.MUL) {\n" +
                "            return left * right;\n" +
                "        }\n" +
                "\n" +
                "        return left / right;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {\n" +
                "        int left = visit(ctx.expr(0));\n" +
                "        int right = visit(ctx.expr(1));\n" +
                "\n" +
                "        if (ctx.op.getType() == LabeledExprParser.ADD) {\n" +
                "            return left + right;\n" +
                "        }\n" +
                "\n" +
                "        return left - right;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public Integer visitParens(LabeledExprParser.ParensContext ctx) {\n" +
                "        return visit(ctx.expr());\n" +
                "    }\n" +
                "}\n"
        };

        for (String s:testStr){
//            System.out.print("Input expr:"+s);
            run(s);
            System.out.println();
        }
    }

}

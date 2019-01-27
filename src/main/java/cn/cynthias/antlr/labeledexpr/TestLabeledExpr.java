package cn.cynthias.antlr.labeledexpr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestLabeledExpr {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "2\n" +
                "a = 5\n" +
                "b = 4\n" +
                "a+b+3\n" +
                "(a-b)+3\n" +
                "a+(b*3\n" +
                "2*((2*5 - 6)/2)\n"
        };

        for (String s:testStr){
            System.out.print("Input expr:"+s);
            run(s);
            System.out.println();
        }
    }

}

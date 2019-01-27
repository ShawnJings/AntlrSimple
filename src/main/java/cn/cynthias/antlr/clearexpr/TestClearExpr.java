package cn.cynthias.antlr.clearexpr;

import cn.cynthias.antlr.labeledexpr.EvalVisitor;
import cn.cynthias.antlr.labeledexpr.LabeledExprLexer;
import cn.cynthias.antlr.labeledexpr.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestClearExpr {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        ClearExprLexer lexer = new ClearExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ClearExprParser parser = new ClearExprParser(tokens);
        ParseTree tree = parser.prog();
        ClearEvalVisitor visitor = new ClearEvalVisitor();
        visitor.visit(tree);
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "2\n" +
                "a = 5\n" +
                "b = 4\n" +
                "a+b+3\n" +
                "clear\n" +
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

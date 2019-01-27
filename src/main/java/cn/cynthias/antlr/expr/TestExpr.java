package cn.cynthias.antlr.expr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestExpr {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "2\n",
                "a+b+3\n",
                "(a-b)+3\n",
                "a+(b*3\n"
        };

        for (String s:testStr){
            System.out.println("Input expr:"+s);
            run(s);
        }
    }

}

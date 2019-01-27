package cn.cynthias.antlr.libexpr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestLibExpr {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        LibExprLexer lexer = new LibExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LibExprParser parser = new LibExprParser(tokens);
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

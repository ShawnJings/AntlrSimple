package cn.cynthias.antlr.rows;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestRows {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RowsParser parser = new RowsParser(tokens, 2);
        parser.setBuildParseTree(false);
        parser.file();
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "2\t1\n" +
                "a+b+3\t2\n" +
                "(a-b)+3\t3\n" +
                "a+(b*3\t4\n"
        };

        for (String s:testStr){
            System.out.println("Input expr:"+s);
            run(s);
        }
    }

}

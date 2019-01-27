package cn.cynthias.antlr.data;

import cn.cynthias.antlr.rows.RowsLexer;
import cn.cynthias.antlr.rows.RowsParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by Shawn on 2019/1/27 0027 下午 2:51.
 */
public class TestData {

    public static void run(String inputStr) {
        ANTLRInputStream input = new ANTLRInputStream(inputStr);
        DataLexer lexer = new DataLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DataParser parser = new DataParser(tokens);
        DataParser.FileContext file = parser.file();
        System.out.print(file.toStringTree());
    }

    public static void main(String[] args) throws Exception{

        String[] testStr={
                "2 9 10 3 1 2 3"
        };

        for (String s:testStr){
            System.out.println("Input expr:"+s);
            run(s);
        }
    }

}

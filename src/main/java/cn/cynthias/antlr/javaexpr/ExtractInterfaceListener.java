package cn.cynthias.antlr.javaexpr;


import org.antlr.v4.runtime.TokenStream;

/**
 * Created by Shawn on 2019/1/27 0027 下午 6:30.
 */
public class ExtractInterfaceListener extends JavaParserBaseListener {

    private JavaParser parser;

    public ExtractInterfaceListener(JavaParser parser) {
        this.parser = parser;
    }

    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("interface I" + ctx.IDENTIFIER() + " {");
    }

    @Override
    public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        System.out.println(parser.getTokenStream().getText(ctx));
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        TokenStream tokens = parser.getTokenStream();
        String type = "void";

        if (ctx.typeTypeOrVoid() != null) {
            type = tokens.getText(ctx.typeTypeOrVoid());
        }

        String args = tokens.getText(ctx.formalParameters());

        System.out.println("\t" + type + " " + ctx.IDENTIFIER() + args + ";");
    }
}

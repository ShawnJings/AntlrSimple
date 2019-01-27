// Generated from E:/02_java/git/AntlrSimple/src/main/java/cn/cynthias/antlr\Demo.g4 by ANTLR 4.7.2
package cn.cynthias.antlr.detail;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DemoParser}.
 */
public interface DemoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DemoParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(DemoParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(DemoParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(DemoParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(DemoParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(DemoParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(DemoParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(DemoParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link DemoParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(DemoParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(DemoParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(DemoParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(DemoParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(DemoParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(DemoParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(DemoParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(DemoParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(DemoParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(DemoParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link DemoParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(DemoParser.IntContext ctx);
}
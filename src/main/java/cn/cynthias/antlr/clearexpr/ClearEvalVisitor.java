package cn.cynthias.antlr.clearexpr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shawn on 2019/1/27 0027 下午 3:23.
 */
public class ClearEvalVisitor extends ClearExprBaseVisitor<Integer> {

    private Map<String, Integer> memory = new HashMap<String, Integer>();

    @Override
    public Integer visitAssign(ClearExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(ClearExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println("visitPrintExpr" + value);
        return 0;
    }

    @Override
    public Integer visitInt(ClearExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitId(ClearExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }

        return 0;
    }

    @Override
    public Integer visitMulDiv(ClearExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        if (ctx.op.getType() == ClearExprParser.MUL) {
            return left * right;
        }

        return left / right;
    }

    @Override
    public Integer visitAddSub(ClearExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        if (ctx.op.getType() == ClearExprParser.ADD) {
            return left + right;
        }

        return left - right;
    }

    @Override
    public Integer visitParens(ClearExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitClear(ClearExprParser.ClearContext ctx) {
        memory.clear();
        return 0;
    }
}

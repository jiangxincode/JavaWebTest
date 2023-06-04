import java.util.Date;

public final class TreeEvaluationVisitor extends DateCalculatorBaseVisitor<Long> {
    @Override
    public Long visitDataTime(DateCalculatorParser.DataTimeContext dataTime) throws IllegalArgumentException {
        try {
                return Main.parseDate(dataTime.getText());
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public Long visitTimeSpan(DateCalculatorParser.TimeSpanContext timeSpan) throws IllegalArgumentException {
        try {
            return Main.parseTime(timeSpan.getText());
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Long visitExpressionResultData(DateCalculatorParser.ExpressionResultDataContext ctx) throws IllegalArgumentException {
        Function<Long, Long, Long> operand;
        switch(ctx.op.getType()) {
            case DateCalculatorParser.Add:
                operand = (a, b) -> a + b;
                break;
            case DateCalculatorParser.Substract:
                operand = (a, b) -> a - b;
                break;
            default:
                throw new IllegalArgumentException();
        }



        Long left = visit(ctx.getChild(0));
        Long right = visit(ctx.getChild(2));
        return operand.binary(left, right);
    }

    @Override
    public Long visitExpressionResultTime(DateCalculatorParser.ExpressionResultTimeContext ctx) throws IllegalArgumentException {
        Function<Long, Long, Long> operand;
        switch(ctx.op.getType()) {
            case DateCalculatorParser.Add:
                operand = (a, b) -> a + b;
                break;
            case DateCalculatorParser.Substract:
                operand = (a, b) -> a - b;
                break;
            default:
                throw new IllegalArgumentException();
        }



        Long left = visit(ctx.getChild(0));
        Long right = visit(ctx.getChild(2));
        return operand.binary(left, right);
    }

    @Override
    public Long visitExpressionResultDataRightERT(DateCalculatorParser.ExpressionResultDataRightERTContext ctx) throws IllegalArgumentException {
        Function<Long, Long, Long> operand;
        switch(ctx.op.getType()) {
            case DateCalculatorParser.Add:
                operand = (a, b) -> a + b;
                break;
            case DateCalculatorParser.Substract:
                operand = (a, b) -> a - b;
                break;
            default:
                throw new IllegalArgumentException();
        }



        Long left = visit(ctx.getChild(0));
        Long right = visit(ctx.getChild(2));
        return operand.binary(left, right);
    }


}

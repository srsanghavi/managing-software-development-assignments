package ast;

/**
 * The type Prefix expression.
 * @author Shashwat Sanghavi
 *
 * Note: extends type Expression
 */
public class PrefixExpression extends Expression {
    private Operator op;
    private Expression exp1;
    private Expression exp2;

    /**
     * Instantiates a new Prefix expression.
     *
     * @param op   the op
     * @param exp1 the exp 1
     * @param exp2 the exp 2
     */
    public PrefixExpression(Operator op,Expression exp1,Expression exp2){
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public String textRepresentation() {
        return  op.getOperator()+" "+exp1.textRepresentation()+" "+exp2.textRepresentation();
    }

}

package ast;

/**
 * The type Infix expression.
 * @author Shashwat Sanghavi
 *
 * Note: extends type Expression
 */
public class InfixExpression extends Expression {

    private Operator operator;
    private Expression exp1;
    private Expression exp2;

    /**
     * Instantiates a new Infix expression.
     *
     * @param operator the operator
     * @param exp1     the exp 1
     * @param exp2     the exp 2
     */
    public InfixExpression(Operator operator,Expression exp1,Expression exp2){
        this.operator = operator;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * textRepresentation()
     * @return String the text representation of Assignment
     */
    public String textRepresentation() {
        return  exp1.textRepresentation()+" "+operator.getOperator()+" "+exp2.textRepresentation();
    }
}

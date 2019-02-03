package ast2;

/**
 * The type Number expression.
 * @author Shashwat Sanghavi
 *
 * Note: Extends type Expression
 */
public class NumberExpression extends Expression {

    private int number;

    /**
     * Instantiates a new Number expression.
     *
     * @param number the number
     */
    public NumberExpression(int number){
        this.number = number;
    }

    public String textRepresentation() {
        return Integer.toString(this.number);
    }
}

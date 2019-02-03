package ast;

/**
 * The type Operator.
 * @author Shashwat Sanghavi
 */
public class Operator {

    /**
     * Declare operator char to hold the operation type
     */
    private String op;

    /**
     * Instantiates a new Operator.
     *
     * @param operator the operator
     */
    public Operator(String operator){
        this.op = operator;
    }

    /**
     * Gets operator.
     *
     * @return the operator
     */
    String getOperator() {
        return op;
    }
}

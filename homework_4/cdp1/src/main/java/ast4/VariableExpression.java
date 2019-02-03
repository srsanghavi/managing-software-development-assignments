package ast4;

/**
 * The type Variable expression.
 * @author Shashwat Sanghavi
 *
 * Note: extends type expression
 */
public class VariableExpression extends Expression {

    private Variable var;

    /**
     * Instantiates a new Variable expression.
     *
     * @param var the var
     */
    public  VariableExpression(Variable var){
        this.var = var;
    }

    public String textRepresentation() {
        return Character.toString(this.var.getVariable());
    }
}

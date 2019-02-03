package ast4;

/**
 * The type Assignment.
 * @author Shashwat Sanghavi
 *
 * Note: Extends type Statement
 */
public class Assignment extends Statement {
    private Variable variable;
    private Expression expression;

    /**
     * Instantiates a new Assignment.
     *
     * @param variable   the variable
     * @param expression the expression
     */
    public Assignment(Variable variable, Expression expression){
        this.variable = variable;
        this.expression = expression;

    }


    /**
     * textRepresentation()
     * @return String the text representation of Assignment
     */
    public String textRepresentation() {
        return this.variable.getVariable()+" = "+this.expression.textRepresentation()+";";
    }
}

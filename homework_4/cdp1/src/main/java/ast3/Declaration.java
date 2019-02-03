package ast3;

/**
 * The type Declaration.
 * @author Shashwat Sanghavi
 *
 * Note: Extends type Statement
 */
public class Declaration extends Statement {
    private Variable variable;

    /**
     * Instantiates a new Declaration.
     *
     * @param variable the variable
     */
    public Declaration(Variable variable){
        this.variable = variable;
    }

    /**
     * textRepresentation()
     * @return String the text representation of Assignment
     */
    public String textRepresentation() {
        return "var "+this.variable.getVariable()+";";
    }
}

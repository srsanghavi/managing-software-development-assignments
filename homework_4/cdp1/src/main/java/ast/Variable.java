package ast;

/**
 * The type Variable.
 * @author Shashwat Sanghavi
 */
public class Variable {

    private char var;

    /**
     * Instantiates a new Variable.
     *
     * @param variable the variable
     */
    public Variable(char variable){
        this.var = variable;
    }

    /**
     * Gets variable.
     *
     * @return the variable
     */
    public char getVariable() {
        return var;
    }
}

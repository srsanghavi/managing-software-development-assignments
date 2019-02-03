package ast2;

/**
 * The type String expression.
 *
 * @author Shashwat Sanghavi
 *
 * Note: extends type Expression
 */
public class StringExpression extends Expression {

    private String string;

    /**
     * Instantiates a new String expression.
     *
     * @param string the string
     */
    public StringExpression(String string){
        this.string = string;
    }

    public String textRepresentation() {
        return "\""+this.string+"\"";
    }
}

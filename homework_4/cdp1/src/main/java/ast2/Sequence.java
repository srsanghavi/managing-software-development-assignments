package ast2;

/**
 * The type Sequence.
 *
 * @author Shashwat Sanghavi
 *
 * Note: extends type Expression
 */
public class Sequence extends Statement {
    private Statement statement1;
    private Statement statement2;

    /**
     * Instantiates a new Sequence.
     *
     * @param statement1 the statement 1
     * @param statement2 the statement 2
     */
    public Sequence(Statement statement1, Statement statement2){
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public String textRepresentation() {
        return this.statement1.textRepresentation()+" "+this.statement2.textRepresentation();
    }
}

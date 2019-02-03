package ast3;


/**
 * The type Logging node factory.
 */
public class LoggingNodeFactory implements NodeFactory {
    private int numberExpressionCount;
    private int variableExpressionCount;
    private int stringExpressionCount;
    private int infixExpressionCount;
    private int prefixExpressionCount;
    private int expressionCount;
    private int statementCount;
    private int assignmentCount;
    private int declarationCount;
    private int sequenceCount;

    /**
     * Instantiates a new Logging node factory.
     */
    public LoggingNodeFactory() {
        this.numberExpressionCount = 0;
        this.stringExpressionCount = 0;
        this.infixExpressionCount = 0;
        this.prefixExpressionCount = 0;
        this.expressionCount = 0;
        this.statementCount = 0;
        this.assignmentCount = 0;
        this.declarationCount = 0;
        this.sequenceCount = 0;
    }

    public InfixExpression makeInfixExpression(Operator operator, Expression operandLeft, Expression operandRight) {
        this.expressionCount += 1;
        this.infixExpressionCount += 1;
        return new InfixExpression(operator,operandLeft,operandRight);
    }

    public PrefixExpression makePrefixExpression(Operator operator, Expression operandLeft, Expression operandRight) {
        this.expressionCount += 1;
        this.prefixExpressionCount += 1;
        return new PrefixExpression(operator,operandLeft,operandRight);
    }

    public NumberExpression makeNumberExpression(int number) {
        this.expressionCount += 1;
        this.numberExpressionCount += 1;
        return new NumberExpression(number);
    }

    public StringExpression makeStringExpression(String string) {
        this.expressionCount += 1;
        this.stringExpressionCount += 1;
        return new StringExpression(string);
    }

    public VariableExpression makeVariableExpression(Variable variable) {
        this.expressionCount += 1;
        this.variableExpressionCount += 1;
        return new VariableExpression(variable);
    }

    public Declaration makeDeclaration(Variable variable) {
        this.statementCount += 1;
        this.declarationCount += 1;
        return new Declaration(variable);
    }

    public Assignment makeAssignment(Variable variable, Expression exp) {
        this.statementCount += 1;
        this.assignmentCount += 1;
        return new Assignment(variable,exp);
    }

    public Sequence makeSequence(Statement statement1, Statement statement2) {
        this.statementCount += 1;
        this.sequenceCount += 1;
        return new Sequence(statement1,statement2);
    }

    /**
     * Report.
     *
     * Prints report: count of node types created
     */
    public void report() {
        System.out.println("****** REPORT *******");
        System.out.println("Expression Count: " + this.expressionCount);
        System.out.println("\t Infix Expression Count: " + this.infixExpressionCount);
        System.out.println("\t Prefix Expression Count: " + this.prefixExpressionCount);
        System.out.println("\t Number Expression Count: " + this.numberExpressionCount);
        System.out.println("\t Variable Expression Count: " + this.variableExpressionCount);
        System.out.println("\t String Expression Count: " + this.stringExpressionCount);
        System.out.println("\n");
        System.out.println("Statement count: " + this.statementCount);
        System.out.println("\t Assignment Count: " + this.assignmentCount);
        System.out.println("\t Declaration Count: " + this.declarationCount);
        System.out.println("\t Sequence count: " + this.sequenceCount);

    }
}

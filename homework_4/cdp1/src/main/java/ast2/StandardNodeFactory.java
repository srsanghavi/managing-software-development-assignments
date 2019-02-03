package ast2;

/**
 * The type Standard node factory.
 * @author Shashwat Sanghavi
 */
public class StandardNodeFactory implements NodeFactory {
    public InfixExpression makeInfixExpression(Operator operator, Expression operandLeft, Expression operandRight) {
        return new InfixExpression(operator,operandLeft,operandRight);
    }

    public PrefixExpression makePrefixExpression(Operator operator, Expression operandLeft, Expression operandRight) {
        return new PrefixExpression(operator,operandLeft,operandRight);
    }

    public NumberExpression makeNumberExpression(int number) {
        return new NumberExpression(number);
    }

    public StringExpression makeStringExpression(String string) {
        return new StringExpression(string);
    }

    public VariableExpression makeVariableExpression(Variable variable) {
        return new VariableExpression(variable);
    }

    public Declaration makeDeclaration(Variable variable) {
        return new Declaration(variable);
    }

    public Assignment makeAssignment(Variable variable, Expression exp) {
        return new Assignment(variable,exp);
    }

    public Sequence makeSequence(Statement statement1, Statement statement2) {
        return new Sequence(statement1,statement2);
    }
}

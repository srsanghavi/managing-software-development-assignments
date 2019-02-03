package ast4;

/**
 * The interface Node factory.
 * @author Shashwat Sanghavi
 */
interface NodeFactory {
    /**
     * Make infix expression infix expression.
     *
     * @param operator      the operator
     * @param operandLeft   the operand left
     * @param operandRifght the operand rifght
     * @return the infix expression
     */
    public InfixExpression makeInfixExpression(Operator operator,
                                               Expression operandLeft, Expression operandRifght);

    /**
     * Make prefix expression prefix expression.
     *
     * @param operator      the operator
     * @param operandLeft   the operand left
     * @param operandRifght the operand rifght
     * @return the prefix expression
     */
    public PrefixExpression makePrefixExpression(Operator operator,
                                                 Expression operandLeft, Expression operandRifght);

    /**
     * Make number expression number expression.
     *
     * @param number the number
     * @return the number expression
     */
    public NumberExpression makeNumberExpression(int number);

    /**
     * Make string expression string expression.
     *
     * @param string the string
     * @return the string expression
     */
    public StringExpression makeStringExpression(String string);

    /**
     * Make variable expression variable expression.
     *
     * @param variable the variable
     * @return the variable expression
     */
    public VariableExpression makeVariableExpression(Variable variable);

    /**
     * Make declaration declaration.
     *
     * @param variable the variable
     * @return the declaration
     */
    public Declaration makeDeclaration(Variable variable);

    /**
     * Make assignment assignment.
     *
     * @param variable the variable
     * @param exp      the exp
     * @return the assignment
     */
    public Assignment makeAssignment(Variable variable, Expression exp);

    /**
     * Make sequence sequence.
     *
     * @param statement1 the statement 1
     * @param statement2 the statement 2
     * @return the sequence
     */
    public Sequence makeSequence(Statement statement1, Statement statement2);
}


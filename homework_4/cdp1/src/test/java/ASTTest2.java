import ast2.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASTTest2 {

    /*
        Default test case
     */
    @Test
    public void test1(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable x = new Variable('x');
        Expression one = snf.makeNumberExpression(1);
        Expression two = snf.makeNumberExpression(2);
        Operator o = new Operator("+");
        Expression exp = snf.makeInfixExpression(o,one,two);
        Statement decl = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,exp);
        Statement seq = snf.makeSequence(decl,assign);
        assertEquals( "var x; x = 1 + 2;",seq.textRepresentation());
    }

    /*
        test Variable, variableExpression, Declaration, Sequence and assignment
     */
    @Test
    public void testVariableExpression(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable v1 = new Variable('s');
        Variable v2 = new Variable('x');
        Expression vex = snf.makeVariableExpression(v1);
        Statement declareS = snf.makeDeclaration(v1);
        Statement declareX = snf.makeDeclaration(v2);
        Statement seq = snf.makeSequence(declareS,declareX);
        Statement assign = snf.makeAssignment(v2,vex);
        seq = snf.makeSequence(seq,assign);
        assertEquals("var s; var x; x = s;",seq.textRepresentation());
    }

    /*
            test Variable, Operator, NumberExpression, Declaration, Sequence and assignment

     */
    @Test
    public void testPrefixExpression(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable x = new Variable('x');
        Expression one = snf.makeNumberExpression(1);
        Expression two = snf.makeNumberExpression(-2);
        Operator o = new Operator("*");
        Expression exp = snf.makePrefixExpression(o,one,two);
        Statement declare = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,exp);
        Statement sequence = snf.makeSequence(declare,assign);
        assertEquals("var x; x = * 1 -2;",sequence.textRepresentation());
    }

    /*
            test Variable, Operator, String, Declaration, Sequence and assignment

     */
    @Test
    public void testStringExpression(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable x = new Variable('x');
        Expression st = snf.makeStringExpression("hoho");
        Statement decl = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,st);
        Statement seq = snf.makeSequence(decl,assign);
        assertEquals( "var x; x = \"hoho\";",seq.textRepresentation());
    }

    /*
            test Variable, Operator, StringExpression, NumberExpression, Declaration, Sequence and assignment
            nested infix expression
     */
    @Test
    public void testNestedInfixExpression(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable x = new Variable('x');
        Expression st = snf.makeStringExpression("hoho");
        Expression eleven = snf.makeNumberExpression(11);
        Expression twelve = snf.makeNumberExpression(12);
        Operator plus = new Operator("+");
        Expression expr = snf.makeInfixExpression(plus,eleven,twelve);
        expr = snf.makeInfixExpression(plus,expr,st);
        Statement decl = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,expr);
        Statement seq = snf.makeSequence(decl,assign);
        assertEquals("var x; x = 11 + 12 + \"hoho\";",seq.textRepresentation());
    }
}

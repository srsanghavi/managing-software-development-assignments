package tests;

import ast.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ASTTests {

    /*
        Default test case
     */
    @Test
    public void test1(){
        Variable x = new Variable('x');
        Expression one = new NumberExpression(1);
        Expression two = new NumberExpression(2);
        Operator o = new Operator("+");
        Expression exp = new InfixExpression(o,one,two);
        Statement decl = new Declaration(x);
        Statement assign = new Assignment(x,exp);
        Statement seq = new Sequence(decl,assign);
        assertEquals( "var x; x = 1 + 2;",seq.textRepresentation());
    }

    @Test
    public void testVariableExpression(){
        Variable v1 = new Variable('s');
        Variable v2 = new Variable('x');
        Expression vex = new VariableExpression(v1);
        Statement declareS = new Declaration(v1);
        Statement declareX = new Declaration(v2);
        Statement seq = new Sequence(declareS,declareX);
        Statement assign = new Assignment(v2,vex);
        seq = new Sequence(seq,assign);
        assertEquals("var s; var x; x = s;",seq.textRepresentation());
    }

    @Test
    public void testPrefixExpression(){
        Variable x = new Variable('x');
        Expression one = new NumberExpression(1);
        Expression two = new NumberExpression(-2);
        Operator o = new Operator("*");
        Expression exp = new PrefixExpression(o,one,two);
        Statement declare = new Declaration(x);
        Statement assign = new Assignment(x,exp);
        Statement sequence = new Sequence(declare,assign);
        assertEquals("var x; x = * 1 -2;",sequence.textRepresentation());
    }

    @Test
    public void testStringExpression(){
        Variable x = new Variable('x');
        Expression st = new StringExpression("hoho");
        Statement decl = new Declaration(x);
        Statement assign = new Assignment(x,st);
        Statement seq = new Sequence(decl,assign);
        assertEquals( "var x; x = \"hoho\";",seq.textRepresentation());
    }

    @Test
    public void testNestedInfixExpression(){
        Variable x = new Variable('x');
        Expression st = new StringExpression("hoho");
        Expression eleven = new NumberExpression(11);
        Expression twelve = new NumberExpression(12);
        Operator plus = new Operator("+");
        Expression expr = new InfixExpression(plus,eleven,twelve);
        expr = new InfixExpression(plus,expr,st);
        Statement decl = new Declaration(x);
        Statement assign = new Assignment(x,expr);
        Statement seq = new Sequence(decl,assign);
        assertEquals("var x; x = 11 + 12 + \"hoho\";",seq.textRepresentation());
    }
}

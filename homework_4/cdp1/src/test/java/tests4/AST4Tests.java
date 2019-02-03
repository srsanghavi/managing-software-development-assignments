package tests4;

import ast4.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AST4Tests {

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

    @Test
    public void testVariableExpression(){
        StandardNodeFactory snf = new StandardNodeFactory();
        Variable v1 = new Variable('s');
        Variable v2 = new Variable('x');
        Expression exp = snf.makeVariableExpression(v2);
        Statement declareS = snf.makeDeclaration(v1);
        Statement assign = snf.makeAssignment(v1,exp);
        Statement declareX = snf.makeDeclaration(v2);
        Statement seq = snf.makeSequence(declareS,declareX);
        seq = snf.makeSequence(seq,assign);
        assertEquals("var s; var s; s = x;",seq.textRepresentation());
    }

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

    @Test
    public void testMultipleDeclaration(){
        StandardNodeFactory snf = new StandardNodeFactory();

        Variable x = new Variable('x');
        Variable y = new Variable('y');
        Expression one = snf.makeNumberExpression(2121212);
        Statement declarex = snf.makeDeclaration(x);
        Statement assignment = snf.makeAssignment(x,one);
        Statement declarey = snf.makeDeclaration(y);
        Statement seq = snf.makeSequence(declarex,assignment);
        seq = snf.makeSequence(seq,declarey);
        assertEquals("var x; x = 2121212; var x;",seq.textRepresentation());
    }


    @Test
    public void test1Logging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();

        Variable x = new Variable('x');
        Expression one = snf.makeNumberExpression(1);
        Expression two = snf.makeNumberExpression(2);
        Operator o = new Operator("+");
        Expression exp = snf.makeInfixExpression(o,one,two);
        Statement decl = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,exp);
        Statement seq = snf.makeSequence(decl,assign);
        assertEquals( "var x; x = 1 + 2;",seq.textRepresentation());
        snf.report();
    }

    @Test
    public void testVariableExpressionLogging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();
        Variable v1 = new Variable('s');
        Variable v2 = new Variable('x');
        Expression exp = snf.makeVariableExpression(v2);
        Statement declareS = snf.makeDeclaration(v1);
        Statement assign = snf.makeAssignment(v1,exp);
        Statement declareX = snf.makeDeclaration(v2);
        Statement seq = snf.makeSequence(declareS,declareX);
        seq = snf.makeSequence(seq,assign);
        assertEquals("var s; var s; s = x;",seq.textRepresentation());
        snf.report();
    }

    @Test
    public void testPrefixExpressionLogging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();

        Variable x = new Variable('x');
        Expression one = snf.makeNumberExpression(1);
        Expression two = snf.makeNumberExpression(-2);
        Operator o = new Operator("*");
        Expression exp = snf.makePrefixExpression(o,one,two);
        Statement declare = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,exp);
        Statement sequence = snf.makeSequence(declare,assign);
        assertEquals("var x; x = * 1 -2;",sequence.textRepresentation());
        snf.report();
    }

    @Test
    public void testStringExpressionLogging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();

        Variable x = new Variable('x');
        Expression st = snf.makeStringExpression("hoho");
        Statement decl = snf.makeDeclaration(x);
        Statement assign = snf.makeAssignment(x,st);
        Statement seq = snf.makeSequence(decl,assign);
        assertEquals( "var x; x = \"hoho\";",seq.textRepresentation());
        snf.report();
    }

    @Test
    public void testNestedInfixExpressionLogging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();

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
        snf.report();
    }

    @Test
    public void testMultipleDeclarationLogging(){
        LoggingNodeFactory snf = new LoggingNodeFactory();

        Variable x = new Variable('x');
        Variable y = new Variable('y');
        Expression one = snf.makeNumberExpression(2121212);
        Statement declarex = snf.makeDeclaration(x);
        Statement assignment = snf.makeAssignment(x,one);
        Statement declarey = snf.makeDeclaration(y);
        Statement seq = snf.makeSequence(declarex,assignment);
        seq = snf.makeSequence(seq,declarey);
        assertEquals("var x; x = 2121212; var x;",seq.textRepresentation());
        snf.report();
    }

}

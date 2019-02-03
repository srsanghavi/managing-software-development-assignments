import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.ASTTests;
import tests2.AST2Tests;
import tests3.AST3Tests;
import tests4.AST4Tests;

@RunWith(value = Suite.class)
@SuiteClasses({ASTTests.class, AST2Tests.class, AST3Tests.class, AST4Tests.class})

public class TestSuite {
}
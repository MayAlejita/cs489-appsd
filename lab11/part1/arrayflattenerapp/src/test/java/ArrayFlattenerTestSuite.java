import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("ArrayFlattener TestSuite")
@SelectClasses(value = {ArrayFlattenerTest.class, ArrayFlattenerNullTest.class})
public class ArrayFlattenerTestSuite {
}

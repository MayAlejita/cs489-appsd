import edu.miu.cs489.arrayflattener.ArrayFlattener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ArrayFlattenerNullTest {
    private ArrayFlattener arrayFlattener;

    @Before
    public void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @After
    public void tearDown() {
        arrayFlattener = null;
    }

    @Test
    public void testFlattenArray() {
        Integer [][] input = null;
        Integer [] expected = null;
        Integer [] actual = arrayFlattener.flattenArray(input);
        assertThat(actual, equalTo(expected));
    }
}

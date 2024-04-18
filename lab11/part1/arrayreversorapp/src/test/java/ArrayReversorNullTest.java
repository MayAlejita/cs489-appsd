import edu.miu.cs489.arrayreversor.ArrayReversor;
import edu.miu.cs489.arrayreversor.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {
    private ArrayReversor arrayReversor;
    ArrayFlattenerService arrayFlattenerService2 = mock(ArrayFlattenerService.class);

    @Before
    public void setUp() {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService2);
    }

    @After
    public void tearDown() {
        this.arrayReversor = null;
    }

    @Test
    public void testReverseArray() {
        Integer [][] a_in = null;
        when(arrayFlattenerService2.flattenArray(null)).thenReturn(null);
        Integer [] result = arrayReversor.reverseArray(a_in);
        assertThat(result, equalTo(null));
    }
}

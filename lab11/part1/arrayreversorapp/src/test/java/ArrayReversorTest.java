import edu.miu.cs489.arrayreversor.ArrayReversor;
import edu.miu.cs489.arrayreversor.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {

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
        Integer [] e1 = {1,3};
        Integer [] e2 = {0};
        Integer [] e3 = {4,5,9};
        Integer [][] a_in = new Integer[][]{e1,e2,e3};

        when(arrayFlattenerService2.flattenArray(Mockito.any())).thenReturn(new Integer[]{1,3,0,4,5,9});
        Integer [] result = arrayReversor.reverseArray(a_in);
        assertThat(result, is(new Integer[]{9,5,4,0,3,1}));
        verify(arrayFlattenerService2).flattenArray(a_in);
    }
}

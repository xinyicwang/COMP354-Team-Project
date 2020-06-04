import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NRootTest {

    @Test
    public void testNRoot(int value, int n) {
        double a = NRoot.nRoot(value, n);
        assertEquals(value, Math.pow(Math.round(a), n));
    }
    
    //testing

}
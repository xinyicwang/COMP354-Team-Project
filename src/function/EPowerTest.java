import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EPowerTest {

    private final static double E =  2.718281828459045;

    @Test
    public void testEPower() {
        // exponent is integer
        assertEquals(EPower.ePower(0), Math.pow(E, 0));

        // exponent is not integer
        assertEquals(EPower.ePower(1.5), Math.pow(E, 1.5));
    }

}
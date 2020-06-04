import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    public void testPower() {
        // base number is integer, exponent is integer
        assertEquals(Power.power(5, 2), Math.pow(5, 2));

        // base number is integer, exponent is not integer
        assertEquals(Power.power(5, 1.5), Math.pow(5, 1.5));

        // base number is not integer, exponent is integer
        assertEquals(Power.power(1.5, 2), Math.pow(1.5, 2));

        // base number is not integer, exponent is not integer
        assertEquals(Power.power(1.5, 1.5), Math.pow(1.5, 1.5));
    }

}
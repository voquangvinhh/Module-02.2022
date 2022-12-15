import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CylinderTest {
    @Test
    @DisplayName("Testing getVolume(0,0)")
    public void testGetVolume0And0(){
        int radius = 0;
        int height = 0;
        double expected = 0;

        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected, result);
    }


}

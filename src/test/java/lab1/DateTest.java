package lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    @DisplayName("--- testing method toString ---")
    void testToString() {
        assertTrue("11.11.2022".equals(new Date(11, 11, 2022).toString()));
    }
}
package lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class RecordBookTest {

    @Test
    @DisplayName("--- testing method counting days to birthday ---")
    void birthdayToday() {
        Calendar cal = Calendar.getInstance();
        assertTrue("birthday today".equals(new RecordBook("name", "surname", "patronymic",
                "+380660000000", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, 2020).daysToBirthday()));
    }

    @Test
    @DisplayName("--- testing method counting days to birthday ---")
    void birthdayNotToday() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_MONTH) <= 20) {
            assertTrue("birthday in 5 day(s)".equals(new RecordBook("name", "surname", "patronymic",
                    "+380660000000", cal.get(Calendar.DAY_OF_MONTH)+5, cal.get(Calendar.MONTH)+1, 2020).daysToBirthday()));
        } else {
            assertTrue("birthday in 360 day(s)".equals(new RecordBook("name", "surname", "patronymic",
                    "+380660000000", cal.get(Calendar.DAY_OF_MONTH) - 5, cal.get(Calendar.MONTH)+1, 2020).daysToBirthday()));
        }
    }

    @Test
    @DisplayName("--- testing method toString ---")
    void testToString() {
        String expected = """
                Name: name
                Surname: surname
                Patronymic: patronymic
                Phone: +380660000000
                Date of birth: 5.5.2020""";
        assertTrue(expected.equals(new RecordBook("name", "surname", "patronymic",
                "+380660000000", 5, 5, 2020).toString()));
    }
}
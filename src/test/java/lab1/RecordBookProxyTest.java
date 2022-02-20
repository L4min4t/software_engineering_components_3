package lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordBookProxyTest {

    @Test
    @DisplayName("--- testing proxing setters ---")
    public void invoke() {
        RecordBook entity = new RecordBook("Kolia", "Pupkin", "Vasilievich", "+380961589623", 20, 11, 2002);
        IRecordBook proxy = (IRecordBook) RecordBookProxy.newProxyInstance(entity);
        assertThrows(IllegalAccessError.class, () -> {proxy.setName("some new name");});
    }
}
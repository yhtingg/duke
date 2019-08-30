package duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {
    @Test
    public void testDate() {
        assertEquals("31st of August 2019", new Date("31/08/2019 0000").getDate());
        assertEquals("2nd of September 2020", new Date("02/09/2020 0000").getDate());
        assertEquals("27th of October 1997", new Date("27/10/1997 0000").getDate());
    }

    @Test
    public void testTime() {
        assertEquals("12:00am", new Date("01/01/2000 0000"));
        assertEquals("11:59pm", new Date("01/01/2000 2359"));
        assertEquals("12:35pm", new Date("01/01/2000 1235"));
    }
}

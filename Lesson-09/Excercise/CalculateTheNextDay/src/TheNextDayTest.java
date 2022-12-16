import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TheNextDayTest {
    @Test
    @DisplayName("case 1/1/2022")
    public void testDay1Month1Year2022(){
        int dayTest = 1;
        int monthTest = 1;
        int yearTest = 2022;
        String result = TheNextDay.getNextDay(dayTest,monthTest,yearTest);
        String expected = "2/1/2022";
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("case 31/1/2022")
    public void testDay31Month1Year2022(){
        int dayTest = 31;
        int monthTest = 1;
        int yearTest = 2022;
        String result = TheNextDay.getLastDayMonth(dayTest, monthTest, yearTest);
        String expected = "1/2/2022";
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("case 30/4/2022")
    public void testDay30Month4Year2022(){
        int dayTest = 30;
        int monthTest = 4;
        int yearTest = 2022;
        String result = TheNextDay.getLast30DayMonth(dayTest, monthTest, yearTest);
        String expected = "1/5/2022";
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("case 28/2/2022")
    public void testDay28Month2Year2022(){
        int dayTest = 28;
        int monthTest = 2;
        int yearTest = 2022;

        String result =TheNextDay.getMonth2(dayTest, monthTest, yearTest);
        String expected = "1/3/2022";
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("case 29/2/2022")
    public void testDay29Month2Year2022(){
        int dayTest = 29;
        int monthTest = 2;
        int yearTest = 2022;

        String result = TheNextDay.getMonth2(dayTest, monthTest, yearTest);
        String expected = "1/3/2022";
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("case 31/12/2022")
    public void testDay31Month12Year2022(){
        int dayTest = 31;
        int monthTest = 12;
        int yearTest = 2022;

        String result = TheNextDay.getLastDayOfYear(dayTest, monthTest, yearTest);
        String expected = "1/1/2023";
        assertEquals(expected,result);
    }
}
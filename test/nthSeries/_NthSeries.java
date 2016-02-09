package nthSeries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _NthSeries {

    @Test
    public void test1() {
        assertEquals(NthSeries.seriesSum(5), "1.57");
    }

    @Test
    public void test3() {
        assertEquals(NthSeries.seriesSum(15), "1.94");
    }

}

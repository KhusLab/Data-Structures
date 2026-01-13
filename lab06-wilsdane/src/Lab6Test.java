import static org.junit.jupiter.api.Assertions.*;

class Lab6Test {

    @org.junit.jupiter.api.Test
    void testCase1() {
        double[] p = {1,5,8,9,10,17,17,20,24,30};

        assertEquals(1,Lab6.cutRodBottomUp(p,1));
        assertEquals(5,Lab6.cutRodBottomUp(p,2));
        assertEquals(8,Lab6.cutRodBottomUp(p,3));
        assertEquals(10,Lab6.cutRodBottomUp(p,4));
        assertEquals(13,Lab6.cutRodBottomUp(p,5));
        assertEquals(17,Lab6.cutRodBottomUp(p,6));
        assertEquals(18,Lab6.cutRodBottomUp(p,7));
        assertEquals(22,Lab6.cutRodBottomUp(p,8));
        assertEquals(25,Lab6.cutRodBottomUp(p,9));
        assertEquals(30.0,Lab6.cutRodBottomUp(p,10));
    }

    // implement your two additional tests here
    //1. leng 3
    @org.junit.jupiter.api.Test
    public void testRodLengthThree() {
        Lab6 lab = new Lab6();
        double[] prices = {1.0, 5.0, 8.0};
        int length = 3;
        double expected = 8.0;  // Best cut is full length 3
        assertEquals(expected, lab.cutRodBottomUp(prices, length), 0.001);
    }
    //2. leng 5
    @org.junit.jupiter.api.Test
    public void testRodLengthFive() {
        Lab6 lab = new Lab6();
        double[] prices = {2.0, 5.0, 9.0, 10.0, 17.0};
        int length = 5;
        double expected = 17.0;  // Best cut is full length 5
        assertEquals(expected, lab.cutRodBottomUp(prices, length), 0.001);
    }

}

package portugal.ergo.tools;

import static org.junit.jupiter.api.Assertions.*;


class FunctionsTest {

    @org.junit.jupiter.api.Test
    void kwPerHour() {
        assertEquals(12.0, Functions.kwPerHour(500.0,24.0));
    }

    @org.junit.jupiter.api.Test
    void dailyBlockRewards() {
        assertEquals(34560.0, Functions.dailyBlockRewards(48.0, 2.0));
    }

    @org.junit.jupiter.api.Test
    void dailyBlockRewardsInValue() {
        assertEquals(103_680.0 ,Functions.dailyBlockRewardsInValue(48.0,3.0,2.0));
    }

    @org.junit.jupiter.api.Test
    void dailyCost() { assertEquals(2.40, Functions.dailyCost(500.0,24.0,0.20), 0.00000000001); }

    @org.junit.jupiter.api.Test
    void dailyReturns() {
        assertEquals(4.316683322825412e-6,Functions.dailyReturns(48.0, 3.0, 12009220070855L,500.0,2.0));
    }

    @org.junit.jupiter.api.Test
    void minedTokenShare() {
        assertEquals(4.1634677110584614e-11, Functions.minedTokenShare(500.0,12009220070855L));
    }

    @org.junit.jupiter.api.Test
    void minedReturnsErg() {
        assertEquals(1.199078700784837E-6, Functions.minedReturnsErg(40.0,500.0,12009220070855L,2.0));
    }
}
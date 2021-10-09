package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {
    @Test
    @Disabled("for some reason unknown to me")
    void test0() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test1() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test2() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test3() {
        assertTrue(true);
    }

}

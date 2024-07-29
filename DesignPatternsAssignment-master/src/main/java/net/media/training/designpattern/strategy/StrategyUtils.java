package net.media.training.designpattern.strategy;

public class StrategyUtils {
    public static void atLeast(int val, int min) {
        if (val < min)
            throw new RuntimeException("at least check failed:" + val);
    }

    public static void atMost(int val, int max) {
        if (val > max) {
            throw new RuntimeException("at least check failed:" + val);
        }
    }
}

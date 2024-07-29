package net.media.training.designpattern.strategy;

public class RangeBoundCheckerStrategy implements BoundCheckerStrategy {
    private final int lowerBound;
    private final int upperBound;

    public RangeBoundCheckerStrategy(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public void validate(int value) {
        StrategyUtils.atLeast(value, lowerBound);
        StrategyUtils.atMost(value, upperBound);
    }
}

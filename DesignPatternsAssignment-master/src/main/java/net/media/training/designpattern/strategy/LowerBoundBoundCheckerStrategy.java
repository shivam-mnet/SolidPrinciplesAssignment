package net.media.training.designpattern.strategy;

public class LowerBoundBoundCheckerStrategy implements BoundCheckerStrategy {
    private final int lowerBound;

    public LowerBoundBoundCheckerStrategy(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    public void validate(int value) {
        StrategyUtils.atLeast(value, lowerBound);
    }
}

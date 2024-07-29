package net.media.training.designpattern.strategy;

public class LengthStringValidationStrategy implements StringValidationStrategy {
    private BoundCheckerStrategy boundCheckerStrategy;

    public LengthStringValidationStrategy(BoundCheckerStrategy boundCheckerStrategy) {
        this.boundCheckerStrategy = boundCheckerStrategy;
    }

    @Override
    public void validate(String val) {
        try {
            if (val == null || val.isEmpty())
                throw new RuntimeException("Invalid length:" + 0);
            boundCheckerStrategy.validate(val.length());
        } catch (Exception e) {
            throw new RuntimeException("Invalid length:" + val.length());
        }
    }
}

package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:37:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends CompanyMember {
    private String managementBand;
    private final StringValidationStrategy managementBandStrategy;

    public Manager() {
        salaryStrategy = new LowerBoundBoundCheckerStrategy(1);
        monthsStrategy = new LowerBoundBoundCheckerStrategy(0);
        managementBandStrategy = new LengthStringValidationStrategy(new LowerBoundBoundCheckerStrategy(0));
    }

    public void setManagementBand(String managementBand) {
        managementBandStrategy.validate(managementBand);
        this.managementBand = managementBand;
    }
}

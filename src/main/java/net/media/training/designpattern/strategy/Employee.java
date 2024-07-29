package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:31:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee extends CompanyMember {
    private int maxAllowedLeaves;
    private BoundCheckerStrategy maxLeavesStrategy;

    Employee() {
        maxLeavesStrategy = new LowerBoundBoundCheckerStrategy(1);
        salaryStrategy = new RangeBoundCheckerStrategy(1, 1000);
        monthsStrategy = new LowerBoundBoundCheckerStrategy(0);
    }

    public void setMaxAllowedLeaves(int leaves) {
        maxLeavesStrategy.validate(leaves);
        this.maxAllowedLeaves = leaves;
    }
}


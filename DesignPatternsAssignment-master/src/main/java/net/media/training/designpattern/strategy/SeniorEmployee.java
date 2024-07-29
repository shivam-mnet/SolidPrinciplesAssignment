package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:35:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeniorEmployee extends CompanyMember {
    private int setMaxBonus;
    private final BoundCheckerStrategy maxBonusStrategy;

    public SeniorEmployee() {
        maxBonusStrategy = new LowerBoundBoundCheckerStrategy(1);
        salaryStrategy = new RangeBoundCheckerStrategy(200, 1000);
        monthsStrategy = new LowerBoundBoundCheckerStrategy(60);
    }

    public void setMaxBonus(int bonus) {
        maxBonusStrategy.validate(bonus);
        this.setMaxBonus = bonus;
    }
}

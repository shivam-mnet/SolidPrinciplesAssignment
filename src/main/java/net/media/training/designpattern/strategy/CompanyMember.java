package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:14:31 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompanyMember {
    private String name;
    protected String mgrName;
    protected int salary;
    protected int monthsSpent;

    protected BoundCheckerStrategy salaryStrategy;
    protected BoundCheckerStrategy monthsStrategy;
    protected StringValidationStrategy nameValidationStrategy;

    public CompanyMember() {
        nameValidationStrategy = new LengthStringValidationStrategy(new RangeBoundCheckerStrategy(0, 50));
    }

    public void setName(String name) {
        nameValidationStrategy.validate(name);
        this.name = name;
    }

    public void setSalary(int salary) {
        salaryStrategy.validate(salary);
        this.salary = salary;
    }

    public void setMonthsSpent(int months) {
        monthsStrategy.validate(months);
        this.monthsSpent = months;
    }

    public void setManagerName(String name) {
        nameValidationStrategy.validate(name);
        this.mgrName = name;
    }
}

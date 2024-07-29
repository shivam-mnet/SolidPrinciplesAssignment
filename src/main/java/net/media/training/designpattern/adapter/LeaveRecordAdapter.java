package net.media.training.designpattern.adapter;

import java.util.Arrays;
import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

public class LeaveRecordAdapter implements LeaveRecord {
    private final ThirdPartyLeaveRecord thirdPartyLeaveRecord;

    public LeaveRecordAdapter() {
        thirdPartyLeaveRecord = new ThirdPartyLeaveRecord();
    }

    @Override
    public String getMostAbsentEmployee() {
        String employeeName = thirdPartyLeaveRecord.getMostAbsentEmployee().getName();
        String [] names = employeeName.split(",");
        return names[1].trim() + " " + names[0];
    }

    @Override
    public int getEmployeeAbsences(String employeeName) {
        return thirdPartyLeaveRecord.getEmployeeAbsences(new Employee(getFormattedName(employeeName)));
    }

    private String getFormattedName(String employeeName) {
        String [] names = employeeName.split(" ");
        String lastName = names[names.length - 1];
        StringBuilder firstNameBuilder = new StringBuilder();
        for (int i = 0; i < names.length - 1; ++i) {
            firstNameBuilder.append(names[i]).append(" ");
        }
        return lastName + ", " + firstNameBuilder.toString().trim();
    }
}

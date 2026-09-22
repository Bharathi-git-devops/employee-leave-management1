package com.devops.leave.model;

public class LeaveRequest {

    private int employeeId;
    private String leaveType;
    private int days;

    public LeaveRequest(int employeeId, String leaveType, int days) {
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.days = days;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getDays() {
        return days;
    }
}

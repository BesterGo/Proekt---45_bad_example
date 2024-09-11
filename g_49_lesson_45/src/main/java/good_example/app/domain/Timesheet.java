package good_example.app.domain;

import java.util.Objects;

public class Timesheet {

    private int hours;
    private String employeeName;
    private String department;

    public Timesheet(int hours, String employeeName, String department) {
        this.hours = hours;
        this.employeeName = employeeName;
        this.department = department;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheet timesheet = (Timesheet) o;
        return hours == timesheet.hours && Objects.equals(employeeName, timesheet.employeeName) && Objects.equals(department, timesheet.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, employeeName, department);
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "hours=" + hours +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
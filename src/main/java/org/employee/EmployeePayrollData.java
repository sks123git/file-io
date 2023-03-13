package org.employee;

import java.io.Serializable;

public class EmployeePayrollData implements Serializable {
    public int id;
    public String name;
    public double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", Name: "+ this.name + ", Salary: " + this.salary;
    }
}

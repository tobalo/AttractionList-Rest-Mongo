package edu.txstate.sl20.mongodb;

/**
 * Created by sl20 on 4/23/2018.
 */

public class Employee {
    private String oid;
    private int employeeId;
    private String account;
    private double salary;

    public Employee(String oid, int employeeId, String account, double salary) {
        this.oid = oid;
        this.employeeId = employeeId;
        this.account = account;
        this.salary = salary;
    }

    public Employee(int employeeId, String account, double salary) {
        this.employeeId = employeeId;
        this.account = account;
        this.salary = salary;
    }
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){return employeeId + ", " + account;}
}

package com.dash.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    @Column(name="firstName",length = 20)
    private String ename;
    @Column(name="address",length = 30)
    private String eaddress;
    @Column(name="salary",length = 15)
    private double esalary;

    public Employee() {

    }
    public Employee(int eid, String ename, String eaddress, double esalary) {
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.esalary = esalary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public double getEsalary() {
        return esalary;
    }

    public void setEsalary(double esalary) {
        this.esalary = esalary;
    }
}

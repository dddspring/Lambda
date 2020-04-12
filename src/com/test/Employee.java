package com.test;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private double moneg;

    public Employee(){

    }

    public Employee(int age){
        this.age = age;
    }

    public Employee(String name, int age, double moneg) {
        this.name = name;
        this.age = age;
        this.moneg = moneg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", moneg=" + moneg +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoneg() {
        return moneg;
    }

    public void setMoneg(double moneg) {
        this.moneg = moneg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.moneg, moneg) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, moneg);
    }
}

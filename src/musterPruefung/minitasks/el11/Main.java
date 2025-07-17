package musterPruefung.minitasks.el11;

//stream

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Employee {
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(Integer age, String gender, String firstName, String lastName, double salary) {
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public double calculateAverage(List<Employee> employeeList){
        return employeeList.stream()
                .map(x-> x.getSalary())
                .mapToDouble(x -> x)
                .average()
                .getAsDouble();
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

package Uebung8.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class EmployeeAdministration {
    List<Employee> employees = new ArrayList<Employee>();

    public EmployeeAdministration(List<Employee> list) {
        employees.addAll(list);
    }

    public void add(Employee e) {
        employees.add(e);
    }

    //.................................
    public List<Employee> filter(Predicate<Employee> p) {
        return employees.stream().filter(p).toList();//terminate operators(foreach/toList/findfirst)
    }
}

class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public Employee(Integer id, Integer age, String gender, String fName,
                    String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", age=" + age + ", gender=" + gender + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

}

class EmployeeAdminTest {

    public static void applyPredicates() {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex David", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        EmployeeAdministration employees = new EmployeeAdministration(
                List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10)
        );


        // alle die älter als 18 sind
        Predicate<Employee> isAgeMoreThan18 = employee -> employee.getAge() > 18;

        // alle die männlich sind
        Predicate<Employee> isMale = x -> x.getGender().equals("M");

        // alle die weiblich sind
        Predicate<Employee> isFemale = isMale.negate();

        // alle die männlich und über 18 sind
        Predicate<Employee> isAdultMale = isAgeMoreThan18.and(isMale);

        // alle mit Vornamen David
        Predicate<Employee> firstNameDavid = x->x.getFirstName().contains("David");


        System.out.println("---- all employees > age 21----\n" + employees.filter(x -> x.getAge() > 21));

        System.out.println("\n---- all employees male----\n" + employees.filter(isMale));

        System.out.println("\n---- all employees female----\n" + employees.filter(isFemale));

        System.out.println("\n---- all employees AdultMale----\n" + employees.filter(isAdultMale));

        System.out.println("\n---- all employees David firstName----\n" + employees.filter(firstNameDavid));

        System.out.println("\n---- all employees <= age 35----\n" + employees.filter(x->x.getAge()<=35));

        System.out.println("\n---- all employees AdultMale or female----\n" + employees.filter(isAdultMale.or(isFemale)));
    }
}


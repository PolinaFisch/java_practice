package com.example.Uebung1.Two;

public class Two {
    public static void main(String[] args) {
        long employeeNumber = 0;
        String employeeName = null;
        double hourlySalary = 0.00;
        double weeklyTime = 0.00;
        double regularTime, overtime;
        double regularPay, overtimePay, netPay;

        System.out.print("Enter Employee Number (00000): ");
        //
        ScannerDecorator scannerCustom = new ScannerDecorator();
        employeeNumber = scannerCustom.nextLong();
        //

        if (employeeNumber == 82500)
            employeeName = "Peter Baker";
        else if (employeeNumber == 92746)
            employeeName = "John Kouma";
        else if (employeeNumber == 54080)
            employeeName = "Steg Larson";
        else if (employeeNumber == 86285)
            employeeName = "Gertrude Monay";
        else
            employeeName = "Unknown";

        System.out.print("Enter Hourly Salary: ");
        hourlySalary = scannerCustom.nextDouble();

        System.out.print("Enter Weekly Time: ");
        weeklyTime = scannerCustom.nextDouble();

        //
        if (weeklyTime < 0) {
            throw new IllegalArgumentException("Weekly time is negative.");//RuntimeEx
        }
        //

        if (weeklyTime < 40) {
            regularTime = weeklyTime;
            overtime = 0;
            regularPay = hourlySalary * regularTime;
            overtimePay = 0;
            netPay = regularPay;
        } else {
            regularTime = 40;
            overtime = weeklyTime - 40;
            regularPay = hourlySalary * 40;
            overtimePay = hourlySalary * overtime;
            netPay = regularPay + overtimePay;
        }

        System.out.println("======================");
        System.out.println("==-=-= Employee Payroll =-=-==");
        System.out.println("-------------------------------------------");
        System.out.printf("Employee #:    %d\n", employeeNumber);
        System.out.printf("Employee Name: %s\n", employeeName);
        System.out.printf("Hourly Salary: %.2f\n", hourlySalary);
        System.out.printf("Weekly Time:   %.2f\n", weeklyTime);
        System.out.printf("Regular Pay:   %.2f\n", regularPay);
        System.out.printf("Overtime Pay:  %.2f\n", overtimePay);
        System.out.printf("Total Pay:     %.2f\n", netPay);
        System.out.println("======================");
    }
}

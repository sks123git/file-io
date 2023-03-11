package org.employee;
//Program to perform IO operations
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollServices
{
    public  static List<EmployeePayrollData> empList = new ArrayList<EmployeePayrollData>();

    public void readEmployeeData(Scanner scanner){
        System.out.println("Enter the id:");
        int id = scanner.nextInt();
        System.out.println("Enter the name:");
        String name = scanner.next();
        System.out.println("Enter the Salary:");
        double salary = scanner.nextInt();
        empList.add(new EmployeePayrollData(id,name,salary));
}
    public void writeEmployeeData(){
        empList.forEach(System.out::println);
    }
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        EmployeePayrollServices emp1 = new EmployeePayrollServices();
        emp1.readEmployeeData(scanner);
        emp1.writeEmployeeData();

    }
}

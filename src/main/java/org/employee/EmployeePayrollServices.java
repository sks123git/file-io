package org.employee;
//Program to perform IO operations
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollServices
{
    public  static List<EmployeePayrollData> empList = new ArrayList<EmployeePayrollData>();
    public static ObjectOutputStream oos =null;
    public static ObjectInputStream ois = null;
    public static int entries = 0;
    public static File file = new File("Employee.txt");
    public void readEmployeeData(Scanner scanner) throws Exception{
        System.out.println("How many records you want to enter");
        int records = scanner.nextInt();
        for (int i = 0; i < records; i++) {
            System.out.println("Enter the id:");
            int id = scanner.nextInt();
            System.out.println("Enter the name:");
            String name = scanner.next();
            System.out.println("Enter the Salary:");
            double salary = scanner.nextInt();
            empList.add(new EmployeePayrollData(id, name, salary));
        }
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(empList);
        oos.close();
        entries++;

}
    public void writeEmployeeData(){
        System.out.println("--------------------------------");
        empList.forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    public void countEntries(){
            System.out.println("--------------------------------");
            System.out.println("entries made: "+entries);
            System.out.println("--------------------------------");

    }
    public static void main( String[] args ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        EmployeePayrollServices emp1 = new EmployeePayrollServices();
        int choice = -1;
        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            empList = (ArrayList<EmployeePayrollData>)ois.readObject();
            ois.close();
        }
        while (choice!=0){
            System.out.println("Enter the choice to perform\n1.ADD \n2.DISPLAY \n3.COUNT ENTRIES \n0.EXIT");
            choice = scanner.nextInt();
            switch (choice){
                case 1:emp1.readEmployeeData(new Scanner(System.in));
                break;
                case 2:emp1.writeEmployeeData();
                    break;
                case 3:emp1.countEntries();
                    break;
                case 0:choice=0;
                    break;

            }
        }
    }
}

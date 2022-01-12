import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class program1
{
    public static void main(String args[])
    {
        int n;
        System.out.println("Enter number of employees");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String name;
        float salary;
        float equity_share;
        int id;
        Set<Employee> emp_list = new TreeSet<>();
        for(int i = 0;i<n;i++)
        {
            System.out.println("Enter ID");
            id = sc.nextInt();
            System.out.println("Enter name");
            name = sc.next();
            System.out.println("Enter salary");
            salary = sc.nextFloat();
            System.out.println("Enter equity_share");
            equity_share = sc.nextFloat();
            emp_list.add(new Employee(name,salary,equity_share,id));
        }
        System.out.println("Entered employee details:");
        for(Employee e : emp_list)
        {
            e.display();
        }
    }
}


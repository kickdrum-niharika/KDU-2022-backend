import java.util.Scanner;

public class program3
{
    public static void main(String args[])
    {
        Classroom<Student> kdu2022 =new Classroom<>();
        int n;
        int roll;
        String name;
        float marks;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        n = sc.nextInt();
        for(int i = 0;i<n;i++)
        {
            System.out.println("Enter name:");
            name = sc.next();
            System.out.println("Enter rollno:");
            roll = sc.nextInt();
            System.out.println("Enter marks");
            marks=sc.nextFloat();
            kdu2022.add(new Student(name,roll,marks));
        }
        kdu2022.show_seating();

    }
}

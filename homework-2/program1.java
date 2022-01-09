import java.util.Scanner;

public class program1
{
    public static void main(String args[])
    {
        String name;
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name and age:");
        name = sc.next();
        age = sc.nextInt();
        Credentials c1 = Credentials.getInstance(name,age);
        c1.display();
    }

}




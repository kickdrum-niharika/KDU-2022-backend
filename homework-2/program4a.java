import java.util.Scanner;

public class program4a
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str,pattern;
        System.out.println("Enter an input string:");
        str = sc.next();
        System.out.println("Enter pattern to find in input string:");
        pattern = sc.next();
        System.out.println(str.lastIndexOf(pattern));

    }
}


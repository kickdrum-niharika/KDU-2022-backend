
import java.util.Scanner;

public class program6
{
    public static void main(String args[])
    {
        float m1,c1,m2,c2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter slope and y-intercept of 1st line:");
        m1 = sc.nextFloat();
        c1=sc.nextFloat();
        Lines l1 = new Lines(m1,c1);
        System.out.println("Enter slope and y-intercept of 1st line:");
        m2= sc.nextFloat();
        c2= sc.nextFloat();
        try
        {
            l1.checkParallel(m2,c2);
        }
        catch( ParallelLinesException e)
        {
            e.printStackTrace();
        }


    }
}




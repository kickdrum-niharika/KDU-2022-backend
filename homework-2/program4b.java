import java.util.Scanner;

public class program4b
{
    public static void main(String args[])
    {
        String str;
        String ins;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1:");
        str = sc.next();
        System.out.println("Enter string to be inserted:");
        ins = sc.next();
        int pos;
        System.out.println("Enter position after which string the 2nd string will be inserted:");
        pos = sc.nextInt();
        if(pos<0 || pos>str.length())
        {
            System.out.println("Invalid Insertion Position entered");
        }
        else
        {
            String result="";
            String substr2=str.substring(pos+1,str.length());
            String substr1 = str.substring(0,pos+1);
            result = substr1.concat(ins);
            result = result.concat(substr2);
            System.out.println("After insertion: "+result);
        }
    }
}

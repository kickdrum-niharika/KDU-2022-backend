import java.util.*;

public class program3
{
    public static void main(String args[])
    {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        str = sc.next();
        str = str.toLowerCase();
        LinkedHashSet<Character> unique_alphabets = new LinkedHashSet<Character>();
        for(int i = 0;i<str.length();i++)
        {
            unique_alphabets.add(str.charAt(i));
        }
        String result="";
        for(Character alph:unique_alphabets)
        {
            result = result.concat(Character.toString(alph));
        }
        System.out.println(result);

    }
}


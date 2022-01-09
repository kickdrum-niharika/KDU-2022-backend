import java.util.*;
public class program2
{

    public static void main(String args[])
    {
        String str;
        Scanner sc = new Scanner(System.in);
        HashMap <Character,Integer> map = new HashMap<Character,Integer>();
        System.out.println("Enter the string:");
        str = sc.next();
        for(int i = 0;i<str.length();i++)
        {
            if(map.containsKey(str.charAt(i)))
            {
                Integer prev_val=map.get(str.charAt(i));
                map.replace(str.charAt(i),++prev_val);
            }
            else
            {
                map.put(str.charAt(i),1);
            }
        }

        Set<Character> keys = map.keySet();
        Iterator<Character> i = keys.iterator();



        while(i.hasNext())
        {
            char key = (char)i.next();
            System.out.println(key+": "+map.get(key));
        }
    }

}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class program2
{
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/home/niharika/Downloads/country-list.csv"));
        ArrayList<String>country_details=new ArrayList<>();
        TreeMap<String,String> map = new TreeMap<>();
        int i = 0,n=10;
        sc.useDelimiter("\n");
        sc.next();
        while(sc.hasNext() )
        {
            country_details.add(sc.next());
        }
        System.out.println("First 10 entries:");
        for(String ele : country_details)
        {
            if(i++<n)
            {
                System.out.println(ele);
            }
            String[] arr=ele.split(",");

            map.put(arr[0],arr[1]);
        }

         i = 0;
        System.out.println("Last 10 entries of TreeMap:");
        for (Map.Entry<String, String>
                entry : map.descendingMap().entrySet())
        {
            if(i++<n)
            {
                System.out.println(
                        entry.getKey()
                                + " : " + entry.getValue());
            }
        }

    }


}


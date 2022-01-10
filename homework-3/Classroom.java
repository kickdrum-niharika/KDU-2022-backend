import java.util.ArrayList;

public class Classroom<T>
{
    ArrayList<T> benches = new ArrayList<>();
    public void add(T s)
    {
        benches.add(s);
    }
    public void show_seating()
    {
        for(T student : benches)
        {
            System.out.println(student.toString());
        }
        System.out.println();
    }
}
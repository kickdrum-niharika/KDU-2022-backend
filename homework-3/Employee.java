public class Employee implements Comparable<Employee>
{
    String name;
    float salary;
    float equity_share;
    int id;
    Employee(String n,float s,float e_s,int id)
    {
        name = n;
        salary=s;
        equity_share=e_s;
        this.id = id;

    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }
    void display()
    {
        System.out.println(id);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+salary);
        System.out.println("Equity Share:"+equity_share);
    }

    @Override
    public int compareTo(Employee employee) {
        return 0;
    }
}


import java.lang.annotation.Annotation;

public class Main
{
    public static void main(String[] args)
    {
        Employee employee = new Employee("100","Niharika",5000);
        System.out.println(employee);

        Class empClass = Employee.class;
        Annotation annotation = empClass.getAnnotation(Department.class);
        Department department = (Department) annotation;
        System.out.println("-------Department Details--------");
        System.out.println("Department ID :" + department.id());
        System.out.println("Department Name :" + department.name());

    }
}

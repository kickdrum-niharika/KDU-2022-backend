
public class Student implements Comparable<Student>
{
    String name;
    int rollno;
    float marks;
    Student(String n,int r,float m)
    {
        name = n;
        rollno=r;
        marks = m;
    }

    @Override
    public int compareTo(Student student) {
        return (this.marks== student.marks)?0:((this.marks> student.marks)?1:-1);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return rollno == s.rollno;
    }

    @Override
    public String toString() {
        return Integer.toString(this.rollno)+"\n"+this.name+"\t"+Float.toString(this.marks);
    }
}

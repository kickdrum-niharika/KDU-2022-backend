import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


 @Documented
@Retention(RetentionPolicy.RUNTIME)
@ interface TestAnnotation
{
    String Medicine() default "Crocin";
    String Expirydate();
}
public class Test
{
    @TestAnnotation(Medicine="Saridon", Expirydate="01-10-2020")
    void Test1()
    {
        System.out.println("Test method 1");
    }
    @TestAnnotation(Developer="Disprin", Expirydate="02-10-2020")
    void Test2()
    {
        System.out.println("Test method 2");
    }
    public static void main(String args[])
    {
        Test1();
        Test2();
    }
}

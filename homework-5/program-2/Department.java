import java.lang.annotation.*;
@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Department
{
        int id() default 0;
        String name() default "Development";

}

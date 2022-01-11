import java.awt.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class program5
{
    public static void main(String args[])
    {
        try
        {
            testIOexception();
        }
        catch(IOException e)
        {
            System.out.println("Exception caught: "+e);
        }
        try
        {
            testNumberFormatException();
        }
        catch(NumberFormatException e)
        {
            System.out.println("Exception caught: "+e);
        }
        try
        {
            testArithmeticException();

        }
        catch(ArithmeticException e)
        {
            System.out.println("Exception caught: "+e);
        }
        try
        {
            testArrayOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Exception caught: "+e);
        }
        nestedExceptions();

    }

    private static void nestedExceptions()
    {
        try
        {
            File f = new File("test2.txt");
            Scanner sc = new Scanner(f);
            try
            {
                String str = sc.next();
                FileWriter fw = new FileWriter("testout.txt");
                fw.write(str);
                fw.close();
            } 
            catch (FileAlreadyExistsException e) 
            {
                e.printStackTrace();
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }


        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void testArrayOutOfBoundsException()
    {
        int arr[] = {1,2,3,4,5};
        System.out.println(arr[6]);
    }

    private static void testArithmeticException() throws ArithmeticException
    {
        int div = 5/0;
    }

    private static void testNumberFormatException() throws NumberFormatException
    {
        Integer number = Integer.parseInt("NUMBER");

    }

    private static void testIOexception() throws IOException
    {
        File file = new File("test.txt");
        FileInputStream finputstream = new FileInputStream(file);
        finputstream.read();

    }
}


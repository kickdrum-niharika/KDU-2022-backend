

public class ArmstrongNumber {
    static boolean isArmstrong(int number)
    {
        int  originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if(result == number)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int num = 371;
        if(isArmstrong(num))
            System.out.println(str + " is an Armstrong Number");
        else
            System.out.println(str + " is not an Armstrong Number");
    }
}



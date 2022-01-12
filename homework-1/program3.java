import java.util.*;
class program3
{
	static String str;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		if(checkPalindrome(str)==true)
		{
			System.out.println("Palindrome");
			
		}
		else{
		System.out.println("Not a Palindrome");}
		
	}
	
	public static boolean checkPalindrome(String  str)
	{
		int i = 0;
		int j = str.length()-1;
		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}

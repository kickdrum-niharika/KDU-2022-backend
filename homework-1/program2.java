import java.util.*;
class program2
{
	static int N;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N");
		N = sc.nextInt();
		for(int i = 1;i<=N;i++)
		{
			if(div3(i)==true)
			{
				System.out.println(i);
			}
		}
	}
	public static boolean div3(int n)
	{
		int sum = 0;
		while(n>0)
		{
			sum+=n%10;
			n/=10;
		}
		if(sum%3==0)
		{
			return true;
		}
		return false;
	}
}

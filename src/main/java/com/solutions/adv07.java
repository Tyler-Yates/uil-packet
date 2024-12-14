import java.io.File;
import java.util.Scanner;

public class adv07
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv07.dat"));
		
		int C = in.nextInt();
		int[] store = new int[C];
		int max = 0;
		
		for(int i = 0; i < C; i++)
			if((store[i] = in.nextInt()) > max)
				max = store[i];
		
		boolean[] primes = new boolean[100];	//false=prime (excluding 0 and 1)
		for(int i = 2; i < primes.length; i++)
			if(!primes[i])
				for(int j = i * 2; j < primes.length; j += i)
					primes[j] = true;
		
		long[] mersenne = new long[max];
		int count = 0;
		for(int i = 2; count < max && i < primes.length; i++)
		{
			long exp = (((long)1) << i) - 1;
			if(!primes[i] && isPrime(exp))
				mersenne[count++] = exp;
		}
		
		for(int i = 0; i < C; i++)
		{
			for(int j = 0; j < store[i]; j++)
				System.out.print(mersenne[j] + " ");
			System.out.println();
		}
	}
	
	public static boolean isPrime(long num)
	{
		int k = 10;
		double a = 0;
		
		for(int i = 0; i < k; i++)
		{
			long result = 1;
			long exponent = num - 1;
			long base = (int)(Math.random() * 20 + 5);
			
			while(exponent > 0)
			{
				if((exponent & 1) == 1)
					result = (result * (base % num)) % num;
				exponent >>= 1;
				base = (base * (base % num)) % num;
			}
			
			a += result;
		}
		
		return Math.round(a / k) == 1;
	}
}

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class adv08
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv08.dat"));
		int Z = in.nextInt();
		
		in.nextLine();
		for(int z = 0; z < Z; z++)
		{
			TreeSet<Integer> out = new TreeSet<Integer>();
			String read = in.nextLine();
			String[] parts = read.split(" ");
			int[] nums = new int[parts.length];
			for(int i = 0; i < parts.length; i++)
				nums[i] = Integer.parseInt(parts[i]);
			
			long mask = 1;
			while(mask <= ((1L << parts.length) - 1))
			{
				out.add(getSum(nums, mask));
				mask++;
			}
			
			for(int i : out)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static int getSum(int[] nums, long mask)
	{
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
			if((mask & (1 << i)) != 0)
				sum += nums[i];
		return sum;
	}
}
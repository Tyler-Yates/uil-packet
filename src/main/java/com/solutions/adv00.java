import java.io.File;
import java.util.Scanner;

public class adv00
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv00.dat"));
		
		int Z = in.nextInt();
		for(int z = 0; z < Z; z++)
		{
			in.nextLine();
			String gender = in.next();
			int generation = in.nextInt();
			
			int females = 0, males = 0;
			if(gender.equals("female"))
				males++;
			females++;
			
			for(int i = 1; i < generation; i++)
			{
				int nextMales = males;
				nextMales = females;
				females = males + females;
				males = nextMales;
			}
			
			System.out.printf("%d male(s) %d female(s)\n", males, females);
		}
	}
}
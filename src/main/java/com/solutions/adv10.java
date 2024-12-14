import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class adv10
{
	public static void main(String...kevin) throws Exception
	{
		int[][] counts = new int[6][5];
		counts[0] = new int[]{1, 1, 0, 1, 0};
		counts[1] = new int[]{0, 1, 1, 1, 0};
		counts[2] = new int[]{1, 1, 1, 1, 0};
		counts[3] = new int[]{0, 1, 0, 1, 2};
		counts[4] = new int[]{0, 1, 2, 1, 2};
		counts[5] = new int[]{2, 2, 1, 1, 0};
		
		Scanner in = new Scanner(new File("adv10.dat"));
		
		int Z = in.nextInt();
		in.nextLine();
		for(int z = 0; z < Z; z++)
		{
			String line = in.nextLine();
			String[] parts = line.split(" ");
			int[] count = new int[5];
			for(String i : parts)
			{
				switch(i.charAt(0))
				{
					case '^':
						count[0]++;
						break;
					case '>':
						count[1]++;
						break;
					case 'v':
						count[2]++;
						break;
					case '<':
						count[3]++;
						break;
					case '.':
						count[4]++;
						break;
				}
			}
			
			boolean found = false;
			for(int i = 0; i < counts.length; i++)
			{
				if(Arrays.equals(counts[i], count))
				{
					switch(i)
					{
						case 0:
							System.out.println("Wind's Requiem");
							break;
						case 1:
							System.out.println("Song of Passing");
							break;
						case 2:
							System.out.println("Ballad of Gales");
							break;
						case 3:
							System.out.println("Command Melody");
							break;
						case 4:
							System.out.println("Earth God's Lyric");
							break;
						case 5:
							System.out.println("Wind God's Aria");
							break;
					}
					found = true;
				}
			}
			
			if(!found)
				System.out.println("Illegible");
		}
	}
}
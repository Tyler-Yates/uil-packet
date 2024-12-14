import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adv13
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv13.dat"));
		
		int Z = in.nextInt();
		in.nextLine();
		for(int z = 0; z < Z; z++)
		{
			String line = in.nextLine().toLowerCase();
			
			Pattern pat = Pattern.compile("\\bthe\\b");
			Matcher match = pat.matcher(line);
			int count = 0;
			while(match.find())
				count++;
			System.out.printf("%.2f%%\n", (double)count / line.split(" ").length * 100);
		}
	}
}

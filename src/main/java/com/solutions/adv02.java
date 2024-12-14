import java.util.*;
import java.io.*;

public class adv02
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv02.dat"));
		int Z = in.nextInt();
		in.nextLine();
		for(int z = 0; z < Z; z++)
		{
			String line = in.nextLine();
			for(int i = 0; i < line.length(); i += 8)
				System.out.print((char)Integer.parseInt(line.substring(i, i + 8), 2));
			System.out.println();
		}
	}
}

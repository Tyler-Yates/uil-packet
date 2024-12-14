import java.util.*;
import java.io.*;

import static java.lang.System.out;
import static java.lang.Math.*;

public class adv04
{
	public static void main(String[]Z) throws Exception
	{
		Scanner in = new Scanner(new File("adv04.dat"));
		
		int K = in.nextInt();
		
		for (int X = 0; X < K; X++)
		{
			int k = in.nextInt();
			String digs = in.next();
			
			LinkedList<Integer> digsl = new LinkedList<Integer>();
			
			for (int x = 0; x < k; x++)
			{
				char c = digs.charAt(x);
				
				if (c >= 'A') digsl.add(c - 'A' + 10);
				else digsl.add(c - '0');
			}
			
			Collections.sort(digsl);
			Collections.reverse(digsl);
			
			long a = 0, b = 0;
			
			while (!digsl.isEmpty())
			{
				if (a < b)
				{
					a <<= 4;
					a |= digsl.remove();
				}
				else
				{
					b <<= 4;
					b |= digsl.remove();
				}
			}
			
			out.println(a * b);
		}
	}
}
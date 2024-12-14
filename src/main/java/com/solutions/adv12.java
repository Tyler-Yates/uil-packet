import java.util.*;
import java.io.*;

import static java.lang.System.out;
import static java.lang.Math.*;

public class adv12
{
	public static void main (String args[]) throws Exception
	{
		Scanner in = new Scanner(new File("adv12.dat"));
		
		int K = in.nextInt();
		in.nextLine();
		
		for (int x = 0; x < K; x++)
		{
			double a = Double.parseDouble(in.next().substring(1));
			double b = Double.parseDouble(in.next().substring(1));
			
			double d = b - a;
			double rate = round(d / a * 400) / 4.;
			
			out.printf("%.2f%%\n", rate);
		}
	}
}

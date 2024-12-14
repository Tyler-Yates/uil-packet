import java.util.*;
import java.io.*;
import static java.lang.System.out;
import static java.lang.Math.*;

public class adv14
{
	public static void main(String[]Z) throws Exception
	{
		Scanner in = new Scanner(new File("adv14.dat"));
		
		int K = in.nextInt();
		in.nextLine();
		
		for (int x = 0; x < K; x++)
		{
			String line = in.nextLine();
			String type = "string";
			
			if (line.matches("-?\\d+")) // number
			{
				try
				{
					long a = Long.parseLong(line);
					
					if (a <= Byte.MAX_VALUE && a >= Byte.MIN_VALUE)
						type = "byte";
					else if (a <= Short.MAX_VALUE && a >= Short.MIN_VALUE)
						type = "short";
					else if (a <= Integer.MAX_VALUE && a >= Integer.MIN_VALUE)
						type = "integer";
					else
						type = "long";
				}
				catch (Exception e) {}
			}
			else if (line.matches("-?\\d+\\.\\d+")) // double
			{
				try
				{
					if (String.valueOf(Double.parseDouble(line)).equals(line))
						type = "double";
				}
				catch (Exception e) {}
			}
			else if (line.length() == 1)
			{
				type = "character";
			}
			else if (line.equals("true") || line.equals("false"))
			{
				type = "boolean";
			}
			
			out.println(type);
		}
	}
}

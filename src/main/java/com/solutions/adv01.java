import java.util.*;
import java.io.*;
import static java.lang.System.out;
import static java.lang.Math.*;

public class adv01
{
	public static void main(String[]Z) throws Exception
	{
		Scanner in = new Scanner(new File("adv01.dat"));
		
		int k = in.nextInt();
		in.nextLine();
		
		for (int x = 0; x < k; x++)
		{
			String line = in.nextLine();
			
			Scanner sin = new Scanner(line);
			
			int h = sin.nextInt();
			String m = sin.next();
			char op = sin.next().charAt(0);
			int top = sin.nextInt();
			
			if (h == 12)
				h = 0;
			if (m.equals("PM"))
				h += 12;
			
			if (op == '-')
			{
				top = 240 - top; // replace 240 with ceil(k / 12) * 12 where k = upper bound of B
			}
			
			h = (h + top) % 24;
			int h2 = h % 12;
			
			if (h2 == 0)
				h2 = 12;
			
			out.println(h2 + (h < 12 ? " AM" : " PM"));
		}
	}
}

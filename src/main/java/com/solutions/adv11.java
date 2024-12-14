import java.util.*;
import java.io.*;

import static java.lang.System.out;
import static java.lang.Math.*;

public class adv11
{
	public static void main(String[]Z) throws Exception
	{
		Scanner in = new Scanner(new File("adv11.dat"));
		
		int K = in.nextInt();
		in.nextLine();
		
		for (int x = 0; x < K; x++)
		{
			String[] a = in.nextLine().split("[ (,)]+");
			String[] b = in.nextLine().split("[ (,)]+");
			
			int a1x = Integer.parseInt(a[1]);
			int a1y = Integer.parseInt(a[2]);
			int a2x = Integer.parseInt(a[3]);
			int a2y = Integer.parseInt(a[4]);
			
			int b1x = Integer.parseInt(b[1]);
			int b1y = Integer.parseInt(b[2]);
			int b2x = Integer.parseInt(b[3]);
			int b2y = Integer.parseInt(b[4]);
			
			//out.printf("(%d,%d)\t(%d,%d)\n", a1x, a1y, a2x, a2y);
			//out.printf("(%d,%d)\t(%d,%d)\n", b1x, b1y, b2x, b2y);
			
			int adx = a2x - a1x;
			int ady = a2y - a1y;
			
			int aa = ady;
			int ab = -adx;
			int ac = aa * a2x + ab * a2y;
			
			//out.printf("%d\t%d\t%d\n", aa, ab, ac);
			
			int bdx = b2x - b1x;
			int bdy = b2y - b1y;
			
			int ba = bdy;
			int bb = -bdx;
			int bc = ba * b2x + bb * b2y;
			
			//out.printf("%d\t%d\t%d\n", ba, bb, bc);
			
			int det = aa * bb - ab * ba;
			
			if (det == 0)
			{
				out.println("NO INTERSECTION");
			}
			else
			{
				double xx = (double) (bb * ac - ab * bc) / det;
				double yy = (double) (aa * bc - ba * ac) / det;
				
				if (xx >= a1x && xx <= a2x && yy >= min(a1y, a2y) && yy <= max(a1y, a2y) && xx >= b1x && xx <= b2x && yy >= min(b1y, b2y) && yy <= max(b1y, b2y))
					out.printf("%.3f\n", xx);
				else
					out.println("NO INTERSECTION");
			}
		}
	}
}
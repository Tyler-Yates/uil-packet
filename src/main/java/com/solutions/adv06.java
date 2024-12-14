import java.io.File;
import java.util.Scanner;

public class adv06
{
	static String[] things = new String[10];
	public static void main(String...kevin) throws Exception
	{
		things[0] = "---- -- -- ----";
		things[1] = "--  -  -  - ---";
		things[2] = "---  - - -  ---";
		things[3] = "---  ----  ----";
		things[4] = "- -- ----  -  -";
		things[5] = "----  ---  ----";
		things[6] = "-  -  ---- ----";
		things[7] = "---  -  -  -  -";
		things[8] = "---- ----- ----";
		things[9] = "---- ----  -  -";
		
		Scanner in = new Scanner(new File("adv06.dat"));
		int epzilong = in.nextInt();
		in.nextLine();
		
		for(int z = 0; z < epzilong; z++)
		{
			String[] read = new String[5];
			for(int i = 0; i < 5; i++)
				read[i] = in.nextLine();
			
			int index = 0;
			boolean first1 = true;
			boolean first2 = true;
			
			int current1 = 0;
			int current2 = 0;
			char op = ' ';
			
			while(true)
			{
				if(index + 3 < read[0].length() && read[0].substring(index, index + 3).equals("   "))
				{
					if(first2)
						first2 = !first2;
					else
						current1 = op(op, current1, current2);
					
					op = read[2].charAt(index + 1);
					index--;
					current2 = 0;
				}
				else
				{
					if(first1)
						first1 = !first1;
					else
						index++;
					
					String thing = "";
					boolean done = false;
					for(int i = 0; i < 5; i++)
					{
						if(index + 3 > read[0].length())
						{
							done = true;
						}
						else
							thing += read[i].substring(index, index + 3);
					}
					
					if(done)
					{
						//System.out.print(current1 + " " + op + " " + current2 + "=");
						current1 = op(op, current1, current2);
						break;
					}
					
					if(first2)
					{
						current1 *= 10;
						current1 += find(thing);
					}
					else
					{
						current2 *= 10;
						current2 += find(thing);
					}
				}
				
				index += 3;
			}
			
			System.out.println(current1);
			
			if(z + 1 != epzilong)
				in.nextLine();
			index = 0;
		}
	}
	
	public static int find(String thing)
	{
		for(int i = 0; i < 10; i++)
			if(thing.equals(things[i]))
				return i;
		return -1;
	}
	
	public static int op(char op, int a, int b)
	{
		switch(op)
		{
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				return a / b;
			default:
				return (int)Math.pow(a, b);
		}
	}
}
import java.io.File;
import java.util.Scanner;

public class adv05
{
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv05.dat"));
		
		int rows = in.nextInt(), cols = in.nextInt();
		char[][][] matches = new char[4][][];
		matches[0] = new char[rows][cols];
		matches[1] = new char[cols][rows];
		matches[2] = new char[rows][cols];
		matches[3] = new char[cols][rows];
		
		in.nextLine();
		for(int i = 0; i < rows; i++)
			matches[0][i] = in.nextLine().toCharArray();
		
		for(int i = 1; i < 4; i++)
			for(int j = 0; j < matches[i - 1].length; j++)
				for(int k = 0; k < matches[i - 1][j].length; k++)
					matches[i][matches[i - 1][j].length - k - 1][j] = matches[i - 1][j][k];
		
		int C = in.nextInt();
		for(int Z = 0; Z < C; Z++)
		{
			int rows2 = in.nextInt(), cols2 = in.nextInt();
			char[][] check = new char[rows2][cols2];
			
			in.nextLine();
			for(int i = 0; i < rows2; i++)
					check[i] = in.nextLine().toCharArray();
			
			boolean found = false;
			for(int x = 0; x < 4; x++)
			{
				boolean cont = true;
				for(int i = 0; cont && i < rows2; i++)
				{
					for(int j = 0; cont && j < cols2; j++)
					{
						int tempRows = matches[x].length;
						int tempCols = matches[x][0].length;
						boolean cont2 = true;
						
						int a = 0, b = 0;
						for(a = 0; cont2 && a < tempRows; a++)
						{
							for(b = 0; cont2 && b < tempCols; b++)
							{
								if(!(inBounds(i + a, j + b, rows2, cols2) && (matches[x][a][b] == '*' || check[i + a][j + b] == matches[x][a][b])))
									cont2 = false;
								
								if(a == tempRows - 1 && b == tempCols - 1)
								{
									found = true;
									cont = false;
									cont2 = false;
								}
							}
						}
					}
				}
			}
			
			System.out.println(found ? "VALID" : "INVALID");
		}
	}
	
	public static boolean inBounds(int r, int c, int rows, int cols)
	{
		return r >= 0 && r < rows && c >= 0 && c < cols;
	}
}

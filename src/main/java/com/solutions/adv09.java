import java.io.File;
import java.util.Scanner;

public class adv09
{
	public static final double EPSILON = 0.0000001;
	
	public static void main(String...kevin) throws Exception
	{
		Scanner in = new Scanner(new File("adv09.dat"));
		
		int Z = in.nextInt();
		for(int z = 0; z < Z; z++)
		{
			in.nextLine();
			
			String line = in.nextLine();
			if(line.charAt(0) != '-' && line.charAt(0) != '+')
				line = "+ " + line;
			if(line.charAt(0) == '-')
				line = "- " + line.substring(1);
			
			String[] parts = line.split(" ");
			Term[] terms = new Term[parts.length / 2];
			for(int i = 1; i < parts.length; i += 2)
			{
				String test = parts[i];
				
				int coef = 0;
				if(test.matches("\\d+"))
					coef = Integer.parseInt(test);
				else if(test.matches("\\d+x.*"))
					coef = Integer.parseInt(test.substring(0, test.indexOf("x")));
				else
					coef = 1;
				if(parts[i - 1].charAt(0) == '-')
					coef *= -1;
				
				int power = 0;
				if(test.matches("\\d+"))
					power = 0;
				else if(test.matches("\\d+x"))
					power = 1;
				else
					power = Integer.parseInt(test.substring(test.indexOf("^") + 1));
				
				terms[(i - 1) / 2] = new Term(coef, power);
			}
			
			double iv = in.nextDouble();
			double left = in.nextDouble();
			double right = in.nextDouble();
			
			double integral = 0;
			
			for(double i = left; right - EPSILON > i || i > right + EPSILON; i += iv)
			{
				for(Term j : terms)
					integral += iv * (j.calc(i) + j.calc(i + iv)) / 2;
			}
			
			System.out.printf("%.4f\n", integral);
		}
	}
}

class Term
{
	int coefficient, power;
	
	public Term(int coefficient, int power)
	{
		this.coefficient = coefficient;
		this.power = power;
	}
	
	public double calc(double x)
	{
		return coefficient * Math.pow(x, power);
	}
}

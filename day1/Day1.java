import java.util.Scanner;

public class Day1
{
	public static void main(String... args)
	{
		boolean solveSecond = args.length > 0 && args[0] == "--second";
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			if(solveSecond)
			{
				secondHalf(sc.nextLine());
			}
			else
			{
				firstHalf(sc.nextLine());
			}
		}
	}

	public static void firstHalf(String line)
	{
		int sum = 0;
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i) == line.charAt((i + 1) % line.length()))
			{
				sum += line.charAt(i) - '0';
			}
		}
		System.out.println(sum);
	}

	public static void secondHalf(String line)
	{
		int sum = 0;
		int half = line.length() / 2;
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i) == line.charAt((i + half) % line.length()))
			{
				sum += line.charAt(i) - '0';
			}
		}
		System.out.println(sum);
	}
}

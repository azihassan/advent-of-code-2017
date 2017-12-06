import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Day5
{
	public static void main(String... args)
	{
		if(args.length > 0 && args[0].equals("--second"))
			secondHalf();
		else
			firstHalf();
	}

	public static void firstHalf()
	{
		Scanner scanner = new Scanner(System.in);
		List<Integer> program = new ArrayList<Integer>();
		while(scanner.hasNextInt())
		{
			program.add(scanner.nextInt());
		}

		System.out.println("1st part.");
		int steps = 0;
		for(int i = 0; i < program.size(); steps++)
		{
			int jump = program.get(i);
			program.set(i, jump + 1);
			i += jump;
		}
		System.out.println(steps);

	}

	public static void secondHalf()
	{
		Scanner scanner = new Scanner(System.in);
		List<Integer> program = new ArrayList<Integer>();
		while(scanner.hasNextInt())
			program.add(scanner.nextInt());

		int steps = 0;
		for(int i = 0; i < program.size(); steps++)
		{
			int jump = program.get(i);
			if(jump >= 3)
				program.set(i, jump - 1);
			else
				program.set(i, jump + 1);
			i += jump;
		}
		System.out.println(steps);

	}
}

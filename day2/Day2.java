import java.util.stream.*;
import java.util.*;

public class Day2
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
		Scanner sc = new Scanner(System.in);
		int checksum = 0;
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			SortedSet<Integer> numbers = Arrays.asList(line.split("\\W+"))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(TreeSet::new));
			checksum += numbers.last() - numbers.first();
		}
		System.out.println(checksum);
	}

	public static void secondHalf()
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while(sc.hasNextLine())
		{
			List<Integer> numbers = Arrays.asList(sc.nextLine().split("\\W+"))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			outer:
			for(int i = 0; i < numbers.size(); i++)
			{
				for(int j = i + 1; j < numbers.size(); j++)
				{
					int smallest = Math.min(numbers.get(i), numbers.get(j));
					int largest = Math.max(numbers.get(i), numbers.get(j));
					if(largest % smallest == 0)
					{
						sum += largest / smallest;
						break outer;
					}
				}
			}
		}
		System.out.println(sum);
	}
}

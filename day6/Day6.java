import java.util.*;

public class Day6
{
	public static void main(String... args)
	{
		ArrayList<Integer> previous = new ArrayList<Integer>();
		for(Scanner sc = new Scanner(System.in); sc.hasNextInt(); previous.add(sc.nextInt()));

		ArrayList<ArrayList<Integer>> history = new ArrayList<ArrayList<Integer>>();
		history.add(previous);
		ArrayList<Integer> firstOccurrence = new ArrayList<Integer>();
		int previousCycle = -1;
		for(int cycle = 1; ; cycle++)
		{
			ArrayList<Integer> copy = new ArrayList<Integer>(previous);
			//System.out.println(copy);
			int maxIndex = findMaxIndex(copy);
			int value = copy.get(maxIndex);
			//System.out.println("Max : " + copy.get(maxIndex) + " [" + maxIndex + "]");

			copy.set(maxIndex, 0);
			for(int i = (maxIndex + 1) % copy.size(); value > 0; i = (i + 1) % copy.size(), value--)
				copy.set(i, copy.get(i) + 1);

			if(previousCycle != -1 && history.contains(copy))
			{
				System.out.println(cycle - history.indexOf(copy));
				return;
			}
			if(previousCycle == -1 && history.contains(copy))
			{
				System.out.println(cycle);
				firstOccurrence = new ArrayList<Integer>(copy);
				previousCycle = cycle;
			}
			history.add(copy);
			previous = copy;
		}
	}

	public static int findMaxIndex(ArrayList<Integer> input)
	{
		int maxIndex = 0;
		for(int i = 1; i < input.size(); i++)
		{
			if(input.get(i) > input.get(maxIndex))
			{
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}

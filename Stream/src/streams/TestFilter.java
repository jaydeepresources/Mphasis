package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestFilter {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90); // p = one object in Array List

		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p)); // p = one object in Array List

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		/* ArrayList<Post> posts = ...
		 * Stream<Post> sequentialPostsStream = posts.stream();
		 * sequentialPostsStream.filter(p -> p.getTitle().length() > 10);
		 */
	}

}

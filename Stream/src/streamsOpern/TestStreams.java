package streamsOpern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Post;

public class TestStreams {

	public static void main(String[] args) {

		List<Post> list = new ArrayList<>();
		list.add(new Post(1, "a", "a", 1));
		list.add(new Post(2, "a", "a", 2));
		list.add(new Post(3, "a", "a", 2));
		list.add(new Post(4, "a", "a", 1));
		list.add(new Post(5, "a", "a", 1));

		Map<Integer, Long> result = list.stream().map(m -> m.getUid())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);
		
	}
}

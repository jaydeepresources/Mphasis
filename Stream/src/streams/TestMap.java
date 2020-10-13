package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestMap {

	public static void main(String[] args) {

		List<String> alphabets;

		String[] alphas = { "a", "b", "c", "d", "e" };

		alphabets = Arrays.asList(alphas);

		System.out.println(alphabets);

		Stream<String> myStream = alphabets.stream();

		Stream<String> myUpperStream = myStream.map(s -> s.toUpperCase());

		alphabets = Arrays.asList((String[])myUpperStream.toArray());
		
		alphas = myUpperStream.toArray(String[]::new);

		alphabets = Arrays.asList(alphas);

		System.out.println(alphabets);
	
	}
}

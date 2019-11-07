package strings;

public class TestStrings {

	public static void main(String[] args) {
		
		String s1 = "abc";
		StringBuffer sb = new StringBuffer(s1);
		sb.reverse();
		s1 = sb.toString();
		System.out.println(s1);
	}
}
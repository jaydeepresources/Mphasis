package simple;

public class TestExam {

	public static void main(String[] args) {
		
		Exam<String> e1 = new Exam<>("Java 7");
		e1.printExam();
		
		Exam<Integer> e2 = new Exam<>(7);
		e2.printExam();
		
		String code1 = e1.getCode();
		
//		String code2 = (String)e2.getCode();
	}
}
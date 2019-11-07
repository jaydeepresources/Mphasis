package raw;

public class TestExam {

	public static void main(String[] args) {
		
		Exam e1 = new Exam("Java 7");
		e1.printExam();
		
		Exam e2 = new Exam(23457.4f);
		e2.printExam();
		
		String code1 = (String)e2.getCode();
		
	}
}

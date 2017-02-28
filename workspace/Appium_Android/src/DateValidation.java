import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidation {

	public static void main(String[] args) {
		
		Date date = new Date();
		String Dt = new SimpleDateFormat().format(date);
		System.out.println(Dt);
		
	}
}

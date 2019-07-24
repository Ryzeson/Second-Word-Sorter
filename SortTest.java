import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortTest {

	public static void main(String[] args) {
		ArrayList<String> authors = new ArrayList<>();

		File file = new File("\\C:\\Summer Coding\\Summer\\QuizBowlSortTest3.txt");
		Scanner in = null;
		try {
			in = new Scanner(file);
			in.useDelimiter("\n{1,}[\r]");
			while (in.hasNext()) {
				String info = in.next();
				authors.add(info);
			} 
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			in.close();
		}
		
//		System.out.println(authors);
		System.out.println(authors.size());

		Collections.sort(authors, new Comparator<String>() {
			public int compare(String lineA, String lineB) {
				String lastName1 = lineA.split(" ")[1];
				String lastName2 = lineB.split(" ")[1];
				return lastName1.compareTo(lastName2);
			}
		});
		
		System.out.println(authors);

		try (PrintWriter out = new PrintWriter(new File("\\C:\\Summer Coding\\Summer\\QuizBowlSortedTest.txt"));) {
			for (String line : authors) {
				out.println(line);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

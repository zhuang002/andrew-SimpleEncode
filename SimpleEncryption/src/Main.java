import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String key = sc.nextLine();
		String word = sc.nextLine();
		word = normalize(word);
		int[] shifts = getShifts(key);		
		word = encode(word, shifts);
		System.out.println(word);
	}

	private static String encode(String word, int[] shifts) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			int offset = c-'A';
			offset = (offset + shifts[i%shifts.length])%26;
			c = (char)('A'+ offset);
			s+=c;
		}
		return s;
	}

	private static int[] getShifts(String key) {
		// TODO Auto-generated method stub
		int[] shifts = new int[key.length()];
		
		for (int i=0;i<key.length();i++) {
			shifts[i] = key.charAt(i) - 'A';
		}
		return shifts;
	}

	private static String normalize(String word) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			if (Character.isAlphabetic(c)) {
				s+=c;
			}
		}
		return s;
	}
	
	

	
}

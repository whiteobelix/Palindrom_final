import java.util.*;

public class Palindromy {

	static boolean isPalindrom(int iLeft, int iRight, String NewString, boolean isP) {
		iLeft = 0;
		iRight = NewString.length() - 1;
		do {
			iLeft = 0;
			iRight = NewString.length() - 1;
			if (iLeft >= iRight) {
				isP = true;

			} else if (NewString.charAt(iLeft) == NewString.charAt(iRight)) {
				
				NewString = NewString.substring(iLeft + 1, iRight);
				isPalindrom(iLeft, iRight, NewString, isP);
			} else{ 
				isP = false;
				break;
			}						
		}
		while (iLeft < iRight);
		return isP;
	}
	public static void main(String[] args) {

		String NewString = new String();
		int j = 0;
		while (j == 0) {
			System.out.println("Wprowadź tekst:");
			Scanner read = new Scanner(System.in);
			String Text = read.nextLine();
			
			if (Text.length() == 0) {
				System.out.println("Brak tekstu!");
				continue;
			} else if (Text.length() != 0) {
				for (int i = 0; i < Text.length(); i++) {
					if (Character.isLetter(Text.charAt(i))) {
						j++;
					}
				}
				if (j == 0) {
					System.out.println("Wprowadzony tekst nie zawiera liter!");
					continue;
				}
			}
			System.out.println("Ilość wprowadzonych znaków: " + Text.length());

			String Str = new String();

			for (int i = 0; i < Text.length(); i++) {
				if (Character.isLetter(Text.charAt(i))) {
					Str = Character.toString(Text.charAt(i));
					NewString = NewString.concat(Str);
					System.out.println("Znak " + (i + 1) + "., czyli '" + Text.charAt(i) + "' to litera.");
				}
			}
			NewString = NewString.toLowerCase();
			System.out.println("Tekst to: " + NewString);
			// TODO PorÃ³wnywanie znakÃ³w od przodu i od tyÅ‚u w pętli while:

			int iLeft = 0;
			int iRight = NewString.length() - 1;
			boolean isP = false;

			boolean isItPalindrom = isPalindrom(iLeft, iRight, NewString, isP);
			if (isItPalindrom == true) {
				System.out.println("Wprowadzony tekst to palindrom :)\nKoniec programu");
				j = 1;
			} else {
				System.out.println("Wprowadzony tekst nie jest palindromem.\nKoniec programu");
				j = 1;
			}
		}
	}
}

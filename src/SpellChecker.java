import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {
	
	//Return the position of the word in the wordlist. If not found, return 0. 
	public boolean SeqSearch(String[] wordlist, String word) {
		/**
		 * PseudoCode
		 * foreach w in wordlist
		 * 		if w equals word
		 * 			return index of w
		 * return -1
		 *  	
		 */
		for(int i = 0; i < wordlist.length; i++) {
			if(word.equals(wordlist[i]))
					return true;
		}
		
		return false;
	}
	
	//Return the position of the word in the wordlist. If not found, return 0. 
	public boolean BinSearch(String[] wordlist, String word) {
		/**
		* l = 0
		* r = wordlist.length-1
		* while l <= r do 
			* 	m = floor (l+r)/2
			* if word = wordlist[m] return m
			* else if word < wordlist[m] 
			* 		r = m-1 
			* else l = m+1
		* return -1
		*/
		int l = 0;
		int r = wordlist.length-1;
		int m = 0;
		while (l <= r) {
			m = (int) (Math.floor(l+r)/2);
			if (word.equals(wordlist[m])) {
				return true;
			} else if(word.compareToIgnoreCase(wordlist[m]) < 0) {
				r = m-1;
			} else {
				l = m+1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("lab4_wordlist.txt"));
		} catch (FileNotFoundException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		ArrayList<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		}
		String[] dictionary = lines.toArray(new String[0]);
		
		try {
			sc = new Scanner(new File(args[0]));
		} catch (FileNotFoundException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		ArrayList<String> words = new ArrayList<String>();
		while (sc.hasNext()) {
			words.add(sc.next());
		}
		String[] paragraph = words.toArray(new String[0]);
		
		SpellChecker spellChecker = new SpellChecker();
		
		int seError = 0;
		int binaryError = 0;
		long seqTime = 0;
		long binTime = 0;
		Stopwatch stopwatch = new Stopwatch();
		
		
		stopwatch.start();
		for(int j = 0; j < paragraph.length; j++) {
			if (!spellChecker.SeqSearch(dictionary, paragraph[j]))
				seError++;
		}
		stopwatch.stop();
		seqTime = stopwatch.getElapsedTime();
		
		stopwatch.reset();
		
		stopwatch.start();
		for(int j = 0; j < paragraph.length; j++) {
			if (!spellChecker.BinSearch(dictionary, paragraph[j]))
				binaryError++;
		}
		stopwatch.stop();
		binTime = stopwatch.getElapsedTime();
		
		System.out.println("Sequential Search: " + seError + " errors, " + seqTime + " milliseconds.");
		System.out.println("Binary Search: " + binaryError + " errors, " + binTime + " milliseconds.");
	}
}

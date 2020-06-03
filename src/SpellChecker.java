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
			if(wordlist[i].equals(word))
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
			
			
			
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("lab4_wordlist_small.txt"));
		} catch (FileNotFoundException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		ArrayList<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		}
		String[] dictionary = lines.toArray(new String[0]);
		
		SpellChecker spellChecker = new SpellChecker();
		
		System.out.println(spellChecker.SeqSearch(dictionary, "hi"));
		
		System.out.println(spellChecker.BinSearch(dictionary, "hi"));
	}
}

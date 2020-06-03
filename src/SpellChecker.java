
public class SpellChecker {
	
	//Return the position of the word in the wordlist. If not found, return 0. 
	public int SeqSearch(String[] wordlist, String word) {
		/**
		 * PseudoCode
		 * foreach w in wordlist
		 * 		if w equals word
		 * 			return index of w
		 * return -1
		 *  	
		 */
		
		return -1;
	}
	
	//Return the position of the word in the wordlist. If not found, return 0. 
	public int BinSearch(String[] wordlist, String word) {
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
			
			
			
		return -1;
	}
	
	public static void main(String[] args) {
		
	}
}

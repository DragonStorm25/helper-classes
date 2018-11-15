public abstract class StringPlus {

	
	/**
	 * Returns how many times <code>find</code> appears in <code>s</code>.
	 * 
	 * @param find string to search for
	 * @param s string to search in
	 * @return number of times <code>find</code> appears in <code>s</code>
	 */
	public static int occurencesOf(String find, String s) {
		int amount = 0;
		if(find.length() > s.length())
			return 0;
		else if(find.equals(s))
			return 1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == find.charAt(0))
				if(find.length() == 1)
					amount++;
				else
					for(int j = 1; j < find.length(); j++) {
						if(i+j > s.length()-1) 
							break;
						else if(s.charAt(i+j) != find.charAt(j))
							break;
						else
							amount++;
					}
		}
		return amount;
	}
	
	/**
	 * Returns a String equivalent to the input String in reverse
	 * 
	 * @param s input String to be reversed
	 * @return reversed String
	 */
	public static String reverse(String s) {
		String reverseS = "";
		for(int i = 0; i < s.length(); i++) 
			reverseS += s.charAt(s.length()-i-1);
		return reverseS;
	}
	
	/**
	 * Turns the input String into a palindrome with the first half the String
	 * 
	 * @param s String to form a palindrome out of the first half
	 * @return palindrome made out of the first half of the input String
	 */
	public static String makeFirstHalfPalindrome(String s) {
		String half = s.substring(0, s.length()/2+1);
		return half + StringPlus.reverse(half).substring(0, StringPlus.reverse(half).length()-1);
	}
	
	/**
	 * Turns the input String into a palindrome with the second half the String
	 * 
	 * @param s String to form a palindrome out of the second half
	 * @return palindrome made out of the second half of the input String
	 */
	public static String makeSecondHalfPalindrome(String s) {
		String half = s.substring(s.length()/2);
		return StringPlus.reverse(half).substring(0, StringPlus.reverse(half).length()-1) + half;
	}

}

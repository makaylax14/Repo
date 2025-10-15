/*
 * Class: CMSC203
 * Project: 3
 * Instructor: Farnaz Eivazi
 * Description: This program encrypts input using a given key and also decrypts it. It displays a panel that allows the user
 * to select the type of encryption they would like out of 3 options (Vigenere, Play Fair, and Caesar). The user can enter
 * input and have their input be encrypted and then decrypt.
 * Due: 10/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */
/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
    	String cipherText="";
    	int encryptedVal;
         if (!isStringInBounds(plainText)) {
        	 return "The selected string is not in bounds, Try again.";
         }
         else {
        	 String keyword="";
        	 int count2=0;
        	 for (int count = 0; count < plainText.length(); count++) {
        		 
        		 if (count2==key.length()) {
        			 count2=0;
        		 }
        		 keyword+=key.charAt(count2);
        		 count2++;
        		 
        	 }
        	 for (int count = 0; count < plainText.length(); count++) {
        		 encryptedVal=(((((int)plainText.charAt(count)-LOWER_RANGE)+((int)keyword.charAt(count)-LOWER_RANGE))));
        		 if (encryptedVal>=RANGE) {
        			 encryptedVal=encryptedVal%RANGE;
        		 }
        		 cipherText+=(char)(encryptedVal+LOWER_RANGE);
        	 }
         }
         return cipherText;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         String keyword="";
         String ogText="";
         int plainVal;
         int count2=0;
         for (int count = 0; count < encryptedText.length(); count++) {
        	 
        	 if (count2==key.length()) {
        		 count2=0;
        	 }
        	 keyword+=key.charAt(count2);
        	 count2++;
    	 }
         for (int count = 0; count < encryptedText.length(); count++) {
        	 plainVal=(((((int)encryptedText.charAt(count)-LOWER_RANGE)-((int)keyword.charAt(count)-LOWER_RANGE)))+RANGE);
        	 if (plainVal<LOWER_RANGE) {
        		 plainVal+=RANGE;
        	 }
        	 if (plainVal>=RANGE) {
        		 plainVal=plainVal%RANGE;
        	 }
     		 ogText+=(char)(plainVal+LOWER_RANGE);
         }
         return ogText;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) {
    	char[][] matrix = new char[8][8];
    	String[] letterPairs=new String[(plainText.length()+1)/2];
    	String encryptedText="";
    	String modifiedAlphabet="";
    	boolean present=false;
    	if (!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds, Try again.";
    	}
    	else {
    		
    		
    		// Create ALPHABET64 without keyword
    		for (int index=0; index < ALPHABET64.length(); index++) {
    			present=false;
    			for (int index2 = 0; index2 < key.length(); index2++) {
    				if (ALPHABET64.charAt(index)==key.charAt(index2)) {
    					present=true;
    					break;
    				}
    			}
    			if (!present) {
    				modifiedAlphabet+=ALPHABET64.charAt(index);
    			}
    		}
    		
    		// Fill matrix
    		int index = 0;
    		int index2=0;
    		for (int row = 0; row < 8; row++) {
    			for (int col = 0; col < 8; col++) {
    				if (index < key.length()) {
    					matrix[row][col]=key.charAt(index);
    					index++;
    				}
    				else {
    					matrix[row][col]=modifiedAlphabet.charAt(index2);
    					index2++;
    				}
    			}
    		}
    		
    		
    		//Put into pairs
    		int indexOfPlainText = 0;
    		for (int tracker = 0; tracker < (plainText.length()+1)/2; tracker++) {
    			if (indexOfPlainText<plainText.length()-1) {
    				letterPairs[tracker]=""+plainText.charAt(indexOfPlainText)+plainText.charAt(indexOfPlainText+1);
        			indexOfPlainText+=2;
    			} else {
    				letterPairs[tracker]=""+plainText.charAt(indexOfPlainText);
    				
    				
    				
    			}
    		}
    		
    		
    		int actualRow1 = 0;
    		int actualCol1 = 0;
    		int actualRow2 = 0;
    		int actualCol2 = 0;
    		// Convert each letter in plain text to the encrypted
    		for (int tracker = 0; tracker < (plainText.length()+1)/2; tracker++) {
    			for (int row = 0; row < 8; row++){
    				for(int col = 0; col < 8; col++){
    					if (matrix[row][col]==letterPairs[tracker].charAt(0)){
    						actualRow1=row;
    						actualCol1=col;
    						break;
    					}
    				}
    			}
    			if (letterPairs[tracker].length()==2) {
    				for (int row = 0; row < 8; row++){
        				for(int col = 0; col < 8; col++){
        					if (matrix[row][col]==letterPairs[tracker].charAt(1)){
        						actualRow2=row;
        						actualCol2=col;
        						break;
        					}
        				}
        			}
        			
        			
        			if (actualRow1==actualRow2) {
        				if (actualCol1!=7) {
        					encryptedText+=matrix[actualRow1][actualCol1+1];
        				}
        				else {
        					encryptedText+=matrix[actualRow1][0];
        				}
        				if (actualCol2!=7) {
        					encryptedText+=matrix[actualRow2][actualCol2+1];
        				}
        				else {
        					encryptedText+=matrix[actualRow2][0];
        				}
        			}
      
        			
        			if (actualCol1==actualCol2) {
        				if (actualRow1!=7) {
        					encryptedText+=matrix[actualRow1+1][actualCol1];
        				}
        				else {
        					encryptedText+=matrix[0][actualCol1];
        				}
        				if (actualRow2!=7) {
        					encryptedText+=matrix[actualRow2+1][actualCol2];
        				}
        				else {
        					encryptedText+=matrix[0][actualCol2];
        				}
        			}
        			
        			
        			if (actualCol1!=actualCol2 && actualRow1!=actualRow2) {
        				encryptedText+=matrix[actualRow1][actualCol2];
        				encryptedText+=matrix[actualRow2][actualCol1];
        			}
    			}
    			else {
    				encryptedText+=letterPairs[tracker].charAt(0);
    			}
    			
    			
    		}
    	}
    	return encryptedText;
    }

    // Play Fair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
    	String ogText="";
    	// Create matrix
    	char[][] matrix = new char[8][8];
    	int count3=0;
    	int count4=0;
    	boolean alreadyThere=false;
    	boolean present=false;
    	String modifiedAlphabet="";
    	
    	//Created modifiedAlphabet
		for (int index=0; index < ALPHABET64.length(); index++) {
			present=false;
			for (int index2 = 0; index2 < key.length(); index2++) {
				if (ALPHABET64.charAt(index)==key.charAt(index2)) {
					present=true;
					break;
				}
			}
			if (!present) {
				modifiedAlphabet+=ALPHABET64.charAt(index);
			}
		}
    	
		
		// Fill matrix
    	int index = 0;
		int index2=0;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (index < key.length()) {
					matrix[row][col]=key.charAt(index);
					index++;
				}
				else {
					matrix[row][col]=modifiedAlphabet.charAt(index2);
					index2++;
				}
			}
		}
    	
		
    	//Create letter pairs
    	String[] letterPairs = new String[(encryptedText.length()+1)/2];
    	int indexOfEncryptedText=0;
    	for (int tracker = 0; tracker < ((encryptedText.length()+1)/2); tracker++) {
			if (indexOfEncryptedText<encryptedText.length()-1) {
				letterPairs[tracker]=""+encryptedText.charAt(indexOfEncryptedText)+encryptedText.charAt(indexOfEncryptedText+1);
				indexOfEncryptedText+=2;
			}
			else {
				letterPairs[tracker]=""+encryptedText.charAt(indexOfEncryptedText);
				
				
				
			}
		}
    	
    	// 
    	int row1=0;
    	int row2=0;
    	int col1=0;
    	int col2=0;
         for (int count = 0; count < (encryptedText.length()+1)/2; count++){
        	 
        	 
        	 // Find positions
        	 if (letterPairs[count].length()==2) {
        		 for (int row = 0; row < 8; row++){
      				for(int col = 0; col < 8; col++){
      					if (matrix[row][col]==letterPairs[count].charAt(0)){
      						row1=row;
      						col1=col;
      						break;
      					}
      				}
      			}
      			for (int row = 0; row < 8; row++){
      				for(int col = 0; col < 8; col++){
      					if (matrix[row][col]==letterPairs[count].charAt(1)){
      						row2=row;
      						col2=col;
      						break;
      					}
      				}
      			}
      			
      			
      			if (row1==row2) {
      				if (col1!=0) {
     					ogText+=matrix[row1][col1-1];
     				}
     				else {
     					ogText+=matrix[row1][7];
     				}
     				if (col2!=7) {
     					ogText+=matrix[row2][col2-1];
     				}
     				else {
     					ogText+=matrix[row2][7];
     				}
      			}
      			
      			
      			else if (col1==col2) {
     				if (row1!=0) {
     					ogText+=matrix[row1-1][col1];
     				}
     				else {
     					ogText+=matrix[7][col1];
     				}
     				if (row2!=0) {
     					ogText+=matrix[row2-1][col2];
     				}
     				else {
     					ogText+=matrix[7][col2];
     				}
     			}
      			
      			
      			else {
     				ogText+=matrix[row1][col2];
     				ogText+=matrix[row2][col1];
     			}
        	 }
        	 else {
        		 ogText+=letterPairs[count].charAt(0);
        	 }
 			
 			
         }
         return ogText;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	if (!isStringInBounds(plainText)) {
    		return "The selected string is not in bounds, Try again.";
    	}
    	else {
    		String encryptedText="";
    		int newASCIIVal;
    		for (int count = 0; count < plainText.length(); count++) {
    			newASCIIVal=(int)plainText.charAt(count)+key;
    			if (newASCIIVal>UPPER_RANGE) {
    				newASCIIVal=newASCIIVal-UPPER_RANGE;
    			}
    			encryptedText+=(char)(newASCIIVal);
    		}
    		return encryptedText;
    	}
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
		String ogText="";
		int newASCIIVal;
		for (int count = 0; count < encryptedText.length(); count++) {
			newASCIIVal=(int)encryptedText.charAt(count)-key;
			if (newASCIIVal<LOWER_RANGE) {
				newASCIIVal=(UPPER_RANGE+1)-(LOWER_RANGE-newASCIIVal);
			}
			ogText+=(char)(newASCIIVal);
		}
		return ogText;
    }    

}

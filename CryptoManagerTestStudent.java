import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CAT"));
		assertFalse(CryptoManager.isStringInBounds("{}!"));
	}
	@Test
	public void testVigenereEncryptDecrypt() {
        String plain = "HELLO";
        String key = "123";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
    
	@Test
    public void testPlayfairEncryptDecrypt() {
        String plain = "DOG";
        String key = "BA";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals("DOG", decrypted);
    }
    @Test
    public void testCaesarEncryptDecrypt() {
    	String plain = "CAR";
    	int key = 5;
    	String encrypted = CryptoManager.caesarEncryption(plain, key);
    	String decrypted = CryptoManager.caesarDecryption(encrypted, key);
    	assertEquals(plain, decrypted);
    }

}

package com.ekit.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class for Encrypt and Decrypt a given string by triple-DES Algorithm
 */
public class DESEDE {
   
    Cipher ecipher;
    Cipher dcipher;

    /**
     * Pad a string with spaces on the right.
     * 
     * @param str
     *                String to add spaces
     * @param width
     *                Width of string after padding
     */
    public static String pad(String string, int width) {
	StringBuffer stringBuffer = new StringBuffer(string);
	int space = width - stringBuffer.length();
	while(space-- > 0) {
	    stringBuffer.append(' ');
	}

	return stringBuffer.toString();
    }

    /**
     * Constructor
     * 
     * @param passphrase
     */
    public DESEDE(String passphrase) {
	int keyWidth = passphrase.length();
	if(keyWidth < 24)
	    passphrase = pad(passphrase, 24);
	try {
	    byte[] rawkey = passphrase.getBytes();
	    DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
	    SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
	    SecretKey key = keyfactory.generateSecret(keyspec);

	    ecipher = Cipher.getInstance("DESede/ECB/NoPadding");
	    dcipher = Cipher.getInstance("DESede/ECB/NoPadding");
	    ecipher.init(Cipher.ENCRYPT_MODE, key);
	    dcipher.init(Cipher.DECRYPT_MODE, key);
	} catch(Exception e) {
	   
	}
    }

    /**
     * Encrypt a given string
     * 
     * @param str
     * @return the encrypted string
     */
    public String encrypt(String str) {
	try {
	    int byteLength = str.getBytes("UTF8").length;
	    if(byteLength % 8 != 0) {
		byteLength = (byteLength / 8 + 1) * 8;
		str = pad(str, byteLength);
	    }
	    try {
		byte[] utf8 = str.getBytes("UTF8");
		byte[] enc = ecipher.doFinal(utf8);

		return new sun.misc.BASE64Encoder().encode(enc);
	    } catch(Exception e) {
		

		e.printStackTrace();
	    }
	} catch(java.io.UnsupportedEncodingException ue) {
	    
	    ue.printStackTrace();
	}

	return str;
    }

    /**
     * Decrypt a given String
     * 
     * @param str
     * @return decrypt string
     */
    public String decrypt(String str) {
	try {
	    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
	    byte[] utf8 = dcipher.doFinal(dec);

	    return (new String(utf8, "UTF8")).trim();
	} catch(Exception e) {
	   
	}

	return str;
    }

}
// checklist
// 1 Ceaser cipher
// 2 Transposition Cipher
// 3 playfair cipher
//  4

// // 1. polyalphanumeric cipher
// import java.util.*;
// import java.io.*;
// class Main{
// 	public static void main(String args[])
// 	{
// 		Scanner sc = new Scanner(System.in);
// 		String str = sc.nextLine();
// 		int shift = 3;
// 		String enc = encrypt(str, shift);
// 		System.out.println(enc);
// 		String dec = encrypt(enc, -shift);
// 		System.out.println(dec);

// 	}
// 	static String encrypt(String s , int shift){
// 		StringBuilder sb = new StringBuilder();
// 		for(char c : s.toCharArray()){
// 			char e =  (char)(((c - 'a' + shift) % 26)+'a');
// 			sb.append(e);
// 		}
// 		return sb.toString();
// 	}
// }


// 2.Playfair cipehr
// import java.util.*;
// import java.io.*;
// class Main{
// 	static char m[][] = new char[5][5];
// 	public static void main(String args[])
// 	{
// 		Scanner sc = new Scanner(System.in);
// 		String key = sc.nextLine();
// 		String str = sc.nextLine();
// 		generate(key);
// 		str = prepareText(str);
// 		System.out.println(str);
// 		String enc = encrypt(str);
// 		System.out.println(enc);
	
// 	}
// 	static void generate(String key)
// 	{
// 		boolean visited[] = new boolean[26];
// 		key = key.replace("j","i");
// 		StringBuilder sb = new StringBuilder();
// 		for(char c : key.toCharArray())
// 		{
// 			if(!visited[c-'a']){
// 				visited[c-'a'] = true;
// 				sb.append(c);
// 			}
// 		}
// 		// add remanining
// 		for(char c = 'a' ; c<='z' ; c++){
// 			if(c=='j')
// 					continue;
// 			if(!visited[c-'a']){
// 				visited[c-'a'] = true;
// 				sb.append(c);
// 		}
// 		}
// 		// fill the matrix
// 		int index = 0;
// 		for(int i = 0 ; i < 5 ; i ++){
// 			for(int j = 0 ; j < 5 ; j ++){
// 				m[i][j] = sb.charAt(index++);
// 			}
// 		}
// 	}
// 	static String prepareText(String s)
// 	{
// 		s = s.replace("j" , "i");
// 		StringBuilder sb = new StringBuilder();
// 		for(int i = 0 ; i < s.length() ; i ++)
// 		{
// 			sb.append(s.charAt(i));
// 			if( i < s.length()- 1 && s.charAt(i)==s.charAt(i+1))
// 					sb.append('x');
// 		}
// 		// make even length
// 		if(sb.length()%2==1)
// 				sb.append('x');
// 		return sb.toString();
// 	}
// 	static int[] findPosition(char c )
// 	{
// 		for(int i = 0 ; i < 5 ; i ++)
// 		{
// 			for(int j = 0 ; j < 5 ; j ++)
// 			{
// 				if(m[i][j]==c)
// 						return new int[]{i,j};
// 			}
// 		}
// 		return null;
// 	}
// 	static String encrypt(String s){
// 		StringBuilder sb = new StringBuilder();
// 		for(int i = 0 ;i < s.length() ; i +=2){
// 			char a = s.charAt(i);
// 			char b = s.charAt(i+1);
// 			int p1[] = findPosition(a);
// 			int p2[] = findPosition(b);
// 			if(p1[0] == p2[0]){
// 				sb.append(m[p1[0]][(p2[1]+1)%5 ]);
// 				sb.append(m[p2[0]][(p2[1]+1)%5]);
// 			}
// 			else if(p1[1] == p2[1]){
// 				sb.append(m[ (p1[0	]+1)%5 ][p1[1]]);
// 				sb.append( m[(p2[0]+1) % 5] [p2[1]] );
// 			}
// 			else{
// 				sb.append(m[p1[0]][p2[1]]);
// 				sb.append(m[p2[0]][p1[1]]);
// 			}
// 		}
// 		return sb.toString();
// 		// current and next character in a and b
// 		// find their positions
// 		// if they are in same row then append next column char
// 		// if they are in same column then append next row char
// 		// else
// 		// append each others column position
// 	}
// }



// des
// import java.util.*;
// import java.io.*;
// import java.security.*;
// import javax.crypto.*;
// class Main
// {
// 	public static void main(String args[])
// 	{
// 		try {
// 		KeyGenerator keygen = KeyGenerator.getInstance("DES");
// 		Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
// 		SecretKey myKey = keygen.generateKey();
// 		desCipher.init(Cipher.ENCRYPT_MODE , myKey);
// 		String text = "Information Security";
// 		byte bytes[] = text.getBytes();
// 		byte enc[] = desCipher.doFinal(bytes);
// 		System.out.println(Base64.getEncoder().encodeToString(enc));

// 		desCipher.init(Cipher.DECRYPT_MODE , myKey);
// 		byte dec[] =desCipher.doFinal(enc);
// 		System.out.println(new String(dec));
// 	}
// 	catch(Exception e){
// 	}
// 	}
// }

// AES
// import java.util.*;
// import java.io.*;
// import javax.crypto.*;
// import java.security.*;
// class Main
// {
// 	public static void main(String args[]) throws Exception
// 	{
// 		KeyGenerator keygen = KeyGenerator.getInstance("AES");
// 		keygen.init(256);

// 		SecretKey myKey = keygen.generateKey();
// 		String message = "Information Security";

// 		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
// 		cipher.init(Cipher.ENCRYPT_MODE , myKey);

// 		byte enc[] = cipher.doFinal(message.getBytes());

// 		System.out.println(Base64.getEncoder().encodeToString(enc));

// 		cipher.init(Cipher.DECRYPT_MODE , myKey);
// 		byte dec[] = cipher.doFinal(enc);
// 		System.out.println(new String(dec));
// 	}
// }


// diffie hellman
// class Main
// {
// 	public static void main(String args[])
// 	{

// 		long p ,g , a , b , x , y , ka , kb;
// 		p =  23;
// 		System.out.println("Value of p is "+ p);
// 		g = 5;
// 		System.out.println("Value of g is " + g);
// 		a = 4;
// 		System.out.println("Private Key for alice"+ a);
// 		x = (long)((Math.pow(g , a )) % p);

// 		b = 3;
//    		System.out.println("Private key for bob " + b);
// 		y = (long)((Math.pow(g, b)) % p);

// 		ka = (long)((Math.pow( y , a )) % p);
// 		kb = (long)((Math.pow( x , a )) % p);
// 		System.out.println("Secret key for alice : " + ka);
// 		System.out.println("Secret key for bob : " + kb);

// 	}
// }


// import java.io.*;
// import java.security.*;
// import javax.crypto.*;
// import java.util.*;
// class Main
// {
// 	public static byte[] getHash(String fileName) throws Exception
// 	{
// 		MessageDigest digest = MessageDigest.getInstance("SHA-256");
// 		FileInputStream fin = new FileInputStream(fileName);
// 		byte arr[] = new byte[1024];
// 		int bcount = 0 ;
// 		while( (bcount = fin.read(arr))!=-1 ){
// 			digest.update(arr , 0 , bcount);
// 		}
// 		return digest.digest();
// 	}
// 	public static void main(String args[]) throws Exception
// 	{	
// 		byte original[] = getHash("input.txt");
// 		byte received[] = getHash("output.txt");
// 		if(Arrays.equals(original , received))
// 				System.out.println("OK ✅");
// 		else
// 			System.out.println("modified ❌");
// 	}
// }


// // digital signature rsa user auth + integrity
// import java.security.*;
// import java.util.Base64;
// class Main {
//     public static void main(String[] args) throws Exception {
//         // Generate RSA Key Pair
//         KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
//         keyGen.initialize(1024);
//         KeyPair pair = keyGen.generateKeyPair();
//         PrivateKey privateKey = pair.getPrivate();
//         PublicKey publicKey = pair.getPublic();
//         String message = "Hello";
//         // Create Digital Signature
//         Signature sign = Signature.getInstance("SHA256withRSA");
//         sign.initSign(privateKey);
//         sign.update(message.getBytes());
//         byte[] signature = sign.sign();
//         // Verify Digital Signature
//         Signature verify = Signature.getInstance("SHA256withRSA");
//         verify.initVerify(publicKey);
//         verify.update(message.getBytes());

//         boolean result = verify.verify(signature);

//         System.out.println("Message: " + message);
//         System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
//         System.out.println("Verified: " + result);
//     }
// }


// // rsa confidentiality + integrity
// import java.security.*;
// import javax.crypto.Cipher;
// import java.util.Base64;
//  class Main {
//     public static void main(String[] args) throws Exception {

//         // Generate RSA Keys
//         KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
//         keyGen.initialize(1024);
//         KeyPair pair = keyGen.generateKeyPair();

//         PrivateKey privateKey = pair.getPrivate();
//         PublicKey publicKey = pair.getPublic();

//         String message = "Hello";

//         // Confidentiality (Encryption
//         Cipher cipher = Cipher.getInstance("RSA");
//         cipher.init(Cipher.ENCRYPT_MODE, publicKey);

//         byte[] encrypted = cipher.doFinal(message.getBytes());

//         //  Integrity (Hash) 
//         MessageDigest md = MessageDigest.getInstance("SHA-256");
//         byte[] hash = md.digest(message.getBytes());

//         // Decryption 
//         cipher.init(Cipher.DECRYPT_MODE, privateKey);
//         String decrypted = new String(cipher.doFinal(encrypted));

//         //  Verify Integrity 
//         byte[] newHash = md.digest(decrypted.getBytes());

//         boolean integrity = MessageDigest.isEqual(hash, newHash);

//         System.out.println("Encrypted: " +
//                 Base64.getEncoder().encodeToString(encrypted));

//         System.out.println("Decrypted: " + decrypted);
//         System.out.println("Integrity Verified: " + integrity);
//     }
// }

// // rsa with auth + confidentiality + integrity
// import java.security.*;
// import javax.crypto.Cipher;
// import java.util.Base64;

// class Main {
//     public static void main(String[] args) throws Exception {

//         // Generate RSA keys
//         KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
//         keygen.initialize(1024);

//         KeyPair pair = keygen.generateKeyPair();

//         PrivateKey privateKey = pair.getPrivate();
//         PublicKey publicKey = pair.getPublic();

//         String msg = "Hello";

//         // CONFIDENTIALITY -> Encrypt
//         Cipher cipher = Cipher.getInstance("RSA");
//         cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//         byte[] encrypted = cipher.doFinal(msg.getBytes());

//         // AUTH + INTEGRITY -> Digital Signature
//         Signature sign = Signature.getInstance("SHA256withRSA");
//         sign.initSign(privateKey);
//         sign.update(msg.getBytes());

//         byte[] signature = sign.sign();

//         // Decrypt message
//         cipher.init(Cipher.DECRYPT_MODE, privateKey);
//         String decrypted = new String(cipher.doFinal(encrypted));

//         // Verify signature
//         Signature verify = Signature.getInstance("SHA256withRSA");
//         verify.initVerify(publicKey);
//         verify.update(decrypted.getBytes());

//         boolean result = verify.verify(signature);

//         System.out.println("Encrypted: " +
//                 Base64.getEncoder().encodeToString(encrypted));

//         System.out.println("Decrypted: " + decrypted);
//         System.out.println("Verified: " + result);
//     }
// }


// dsa with authentication and integrity
// import java.util.*;
// import java.security.*;
// class Main
// {
// 	public static void main(String args[]) throws Exception
// 	{
// 		KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
// 		keygen.initialize(1024);

// 		KeyPair keys = keygen.generateKeyPair();

// 		PrivateKey prKey = keys.getPrivate();
// 		PublicKey puKey = keys.getPublic();

// 		String msg = "Hello";

// 		Signature sign = Signature.getInstance("SHA256withDSA");
// 		sign.initSign(prKey);
// 		sign.update(msg.getBytes());

// 		byte signature[] = sign.sign();

// 		Signature verify = Signature.getInstance("SHA256withDSA");
// 		verify.initVerify(puKey);
// 		verify.update(msg.getBytes());

// 		boolean result = verify.verify(signature);
// 		System.out.println("Message = "+ msg);
// 		System.out.println(Base64.getEncoder().encodeToString(signature));

// 	}
// }

// dsa with confidentiality + integrity:
// import java.security.*;
// import javax.crypto.*;
// import java.util.Base64;
// class Main {
//     public static void main(String[] args) throws Exception {

//         // DSA Keys
//         KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
//         keyGen.initialize(1024);

//         KeyPair pair = keyGen.generateKeyPair();

//         PrivateKey privateKey = pair.getPrivate();
//         PublicKey publicKey = pair.getPublic();

//         String msg = "Hello";

//         // CONFIDENTIALITY -> AES Encryption
//         KeyGenerator kg = KeyGenerator.getInstance("AES");
//         kg.init(128);

//         SecretKey aesKey = kg.generateKey();

//         Cipher cipher = Cipher.getInstance("AES");
//         cipher.init(Cipher.ENCRYPT_MODE, aesKey);

//         byte[] encrypted = cipher.doFinal(msg.getBytes());

//         // AUTHENTICATION + INTEGRITY -> DSA Signature
//         Signature sign = Signature.getInstance("SHA256withDSA");
//         sign.initSign(privateKey);
//         sign.update(msg.getBytes());

//         byte[] signature = sign.sign();

//         // Decrypt
//         cipher.init(Cipher.DECRYPT_MODE, aesKey);
//         String decrypted = new String(cipher.doFinal(encrypted));

//         // Verify Signature
//         Signature verify = Signature.getInstance("SHA256withDSA");
//         verify.initVerify(publicKey);
//         verify.update(decrypted.getBytes());

//         boolean result = verify.verify(signature);

//         System.out.println("Encrypted: " +
//                 Base64.getEncoder().encodeToString(encrypted));

//         System.out.println("Decrypted: " + decrypted);
//         System.out.println("Verified: " + result);
//     }
// }

import java.security.*;
import javax.crypto.*;
import java.util.Base64;

class Main {
    public static void main(String[] args) throws Exception {

        // DSA Keys
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(1024);

        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String msg = "Hello";

        // CONFIDENTIALITY -> AES Encryption
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);

        SecretKey aesKey = kg.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        byte[] encrypted = cipher.doFinal(msg.getBytes());

        // AUTHENTICATION + INTEGRITY -> DSA Signature
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(msg.getBytes());

        byte[] signature = sign.sign();

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encrypted));

        // Verify Signature
        Signature verify = Signature.getInstance("SHA256withDSA");
        verify.initVerify(publicKey);
        verify.update(decrypted.getBytes());

        boolean result = verify.verify(signature);

        System.out.println("Encrypted: " +
                Base64.getEncoder().encodeToString(encrypted));

        System.out.println("Decrypted: " + decrypted);
        System.out.println("Verified: " + result);
    }
}
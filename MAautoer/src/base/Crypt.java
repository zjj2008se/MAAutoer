package base;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import base.Base64;

public class Crypt {
	public static final boolean ON = true;
	public static String a = null;

	public static byte[] decode(byte[] paramArrayOfByte) {
		return decode(paramArrayOfByte, a.getBytes());
	}

	public static byte[] decode(byte[] paramArrayOfByte1,
			byte[] paramArrayOfByte2) {
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte2,
				"AES");
		try {
			Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			localCipher.init(2, localSecretKeySpec);
			byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte1);
			return arrayOfByte;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	public static byte[] decode64(String paramArrayOfByte) {
		try {
			byte[] arrayOfByte1 = Base64.decode(paramArrayOfByte, 0);
			byte[] arrayOfByte2 = decode(arrayOfByte1);
			return arrayOfByte2;
		} catch (Exception localException) {
		}
		return null;
	}

	public static byte[] encode(String paramString) {
		return encode(paramString, a.getBytes());
	}

	public static byte[] encode(String paramString, byte[] paramArrayOfByte) {
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte,
				"AES");
		try {
			byte[] arrayOfByte1 = paramString.getBytes();
			Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			localCipher.init(1, localSecretKeySpec);
			byte[] arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
			return arrayOfByte2;
		} catch (Exception localException) {
		}
		return null;
	}

	public static String encode64(String paramString) {
		SecretKeySpec localSecretKeySpec = new SecretKeySpec(a.getBytes(),
				"AES");
		try {
			byte[] arrayOfByte = paramString.getBytes();
			Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			localCipher.init(1, localSecretKeySpec);
			String str = Base64.encodeToString(
					localCipher.doFinal(arrayOfByte), 0);

			int i = str.length() - 1;
			while (i >= 0 && str.charAt(i) == '=')
				i--;
			return str.substring(0, i + 1);
		} catch (Exception localException) {
		}
		return null;
	}

	public static String getCryptUrl(String paramString) {
		StringBuffer localStringBuffer = new StringBuffer(paramString);
		if (paramString.indexOf("?") == -1)
			localStringBuffer.append("?");
		while (true) {
			localStringBuffer.append("cyt=1");
			return localStringBuffer.toString();
		}
	}

	public static void setKey(String paramString) {
		a = paramString;
	}
}

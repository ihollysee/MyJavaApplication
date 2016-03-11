package org.test.security;


import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;


public class Base64Util {
	
	public static String encode(byte[] binaryData) {
		try {
			return new String(Base64.encodeBase64(binaryData), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

    /**
     * base64 中含有不能作为文件名的特殊字符串： + 和 / ，该函数生成的base64字串中，+ 替换成 -， / 替换成 _
     * 这样生成的字符串就能作为文件名 该函数对应的解码函数是{@link #decodeFromFileName}
     * 
     * @param bytes
     * @return
     */
    public static String encodeForFileName(String filename) {
        String base64 = encodeString(filename);
        if (base64 == null) {
            return null;
        }
        // 替换文件名不支持的特殊字符
        return base64.replaceAll("\\+", "-").replaceAll("\\/", "_");
    }

    /**
     * {@link #encodeForFileName} 对应的解码函数
     * 
     * @param filename
     * @return
     */
    public static String decodeFromFileName(String filename) {
        // 还原替换了的字符
        String base64 = filename.replaceAll("\\-", "+").replaceAll("_", "/");
        return decodeString(base64);
    }
	
	public static byte[] decode(String base64String) {
		try {
			return Base64.decodeBase64(base64String.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static String encodeString(String plain) {
		return encodeString(plain, "UTF-8");
	}

	public static String encodeString(String plain, String encoding) {
		if(plain == null) {
			return null;
		}
		try {
			return encode(plain.getBytes(encoding));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static String decodeString(String base64) {
		return decodeString(base64, "UTF-8");
	}

	public static String decodeString(String base64, String encoding) {
		if(base64 == null) {
			return null;
		}
		try {
			return new String(decode(base64), encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
}

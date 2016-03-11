
package org.test.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    public static void main(String[] args) {
        // java.security.MessageDigest alga;
        // try {
        // for (int i = 0; i < 100; i++) {
        // alga = java.security.MessageDigest.getInstance("sha-1");
        // alga.update("abcdef".getBytes("UTF-8"));
        // System.out.println(new String(alga.digest()));
        // System.out.println(byteArrayToHex(alga.digest()));
        // }
        // } catch (Exception e) {
        // }
        //
        // //
        // System.out.println(getMD5Str("aa"));
        //
        // // 长连接： http://tech.sina.com.cn/i/2011-03-23/11285321288.shtml
        // // 新浪解析后的短链接为： http://t.cn/h1jGSC
        // String sLongUrl =
        // "http://tech.sina.com.cn/i/2011-03-23/11285321288.shtml"; //
        // 3BD768E58042156E54626860E241E999
        // String[] aResult = shortUrl(sLongUrl);
        // // 打印出结果
        // for (int i = 0; i < aResult.length; i++) {
        // System.out.println("[" + i + "]:::" + aResult[i]);
        // }
        //
        //
        // String myinfo="我的测试信息";
        // //java.security.MessageDigest
        // alg=java.security.MessageDigest.getInstance("MD5");
        // java.security.MessageDigest alga1;
        // try {
        // alga1 = java.security.MessageDigest.getInstance("SHA-1");
        // alga1.update(myinfo.getBytes());
        // byte[] digesta=alga1.digest();
        // System.out.println("本信息摘要是 :"+byte2hex(digesta));
        // } catch (NoSuchAlgorithmException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println(getMD5("afafaf".getBytes()));
        
        
    }
    public static String encodeHex(byte[] data) {

        if (data == null) {
            
            return null;
        }
        
        final String HEXES = "0123456789abcdef";
        int len = data.length;
        StringBuilder hex = new StringBuilder(len * 2);
        
        for(int i = 0; i < len; ++i) {
            
            hex.append(HEXES.charAt((data[i] & 0xF0) >>> 4));
            hex.append(HEXES.charAt((data[i] & 0x0F)));
        }
        
        return hex.toString();
    }
    public static String byte2hex(byte[] b) // 二行制转字符串
    {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++)
        {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static String[] shortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "wuguowei";
        // 要使用生成 URL 的字符
        String[] chars = new String[] {
                "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"

        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = MD5Util.getStringMD5(key + url);
        String hex = sMD5EncryptResult;

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用
            // long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    public static String getMD5(byte[] source) {
        String s = null;
        char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
          'e', 'f' };
        try {
         MessageDigest md = MessageDigest
           .getInstance("MD5");
         md.update(source);
         byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
         // 用字节表示就是 16 个字节
         char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
         // 所以表示成 16 进制需要 32 个字符
         int k = 0; // 表示转换结果中对应的字符位置
         for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
          // 转换成 16 进制字符的转换
          byte byte0 = tmp[i]; // 取第 i 个字节
          str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
          // >>> 为逻辑右移，将符号位一起右移
          str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
         }
         s = new String(str); // 换后的结果转换为字符串
        } catch (Exception e) {
         e.printStackTrace();
        }
        return s;
       }
    
    public static byte[] getMD5Byte(byte[] source) {
        byte[] b = new byte[16];
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f'
        };

        try {
            MessageDigest md = MessageDigest
                    .getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
                int a = Integer.parseInt((str[k - 2] + "" + str[k - 1]).toString(), 16);
                b[i] = (byte) a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    private static String getMD5Str(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    public static String byteArrayToHex(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符

        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };

        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））

        char[] resultCharArray = new char[byteArray.length * 2];

        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去

        int index = 0;

        for (byte b : byteArray) {

            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];

            resultCharArray[index++] = hexDigits[b & 0xf];

        }

        // 字符数组组合成字符串返回

        return new String(resultCharArray);

    }
}

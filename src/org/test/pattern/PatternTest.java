
package org.test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        // String COMMAND_PATTERN = "(.{0,})" +
        // "(baojing|dingwei|suoding)#(.{6,}+)";
        //
        // Pattern p = Pattern.compile(COMMAND_PATTERN);
        // Matcher m = p.matcher("杨贝贝：suoding#235689");
        // if (m.find()) {
        // System.out.println("true");
        // } else {
        // System.out.println("false");
        // }

        System.out.println(isEmail("jkk_kjk@cyou-inc.com"));

    }

    // 验证邮箱的格式
    public static boolean isEmail(String email) {

        final String check = "^[a-z0-9A-Z]([a-z0-9A-Z_]*[a-z0-9A-Z]+)*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";// "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";//
                                                                                                                        // "^(\\w+([-+.]\\w+)*)@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";//
        //
        final Pattern regex = Pattern.compile(check);
        final Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

}

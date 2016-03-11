
package org.test.main;

import java.text.DecimalFormat;

public class Formmater {

    public static void main(String[] args) {
        System.out.println(formatLocation(Double.valueOf(0)));

    }

    private static String formatLocation(double location) {
        if(location==0){
            return "0";
        }
        DecimalFormat df = new DecimalFormat("###.0000000");
        return df.format(location);
    }
}

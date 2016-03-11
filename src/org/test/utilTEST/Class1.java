
package org.test.utilTEST;

public class Class1 {
    public boolean debug = CommonLog.getDeg() && true;

    public void fun() {
        System.out.println("debug:" + debug);
    }
}

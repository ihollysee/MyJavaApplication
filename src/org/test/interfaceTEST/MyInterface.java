package org.test.interfaceTEST;

public interface MyInterface {
	// 接口内不可以有构造方法,而抽象类可以
	/*
	 * MyInterface(String str1){
	 * 
	 * }
	 */
	// 接口类可以有成员变量,该成员变量必须是public或static或final的,必须已经初始化了
	public String str1 = "";
	public Object str2 = "";
	// public Object str;
	// private String str3="";
	static String str4 = "";
	final String str5 = "";

	public void method1();

}

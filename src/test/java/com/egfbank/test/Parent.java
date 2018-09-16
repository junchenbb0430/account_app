package com.egfbank.test;

public class Parent {
	public static int A =1;
	// 对于类来说，父类静态代码块要优先于子类Sub中类变量B的复制操作
	static {
		A =2;
	}
	public static void main(String[] args) {
		 System.out.println(Sub.B);//结果为2
	}
}

class Sub extends Parent{
	public static int B =A;
}

package com.egfbank.test;

  class SuperClass {
	static {
		System.out.println("superClass init!");
	}
	public static int value =123;
}
  class SubClass extends SuperClass{
	static {
		System.out.println("subClass init!");
	}
}
public class TestInit{
	public static void main(String[] args) {
		//通过子类引用父类定义的静态字段，只会初始化父类初始化，不会初始化子类
		System.out.println(SubClass.value);
	}
}

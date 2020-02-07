package buh;
public class main {
	public static void main(String[] args) {
		Object var1 = new Bite();
		Gulp var2 = new Gulp();
		Gulp var3 = new Sip();
		Bite var4 = new Drink();
		Object var5 = new Gulp();
		Gulp var6 = new Drink();

((Gulp) var1).method2();
System.out.println();
var2.method2();
System.out.println();
var3.method2();
System.out.println();
var4.method2();
System.out.println();
((Gulp) var5).method2();
System.out.println();
var6.method2();
System.out.println();
((Bite) var1).method3();
System.out.println();
var3.method3();
System.out.println();
var4.method3();
System.out.println();

//((Bite) var5).method3();
System.out.println();

var6.method3();
System.out.println();
//((Sip) var6).method1();
System.out.println();
//((Gulp) var1).method1();
System.out.println();

((Gulp) var1).method2();
System.out.println();
((Bite) var6).method1();
System.out.println();
//((Drink)var1).method1();
System.out.println();
((Drink)var4).method2();
System.out.println();
//((Bite) var3).method1();

	}
}

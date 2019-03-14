package com.example.demo;

public class Test {
public static void main(String[] args) {
	int a =10;
	myLamda lamda = 
			
			new myLamda() {
		
		public void process(int a) {
			System.out.println(a);
			
		}
	};
	
	doproc(a, lamda);
}
private static void doproc(int i,myLamda lamda) {
	lamda.process(i);

}
interface myLamda{
	void process(int a);
}
}

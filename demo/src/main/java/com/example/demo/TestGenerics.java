package com.example.demo;

public class TestGenerics<RM> {
	RM r;

	public RM getR() {
		return r;
	}

	public void setR(RM r) {
		this.r = r;
	}
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
		return g1.get().equals(g2.get());
	}
	
	public static void main(String[] args) {
		
		  TestGenerics<String> s = new TestGenerics<String>(); s.setR("Rameshmeda");
		  String myname = s.getR(); System.out.println(myname);
		 
		int oldCapacity=11;
		System.out.println(oldCapacity + (oldCapacity >> 1));
	}
}

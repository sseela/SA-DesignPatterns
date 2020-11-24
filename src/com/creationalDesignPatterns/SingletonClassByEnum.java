package com.creationalDesignPatterns;

public class SingletonClassByEnum {
	public static void main(String[] args) {
		Connection con = Connection.getInstance;
		Connection c2 = Connection.getInstance;
		con.method();
		System.out.println(con.hashCode());
		System.out.println(c2.hashCode());
	}
}

enum Connection {
	getInstance;			// public static final Connection getInstance = new Connection();
	
	public void method() {
		System.out.println("method called");
	}
}
package com.singleton;

public class DBConn {
	private static DBConn instance = new DBConn();

	private DBConn() {

	}

	public static DBConn getInstance() {
		return instance;
	}

	public void caller() {
		System.out.println("Session2 Hands-on: Sigleton");
	}

}

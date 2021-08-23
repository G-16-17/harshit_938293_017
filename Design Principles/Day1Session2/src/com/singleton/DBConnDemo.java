package com.singleton;

public class DBConnDemo {

	public static void main(String[] args) {
		DBConn dbConn = DBConn.getInstance();
		dbConn.caller();

	}

}

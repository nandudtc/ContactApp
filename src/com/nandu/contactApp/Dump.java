package com.nandu.contactApp;

import java.io.File;

public class Dump {

	public static void main(String[] args) {
		File f = new File("D:\\other\\dump"); 
		
		File[] ff = f.listFiles();
		System.out.println(ff.length);

	}

}

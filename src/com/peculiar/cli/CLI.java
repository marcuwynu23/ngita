package com.peculiar.cli; 

public class CLI{
	
	public static synchronized void execute(String command){
		try{
			Runtime.getRuntime().exec(command);
	}catch(Exception e){
		System.out.println("error");
	}
	}
}
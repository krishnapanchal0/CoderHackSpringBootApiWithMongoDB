package com.CoderHack.CoderHack.Exception;

public class CustomException extends RuntimeException{

	private String s;
	public CustomException(String msg)
	{
		super(msg);
		this.s=msg;
	}
	
}

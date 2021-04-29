package com.icc.curso.services.exceptions;



public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		
		super("Resource Nout Found . ID" +id);
	}

}
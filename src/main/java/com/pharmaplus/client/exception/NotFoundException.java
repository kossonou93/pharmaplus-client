package com.pharmaplus.client.exception;

public class NotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929274209567376060L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public NotFoundException(String message) {
        super(message);
    }

}

package com.MarjoPosse.Profielen.Message;

public class Message {
	private String message;

	/**
	 *
	 * @param message
	 */
	public Message(String message){
	 	this.message = message;
	}

	/**
	 * @deprecated Old Contructor.
	 */
	public Message(){
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}


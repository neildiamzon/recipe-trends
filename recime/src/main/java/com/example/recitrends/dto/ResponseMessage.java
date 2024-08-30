package com.example.recitrends.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {
	private String message;
	
	public ResponseMessage(String m){
		this.message = m;
	}
}

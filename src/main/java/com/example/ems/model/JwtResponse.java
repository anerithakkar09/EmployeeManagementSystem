package com.example.ems.model;

import java.io.Serializable;

public class JwtResponse implements Serializable
{
	private static final long serialVersionUID = 6870958100618967019L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}

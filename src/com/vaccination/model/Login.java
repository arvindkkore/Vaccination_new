package com.vaccination.model;

public class Login {

	private int userid;
	private String username;
	private String password;
	private String user_type;

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
    public int getUserid() 
    {
	return userid;
    }
  public void setUserid(int userid) {
	this.userid = userid;
  }
}
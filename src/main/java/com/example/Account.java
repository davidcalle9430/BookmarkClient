package com.example;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;
public class Account {
	private String username;
	@JsonIgnore
	private String password;

	private Long id;
	private Set<Bookmark> bookmarks;
	
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account() {
		super();
	}

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", id=" + id+ "]";
	}
	
	
}

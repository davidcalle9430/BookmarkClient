package com.example;




import org.neo4j.kernel.api.impl.index.bitmaps.LongPageIterator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Bookmark {
	
	
	private StringProperty description;
	private LongProperty id;
	@JsonIgnore
	private ObjectProperty<Account> account;
	private StringProperty uri;
	
	
	public Bookmark(Account account, String uri, String description) {
		super();
		this.account.set(account);
		this.uri.set(uri);
		this.description.set(description);
	}
	public Long getId() {
		return id.get();
	}
	public void setId(Long id) {
		this.id.set(id);
	}
	public Account getAccount() {
		return account.get();
	}
	public void setAccount(Account account) {
		this.account.set(account);
	}
	public String getUri() {
		return uri.get();
	}
	public void setUri(String uri) {
		this.uri.set(uri);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	public Bookmark() {
		super();
		description = new SimpleStringProperty();
		id = new SimpleLongProperty();
		uri = new SimpleStringProperty();
		account = new SimpleObjectProperty<>();
	}
	public StringProperty URIProperty(){
		return uri;
	}
	public StringProperty descriptionProperty(){
		return description;
	}
	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", account=" + account + ", uri=" + uri + ", description=" + description + "]";
	}
	
	
		
}

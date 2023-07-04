package com.masai.Dto;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User implements Comparable{

	private int userId;
	@NotBlank
	private String name;
	@Email
	private String email;
	private Set<Content>contentToStream=new TreeSet<>(); //(TreeSet of content objects)
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userId, @NotBlank String name, @Email String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Content> getContentToStream() {
		return contentToStream;
	}
	public void setContentToStream(Set<Content> contentToStream) {
		this.contentToStream = contentToStream;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", contentToStream=" + contentToStream
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contentToStream, email, name, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contentToStream, other.contentToStream) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && userId == other.userId;
	}
	@Override
	public int compareTo(Object o) {
		
		return 1;
	}
}

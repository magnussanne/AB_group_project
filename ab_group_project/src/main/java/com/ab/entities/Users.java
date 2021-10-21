package com.ab.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String email;
	private String username;
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Orders> orders;

	public Users() {

	}

	public Users(String email, String username, String password, List<Orders> orders) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.orders = orders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "ID: " + userId + " Email: " + email + " Username: " + username + " Password: " + password + "Orders: "
				+ orders;
	}

}

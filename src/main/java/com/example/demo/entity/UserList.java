package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name="userlist")
@Data
public class UserList {
	
	//ユーザーID
	@Id
	@Column(name="userid")
	private String userid;
	
	//ユーザー名
	@Column(name="usernme")
	private String usernme;
	
	//パスワード
	@Column(name="pass")
	private String pass;
	
}

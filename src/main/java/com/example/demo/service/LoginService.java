package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserList;
import com.example.demo.form.LoginData;
import com.example.demo.repository.UserListRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoginService {

	private final UserListRepository userListRepository ;
	
	//ログイン情報がのチェック
	public List  LoginChk(LoginData logindata) {
		
		//ユーザーリストでユーザーを検索する。
		List<UserList> userlist = userListRepository.findByUseridAndPass(logindata.getUserid(), logindata.getPass());
		
		return userlist; //ユーザーリストを返す。
	}
	
	
	
}

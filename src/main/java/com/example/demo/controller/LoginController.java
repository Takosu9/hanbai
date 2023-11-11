package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserList;
import com.example.demo.form.LoginData;
import com.example.demo.repository.UserListRepository;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
	private final UserListRepository userListRepository;
	private final LoginService loginService;
	
	@Autowired
	HttpSession session;

	//ログイン画面へ遷移
	@GetMapping("/login")
	public ModelAndView  loginShow(ModelAndView mv) {
		
		mv.setViewName("Login"); //Login画面をセットする。
		List<UserList> userList = userListRepository.findAll(); //検索しリストに格納する。
		
		mv.addObject("userList",userList); //リストをセットする。
		
		
		return mv;
	}
	
	
	//ログインボタン押下時の処理
	@PostMapping("login/result")
	public ModelAndView loginchk(ModelAndView mv,LoginData loginData) {
		
		@SuppressWarnings({ "unused", "unchecked" })
		List<UserList> userDataList = loginService.LoginChk(loginData);	//ログインデータをリストにバインドする。
		
		
		//ユーザーがいるかどうかによって返す。
		if(userDataList.size() == 0) 
		{
			mv.setViewName("Login"); //元のデータを返す。
			List<UserList> userList = userListRepository.findAll(); //検索しリストに格納する。
			mv.addObject("userList",userList); //リストをセットする。
			session.setAttribute("userValidate","No"); //ユーザーリストを返す。
		}
		else 
		{
			mv.setViewName("Menu"); //ログインする。
			mv.addObject("userDataList",userDataList); //ユーザーリストを返す。
		}
		
		
		return mv;
	}
	
	
	
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MiniUserDao;
import com.example.demo.dto.MiniUserDto;

@Service
public class MiniUserService {
	private final MiniUserDao miniUserDao;

	public MiniUserService(MiniUserDao miniUserDao) {
		this.miniUserDao = miniUserDao;
	}

	//ユーザー一覧を取得
	public List<MiniUserDto> getAllUser() {

		return miniUserDao.findAll();
	}

	//userIdを取得
	public Optional<MiniUserDto> getUserId(Integer id) {

		return miniUserDao.findById(id);
	}

	//user登録
	public void createUser(MiniUserDto user) {
		miniUserDao.insert(user);
	}

}

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

		for (MiniUserDto user : userList) {
			boolean match = user.getId().equals(id);

			if (match) {
				return Optional.of(user);
			}
		}
		MiniUserDto noneUser = new MiniUserDto(999, "none", 0, "none");

		return Optional.of(noneUser);
	}

}

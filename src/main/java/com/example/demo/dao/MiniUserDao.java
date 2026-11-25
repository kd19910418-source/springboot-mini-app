package com.example.demo.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MiniUserDto;

@Repository
public class MiniUserDao {

	public final JdbcTemplate jdbcTemplate;

	public MiniUserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<MiniUserDto> findAll() {
		String sql = "SELECT `id`, `name`, `age`, `email` FROM `users`";

		List<MiniUserDto> userList = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Integer id = rs.getInt("id");
			String name = rs.getString("name");
			Integer age = rs.getInt("age");
			String email = rs.getString("email");

			return new MiniUserDto(id, name, age, email);
		});

		return userList;
	}

	public Optional<MiniUserDto> findById(Integer id) {
		String sql = "SELECT id, name, age, email FROM users WHERE id = ?";
		List<MiniUserDto> userList = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> new MiniUserDto(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getString("email")), id);

		return userList.stream().findFirst();

	}

}

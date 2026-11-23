package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.MiniUserDto;
import com.example.demo.service.MiniUserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MiniController {
	public final MiniUserService miniUserService;

	@GetMapping("/mini")
	public String getMini() {
		return "mini/index";
	}

	@GetMapping("/mini/users")
	public String getUsers(@RequestParam(required = false) String name,
			Model model) {

		List<MiniUserDto> userList = new ArrayList<>();
		userList = miniUserService.getAllUser();

		if (name == null || name.isBlank()) {

		} else {
			List<MiniUserDto> searchList = new ArrayList<>();
			for (MiniUserDto user : userList) {

				if (user.getName().contains(name)) {
					searchList.add(user);
					userList = searchList;
				}
			}
		}

		model.addAttribute("userList", userList);
		return "mini/users";

	}

	@GetMapping("/mini/users/{id}")
	public String miniIdGet(@PathVariable Integer id,
			Model model) {

		Optional<MiniUserDto> users = miniUserService.getUserId(id);
		MiniUserDto user = users.get();
		model.addAttribute("user", user);

		return "mini/detail";
	}

}

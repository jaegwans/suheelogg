package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Guest;
import net.skhu.mapper.GuestMapper;
import net.skhu.model.Pagination;

@Controller
public class GuestController {
	@Autowired
	GuestMapper studentMapper;

	@RequestMapping("Guest/list")
	public String list(Model model, Pagination pagination) {
		List<Guest> students = studentMapper.findAll(pagination);
		pagination.setRecordCount(studentMapper.count());
		model.addAttribute("students", students);
		Guest student = new Guest();
		model.addAttribute("student", student);
		return "Guest/list";
	}

	@GetMapping("Guest/create")
	public String create(Model model) {
		Guest student = new Guest();
		model.addAttribute("student", student);
		return "Guest/create";
	}

//	@PostMapping("Guest/create")
//	public String create(Model model, Guest student,Pagination pagination) {
//		studentMapper.insert(student);
//		return "redirect:list";
//	}
//
	@PostMapping("Guest/list")
	public String create(Model model, Guest student) {
		studentMapper.insert(student);
		return "redirect:list";

//		int lastPage = (int) Math.ceil((double) studentMapper.count() / pagination.getSz());
//		pagination.setPg(lastPage);
//		return "redirect:list?" + pagination.getQueryString();
	}

}

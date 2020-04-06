package com.jacksubho.vacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacksubho.vacademy.entity.Assignments;
import com.jacksubho.vacademy.entity.Instructor;
import com.jacksubho.vacademy.repository.AssignmentsRepository;
import com.jacksubho.vacademy.repository.InstructorRepository;

@Controller
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepo;
	
	@Autowired
	private AssignmentsRepository assignmentsRepo;

	@RequestMapping("/showInstructorReg")
	public String showInstructorRegistrationPage() {
		return "login/registerInstructor";
	}

	@RequestMapping("/showInstructorLogin")
	public String showInstructorLoginPage() {
		return "login/instructorLogin";
	}

	@RequestMapping(value = "/registerInstructor", method = RequestMethod.POST)
	public String register(@ModelAttribute("instructor") Instructor instructor) {
		instructorRepo.save(instructor);
		return "login/instructorLogin";
	}

	@RequestMapping(value = "/instructorLogin", method = RequestMethod.POST)
	public String instructorLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap map) {
		Instructor instructor = instructorRepo.findByEmail(email);
		List<Assignments> assignments = assignmentsRepo.findAllByInstructorId(instructor.getId());
		if (instructor.getPassword().equals(password)) {
			map.addAttribute("instructor", instructor);
			map.addAttribute("assignments", assignments);
			return "/addAssignments";
		} else
			map.addAttribute("msg", "Invalid UserName/Password");
		return "login/instructorLogin";
	}

}

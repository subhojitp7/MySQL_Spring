package com.jacksubho.vacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.jacksubho.vacademy.entity.Assignments;
import com.jacksubho.vacademy.entity.Instructor;
import com.jacksubho.vacademy.repository.AssignmentsRepository;
import com.jacksubho.vacademy.repository.InstructorRepository;

@Controller
public class AssignmentsController {
	
	@Autowired
	private AssignmentsRepository assignmentsRepo;

	@Autowired
	private InstructorRepository instructorRepo;

	@RequestMapping(value = "/uploadAssignments", method = RequestMethod.POST)
	public String upload(@RequestParam("details") String details,
			@RequestParam("assignment") MultipartFile file, @RequestParam("instructorId") long instructorId,
			ModelMap map) {
		Instructor instructor = instructorRepo.findById(instructorId).get();
		Assignments assignment = new Assignments();
		assignment.setName(file.getOriginalFilename());
		assignment.setDetails(details);
		try {
			assignment.setAssignment(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		assignment.setInstructor(instructor);
		assignmentsRepo.save(assignment);
		List<Assignments> assignments = assignmentsRepo.findAllByInstructorId(instructor.getId());
		map.addAttribute("instructor", instructor);
		map.addAttribute("assignments", assignments);
		return "/addAssignments";
	}

	@RequestMapping("/downloadAssignment")
	public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response) {
		Assignments assignment = assignmentsRepo.findById(id).get();
		byte[] data = assignment.getAssignment();
		response.setHeader("Content-Disposition", "attachment;filename=" + assignment.getName());
		return outputStream -> {
			outputStream.write(data);
		};
	}
	
	/*@RequestMapping("/editAssignment")
	public String edit(@RequestParam("id") long id,ModelMap map) {
		Instructor instructor = assignmentsRepo.findById(id).get().getInstructor();
		Assignments assignment = assignmentsRepo.getOne(id);
		assignment.setDetails(details);
		List<Assignments> assignments = assignmentsRepo.findAllByInstructorId(instructor.getId());
		map.addAttribute("instructor", instructor);
		map.addAttribute("assignments", assignments);
		return "/addAssignments";
	}*/
	
	@RequestMapping("/deleteAssignment")
	public String delete(@RequestParam("id") long id,
			ModelMap map) {
		Instructor instructor = assignmentsRepo.findById(id).get().getInstructor();
		assignmentsRepo.deleteById(id);
		List<Assignments> assignments = assignmentsRepo.findAllByInstructorId(instructor.getId());
		map.addAttribute("instructor", instructor);
		map.addAttribute("assignments", assignments);
		return "/addAssignments";
	}

}

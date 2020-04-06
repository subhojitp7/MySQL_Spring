package com.jacksubho.vacademy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jacksubho.vacademy.entity.Instructor;
import com.jacksubho.vacademy.entity.Videos;
import com.jacksubho.vacademy.repository.InstructorRepository;
import com.jacksubho.vacademy.repository.VideosRepository;

@Controller
public class VideosController {
	
	@Autowired
	private InstructorRepository instructorRepo;
	
	@Autowired
	private VideosRepository videosRepo;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadVideo(@RequestParam("name") String name,@RequestParam("video") MultipartFile multipartFile,
			@RequestParam("instructorEmail") String instructorEmail, ModelMap map) {
		Videos video = new Videos();
		video.setName(name);
		try {
			video.setVideo(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Instructor instructor = instructorRepo.findByEmail(instructorEmail);
		video.setInstructor(instructor);
		videosRepo.save(video);
		map.addAttribute("instructor", instructor);
		return "/addVideos";
	}


}

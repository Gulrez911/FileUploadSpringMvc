package com.gul.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	@Autowired
	ServletContext context;

	@GetMapping("/")
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

	@PostMapping("/upload")
	public ModelAndView success(@RequestParam("name") MultipartFile file, Model model) throws IOException {
		ModelAndView mav = new ModelAndView("index");
		if (!file.getOriginalFilename().isEmpty()) {
//			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
//					new File("D:/Upload/SingleFileUpload", file.getOriginalFilename())));
//			outputStream.write(file.getBytes());
//			outputStream.flush();
//			outputStream.close();
			System.out.println("testing: " + context.getRealPath("/resources")
					+ file.getOriginalFilename());
//			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(
//					context.getRealPath("/resources") + "/" + file.getOriginalFilename()));
			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(
					context.getRealPath("/resources/") + "/" + file.getOriginalFilename()));
			model.addAttribute("msg", "File uploaded successfully");
		} else {
			model.addAttribute("msg", "Please select valid file.");
		}
		return mav;
	}
}

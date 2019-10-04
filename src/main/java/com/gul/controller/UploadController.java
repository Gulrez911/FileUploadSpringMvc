package com.gul.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.PropertiesConfig;

@Controller
public class UploadController {

	@Autowired
	ServletContext context;
	@Autowired
	PropertiesConfig config;

	@GetMapping("/")
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

//	@PostMapping("/upload")
//	public ModelAndView success(@RequestParam("name") MultipartFile file, Model model) throws IOException {
//		ModelAndView mav = new ModelAndView("index");
//		if (!file.getOriginalFilename().isEmpty()) {
////			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
////					new File("D:/Upload/SingleFileUpload", file.getOriginalFilename())));
////			outputStream.write(file.getBytes());
////			outputStream.flush();
////			outputStream.close();
//			System.out.println("testing: " + context.getRealPath("/resources")
//					+ file.getOriginalFilename());
////			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(
////					context.getRealPath("/resources") + "/" + file.getOriginalFilename()));
////			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(
////					config.getFileLocation() + "/" + file.getOriginalFilename()));
//			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(
//					config.getFileLocation() + "/" + file.getOriginalFilename()));
//			model.addAttribute("msg", "File uploaded successfully");
//		} else {
//			model.addAttribute("msg", "Please select valid file.");
//		}
//		return mav;
//	}

	@PostMapping("/upload")
	public ModelAndView success(@RequestParam(name = "name", required = false) MultipartFile file, Model model)
			throws IOException {
		ModelAndView mav = new ModelAndView("index");
		if (!file.getOriginalFilename().isEmpty()) {
			System.out.println("testing: " + config.getFileLocation() + "/" + file.getOriginalFilename());
//			FileCopyUtils.copy(file.getBytes(), new FileOutputStream(config.getFileLocation() + "/" + file.getOriginalFilename()));
			String destination = config.getFileLocation() + "/" + file.getOriginalFilename();
			File file2 = new File(destination);
//			FileUtils.copyFile(file2, file2);
			file.transferTo(file2);

			model.addAttribute("msg", "File uploaded successfully");
		} else {
			model.addAttribute("msg", "Please select valid file.");
		}
		return mav;
	}

	@GetMapping("downloadFile")
	public @ResponseBody void getImageAsByteArray(HttpServletResponse response) throws IOException {
		byte data[] = FileUtils.readFileToByteArray(new File("D://Files/Logogo copy.png"));
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		FileCopyUtils.copy(data, response.getOutputStream());
	}
}

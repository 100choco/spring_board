package com.bbs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbs.model.AttachFileDTO;

import net.coobird.thumbnailator.Thumbnailator;


@Controller
public class UploadController {
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		System.out.println("uploadForm 진입 성공");
		return "uploadForm";
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("----------------");
			System.out.println("업로드된 파일 이름 : " + multipartFile.getOriginalFilename());
			System.out.println("업로드된 파일 크기 : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				System.out.println("파일 저장 실패");
			}
		}
		
	}
	
		@GetMapping("/uploadAjax")
		public String uploadAjax() {
			System.out.println("uploadAjax 진입 성공");
			return "uploadAjax";
		}
		
		@PostMapping(value = "/uploadAjaxAction", 
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public ResponseEntity<List<AttachFileDTO>> 
		uploadAjaxAction(MultipartFile[] uploadFile) {
			
			List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
			
			String uploadFolder = "C:\\upload";
			
			String uploadFolerPath = getFolder();
			
			
			File uploadPath = new File(uploadFolder, uploadFolerPath);
			
			if(uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
			
			
			for(MultipartFile multipartFile : uploadFile) {
				
				AttachFileDTO attachDTO = new AttachFileDTO();
				
				String uploadFileName = multipartFile.getOriginalFilename();
				
				attachDTO.setFileName(uploadFileName);
				
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
				
						
				UUID uuid = UUID.randomUUID();
				
				uploadFileName = uuid.toString()+"_" + uploadFileName;
				
				System.out.println("uploadFileName====>"+uploadFileName);
				
				File saveFile = new File(uploadPath, uploadFileName);
				
				try {
					multipartFile.transferTo(saveFile);
					
					attachDTO.setUuid(uuid.toString());
					attachDTO.setUploadPath(uploadFolerPath);
					
					if(checkImageType(saveFile)) {
						
						attachDTO.setImage(true);
						
						FileOutputStream thumbnail = new FileOutputStream(
								new File(uploadPath, "t_" + uploadFileName));
						Thumbnailator.createThumbnail(multipartFile.getInputStream(),
								thumbnail, 100, 100);
						thumbnail.close();
					}
					
					list.add(attachDTO);
					
				} catch (Exception e) {
					System.out.println("파일 저장 실패");
				}
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
		@GetMapping("/display")
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName){
			String uploadFolder = "C:\\upload\\";
			File file = new File(uploadFolder+fileName);
			
			ResponseEntity<byte[]> result = null;
			
			try {
				
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), 
						header, HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return result;
			
		}
		
		
		
		
		private String getFolder() {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			String str = sdf.format(date);
			return str.replace("-", File.separator);
			
		}
		
		private boolean checkImageType(File file) {
			
			try {
				
				String contentType = Files.probeContentType(file.toPath());
				return contentType.startsWith("image");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
		
	
}

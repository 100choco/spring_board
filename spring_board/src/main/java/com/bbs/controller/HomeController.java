package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.model.BoardDTO;
import com.bbs.model.PersonDTO;
import com.bbs.page.Criteria;
import com.bbs.page.ViewPage;
import com.bbs.service.BoardService;
import com.bbs.service.PersonService;


@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService; 
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String home() {
	
		return "home";
	}
	
	@GetMapping("/register")
	public String goRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(BoardDTO dto) {
		
		boardService.insert(dto);
		
		return "redirect:/";
	}
	

	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno")String ubno) {
		
		Long bno = Long.parseLong(ubno);
		boardService.delete(bno);
		
		return "redirect:/boardList";
	}
	
	@GetMapping("/personDelete")
	public String personDelete(@RequestParam("pno")String upno) {
		
		Long pno = Long.parseLong(upno);
		personService.delete(pno);
		
		return "redirect:/personList";
	}
	
	@GetMapping("/boardContent")
	public String boardContent(@RequestParam("bno")String ubno, Model model) {
		
		Long bno = Long.parseLong(ubno);
		BoardDTO dto = boardService.boardContent(bno);
		model.addAttribute("dto", dto);
		
		return "boardContent";
	}
	
	@GetMapping("/personContent")
	public String personContent(@RequestParam("pno")String upno, Model model) {
		
		Long pno = Long.parseLong(upno);
		PersonDTO dto = personService.personContent(pno);
		model.addAttribute("dto", dto);
		
		return "personContent";
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm(@RequestParam("bno") String ubno, Model model) {
		
		Long bno = Long.parseLong(ubno);
		BoardDTO dto = boardService.boardContent(bno);
		model.addAttribute("dto", dto);
		
		return "modifyForm";
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @RequestParam("bno") String bno) {
		
		boardService.update(dto);
		
		return "redirect:/boardContent?bno="+bno;
	}
	
	@GetMapping("/personModifyForm")
	public String personModifyForm(@RequestParam("pno") String upno, Model model) {
		
		Long pno = Long.parseLong(upno);
		PersonDTO dto = personService.personContent(pno);
		model.addAttribute("dto", dto);
		
		return "personModifyForm";
	}
	
	
	
	@PostMapping("/personModify")
	public String personModify(PersonDTO dto) {
		
		personService.update(dto);
		
		return "redirect:/personContent?pno="+dto.getPno();
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model, Criteria cri) {
		
		List<BoardDTO> boardList = boardService.getListPaging(cri);
		model.addAttribute("boardList", boardList);
		
		int total = boardService.getTotal();
		ViewPage vp = new ViewPage(cri, total);
		model.addAttribute("pageMaker", vp);
		
		return "boardList";
	}

	@GetMapping("/personList")
	public String personList(Model model) {
		
		List<PersonDTO> personList = personService.person_list_all();
		
		model.addAttribute("personList", personList);
		
		
		
		return "personList";
	}
	
	@GetMapping("/personRegister")
	public String gopersonRegister() {
		
		return "personRegister";
	}
	
	@PostMapping("/personRegister")
	public String personRegister(PersonDTO dto) {
		
		personService.insert(dto);
		
		return "redirect:/";
	}



	
}

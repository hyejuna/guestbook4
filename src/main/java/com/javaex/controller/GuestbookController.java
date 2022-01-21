package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/guest")
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookDao gbDao;
	
	
	//메소드일반
	//리스트출력
	@RequestMapping(value="/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addlist(Model model) {
		System.out.println("guest > addList");
		
		//리스트 출력을 위한 메소드사용
		List<GuestbookVo> gbList = gbDao.getList();
		System.out.println(gbList.toString());
		
		//보내주기위해 모델 사용
		model.addAttribute("gbList", gbList);
		
		//리턴
		return "addList";
	}
	
	//등록
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo gbVo) {
		System.out.println("guest > add");
		
		//파라미터값 한번에 넣어주기
		gbDao.insert(gbVo);
		
		//리다이렉트
		return "redirect:/guest/addlist";
	}
	
	//삭제폼
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("guest > deleteForm");
	
		//리다이렉트
		return "deleteForm";
	}
	
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String pass) {
		System.out.println("guest > delete");
		
		//두 파라미터값 vo에 넣어주기
		GuestbookVo gbinfo = new GuestbookVo(no, pass);
		
		//삭제메소드 사용
		gbDao.delete(gbinfo);
		
		//리다이렉트
		return "redirect:/guest/addlist";
	}

}

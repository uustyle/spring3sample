package jp.co.kenshu.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.kenshu.dto.test.TestDto;
import jp.co.kenshu.service.TestService;


@Controller
public class RestfulController {

	@Autowired
	private TestService service;
	
    // テキストが返る※@RestControllerが付いているので、@ResponseBodyが不要
    @RequestMapping(value = "/api/text/")
    @ResponseBody
    public String getTestMember() {
        return "aaaa";
    }
    
    @RequestMapping("/api/json/")
    @ResponseBody
	public List<TestDto> json(
			@RequestParam("param1") String param1, 
			@RequestParam("param2") String param2) {
		List<TestDto> tests = service.getTestAll();
		return tests;
	}
    
    
    @RequestMapping("/api/json2/")
    @ResponseBody
	public List<TestDto> json2(
			HttpSession session) {
    	 Object ret = session.getAttribute("session1");
    	 System.out.print(ret);
    	 session.setAttribute("session1", "httpSession");
		List<TestDto> tests = service.getTestAll();
		return tests;
	}
    
    
    
}

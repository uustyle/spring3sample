package jp.co.kenshu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<TestDto> json() {
        List<TestDto> tests = service.getTestAll();
        return tests;
    }
    
    
}

package jp.co.kenshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.kenshu.dto.test.TestDto;
import jp.co.kenshu.form.TestForm;
import jp.co.kenshu.service.TestService;

@Controller
public class TestController {

//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public String showMessage(Model model) {
//        model.addAttribute("message", "hello world!!");
//        return "showMessage";
//    }
    
	@Autowired
    private TestService testService;	
	
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showMessage(Model model) {
        TestForm form = new TestForm();
        form.setId(0);
        form.setName("ここに名前を書いてね");
        model.addAttribute("testForm", form);
        model.addAttribute("message", "FORMの練習2");
        return "showMessage2";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String getFormInfo(@ModelAttribute TestForm form, Model model) {
        model.addAttribute("message", "ID : " + form.getId() + " & name : " + form.getName());
        return "showMessage";
    }    
    
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String test(Model model, @PathVariable int id) {
        TestDto test = testService.getTest(id);
        model.addAttribute("message", "MyBatisのサンプルです");
        model.addAttribute("test", test);
        return "test";
    }
    
    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public String testAll(Model model) {
        List<TestDto> tests = testService.getTestAll();
        model.addAttribute("message", "MyBatisの全件取得サンプルです");
        model.addAttribute("tests", tests);
        return "testAll";
    }    
    
    @RequestMapping(value = "/test/insert/input/", method = RequestMethod.GET)
    public String testInsert(Model model) {
        TestForm form = new TestForm();
        model.addAttribute("testForm", form);
        model.addAttribute("message", "MyBatisのinsertサンプルです。");
        return "testInsert";
    }

    @RequestMapping(value = "/test/insert/input/", method = RequestMethod.POST)
    public String testInsert(@ModelAttribute TestForm form, Model model) {
        int count = testService.insertTest(form.getName());
//        Logger.getLogger(TestController.class).log(Level.INFO, "挿入件数は" + count + "件です。");
        return "redirect:/test/";
    }
    
    
    @RequestMapping(value = "/test/delete/input/", method = RequestMethod.GET)
    public String testDelete(Model model) {
        TestForm form = new TestForm();
        model.addAttribute("testForm", form);
        model.addAttribute("message", "MyBatisのdeleteサンプルです。");
        return "testDelete";
    }

    @RequestMapping(value = "/test/delete/input/", method = RequestMethod.POST)
    public String testDelete(@ModelAttribute TestForm form, Model model) {
        int count = testService.deleteTest(form.getId());
//        Logger.getLogger(TestController.class).log(Level.INFO, "削除件数は" + count + "件です。");
        return "redirect:/test/";
    }
    
    
    
    
    @RequestMapping(value = "/test/transaction/{id}", method = RequestMethod.GET)
    public String testTransaction(Model model, @PathVariable int id) {
        TestDto dto = new TestDto();
        dto.setId(id);
        testService.deleteAllAndInsert(dto);
        return "redirect:/test/";
    }
    
    
    
    
    
}


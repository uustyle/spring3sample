package jp.co.kenshu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	
	@RequestMapping("/download")
	public void download(HttpServletResponse res) throws Exception {
		// ContentTypeを指定
		res.setContentType("text/csv;charset=MS932");
		String fileName = new String("sample.csv".getBytes("MS932"), "ISO-8859-1");
		// Headerを設定
		res.setHeader("Content-Disposition", "attachment; filename="+fileName);
		// 内容を出力
		PrintWriter writer = res.getWriter();
		writer.write("hello, world, こんにちは,世界");
		writer.close();
	}
	
}

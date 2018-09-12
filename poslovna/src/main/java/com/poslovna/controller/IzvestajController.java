package com.poslovna.controller;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


@RestController
@RequestMapping("/api/izvestaj")
public class IzvestajController {
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;
	@Value("${spring.datasource.url}")
	private String dbUrl;
	private final String libPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "lib"
			+ System.getProperty("file.separator");

	@GetMapping(path = "/FSS/{id}")
	public void getFSS(@PathVariable Long id,HttpServletRequest request, HttpServletResponse response) throws IOException {

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("id", id);

		String jrxml = libPath + "FSS.jrxml";
		String jasper = libPath + "FSS.jasper";
		makeReport(jrxml, jasper, hm);
		File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "out.pdf");
		if (file.exists()) {

			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				//unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			 //Here we have mentioned it to show as attachment
			 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
		
	}

	@GetMapping(path = "/KIF/{beginDate}/{endDate}")
	public ResponseEntity<?> getKIF(@PathVariable Long beginDate, @PathVariable Long endDate) {
		String jrxml = libPath + "KIF.jrxml";
		String jasper = libPath + "KIF.jasper";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("beginDate", beginDate);
		hm.put("endDate", endDate);
		return new ResponseEntity<>(makeReport(jrxml, jasper, hm), HttpStatus.OK);
	}

	private HashMap<String,String> makeReport(String reportFile, String jasper, Map<String, Object> hm) {
		byte[] ret = null;
		try {
			Class.forName(dbDriver);
			JasperCompileManager.compileReportToFile(reportFile, jasper);
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasper, hm, conn);
			ret = JasperExportManager.exportReportToPdf(jprint);
			OutputStream out = new FileOutputStream("out.pdf");
			out.write(ret);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<String,String> map = new HashMap<>();
		map.put("report", Base64Utils.encodeToString(ret));
		return map;
	}

}

package com.ymagis.logcnc;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ymagis.logcnc.service.ILogCNCService;
import com.ymagis.logcnc.service.LogCNCService;

@SpringBootApplication
public class LogCncApplication {
	
	private static Logger logger = Logger.getLogger(LogCncApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(LogCncApplication.class, args);
//		Integer length = args.length;
		String filePath = "C:\\Users\\Amine\\Desktop\\comscore.csv";
		String pathCsv = "C:\\Users\\Amine\\Desktop\\comscore_minimise.csv";
		ILogCNCService service = new LogCNCService();
		try {
			service.execute(filePath, pathCsv);
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}
}

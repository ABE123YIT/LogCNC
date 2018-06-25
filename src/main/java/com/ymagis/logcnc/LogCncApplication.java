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
		Integer length = args.length;
		if(length > 1){
			String filePath = args[0];
			String pathCsv = args[1];
			ILogCNCService service = new LogCNCService();
			try {
				service.execute(filePath, pathCsv);
			} catch (Exception e) {
				logger.log(Level.WARNING, e.getMessage(), e);
			}
		}
	}
}

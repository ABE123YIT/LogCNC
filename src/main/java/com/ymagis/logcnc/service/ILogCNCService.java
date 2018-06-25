package com.ymagis.logcnc.service;

import java.util.List;

import com.ymagis.logcnc.model.LogCNCBean;

public interface ILogCNCService {
	
	public List<LogCNCBean> getData(String filePath) throws Exception;
	
	public void generateCsvFile(List<LogCNCBean> list, String pathCsv) throws Exception;
	
	public void execute(String filePath, String pathCsv) throws Exception;
	
	

}

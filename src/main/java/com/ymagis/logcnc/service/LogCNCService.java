package com.ymagis.logcnc.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ymagis.logcnc.model.LogCNCBean;

public class LogCNCService implements ILogCNCService {

	private static Logger logger = Logger.getLogger(LogCNCService.class.getName());
	
	private static String HEADER = "id; rel_devices_screen_id; cpl_id; cpl_content_title; cpl_content_kind; cpl_duration_s; start_datetime; stop_datetime; duration_s; created; modified; theater_id; theater_code; country; screen_id; show_id; title";

	public void execute(String filePath, String pathCsv) throws Exception {
		try {
			List<LogCNCBean> list = getData(filePath);
			if (null != list && !list.isEmpty()) {
				generateCsvFile(list, pathCsv);
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
	}

	public List<LogCNCBean> getData(String filePath) throws Exception {
		List<LogCNCBean> list = new ArrayList<LogCNCBean>();
		Map<String, BigInteger> mapRelDevScrId = new HashMap<String, BigInteger>();
		Map<String, BigInteger> mapTheaterId = new HashMap<String, BigInteger>();
		Map<String, BigInteger> mapTheaterCode = new HashMap<String, BigInteger>();
		Map<String, BigInteger> mapScreenId = new HashMap<String, BigInteger>();
		try {
			String line = "";
			String cvsSplitBy = "\\|";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			Integer max1 = 0;
			Integer max2 = 0;
			Integer max3 = 0;
			Integer max4 = 0;
			while ((line = br.readLine()) != null) {
				LogCNCBean elt = new LogCNCBean();
				String[] infos = line.split(cvsSplitBy);
				int lenght = infos.length;
				elt.setId(infos[0]);
				elt.setRelDevScrId(lenght > 1 ? infos[1] : "");
				elt.setCplId(lenght > 2 ? infos[2] : "");
				elt.setCplContentTitle(lenght > 3 ? infos[3] : "");
				elt.setCplContentKind(lenght > 4 ? infos[4] : "");
				elt.setCplDuration(lenght > 5 ? infos[5] : "");
				elt.setStartDatetime(lenght > 6 ? infos[6] : "");
				elt.setStopDatetime(lenght > 7 ? infos[7] : "");
				elt.setDuration(lenght > 8 ? infos[8] : "");
				elt.setCreated(lenght > 9 ? infos[9] : "");
				elt.setModified(lenght > 10 ? infos[10] : "");
				elt.setTheaterId(lenght > 11 ? infos[11] : "");
				elt.setTheaterCode(lenght > 12 ? infos[12] : "");
				elt.setCountry(lenght > 13 ? infos[13] : "");
				elt.setScreenId(lenght > 14 ? infos[14] : "");
				elt.setShowId(lenght > 15 ? infos[15] : "");
				elt.setMovieTitle(lenght > 16 ? infos[16] : "");
				// Minimiser les ids
				BigInteger relDevScrIdMinime = mapRelDevScrId.get(elt.getRelDevScrId());
				if (null == relDevScrIdMinime) {
					max1++;
					relDevScrIdMinime = BigInteger.valueOf(max1);
					mapRelDevScrId.put(elt.getRelDevScrId(), relDevScrIdMinime);
				}
				elt.setRelDevScrIdMinime(relDevScrIdMinime);

				BigInteger theaterIdMinime = mapTheaterId.get(elt.getTheaterId());
				if (null == theaterIdMinime) {
					max2++;
					theaterIdMinime = BigInteger.valueOf(max2);
					mapTheaterId.put(elt.getTheaterId(), theaterIdMinime);
				}
				elt.setTheaterIdMinime(theaterIdMinime);

				BigInteger theaterCodeMinime = mapTheaterCode.get(elt.getTheaterCode());
				if (null == theaterCodeMinime) {
					max3++;
					theaterCodeMinime = BigInteger.valueOf(max3);
					mapTheaterCode.put(elt.getTheaterCode(), theaterCodeMinime);
				}
				elt.setTheaterCodeMinime(theaterCodeMinime);

				BigInteger screenIdMinime = mapScreenId.get(elt.getScreenId());
				if (null == screenIdMinime) {
					max4++;
					screenIdMinime = BigInteger.valueOf(max4);
					mapScreenId.put(elt.getScreenId(), screenIdMinime);
				}
				elt.setScreenIdMinime(screenIdMinime);

				list.add(elt);
			}
		} catch (IOException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		} catch (Exception ex) {
			logger.log(Level.WARNING, ex.getMessage(), ex);
		}
		return list;
	}

	public void generateCsvFile(List<LogCNCBean> list, String pathCsv) throws Exception {
		File csvFile = new File(pathCsv);
		if (!csvFile.exists()) {
			csvFile.createNewFile();
		}
		if (csvFile.isFile()) {
			BufferedWriter bw = null;
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"));
			// bw = new BufferedWriter(new FileWriter(csvFile));
			bw.write(HEADER);
			bw.newLine();
			for (LogCNCBean elt : list) {
				bw.write(elt.toString());
				bw.newLine();
			}
			bw.close();
		}
	}

}

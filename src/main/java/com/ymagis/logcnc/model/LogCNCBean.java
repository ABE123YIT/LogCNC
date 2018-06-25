package com.ymagis.logcnc.model;

import java.io.Serializable;
import java.math.BigInteger;

public class LogCNCBean implements Serializable {

	private String id;
	private String relDevScrId;
	private String cplId;
	private String cplContentTitle;
	private String cplContentKind;
	private String cplDuration;
	private String startDatetime;
	private String stopDatetime;
	private String duration;
	private String created;
	private String modified;
	private String theaterId;
	private String theaterCode;
	private String country;
	private String screenId;
	private String showId;
	private String movieTitle;
	private BigInteger screenIdMinime;
	private BigInteger theaterIdMinime;
	private BigInteger theaterCodeMinime;
	private BigInteger relDevScrIdMinime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelDevScrId() {
		return relDevScrId;
	}

	public void setRelDevScrId(String relDevScrId) {
		this.relDevScrId = relDevScrId;
	}

	public String getCplId() {
		return cplId;
	}

	public void setCplId(String cplId) {
		this.cplId = cplId;
	}

	public String getCplContentTitle() {
		return cplContentTitle;
	}

	public void setCplContentTitle(String cplContentTitle) {
		this.cplContentTitle = cplContentTitle;
	}

	public String getCplContentKind() {
		return cplContentKind;
	}

	public void setCplContentKind(String cplContentKind) {
		this.cplContentKind = cplContentKind;
	}

	public String getCplDuration() {
		return cplDuration;
	}

	public void setCplDuration(String cplDuration) {
		this.cplDuration = cplDuration;
	}

	public String getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(String startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getStopDatetime() {
		return stopDatetime;
	}

	public void setStopDatetime(String stopDatetime) {
		this.stopDatetime = stopDatetime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterCode() {
		return theaterCode;
	}

	public void setTheaterCode(String theaterCode) {
		this.theaterCode = theaterCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public BigInteger getScreenIdMinime() {
		return screenIdMinime;
	}

	public void setScreenIdMinime(BigInteger screenIdMinime) {
		this.screenIdMinime = screenIdMinime;
	}

	public BigInteger getTheaterIdMinime() {
		return theaterIdMinime;
	}

	public void setTheaterIdMinime(BigInteger theaterIdMinime) {
		this.theaterIdMinime = theaterIdMinime;
	}

	public BigInteger getTheaterCodeMinime() {
		return theaterCodeMinime;
	}

	public void setTheaterCodeMinime(BigInteger theaterCodeMinime) {
		this.theaterCodeMinime = theaterCodeMinime;
	}

	public BigInteger getRelDevScrIdMinime() {
		return relDevScrIdMinime;
	}

	public void setRelDevScrIdMinime(BigInteger relDevScrIdMinime) {
		this.relDevScrIdMinime = relDevScrIdMinime;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(id).append(";").append(relDevScrIdMinime).append(";").append(cplId).append(";")
				.append(cplContentTitle).append(";").append(cplContentKind).append(";").append(cplDuration).append(";")
				.append(startDatetime).append(";").append(stopDatetime).append(";").append(duration).append(";")
				.append(created).append(";").append(modified).append(";").append(theaterIdMinime).append(";")
				.append(theaterCodeMinime).append(";").append(country).append(";").append(screenIdMinime).append(";")
				.append(showId).append(";").append(movieTitle).toString();
	}

}

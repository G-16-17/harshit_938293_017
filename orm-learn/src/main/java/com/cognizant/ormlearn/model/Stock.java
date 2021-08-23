package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_id")
	private int id;
	@Column(name = "st_code")
	private String code;
	@Column(name = "st_date")
	private Date date;
	@Column(name = "st_open")
	private BigDecimal stOpen;
	@Column(name = "st_close")
	private BigDecimal stClose;
	@Column(name = "st_volume")
	private BigDecimal volume;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(int id, String code, Date date, BigDecimal stOpen, BigDecimal stClose, BigDecimal volume) {
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.stOpen = stOpen;
		this.stClose = stClose;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getStOpen() {
		return stOpen;
	}

	public void setStOpen(BigDecimal stOpen) {
		this.stOpen = stOpen;
	}

	public BigDecimal getStClose() {
		return stClose;
	}

	public void setStClose(BigDecimal stClose) {
		this.stClose = stClose;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return String.format("%-15s%-20s%-15s%-15s%-20s", code, date, stOpen, stClose, volume);
	}

}

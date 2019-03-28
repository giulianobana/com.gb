package open.com.model.object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import open.com.model.type.CurrencyType;
import open.com.model.type.SignType;
import open.com.model.type.SignType2;


public class SecurityPositionModel {

	private String isin;
	private long quantity;
	
	private double price;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="CET")
	@Temporal(TemporalType.DATE)
	private Date valuedate;
	
	private double counterValue;

	
	public double getCounterValue() {
		return quantity * price ;
	}
	
	
	public Date getValuedate() {
		return valuedate;
	}
	public double getPrice() {
		return price;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public SecurityPositionModel(String isin, long quantity , double price , Date valuedate) {
		super();
		this.isin = isin;
		this.quantity = quantity;
		this.price = price;
		this.valuedate =  valuedate;

	}
	
	

	}

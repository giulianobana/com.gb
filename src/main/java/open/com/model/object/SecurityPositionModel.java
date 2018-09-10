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

@Entity
public class SecurityPositionModel {

	@Id
	private String isin;
	private long quantity;
	
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
	
	
	public SecurityPositionModel(String isin, long quantity) {
		super();
		this.isin = isin;
		this.quantity = quantity;
	}
	
	

	}

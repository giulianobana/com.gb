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
@Table(name="SECTRANSACTION")
public class SecTransactionModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	private int accountid;
	

	@Enumerated(EnumType.STRING)
	private SignType2 sign;

	private int quantity;
	
	
	private String ISIN;

	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date valuedate;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public SignType2 getSign() {
		return sign;
	}


	public void setSign(SignType2 sign) {
		this.sign = sign;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getISIN() {
		return ISIN;
	}


	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}


	public Date getValuedate() {
		return valuedate;
	}


	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	
	
}

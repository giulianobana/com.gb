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
public class CashBalanceModel {

	@Id
	private CurrencyType currency;
	private long balance;
	
	public CurrencyType getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public CashBalanceModel(CurrencyType currency, long balance) {
		super();
		this.currency = currency;
		this.balance = balance;
	}
	
	
	
	
	}

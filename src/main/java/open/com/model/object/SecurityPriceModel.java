package open.com.model.object;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import open.com.model.type.CurrencyType;
import open.com.model.type.SignType;
import open.com.model.type.SignType2;

@Entity
@Table(name="SECPRICE")
public class SecurityPriceModel implements Serializable {

	@Id
	private String isin;
	
//	@OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "isin" , insertable=false ,  updatable = false)
//	private SecurityMasterModel securityMasterModel;
	
	private double price;

	@Id
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss z", timezone="CET")
	@Temporal(TemporalType.DATE)
	private Date valuedate;
	
	private boolean isLast;

	public String getIsin() {
		return isin;
	}

	public double getPrice() {
		return price;
	}

	public boolean isLast() {
		return isLast;
	}

	
	}

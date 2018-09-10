package open.com.model.object;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;

import open.com.model.type.CurrencyType;
import open.com.model.type.SignType;
import open.com.model.type.SignType2;

@Entity
@Table(name="SECMASTER")
public class SecurityMasterModel {

	
	@Id
	private String isin;
	

	private String description;

	private String currency;
	private String type;
	private String market;

//	@OneToMany(mappedBy="isin", fetch = FetchType.EAGER)
////	@Fetch(value = FetchMode.SUBSELECT)
//	private List<SecurityPriceModel> prices;	
	
	public String getCurrency() {
		return currency;
	}


	public String getType() {
		return type;
	}


	public String getMarket() {
		return market;
	}


	public String getIsin() {
		return isin;
	}


	public String getDescription() {
		return description;
	}


//	public List<SecurityPriceModel> getPrices() {
//		return prices;
//	}

	
	
	}

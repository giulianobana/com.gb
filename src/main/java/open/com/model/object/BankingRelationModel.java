package open.com.model.object;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="BANKINGRELATION")
public class BankingRelationModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private int customerid;
	
	@Column(nullable = false) 
	private int productid;
	
	@Column(nullable = false) 
	private boolean active;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date openingDate;

	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid" , insertable=false ,  updatable = false)
	private CustomerModel customer;
	
	@OneToMany(mappedBy="bankingRelation", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<AccountModel> accounts;	

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid" , insertable=false ,  updatable = false)
	private ProductModel product;
//	
//	
// 	public String getProductDescription() {
// 		return product.getDescription();
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	// model

	public List<AccountModel> getAccounts() {
		return accounts;
	}
	
	
}

package open.com.model.object;



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

import open.com.model.type.JobType;
import open.com.model.type.MaritalStatus;

@Entity
@Table(name="KNOWYOURCUSTOMER")
public class KycModel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(nullable = false) 
	private int  customerid;
	
	@Enumerated(EnumType.STRING)
	private JobType job;	
	
	private int  annualIncome;
	
	private int annualSpending;
	
	private int totalWealth;

	@Enumerated(EnumType.STRING)
	private MaritalStatus  maritalstatus;

	private int  numberofkids;
	
	private int numberofcar;
	
	private boolean pep;

	private boolean houseHolder;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid" , insertable = false , updatable = false)
	private CustomerModel customer;
	
	
	
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

	public JobType getJob() {
		return job;
	}

	public void setJob(JobType job) {
		this.job = job;
	}

	public int getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	public int getAnnualSpending() {
		return annualSpending;
	}

	public void setAnnualSpending(int annualSpending) {
		this.annualSpending = annualSpending;
	}

	public int getTotalWealth() {
		return totalWealth;
	}

	public void setTotalWealth(int totalWealth) {
		this.totalWealth = totalWealth;
	}

	public MaritalStatus getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(MaritalStatus maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public int getNumberofkids() {
		return numberofkids;
	}

	public void setNumberofkids(int numberofkids) {
		this.numberofkids = numberofkids;
	}


	public int getNumberofcar() {
		return numberofcar;
	}

	public void setNumberofcar(int numberofcar) {
		this.numberofcar = numberofcar;
	}

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}

	public boolean isHouseHolder() {
		return houseHolder;
	}

	public void setHouseHolder(boolean houseHolder) {
		this.houseHolder = houseHolder;
	}
	
}

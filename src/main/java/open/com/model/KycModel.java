package open.com.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name="KNOWYOURCUSTOMER")
public class KycModel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	private int  customerid;
	
	private String job;	
	
	private int  annualIncome;
	
	private int annualSpending;
	
	private int totalWealth;
	
	private int  maritalstatus;

	private int  numberofkids;
	
	private String currentcar;
	
	private boolean pep;

	
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
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

	public int getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public int getNumberofkids() {
		return numberofkids;
	}

	public void setNumberofkids(int numberofkids) {
		this.numberofkids = numberofkids;
	}

	public String getCurrentcar() {
		return currentcar;
	}

	public void setCurrentcar(String currentcar) {
		this.currentcar = currentcar;
	}

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}
	
}

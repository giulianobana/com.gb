package open.com.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private int customerid;
	
	private String job;	
	
	private int  annualIncome;
	
	private int annualSpending;
	
	private int totalWealth;
	
	private int  maritalstatus;

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
	
}
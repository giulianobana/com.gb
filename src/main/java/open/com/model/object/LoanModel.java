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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import open.com.model.type.CurrencyType;
import open.com.model.type.SignType;
import open.com.model.type.SignType2;

@Entity
@Table(name="LOAN")
public class LoanModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false) 
	private int bankingrelationid;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bankingrelationid" , insertable=false ,  updatable = false)
	private BankingRelationModel bankingRelation;
	
	
	
	private int debitaccountid;

	private String loantype;
	
	private String interestratetype;

	private double interestratevalue;
	
	private String buildingAddress;
	
	private double amountIssued;

	private double amountresidual;

	private double estimatedbuildingvalue;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startdate;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date closuredate;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "debitaccountid" , insertable=false ,  updatable = false)
	private AccountModel cashaccount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDebitaccountid() {
		return debitaccountid;
	}

	public void setDebitaccountid(int debitaccountid) {
		this.debitaccountid = debitaccountid;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public String getInterestratetype() {
		return interestratetype;
	}

	public void setInterestratetype(String interestratetype) {
		this.interestratetype = interestratetype;
	}

	public double getInterestratevalue() {
		return interestratevalue;
	}

	public void setInterestratevalue(double interestratevalue) {
		this.interestratevalue = interestratevalue;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}

	public double getAmountIssued() {
		return amountIssued;
	}

	public void setAmountIssued(double amountIssued) {
		this.amountIssued = amountIssued;
	}

	public double getAmountresidual() {
		return amountresidual;
	}

	public void setAmountresidual(double amountresidual) {
		this.amountresidual = amountresidual;
	}

	public double getEstimatedbuildingvalue() {
		return estimatedbuildingvalue;
	}

	public void setEstimatedbuildingvalue(double estimatedbuildingvalue) {
		this.estimatedbuildingvalue = estimatedbuildingvalue;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getClosuredate() {
		return closuredate;
	}

	public void setClosuredate(Date closuredate) {
		this.closuredate = closuredate;
	}

	public int getBankingrelationid() {
		return bankingrelationid;
	}

	public void setBankingrelationid(int bankingrelationid) {
		this.bankingrelationid = bankingrelationid;
	}
	
	
}

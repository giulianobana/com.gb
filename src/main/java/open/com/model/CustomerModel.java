package open.com.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="CUSTOMER")
public class CustomerModel {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false , unique=true) 
	private String nickname;
	
	@Column(nullable = false) 
	private String surname;	
	
	@Column(nullable = false) 
	private String lastname;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false) 
	private Date dateOfBirth;

	@Column(nullable = false) 
	private String countryofbirth;
	
	@Column(nullable = false) 
	private String countryDomicile;
	
	@Column(nullable = false) 
	private String nationality;
	
	@Column(nullable = false) 
	private String city;

	@Column(nullable = false) 
	private String street;
	
	@Column(nullable = false , updatable = false) 
	private String creator;
	
//	@OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id")
//	// @Column(nullable = false , unique=true ,  updatable = false) 
	@OneToOne(mappedBy="customer")
	private KycModel kyc;
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	private List<BankingRelationModel> bankingRelations;	
	
	
	public List<BankingRelationModel> getBankingRelations() {
		return bankingRelations;
	}

	public KycModel getKyc() {
		return kyc;
	}



	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountryofbirth() {
		return countryofbirth;
	}

	public void setCountryofbirth(String countryofbirth) {
		this.countryofbirth = countryofbirth;
	}

	public String getCountryDomicile() {
		return countryDomicile;
	}

	public void setCountryDomicile(String countryDomicile) {
		this.countryDomicile = countryDomicile;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

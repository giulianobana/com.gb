package open.com.model.object;



import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;

import open.com.model.type.GenderType;

@Entity(name = "CustomerSimpleModel")
@Table(name="CUSTOMER")
public class CustomerSimpleModel {

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
	
	@Enumerated(EnumType.STRING) 
	private GenderType gender;
	
	@Column(nullable = false , updatable = false) 
	private String creator;
	
	

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

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	
}

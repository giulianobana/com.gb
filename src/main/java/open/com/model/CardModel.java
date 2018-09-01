package open.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARD")
public class CardModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String cardnumber;
	
	private int accountid;
	
	private String type;

	
	private String circuit;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCardnumber() {
		return cardnumber;
	}


	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCircuit() {
		return circuit;
	}


	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}


	
}

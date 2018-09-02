package open.com.model.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import open.com.model.type.CardCircuitType;
import open.com.model.type.CardType;

@Entity
@Table(name="CARD")
public class CardModel {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(  updatable = false) 
	private String cardnumber;
	
	private int accountid;

	@Enumerated(EnumType.STRING)
	private CardType type;

	
	@Enumerated(EnumType.STRING)
	private CardCircuitType circuit;


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


	public CardType getType() {
		return type;
	}


	public void setType(CardType type) {
		this.type = type;
	}


	public CardCircuitType getCircuit() {
		return circuit;
	}


	public void setCircuit(CardCircuitType circuit) {
		this.circuit = circuit;
	}


	
}

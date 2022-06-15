package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	private Date ctime;

	private String email;

	private String name;

	private String password;

	private BigDecimal tel;

	//bi-directional one-to-one association to Person
	@OneToOne(cascade={CascadeType.ALL})
	private Person person;

	//bi-directional many-to-one association to Tip
	@OneToMany(mappedBy="customer")
	private List<Tip> tips;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="customer")
	private List<History> histories;

	public Customer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getTel() {
		return this.tel;
	}

	public void setTel(BigDecimal tel) {
		this.tel = tel;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Tip> getTips() {
		return this.tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

	public Tip addTip(Tip tip) {
		getTips().add(tip);
		tip.setCustomer(this);

		return tip;
	}

	public Tip removeTip(Tip tip) {
		getTips().remove(tip);
		tip.setCustomer(null);

		return tip;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setCustomer(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setCustomer(null);

		return history;
	}

}
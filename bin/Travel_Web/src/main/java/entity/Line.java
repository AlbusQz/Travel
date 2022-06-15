package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LINE database table.
 * 
 */
@Entity
@NamedQuery(name="Line.findAll", query="SELECT l FROM Line l")
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String agency;

	@Lob
	private String intro;

	private String name;

	private BigDecimal price;

	@Temporal(TemporalType.DATE)
	@Column(name="R_TIME")
	private Date rTime;

	@Temporal(TemporalType.DATE)
	@Column(name="T_TIME")
	private Date tTime;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="T_CITY")
	private City city1;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="R_CITY")
	private City city2;

	public Line() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgency() {
		return this.agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getRTime() {
		return this.rTime;
	}

	public void setRTime(Date rTime) {
		this.rTime = rTime;
	}

	public Date getTTime() {
		return this.tTime;
	}

	public void setTTime(Date tTime) {
		this.tTime = tTime;
	}

	public City getCity1() {
		return this.city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return this.city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

}
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
	private long id;

	private String agency;

	@Lob
	private String intro;

	private String name;

	private BigDecimal price;
	
	@Lob
	private byte[] pic;

	@Temporal(TemporalType.DATE)
	@Column(name="R_TIME")
	private Date rTime;

	@Temporal(TemporalType.DATE)
	@Column(name="T_TIME")
	private Date tTime;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="T_CITY")
	private City tcity;

	//bi-directional one-to-one association to City
	@OneToOne
	@JoinColumn(name="R_CITY")
	private City rcity;

	public Line() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public City getTcity() {
		return this.tcity;
	}

	public void setTcity(City tcity) {
		this.tcity = tcity;
	}

	public City getRcity() {
		return this.rcity;
	}

	public void setRcity(City rcity) {
		this.rcity = rcity;
	}
	
	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
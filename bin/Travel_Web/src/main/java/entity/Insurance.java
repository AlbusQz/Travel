package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INSURANCE database table.
 * 
 */
@Entity
@NamedQuery(name="Insurance.findAll", query="SELECT i FROM Insurance i")
public class Insurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String agency;

	@Lob
	private String intro;

	private String name;

	private BigDecimal period;

	private BigDecimal  price;
	
	@Lob
	private byte[] pic;

	public Insurance() {
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

	public BigDecimal getPeriod() {
		return this.period;
	}

	public void setPeriod(BigDecimal period) {
		this.period = period;
	}

	public BigDecimal getPrice() {
		return this.price;
	}
	public long getPricel()
	{
		return this.price.longValue();
	}

	public void setPrice(BigDecimal  price) {
		this.price = price;
	}
	
	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
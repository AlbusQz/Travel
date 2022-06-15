package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SCENIC database table.
 * 
 */
@Entity
@NamedQuery(name="Scenic.findAll", query="SELECT s FROM Scenic s")
public class Scenic implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ScenicPK id;

	private BigDecimal capacity;

	@Lob
	private String intro;

	private BigDecimal price;

	private BigDecimal stars;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY")
	private City cityBean;

	public Scenic() {
	}

	public ScenicPK getId() {
		return this.id;
	}

	public void setId(ScenicPK id) {
		this.id = id;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getStars() {
		return this.stars;
	}

	public void setStars(BigDecimal stars) {
		this.stars = stars;
	}

	public City getCityBean() {
		return this.cityBean;
	}

	public void setCityBean(City cityBean) {
		this.cityBean = cityBean;
	}

}
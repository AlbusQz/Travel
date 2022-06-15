package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String intro;

	private String name;

	private BigDecimal tel;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY")
	private City cityBean;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="hotel")
	private List<Room> rooms;

	public Hotel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getTel() {
		return this.tel;
	}

	public void setTel(BigDecimal tel) {
		this.tel = tel;
	}

	public City getCityBean() {
		return this.cityBean;
	}

	public void setCityBean(City cityBean) {
		this.cityBean = cityBean;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setHotel(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setHotel(null);

		return room;
	}

}
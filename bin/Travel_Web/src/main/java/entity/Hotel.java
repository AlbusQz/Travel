package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAVEL_HOTEL_SEQ")
	@SequenceGenerator(sequenceName = "TRAVEL_HOTEL_SEQ", allocationSize = 1, name = "TRAVEL_HOTEL_SEQ")
	private long id;

	@Lob
	private String intro;

	private String name;

	private BigDecimal tel;
	
	@Lob
	private byte[] pic;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CITY")
	private City city;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="hotel")
	private List<Room> rooms = new ArrayList<Room>();

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

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoomPK id;

	private BigDecimal capacity;

	private BigDecimal price;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="H_ID")
	private Hotel hotel;

	public Room() {
	}

	public RoomPK getId() {
		return this.id;
	}

	public void setId(RoomPK id) {
		this.id = id;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CITY database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String name;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="city1")
	private List<Ticket> tickets1;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="city2")
	private List<Ticket> tickets2;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="cityBean")
	private List<Hotel> hotels;

	//bi-directional many-to-one association to Scenic
	@OneToMany(mappedBy="cityBean")
	private List<Scenic> scenics;

	//bi-directional many-to-one association to Line
	@OneToMany(mappedBy="city1")
	private List<Line> lines1;

	//bi-directional many-to-one association to Line
	@OneToMany(mappedBy="city2")
	private List<Line> lines2;

	public City() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTickets1() {
		return this.tickets1;
	}

	public void setTickets1(List<Ticket> tickets1) {
		this.tickets1 = tickets1;
	}

	public Ticket addTickets1(Ticket tickets1) {
		getTickets1().add(tickets1);
		tickets1.setCity1(this);

		return tickets1;
	}

	public Ticket removeTickets1(Ticket tickets1) {
		getTickets1().remove(tickets1);
		tickets1.setCity1(null);

		return tickets1;
	}

	public List<Ticket> getTickets2() {
		return this.tickets2;
	}

	public void setTickets2(List<Ticket> tickets2) {
		this.tickets2 = tickets2;
	}

	public Ticket addTickets2(Ticket tickets2) {
		getTickets2().add(tickets2);
		tickets2.setCity2(this);

		return tickets2;
	}

	public Ticket removeTickets2(Ticket tickets2) {
		getTickets2().remove(tickets2);
		tickets2.setCity2(null);

		return tickets2;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setCityBean(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setCityBean(null);

		return hotel;
	}

	public List<Scenic> getScenics() {
		return this.scenics;
	}

	public void setScenics(List<Scenic> scenics) {
		this.scenics = scenics;
	}

	public Scenic addScenic(Scenic scenic) {
		getScenics().add(scenic);
		scenic.setCityBean(this);

		return scenic;
	}

	public Scenic removeScenic(Scenic scenic) {
		getScenics().remove(scenic);
		scenic.setCityBean(null);

		return scenic;
	}

	public List<Line> getLines1() {
		return this.lines1;
	}

	public void setLines1(List<Line> lines1) {
		this.lines1 = lines1;
	}

	public Line addLines1(Line lines1) {
		getLines1().add(lines1);
		lines1.setCity1(this);

		return lines1;
	}

	public Line removeLines1(Line lines1) {
		getLines1().remove(lines1);
		lines1.setCity1(null);

		return lines1;
	}

	public List<Line> getLines2() {
		return this.lines2;
	}

	public void setLines2(List<Line> lines2) {
		this.lines2 = lines2;
	}

	public Line addLines2(Line lines2) {
		getLines2().add(lines2);
		lines2.setCity2(this);

		return lines2;
	}

	public Line removeLines2(Line lines2) {
		getLines2().remove(lines2);
		lines2.setCity2(null);

		return lines2;
	}

}
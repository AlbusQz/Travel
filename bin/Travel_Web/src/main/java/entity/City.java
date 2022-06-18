package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
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

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="city")
	private List<Hotel> hotels = new ArrayList<Hotel>();

	//bi-directional many-to-one association to Line
	@OneToMany(mappedBy="tcity")
	private List<Line> tlines=new ArrayList<Line>();

	//bi-directional one-to-one association to Line
	@OneToMany(mappedBy="rcity")
	private List<Line> rlines=new ArrayList<Line>();

	//bi-directional many-to-one association to Scenic
	@OneToMany(mappedBy="city")
	private List<Scenic> scenics = new ArrayList<Scenic>();

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="tcity")
	private List<Ticket> ttickets= new ArrayList<Ticket>();

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="rcity")
	private List<Ticket> rtickets = new ArrayList<Ticket>();

	public City() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setCity(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setCity(null);

		return hotel;
	}

	public List<Line> getTLines() {
		return this.tlines;
	}

	public void setTLines(List<Line> lines) {
		this.tlines = lines;
	}

	public Line addTLine(Line line) {
		getTLines().add(line);
		line.setTcity(this);

		return line;
	}

	public Line removeTLine(Line line) {
		getTLines().remove(line);
		line.setTcity(null);

		return line;
	}

	public List<Line> getRLines() {
		return this.rlines;
	}

	public void setRLines(List<Line> lines) {
		this.rlines = lines;
	}

	public Line addRLine(Line line) {
		getRLines().add(line);
		line.setRcity(this);

		return line;
	}

	public Line removeRLine(Line line) {
		getRLines().remove(line);
		line.setRcity(null);

		return line;
	}


	public List<Scenic> getScenics() {
		return this.scenics;
	}

	public void setScenics(List<Scenic> scenics) {
		this.scenics = scenics;
	}

	public Scenic addScenic(Scenic scenic) {
		getScenics().add(scenic);
		scenic.setCity(this);

		return scenic;
	}

	public Scenic removeScenic(Scenic scenic) {
		getScenics().remove(scenic);
		scenic.setCity(null);

		return scenic;
	}

	public List<Ticket> getTTickets() {
		return this.ttickets;
	}

	public void setTTickets(List<Ticket> tickets1) {
		this.ttickets = tickets1;
	}

	public Ticket addTTickets(Ticket tickets1) {
		getTTickets().add(tickets1);
		tickets1.setTcity(this);

		return tickets1;
	}

	public Ticket removeTickets1(Ticket tickets1) {
		getTTickets().remove(tickets1);
		tickets1.setTcity(null);

		return tickets1;
	}

	public List<Ticket> getRTickets() {
		return this.rtickets;
	}

	public void setRTickets(List<Ticket> tickets2) {
		this.rtickets = tickets2;
	}

	public Ticket addRTickets(Ticket tickets2) {
		getRTickets().add(tickets2);
		tickets2.setRcity(this);

		return tickets2;
	}

	public Ticket removeRTickets(Ticket tickets2) {
		getRTickets().remove(tickets2);
		tickets2.setRcity(null);

		return tickets2;
	}

}
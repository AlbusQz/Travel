package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SCENIC database table.
 * 
 */
@Embeddable
public class ScenicPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(insertable=false, updatable=false)
	private String city;

	public ScenicPK() {
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ScenicPK)) {
			return false;
		}
		ScenicPK castOther = (ScenicPK)other;
		return 
			this.name.equals(castOther.name)
			&& this.city.equals(castOther.city);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.name.hashCode();
		hash = hash * prime + this.city.hashCode();
		
		return hash;
	}
}
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ROOM database table.
 * 
 */
@Embeddable
public class RoomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"TYPE\"")
	private String type;

	@Column(name="H_ID", insertable=false, updatable=false)
	private long hId;

	public RoomPK() {
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getHId() {
		return this.hId;
	}
	public void setHId(long hId) {
		this.hId = hId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoomPK)) {
			return false;
		}
		RoomPK castOther = (RoomPK)other;
		return 
			this.type.equals(castOther.type)
			&& (this.hId == castOther.hId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.type.hashCode();
		hash = hash * prime + ((int) (this.hId ^ (this.hId >>> 32)));
		
		return hash;
	}
}
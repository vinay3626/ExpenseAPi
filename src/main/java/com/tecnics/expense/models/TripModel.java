package com.tecnics.expense.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tecnics.expense.utils.status;

@Entity
@Table(name = "trip_table")
public class TripModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tripId;
	
	private String tripName;
	
	private Date fromDate;

	private Date toDate;
				
	private String fromLocation;
	
	private String toLocation;
	
	private String description;

	private status status;

	private boolean IsActionTaken;

	private String rejectReason;	

	private String rejectDescription;
	
	private Timestamp created;

	private Timestamp updated;

	public TripModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TripModel(long tripId, String tripName, 
	Date fromDate, Date toDate, String fromLocation, String toLocation,String rejectReason,String rejectDescription,
			String description, boolean IsActionTaken,  status status, Timestamp created, Timestamp updated) {
		super();
		this.tripId = tripId;
		this.tripName = tripName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.description = description;
		this.IsActionTaken = IsActionTaken;
		this.rejectReason = rejectReason;
		this.rejectDescription = rejectDescription;
		this.status = status;
		this.created = created;
		this.updated = updated;
	}



	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public status getStatus() {
		return status;
	}

	public void setStatus(status status) {
		this.status = status;
	}

	public boolean isIsActionTaken() {
		return IsActionTaken;
	}

	public void setIsActionTaken(boolean isActionTaken) {
		IsActionTaken = isActionTaken;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}



	public String getRejectDescription() {
		return rejectDescription;
	}



	public void setRejectDescription(String rejectDescription) {
		this.rejectDescription = rejectDescription;
	}
	
	
	
	
	

}

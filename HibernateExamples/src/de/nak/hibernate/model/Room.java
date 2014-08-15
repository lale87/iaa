package de.nak.hibernate.model;

public class Room {
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}
	private String building;
	private Integer roomNumber;
	private Integer seats;
	private Boolean beamerPresent;
	
	
	public Long getId() {
		return id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public Integer getRoomnumber() {
		return roomNumber;
	}
	public void setRoomnumber(Integer roomnumber) {
		this.roomNumber = roomnumber;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public Boolean getBeamerPresent() {
		return beamerPresent;
	}
	public void setBeamerPresent(Boolean beamerPresent) {
		this.beamerPresent = beamerPresent;
	}
	
	
}

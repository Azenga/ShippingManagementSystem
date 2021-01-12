package shipment;

import java.time.LocalDateTime;

public class Shipment {

	enum Size {
		Small, Large
	}

	enum Delivery {
		Standard, Express
	}

	enum Distance {
		Overseas, Domestic
	}

	enum Status {
		Unconfirmed, Confirmed, Delivered, Archived
	}

	private long idNumber;
	private boolean orderSaved;
	private double price;
	private String summary;
	private Status status;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	private LocalDateTime expectedDeliveryTime;
	private double weight;
	private Size size;
	private Distance distance;
	private static long shipmentCount = 0;

	public Shipment() {
		assignId();
	}

	public Shipment(String summary, double weight, Size size, Distance distance) {
		super();
		this.summary = summary;
		this.weight = weight;
		this.size = size;
		this.distance = distance;
		this.orderSaved = false;
		this.status = Status.Unconfirmed;
		this.assignId();
	}

	public void assignId() {

		shipmentCount++;

		idNumber = shipmentCount;

	}

	public void saveOrder() {
		this.orderSaved = true;
	}

	public void updateStatus(Status status) {
		this.status = status;
	}

	public long getIdNumber() {
		return this.idNumber;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}

	public void setExpectedDeliveryTime(LocalDateTime expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}

	public boolean isOrderSaved() {
		return orderSaved;
	}

}

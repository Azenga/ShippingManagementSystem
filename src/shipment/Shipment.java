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

	public Shipment() {
	}

	public Shipment(String summary, double weight, Size size, Distance distance) {
		super();
		this.summary = summary;
		this.weight = weight;
		this.size = size;
		this.distance = distance;
		this.orderSaved = false;

		this.assignId();
	}

	public void assignId() {

	}

	public void saveOrder() {

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

}

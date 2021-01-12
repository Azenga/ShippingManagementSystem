package shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import shipment.Shipment.Distance;
import shipment.Shipment.Size;

public class ShipmentHistory {

	public static List<Shipment> shipments = new ArrayList<>();

	public boolean addItem(String summary, double weight, Size size, Distance distance) {

		return ShipmentHistory.shipments.add(new Shipment(summary, weight, size, distance));

	}

	public boolean removeItem(Shipment shipment) {

		Optional<Shipment> maybeShipment = shipments.parallelStream()
				.filter(s -> s.getIdNumber() == shipment.getIdNumber()).findFirst();

		if (maybeShipment.isPresent()) {
			ShipmentHistory.shipments.remove(maybeShipment.get());
			return true;
		}

		return false;
	}

	public Optional<Shipment> retrieveItem(long idNumber) {

		return ShipmentHistory.shipments.stream().filter(s -> s.getIdNumber() == idNumber).findFirst();

	}

	public void updateItem(Shipment shipment, long idNumber) {

		Optional<Shipment> maybeShipment = ShipmentHistory.shipments.stream().filter(s -> s.getIdNumber() == idNumber)
				.findFirst();

		if (maybeShipment.isPresent()) {
			Shipment oldShipment = maybeShipment.get();

			oldShipment.setArrivalTime(shipment.getArrivalTime());
			oldShipment.setDepartureTime(shipment.getDepartureTime());
			oldShipment.setSize(shipment.getSize());
			oldShipment.setSummary(shipment.getSummary());
			oldShipment.setDistance(shipment.getDistance());
			oldShipment.setWeight(shipment.getWeight());
			oldShipment.setStatus(shipment.getStatus());
			oldShipment.setExpectedDeliveryTime(shipment.getExpectedDeliveryTime());
		}
	}
}

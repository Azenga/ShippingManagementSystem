package shipment;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class ShipmentHistoryTest {

	@Test
	void testAddItem() {

		ShipmentHistory shipmentHistory = new ShipmentHistory();

		shipmentHistory.addItem("Test Summary", 20.25, Shipment.Size.Small, Shipment.Distance.Domestic);

		assertEquals(1, ShipmentHistory.shipments.size());
	}

	@Test
	void testRemoveItem() {

		ShipmentHistory shipmentHistory = new ShipmentHistory();

		shipmentHistory.addItem("Test Summary", 20.25, Shipment.Size.Small, Shipment.Distance.Domestic);

		shipmentHistory.addItem("Test Summary Again", 10.75, Shipment.Size.Large, Shipment.Distance.Overseas);

		assertEquals(3, ShipmentHistory.shipments.size());

		shipmentHistory.removeItem(ShipmentHistory.shipments.get(0));

		assertEquals(2, ShipmentHistory.shipments.size());

	}

	@Test
	void testRetrieveItem() {

		ShipmentHistory shipmentHistory = new ShipmentHistory();

		shipmentHistory.addItem("Test Summary", 20.25, Shipment.Size.Small, Shipment.Distance.Domestic);

		Optional<Shipment> shipment = shipmentHistory.retrieveItem(3);

		assertTrue(shipment.isPresent());
	}

	@Test
	void testUpdateItem() {

		Shipment shipment = new Shipment("Updated Test Summary", 10.75, Shipment.Size.Large,
				Shipment.Distance.Overseas);

		ShipmentHistory shipmentHistory = new ShipmentHistory();

		shipmentHistory.updateItem(shipment, 1);

		Shipment updateShipment = ShipmentHistory.shipments.get(0);

		assertEquals("Updated Test Summary", updateShipment.getSummary());
		assertEquals(10.75, updateShipment.getWeight());
		assertEquals(Shipment.Size.Large, updateShipment.getSize());
		assertEquals(Shipment.Distance.Overseas, updateShipment.getDistance());

	}

}

package shipment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipmentTest {

	@Test
	void testConstructor() {
		Shipment shipment = new Shipment("Test Summary", 20.25, Shipment.Size.Small, Shipment.Distance.Domestic);

		assertEquals("Test Summary", shipment.getSummary());
		assertEquals(20.25, shipment.getWeight());
		assertEquals(Shipment.Size.Small, shipment.getSize());
		assertEquals(Shipment.Distance.Domestic, shipment.getDistance());
	}

	@Test
	void testUpdateStatus() {
		Shipment shipment = new Shipment("Test Summary", 20.25, Shipment.Size.Small, Shipment.Distance.Domestic);

		assertFalse(shipment.isOrderSaved());

		shipment.saveOrder();

		assertTrue(shipment.isOrderSaved());

	}

}

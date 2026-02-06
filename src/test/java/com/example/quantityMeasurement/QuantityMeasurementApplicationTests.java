package com.example.quantityMeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class QuantityMeasurementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getDoubleValue_Valid(){
		String value = "134";
		assertEquals(134.0,
				QuantityMeasurementApplication.getDoubleValue(value));
	}

	@Test
	public void getDoubleValue_InValid(){
		String value = "Hello";
		Throwable exception = assertThrows(NumberFormatException.class, () -> {
			QuantityMeasurementApplication.getDoubleValue(value);
		});
		assertEquals("Please enter valid numeric value.", exception.getMessage());
	}

	@Test
	public void testFeetEquality_SameValue(){
		QuantityMeasurementApplication.Feet feet1 = new QuantityMeasurementApplication.Feet(1.1);
		QuantityMeasurementApplication.Feet feet2 = new QuantityMeasurementApplication.Feet(1.1);
        Assertions.assertTrue(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_SameObject(){
		QuantityMeasurementApplication.Feet feet1 = new QuantityMeasurementApplication.Feet(1.1);
		Assertions.assertTrue(feet1.equals(feet1));
	}

	@Test
	public void testFeetEquality_DiffValue(){
		QuantityMeasurementApplication.Feet feet1 = new QuantityMeasurementApplication.Feet(0.55);
		QuantityMeasurementApplication.Feet feet2 = new QuantityMeasurementApplication.Feet(1.1);
		Assertions.assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_NullValue(){
		QuantityMeasurementApplication.Feet feet1 = new QuantityMeasurementApplication.Feet(0.55);
		QuantityMeasurementApplication.Feet feet2 = null;
		Assertions.assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_DiffObjectClassValue(){
		QuantityMeasurementApplication.Feet feet1 = new QuantityMeasurementApplication.Feet(0.55);
		Object o = new Object();
		Assertions.assertFalse(feet1.equals(o));
	}

}

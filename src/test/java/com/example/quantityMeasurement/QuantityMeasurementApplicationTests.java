package com.example.quantityMeasurement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuantityMeasurementApplicationTests {

	private final PrintStream originalOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() {
		// Redirect System.out to the custom output stream captor
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		// Restore the original System.out after the test completes
		System.setOut(originalOut);
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

	@Test
	public void testInchesEquality_SameValue(){
		QuantityMeasurementApplication.Inches inches1 = new QuantityMeasurementApplication.Inches(8.6);
		QuantityMeasurementApplication.Inches inches2 = new QuantityMeasurementApplication.Inches(8.6);
		Assertions.assertTrue(inches1.equals(inches2));
	}

	@Test
	public void testInchesEquality_SameObject(){
		QuantityMeasurementApplication.Inches inches = new QuantityMeasurementApplication.Inches(1.89);
		Assertions.assertTrue(inches.equals(inches));
	}

	@Test
	public void testInchesEquality_DiffValue(){
		QuantityMeasurementApplication.Inches inches1 = new QuantityMeasurementApplication.Inches(5.55);
		QuantityMeasurementApplication.Inches inches2 = new QuantityMeasurementApplication.Inches(2.8);
		Assertions.assertFalse(inches1.equals(inches2));
	}

	@Test
	public void testInchesEquality_NullValue(){
		QuantityMeasurementApplication.Inches inches1 = new QuantityMeasurementApplication.Inches(11);
		QuantityMeasurementApplication.Inches inches2 = null;
		Assertions.assertFalse(inches1.equals(inches2));
	}

	@Test
	public void testInchesEquality_DiffObjectClassValue(){
		QuantityMeasurementApplication.Inches inches = new QuantityMeasurementApplication.Inches(1.76);
		Object o = new Object();
		Assertions.assertFalse(inches.equals(o));
	}

	@Test
	public void testDemonstrateFeetEquality() {
		QuantityMeasurementApplication.Feet.demonstrateFeetEquality();
		String expectedOutput = """
                Result for feet1 and feet2: true
                Result for feet3 and feet4: false
                """;
		assertEquals(expectedOutput, outputStreamCaptor.toString());
	}

	@Test
	public void testDemonstrateInchesEquality() {
		QuantityMeasurementApplication.Inches.demonstrateInchesEquality();
		String expectedOutput = """
                Result for inc1 and inc2: true
                Result for inc3 and inc4: false
                """;
		assertEquals(expectedOutput, outputStreamCaptor.toString());
	}

}

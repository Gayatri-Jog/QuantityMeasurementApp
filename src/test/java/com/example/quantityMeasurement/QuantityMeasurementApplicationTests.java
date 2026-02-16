package com.example.quantityMeasurement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuantityMeasurementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testFeetEquality_same(){
		Length feet1 = new Length(1.25, Length.LengthUnit.FEET);
		Length feet2 = new Length(1.25, Length.LengthUnit.FEET);
		Assertions.assertTrue(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_diff(){
		Length feet1 = new Length(1.2, Length.LengthUnit.FEET);
		Length feet2 = new Length(0.5, Length.LengthUnit.FEET);
		Assertions.assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testInchesEquality_same(){
		Length feet1 = new Length(13, Length.LengthUnit.INCHES);
		Length feet2 = new Length(13, Length.LengthUnit.INCHES);
		Assertions.assertTrue(feet1.equals(feet2));
	}

	@Test
	public void testInchesEquality_diff(){
		Length feet1 = new Length(12, Length.LengthUnit.INCHES);
		Length feet2 = new Length(16, Length.LengthUnit.INCHES);
		Assertions.assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testInchesFeetComparison(){
		Length inches1 = new Length(12, Length.LengthUnit.INCHES);
		Length feet1 = new Length(1, Length.LengthUnit.FEET);
		Assertions.assertTrue(inches1.equals(feet1));
	}

	@Test
	public void testFeetInchesComparison(){
		Length feet1 = new Length(2, Length.LengthUnit.FEET);
		Length inches1 = new Length(24, Length.LengthUnit.INCHES);
		Assertions.assertTrue(feet1.equals(inches1));
	}

	@Test
	public void testFeetInchesComparisonInvalid(){
		Length feet1 = new Length(24, Length.LengthUnit.FEET);
		Length inches1 = new Length(24, Length.LengthUnit.INCHES);
		Assertions.assertFalse(feet1.equals(inches1));
	}

	@Test
	public void testInchesEquality_null(){
		Length feet1 = new Length(12, Length.LengthUnit.INCHES);
		Length feet2 = null;
		Assertions.assertFalse(feet1.equals(feet2));
	}

}

package com.example.quantityMeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class QuantityMeasurementApplication {

	public static class Feet{
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {

			if(this == o){
				return true;
			}
			if (o == null || getClass() != o.getClass()){
				return false;
			}
			Feet feet = (Feet) o;
			return Double.compare(this.value, feet.value) == 0;
		}
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(QuantityMeasurementApplication.class, args);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Feet value: ");
			String o1 = br.readLine();
			Feet f1 = new Feet(getDoubleValue(o1));
			System.out.print("Enter another Feet value: ");
			String o2 = br.readLine();
			Feet f2 = new Feet(getDoubleValue(o2));
			System.out.print("Result is :: " + f1.equals(f2) + "\n");
		} catch (Exception e) {
			System.err.println("Error :: "+e.getMessage());
		}
    }

	public static Double getDoubleValue(String o) {
		try{
			return Double.parseDouble(o);
		}catch (NumberFormatException e){
			throw new NumberFormatException("Please enter valid numeric value.");
		}
	}
}

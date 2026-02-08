package com.example.quantityMeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		public static void demonstrateFeetEquality(){
			Feet feet1 = new Feet(8.9);
			Feet feet2 = new Feet(8.9);
			Feet feet3 = new Feet(4.67);
			Feet feet4 = new Feet(7.0);
			System.out.print("Result for feet1 and feet2: "+feet1.equals(feet2)+"\n");
			System.out.print("Result for feet3 and feet4: "+feet3.equals(feet4)+"\n");
		}
	}

	public static class Inches {
		private final double value;

		public Inches(double value) {
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
			Inches feet = (Inches) o;
			return Double.compare(this.value, feet.value) == 0;
		}

		public static void demonstrateInchesEquality(){
			Inches inc1 = new Inches(11);
			Inches inc2 = new Inches(11);
			Inches inc3 = new Inches(0.5);
			Inches inc4 = new Inches(4.3);
			System.out.print("Result for inc1 and inc2: "+inc1.equals(inc2)+"\n");
			System.out.print("Result for inc3 and inc4: "+inc3.equals(inc4)+"\n");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(QuantityMeasurementApplication.class, args);
		Inches.demonstrateInchesEquality();
		Feet.demonstrateFeetEquality();
    }
}

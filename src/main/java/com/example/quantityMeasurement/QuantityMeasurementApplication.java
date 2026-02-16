package com.example.quantityMeasurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.quantityMeasurement.Length.*;

@SpringBootApplication
public class QuantityMeasurementApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuantityMeasurementApplication.class, args);
		demonstrateFeetEquality();
		demonstrateInchesEquality();
		demonstrateFeetInchesComparison();
    }
}

package com.example.quantityMeasurement;

public class Length {

    private final double value;
    private final LengthUnit lengthUnit;

    public enum LengthUnit{

        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit lengthUnit) {
        this.value = value;
        this.lengthUnit = lengthUnit;
    }

    private double convertToBaseUnit(LengthUnit lengthUnit, double value){
        if(lengthUnit.equals(LengthUnit.INCHES)) {
            return value / LengthUnit.FEET.getConversionFactor();
        }else{
            return value * LengthUnit.FEET.getConversionFactor();
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o==null || getClass() != o.getClass()){
            return false;
        }
        Length length = (Length) o;
        if(!length.lengthUnit.equals(lengthUnit)){
            return Double.compare(value, convertToBaseUnit(length.lengthUnit,
                    length.value))==0;
        }
        return Double.compare(value, length.value) == 0;
    }

    public static void demonstrateFeetEquality(){
        Length feet1 = new Length(1.2, LengthUnit.FEET);
        Length feet2 = new Length(1.2, Length.LengthUnit.FEET);
        System.out.print("Result for feet1 and feet2: "+feet1.equals(feet2)+"\n");

        Length feet3 = new Length(55, LengthUnit.FEET);
        Length feet4 = new Length(45.99, Length.LengthUnit.FEET);
        System.out.print("Result for feet3 and feet4: "+feet3.equals(feet4)+"\n");
    }

    public static void demonstrateInchesEquality(){
        Length inches1 = new Length(1.25, LengthUnit.INCHES);
        Length inches2 = new Length(1.25, Length.LengthUnit.INCHES);
        System.out.print("Result for inches1 and inches2: "+inches1.equals(inches2)+"\n");

        Length inches3 = new Length(34, LengthUnit.INCHES);
        Length inches4 = new Length(76.98, Length.LengthUnit.INCHES);
        System.out.print("Result for inches3 and inches4: "+inches3.equals(inches4)+"\n");
    }

    public static void demonstrateFeetInchesComparison(){
        Length length1 = new Length(12, LengthUnit.INCHES);
        Length length2 = new Length(1, LengthUnit.FEET);
        printData(length1,length2);

        Length length3 = new Length(2, LengthUnit.FEET);
        Length length4 = new Length(24, LengthUnit.INCHES);
        printData(length3,length4);

        Length length5 = new Length(13, LengthUnit.INCHES);
        Length length6 = new Length(13, LengthUnit.FEET);
        printData(length5,length6);
    }

    private static void printData(Length length1, Length length2){
        System.out.print("Result for "+length1.value+" "+length1.lengthUnit+
                " = "+length2.value+" "+length2.lengthUnit +" : "
                +length1.equals(length2)+"\n");
    }
}

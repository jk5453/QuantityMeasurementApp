package com.apps.quantitymeasurement;

public class MeasurementApp {


    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }


    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }


        public Length add(Length other) {
            return add(other, this.unit);
        }


        public Length add(Length other, LengthUnit targetUnit) {
            if (other == null)
                throw new IllegalArgumentException("Other length cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
                throw new IllegalArgumentException("Invalid numeric value");


            double thisInFeet = this.unit.toFeet(this.value);
            double otherInFeet = other.unit.toFeet(other.value);


            double sumInFeet = thisInFeet + otherInFeet;


            double result = targetUnit.fromFeet(sumInFeet);

            return new Length(round(result), targetUnit);
        }


        private double round(double value) {
            return Math.round(value * 100.0) / 100.0;
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }


    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println(l1.add(l2, LengthUnit.FEET));
        System.out.println(l1.add(l2, LengthUnit.INCHES));
        System.out.println(l1.add(l2, LengthUnit.YARDS));

        Length l3 = new Length(1.0, LengthUnit.YARDS);
        Length l4 = new Length(3.0, LengthUnit.FEET);

        System.out.println(l3.add(l4, LengthUnit.YARDS));

        Length l5 = new Length(36.0, LengthUnit.INCHES);
        Length l6 = new Length(1.0, LengthUnit.YARDS);

        System.out.println(l5.add(l6, LengthUnit.FEET));
    }
}
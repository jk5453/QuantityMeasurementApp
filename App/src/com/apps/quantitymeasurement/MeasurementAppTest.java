package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    @Test
    public void testAddition_TargetUnit_Feet() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(1.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(12.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        com.apps.quantitymeasurement.MeasurementApp.Length result =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_TargetUnit_Inches() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(1.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(12.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        com.apps.quantitymeasurement.MeasurementApp.Length result =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_TargetUnit_Yards() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(1.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(12.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        com.apps.quantitymeasurement.MeasurementApp.Length result =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.YARDS);

        assertEquals(0.67, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_Commutative() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(1.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(12.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        com.apps.quantitymeasurement.MeasurementApp.Length r1 =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.YARDS);

        com.apps.quantitymeasurement.MeasurementApp.Length r2 =
                l2.add(l1, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), 0.01);
    }

    @Test
    public void testAddition_NullTargetUnit() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(1.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(12.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(l2, null);
        });
    }

    @Test
    public void testAddition_WithZero() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(5.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(0.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        com.apps.quantitymeasurement.MeasurementApp.Length result =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.YARDS);

        assertEquals(1.67, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_NegativeValues() {
        com.apps.quantitymeasurement.MeasurementApp.Length l1 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(5.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length l2 =
                new com.apps.quantitymeasurement.MeasurementApp.Length(-2.0, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.FEET);

        com.apps.quantitymeasurement.MeasurementApp.Length result =
                l1.add(l2, com.apps.quantitymeasurement.MeasurementApp.LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), 0.01);
    }
}
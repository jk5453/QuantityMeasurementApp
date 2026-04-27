import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    MeasurementApp.Length.LengthUnit FEET = MeasurementApp.Length.LengthUnit.FEET;
    MeasurementApp.Length.LengthUnit INCHES = MeasurementApp.Length.LengthUnit.INCHES;

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertTrue(new MeasurementApp.Length(1.0, FEET)
                .equals(new MeasurementApp.Length(1.0, FEET)));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertTrue(new MeasurementApp.Length(1.0, INCHES)
                .equals(new MeasurementApp.Length(1.0, INCHES)));
    }

    @Test
    public void testEquality_FeetToInch_Equivalent() {
        assertTrue(new MeasurementApp.Length(1.0, FEET)
                .equals(new MeasurementApp.Length(12.0, INCHES)));
    }

    @Test
    public void testEquality_InchToFeet_Equivalent() {
        assertTrue(new MeasurementApp.Length(12.0, INCHES)
                .equals(new MeasurementApp.Length(1.0, FEET)));
    }

    @Test
    public void testEquality_FeetToFeet_Different() {
        assertFalse(new MeasurementApp.Length(1.0, FEET)
                .equals(new MeasurementApp.Length(2.0, FEET)));
    }

    @Test
    public void testEquality_InchToInch_Different() {
        assertFalse(new MeasurementApp.Length(1.0, INCHES)
                .equals(new MeasurementApp.Length(2.0, INCHES)));
    }

    @Test
    public void testNullComparison() {
        assertFalse(new MeasurementApp.Length(1.0, FEET).equals(null));
    }

    @Test
    public void testSameReference() {
        MeasurementApp.Length l = new MeasurementApp.Length(1.0, FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MeasurementApp.Length(1.0, null);
        });
    }
}
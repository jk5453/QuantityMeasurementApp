import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    MeasurementApp.Length.LengthUnit FEET = MeasurementApp.Length.LengthUnit.FEET;
    MeasurementApp.Length.LengthUnit INCHES = MeasurementApp.Length.LengthUnit.INCHES;
    MeasurementApp.Length.LengthUnit YARDS = MeasurementApp.Length.LengthUnit.YARDS;
    MeasurementApp.Length.LengthUnit CM = MeasurementApp.Length.LengthUnit.CENTIMETERS;

    @Test
    public void testYardToYard_SameValue() {
        assertTrue(new MeasurementApp.Length(1.0, YARDS)
                .equals(new MeasurementApp.Length(1.0, YARDS)));
    }

    @Test
    public void testYardToYard_DifferentValue() {
        assertFalse(new MeasurementApp.Length(1.0, YARDS)
                .equals(new MeasurementApp.Length(2.0, YARDS)));
    }

    @Test
    public void testYardToFeet_Equivalent() {
        assertTrue(new MeasurementApp.Length(1.0, YARDS)
                .equals(new MeasurementApp.Length(3.0, FEET)));
    }

    @Test
    public void testFeetToYard_Equivalent() {
        assertTrue(new MeasurementApp.Length(3.0, FEET)
                .equals(new MeasurementApp.Length(1.0, YARDS)));
    }

    @Test
    public void testYardToInches_Equivalent() {
        assertTrue(new MeasurementApp.Length(1.0, YARDS)
                .equals(new MeasurementApp.Length(36.0, INCHES)));
    }

    @Test
    public void testInchesToYard_Equivalent() {
        assertTrue(new MeasurementApp.Length(36.0, INCHES)
                .equals(new MeasurementApp.Length(1.0, YARDS)));
    }

    @Test
    public void testYardToFeet_NotEqual() {
        assertFalse(new MeasurementApp.Length(1.0, YARDS)
                .equals(new MeasurementApp.Length(2.0, FEET)));
    }

    @Test
    public void testCentimeterToInches_Equivalent() {
        assertTrue(new MeasurementApp.Length(1.0, CM)
                .equals(new MeasurementApp.Length(0.393701, INCHES)));
    }

    @Test
    public void testCentimeterToFeet_NotEqual() {
        assertFalse(new MeasurementApp.Length(1.0, CM)
                .equals(new MeasurementApp.Length(1.0, FEET)));
    }

    @Test
    public void testTransitiveProperty() {
        MeasurementApp.Length a = new MeasurementApp.Length(1.0, YARDS);
        MeasurementApp.Length b = new MeasurementApp.Length(3.0, FEET);
        MeasurementApp.Length c = new MeasurementApp.Length(36.0, INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
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
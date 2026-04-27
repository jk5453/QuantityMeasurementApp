import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    MeasurementApp.Length.LengthUnit FEET = MeasurementApp.Length.LengthUnit.FEET;
    MeasurementApp.Length.LengthUnit INCHES = MeasurementApp.Length.LengthUnit.INCHES;
    MeasurementApp.Length.LengthUnit YARDS = MeasurementApp.Length.LengthUnit.YARDS;
    MeasurementApp.Length.LengthUnit CM = MeasurementApp.Length.LengthUnit.CENTIMETERS;

    double EPS = 0.0001;

    @Test
    public void testFeetToInches() {
        assertEquals(12.0,
                MeasurementApp.Length.convert(1.0, FEET, INCHES),
                EPS);
    }

    @Test
    public void testInchesToFeet() {
        assertEquals(2.0,
                MeasurementApp.Length.convert(24.0, INCHES, FEET),
                EPS);
    }

    @Test
    public void testYardsToInches() {
        assertEquals(36.0,
                MeasurementApp.Length.convert(1.0, YARDS, INCHES),
                EPS);
    }

    @Test
    public void testInchesToYards() {
        assertEquals(2.0,
                MeasurementApp.Length.convert(72.0, INCHES, YARDS),
                EPS);
    }

    @Test
    public void testCentimeterToInches() {
        assertEquals(1.0,
                MeasurementApp.Length.convert(2.54, CM, INCHES),
                EPS);
    }

    @Test
    public void testFeetToYards() {
        assertEquals(2.0,
                MeasurementApp.Length.convert(6.0, FEET, YARDS),
                EPS);
    }

    @Test
    public void testZeroValue() {
        assertEquals(0.0,
                MeasurementApp.Length.convert(0.0, FEET, INCHES),
                EPS);
    }

    @Test
    public void testNegativeValue() {
        assertEquals(-12.0,
                MeasurementApp.Length.convert(-1.0, FEET, INCHES),
                EPS);
    }

    @Test
    public void testRoundTrip() {
        double v = 5.0;
        double result = MeasurementApp.Length.convert(
                MeasurementApp.Length.convert(v, FEET, INCHES),
                INCHES, FEET);

        assertEquals(v, result, EPS);
    }

    @Test
    public void testSameUnit() {
        assertEquals(5.0,
                MeasurementApp.Length.convert(5.0, FEET, FEET),
                EPS);
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            MeasurementApp.Length.convert(1.0, null, FEET);
        });
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            MeasurementApp.Length.convert(Double.NaN, FEET, INCHES);
        });
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        assertTrue(new MeasurementApp.Feet(1.0)
                .equals(new MeasurementApp.Feet(1.0)));
    }

    @Test
    public void testEquality_DifferentValue() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals(new MeasurementApp.Feet(2.0)));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals(null));
    }

    @Test
    public void testEquality_DifferentClass() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals("1.0"));
    }

    @Test
    public void testEquality_SameReference() {
        MeasurementApp.Feet f = new MeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }
}
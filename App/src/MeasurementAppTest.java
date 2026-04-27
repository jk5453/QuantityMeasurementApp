import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(new MeasurementApp.Feet(1.0)
                .equals(new MeasurementApp.Feet(1.0)));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals(new MeasurementApp.Feet(2.0)));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        assertFalse(new MeasurementApp.Feet(1.0)
                .equals(new MeasurementApp.Inches(1.0)));
    }

    @Test
    public void testFeetEquality_SameReference() {
        MeasurementApp.Feet f = new MeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    public void testInchesEquality_SameValue() {
        assertTrue(new MeasurementApp.Inches(1.0)
                .equals(new MeasurementApp.Inches(1.0)));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertFalse(new MeasurementApp.Inches(1.0)
                .equals(new MeasurementApp.Inches(2.0)));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        assertFalse(new MeasurementApp.Inches(1.0)
                .equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        assertFalse(new MeasurementApp.Inches(1.0)
                .equals(new MeasurementApp.Feet(1.0)));
    }

    @Test
    public void testInchesEquality_SameReference() {
        MeasurementApp.Inches i = new MeasurementApp.Inches(1.0);
        assertTrue(i.equals(i));
    }
}
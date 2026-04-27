public class MeasurementApp {

    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0);

            private final double factor;

            LengthUnit(double factor) {
                this.factor = factor;
            }

            public double getFactor() {
                return factor;
            }
        }

        public Length(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return value * unit.getFactor();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Length other = (Length) obj;
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }
    }

    public static boolean compare(double v1, Length.LengthUnit u1,
                                  double v2, Length.LengthUnit u2) {
        return new Length(v1, u1).equals(new Length(v2, u2));
    }

    public static void main(String[] args) {

        System.out.println(compare(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES));

        System.out.println(compare(1.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.FEET));

        System.out.println(compare(1.0, Length.LengthUnit.INCHES,
                2.0, Length.LengthUnit.INCHES));
    }
}
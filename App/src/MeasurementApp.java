public class MeasurementApp {

    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

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
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return value * unit.getFactor();
        }


        public static double convert(double value, LengthUnit from, LengthUnit to) {
            if (from == null || to == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }

            double base = value * from.getFactor();
            return base / to.getFactor();
        }

        // ✅ Instance conversion (returns new object)
        public Length convertTo(LengthUnit target) {
            double result = convert(this.value, this.unit, target);
            return new Length(result, target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        System.out.println(Length.convert(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES));

        System.out.println(Length.convert(3.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET));

        System.out.println(new Length(2.0,
                Length.LengthUnit.YARDS)
                .convertTo(Length.LengthUnit.INCHES));
    }
}
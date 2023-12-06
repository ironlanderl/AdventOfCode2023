package Day5;

import java.math.BigInteger;

public class RangeConverter {
    private BigInteger destination;
    private BigInteger source;
    private BigInteger lenght;

    public RangeConverter(BigInteger destination, BigInteger source, BigInteger lenght) {
        this.destination = destination;
        this.source = source;
        this.lenght = lenght;
    }

    public BigInteger getDifference() {
        return source.subtract(destination).abs();
    }

    @Override
    public String toString() {
        return "Day5.RangeConverter{" +
                "destination=" + destination +
                ", source=" + source +
                ", lenght=" + lenght +
                '}';
    }

    public BigInteger convert(BigInteger value) {
        /* Check if outside range, keep original value */
        if (value.compareTo(source) < 0 || value.compareTo(source.add(lenght.subtract(BigInteger.ONE))) > 0) {
            return value;
        } else {
            /* Inside range, return value + difference */
            return value.add(getDifference());
        }
    }
}

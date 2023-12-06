package Day5;

import java.math.BigInteger;
import java.util.ArrayList;

public class Converter {
    private ArrayList<RangeConverter> converters = new ArrayList<>();

    public void addConverter(RangeConverter converter) {
        converters.add(converter);
    }

    @Override
    public String toString() {
        return "Day5.Converter{" +
                "converters=" + converters +
                '}';
    }

    public BigInteger convert(BigInteger value) {
        BigInteger original = value;
        for (RangeConverter converter : converters) {
            value = converter.convert(value);
            /* Controllo, se valore cambiato posso ritornare prima che si effettui un cambiamento involuto */
            if (value.compareTo(original) != 0) {
                return value;
            }
        }
        /* Nessun cambiamento, ritorno valore originale */
        return original;
    }
}

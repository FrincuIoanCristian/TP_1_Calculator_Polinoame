package Model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Monom {
    private final int putere;
    private double coeficient;

    public Monom(int putere, double coeficient) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public String toString() {
        String result = "";
        DecimalFormatSymbols simbol = new DecimalFormatSymbols(Locale.getDefault());
        simbol.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("#.##", simbol);
        String coef = format.format(this.coeficient);
        if (this.putere == 0) {
            result += coef;
        } else {
            if (this.coeficient == 1) {
                result += "X";
            } else if (this.coeficient == -1) {
                result += "-X";
            } else {
                result += coef + "X";
            }
            if (this.putere != 1) {
                result += "^" + this.putere;
            }
        }
        return result;
    }
}

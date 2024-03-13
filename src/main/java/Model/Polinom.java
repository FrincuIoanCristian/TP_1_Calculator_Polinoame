package Model;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private TreeMap<Integer, Monom> polinom;

    public Polinom() {
        this.polinom = new TreeMap<>(Comparator.reverseOrder());
    }

    public Polinom(String string) {
        if (string.equals("")) {
            this.polinom = null;
        } else {
            this.polinom = new TreeMap<>(Comparator.reverseOrder());
            Pattern pattern = Pattern.compile("[-+]?\\d*(\\.\\d+)?X\\^\\d+|[-+]?\\d*(\\.\\d+)?X|[+-]?\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(string);
            double coef;
            int exp;
            char c;
            StringBuilder verif = new StringBuilder();
            while (matcher.find()) {
                String monomial = matcher.group();
                if (monomial.matches("[-+]?\\d+(\\.\\d+)?")) {//termenul este o constanta
                    coef = Double.parseDouble(monomial);
                    exp = 0;
                } else if (monomial.matches("[-+]?X")) {//termenul este o singura variabila  fara coef
                    coef = Double.parseDouble(monomial.replace("X", "1"));
                    exp = 1;
                } else if (monomial.matches("[+-]?\\X\\^\\d+")) { //termenul are coef 1/-1 si exp diferit de 1/0
                    c = monomial.charAt(0);
                    coef = (c == '-') ? -1 : 1;
                    String[] partitie = monomial.split("X\\^");
                    exp = Integer.parseInt(partitie[1]);
                } else if (monomial.matches("[-+]?\\d*(\\.\\d+)?X")) {//termenul are coef !=1 si exp = 1
                    String partitie = monomial.replace("X", "");
                    coef = Double.parseDouble(partitie);
                    exp = 1;
                } else {//termenul este o variabila cu exponent
                    String[] partitie = monomial.split("X\\^");
                    coef = Double.parseDouble(partitie[0]);
                    exp = Integer.parseInt(partitie[1]);
                }
                Monom m = new Monom(exp, coef);
                if (!verif.toString().equals("") && m.getCoeficient() > 0) {
                    verif.append("+");
                }
                verif.append(m);
                if (this.polinom.get(m.getPutere()) != null) {
                    this.polinom.get(m.getPutere()).setCoeficient(this.polinom.get(m.getPutere()).getCoeficient() + m.getCoeficient());
                } else {
                    adauga(m);
                }
            }
            if (!verif.toString().equals(string)) {
                this.polinom = null;
            }
        }
    }

    public Map<Integer, Monom> getPolinom() {
        return polinom;
    }

    public void adauga(Monom m) {
        polinom.put(m.getPutere(), m);
    }

    public int gradPolinom() {
        int grad = 0;
        for (Map.Entry<Integer, Monom> entry : polinom.entrySet()) {
            if (entry.getValue().getCoeficient() != 0) {
                grad = entry.getKey();
                break;
            }
        }
        return grad;
    }

    public Monom primulMonom() {
        Monom m = new Monom(0, 0);
        for (Map.Entry<Integer, Monom> entry : polinom.entrySet()) {
            if (entry.getValue().getCoeficient() != 0) {
                m = entry.getValue();
                break;
            }
        }
        return m;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (polinom == null) {
            return null;
        }
        for (Map.Entry<Integer, Monom> entry : polinom.entrySet()) {
            if (entry.getValue().getCoeficient() > 0 && !result.toString().equals("")) {
                result.append("+");
            }
            result.append(entry.getValue().toString());
        }
        if (result.toString().equals("")) {
            result.append(0);
        }
        return result.toString();
    }
}

package Controller;

import Model.Monom;
import Model.Polinom;

import java.util.Map;

public class Operatie {
    public Polinom adunare(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : p1.getPolinom().entrySet()) {
            Monom m = pol1.getValue();
            for (Map.Entry<Integer, Monom> pol2 : p2.getPolinom().entrySet()) {
                if (pol1.getKey().equals(pol2.getKey())) {
                    m.setCoeficient(m.getCoeficient() + pol2.getValue().getCoeficient());
                    break;
                }
            }
            if (m.getCoeficient() != 0) {
                result.adauga(m);
            }
        }
        for (Map.Entry<Integer, Monom> t : p2.getPolinom().entrySet()) {
            if (p1.getPolinom().get(t.getKey()) == null && t.getValue().getCoeficient() != 0) {
                result.adauga(t.getValue());
            }
        }
        return result;
    }

    public Polinom scadere(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : p1.getPolinom().entrySet()) {
            Monom m = new Monom(pol1.getValue().getPutere(), pol1.getValue().getCoeficient());
            for (Map.Entry<Integer, Monom> pol2 : p2.getPolinom().entrySet()) {
                if (pol1.getKey().equals(pol2.getKey())) {
                    m.setCoeficient(m.getCoeficient() - pol2.getValue().getCoeficient());
                }
            }
            if (m.getCoeficient() != 0) {
                result.adauga(m);
            }
        }
        for (Map.Entry<Integer, Monom> t : p2.getPolinom().entrySet()) {
            if (p1.getPolinom().get(t.getKey()) == null && t.getValue().getCoeficient() != 0) {
                Monom m = new Monom(t.getValue().getPutere(), -t.getValue().getCoeficient());
                result.adauga(m);
            }
        }
        return result;
    }

    public Polinom inmultire(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : p1.getPolinom().entrySet()) {
            for (Map.Entry<Integer, Monom> pol2 : p2.getPolinom().entrySet()) {
                Monom m = new Monom(pol1.getKey() + pol2.getKey(), pol1.getValue().getCoeficient() * pol2.getValue().getCoeficient());
                if (result.getPolinom().get(m.getPutere()) == null) {
                    if (m.getCoeficient() != 0) {
                        result.adauga(m);
                    }
                } else {
                    result.getPolinom().get(m.getPutere()).setCoeficient(result.getPolinom().get(m.getPutere()).getCoeficient() + m.getCoeficient());
                    if (result.getPolinom().get(m.getPutere()).getCoeficient() == 0) {
                        result.getPolinom().remove(m.getPutere());
                    }
                }
            }
        }
        return result;
    }

    public Polinom derivare(Polinom p) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : p.getPolinom().entrySet()) {
            Monom m = new Monom(pol1.getKey() - 1, pol1.getValue().getCoeficient() * pol1.getKey());
            if (m.getCoeficient() != 0) {
                result.adauga(m);
            }
        }
        return result;
    }

    public Polinom integrare(Polinom p) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : p.getPolinom().entrySet()) {
            Monom m = new Monom(pol1.getKey() + 1, pol1.getValue().getCoeficient() / (pol1.getKey() + 1));
            if (m.getCoeficient() != 0) {
                result.adauga(m);
            }
        }
        return result;
    }

    public Polinom inmultireCuMonom(Polinom polinom, Monom monom) {
        Polinom result = new Polinom();
        for (Map.Entry<Integer, Monom> pol1 : polinom.getPolinom().entrySet()) {
            result.adauga(new Monom(pol1.getValue().getPutere() + monom.getPutere(), pol1.getValue().getCoeficient() * monom.getCoeficient()));
        }

        for (Monom m : polinom.getPolinom().values())
        return result;
        return result;
    }

    public Polinom[] impartire(Polinom P, Polinom Q) {
        Polinom[] result = new Polinom[2];
        result[0] = new Polinom();
        result[1] = new Polinom();
        if (Q.primulMonom().getCoeficient() == 0) {
            return null;
        }
        if (P.gradPolinom() == 0 && Q.gradPolinom() == 0) {
            result[0].adauga(new Monom(0, P.primulMonom().getCoeficient() / Q.primulMonom().getCoeficient()));
        } else {
            while (Q.gradPolinom() <= P.gradPolinom() && (P.gradPolinom() != 0 || P.primulMonom().getCoeficient() != 0)) {
                Monom prim = P.primulMonom();
                Monom m = new Monom(prim.getPutere() - Q.primulMonom().getPutere(), prim.getCoeficient() / Q.primulMonom().getCoeficient());
                result[0].adauga(m);
                Polinom polinom = inmultireCuMonom(Q, m);
                P = scadere(P, polinom);
            }
            result[1] = P;
        }
        return result;
    }
}

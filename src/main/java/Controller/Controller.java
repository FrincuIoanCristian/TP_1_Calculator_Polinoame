package Controller;

import View.CalculatorView;
import Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final CalculatorView calculatorView;

    public Controller(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        this.calculatorView.adunare(new OperatieListener(TipOperatii.ADUNARE));
        this.calculatorView.scadere(new OperatieListener(TipOperatii.SCADERE));
        this.calculatorView.inmultire(new OperatieListener(TipOperatii.INMULTIRE));
        this.calculatorView.impartire(new OperatieListener(TipOperatii.IMPARTIRE));
        this.calculatorView.derivare(new DerivareIntegrareListener(TipOperatii.DERIVARE));
        this.calculatorView.integrare(new DerivareIntegrareListener(TipOperatii.INTEGRARE));
    }

    class OperatieListener implements ActionListener {
        private final TipOperatii op;

        public OperatieListener(TipOperatii o) {
            this.op = o;
        }

        Operatie operatie = new Operatie();

        public void actionPerformed(ActionEvent e) {
            Polinom polinom1 = new Polinom(calculatorView.getPolinom1());
            Polinom polinom2 = new Polinom(calculatorView.getPolinom2());
            Polinom result = new Polinom();
            Polinom[] imp = new Polinom[2];
            if (polinom1.getPolinom() != null && polinom2.getPolinom() != null) {
                switch (this.op) {
                    case ADUNARE -> result = operatie.adunare(polinom1, polinom2);
                    case SCADERE -> result = operatie.scadere(polinom1, polinom2);
                    case INMULTIRE -> result = operatie.inmultire(polinom1, polinom2);
                    case DERIVARE -> result = operatie.derivare(polinom1);
                    case INTEGRARE -> result = operatie.integrare(polinom1);
                    case IMPARTIRE -> {
                        if (polinom2.primulMonom().getCoeficient() == 0) {
                            calculatorView.showNumberError("Nu se poate efectua impartirea la 0!");
                            imp = null;
                        } else {
                            imp = operatie.impartire(polinom1, polinom2);
                        }
                    }
                }
                if (this.op.equals(TipOperatii.IMPARTIRE)) {
                    if (imp != null) {
                        calculatorView.setRezultatTextField(imp[0].toString() + "; R:" + imp[1].toString());
                    }
                } else {
                    calculatorView.setRezultatTextField(result.toString());
                }
            } else {
                calculatorView.showNumberError("Date introduse gresit!");
            }
        }
    }

    class DerivareIntegrareListener implements ActionListener {
        private final TipOperatii op;

        public DerivareIntegrareListener(TipOperatii o) {
            this.op = o;
        }

        Operatie operatie = new Operatie();

        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom polinom;
            Polinom result;
            if (calculatorView.getCheckPolinom1() && calculatorView.getCheckPolinom2()) {
                calculatorView.showNumberError("Selectati un singur polinom pentru operatie!");
                return;
            } else if (calculatorView.getCheckPolinom1()) {
                polinom = new Polinom(calculatorView.getPolinom1());
            } else if (calculatorView.getCheckPolinom2()) {
                polinom = new Polinom(calculatorView.getPolinom2());
            } else {
                calculatorView.showNumberError("Niciun polinom selectat!");
                return;
            }
            if (polinom.getPolinom() != null) {
                switch (this.op) {
                    case DERIVARE -> {
                        result = operatie.derivare(polinom);
                        calculatorView.setRezultatTextField(result.toString());
                    }
                    case INTEGRARE -> {
                        result = operatie.integrare(polinom);
                        if (result.toString().equals("0")) {
                            calculatorView.setRezultatTextField("C");
                        } else {
                            calculatorView.setRezultatTextField(result + "+C");
                        }
                    }
                }
            } else {
                calculatorView.showNumberError("Date introduse gresit!");
            }
        }
    }
}

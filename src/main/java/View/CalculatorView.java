package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CalculatorView extends JFrame {
    //TextField
    private final JTextField polinom1TextField;
    private final JTextField polinom2TextField;
    private final JTextField rezultatTextField;

    private final JCheckBox polinom1CheckBox;
    private final JCheckBox polinom2CheckBox;

    //butoane
    private final JButton adunareButton;
    private final JButton scadereButton;
    private final JButton inmultireButton;
    private final JButton impartireButton;
    private final JButton derivareButton;
    private final JButton integrareButton;

    public CalculatorView() {
        Color color1 = new Color(155, 153, 205);
        Color color2 = Color.white;
        Color color3 = Color.white;
        Color color4 = Color.yellow;

        JPanel mainPanel = new GradientPanel(color1, color1);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel polinom1Label = new JLabel("Polinom 1 = ");
        polinom1Label.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel polinom2Label = new JLabel("Polinom 2 = ");
        polinom2Label.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel rezultatLabel = new JLabel("Rezultat = ");
        rezultatLabel.setFont(new Font("Serif", Font.BOLD, 20));
        //Label
        JLabel titluLabel = new JLabel("Calculator Polinoame");
        titluLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JPanel titlu = new GradientPanel(Color.red, Color.red);
        titlu.setLayout(new BoxLayout(titlu, BoxLayout.Y_AXIS));
        titlu.add(titluLabel);

        this.polinom1TextField = new JTextField("aX^3+bX^2+cX+d");
        this.polinom1TextField.setPreferredSize(new Dimension(300, 30));
        polinom1TextField.setFont(new Font("Times", Font.ITALIC, 15));
        polinom1TextField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (polinom1TextField.getText().equals("aX^3+bX^2+cX+d")) {
                    polinom1TextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (polinom1TextField.getText().equals("")) {
                    polinom1TextField.setText("aX^3+bX^2+cX+d");
                }
            }
        });
        this.polinom2TextField = new JTextField("aX^3+bX^2+cX+d");
        this.polinom2TextField.setPreferredSize(new Dimension(300, 30));
        polinom2TextField.setFont(new Font("Times", Font.ITALIC, 15));
        polinom2TextField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (polinom2TextField.getText().equals("aX^3+bX^2+cX+d")) {
                    polinom2TextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (polinom2TextField.getText().equals("")) {
                    polinom2TextField.setText("aX^3+bX^2+cX+d");
                }
            }
        });
        this.rezultatTextField = new JTextField();
        this.rezultatTextField.setPreferredSize(new Dimension(300, 30));
        rezultatTextField.setFont(new Font("Times", Font.ITALIC, 15));

        polinom1CheckBox = new JCheckBox();
        polinom1CheckBox.setBackground(null);
        polinom2CheckBox = new JCheckBox();
        polinom2CheckBox.setBackground(null);
        JPanel combo = new GradientPanel(color1, color2);
        combo.setLayout(null);
        polinom1Label.setBounds(30, 10, 150, 30);
        polinom1TextField.setBounds(200, 10, 300, 30);
        polinom1CheckBox.setBounds(510, 15, 20, 20);
        polinom2Label.setBounds(30, 50, 150, 30);
        polinom2TextField.setBounds(200, 50, 300, 30);
        polinom2CheckBox.setBounds(510, 55, 20, 20);
        rezultatLabel.setBounds(30, 90, 150, 30);
        rezultatTextField.setBounds(200, 90, 300, 30);

        combo.add(polinom1Label);
        combo.add(polinom1TextField);
        combo.add(polinom1CheckBox);
        combo.add(polinom2Label);
        combo.add(polinom2TextField);
        combo.add(polinom2CheckBox);
        combo.add(rezultatLabel);
        combo.add(rezultatTextField);

        adunareButton = new JGradientButton("Adunare", color3, color4);
        adunareButton.setFont(new Font("Serif", Font.BOLD, 20));
        scadereButton = new JGradientButton("Scadere", color3, color4);
        scadereButton.setFont(new Font("Serif", Font.BOLD, 20));
        inmultireButton = new JGradientButton("Inmultire", color3, color4);
        inmultireButton.setFont(new Font("Serif", Font.BOLD, 20));
        impartireButton = new JGradientButton("Impartire", color3, color4);
        impartireButton.setFont(new Font("Serif", Font.BOLD, 20));
        derivareButton = new JGradientButton("Derivare", color3, color4);
        derivareButton.setFont(new Font("Serif", Font.BOLD, 20));
        integrareButton = new JGradientButton("Integrare", color3, color4);
        integrareButton.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel butoane = new GradientPanel(color1, color2);
        butoane.setLayout(new GridLayout(0, 2));
        butoane.add(adunareButton);
        butoane.add(scadereButton);
        butoane.add(inmultireButton);
        butoane.add(impartireButton);
        butoane.add(derivareButton);
        butoane.add(integrareButton);

        mainPanel.add(titluLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(combo);
        mainPanel.add(butoane);

        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(550, 500);
        this.setTitle("CALCULATOR POLINOAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void adunare(ActionListener actionListener) {
        this.adunareButton.addActionListener(actionListener);
    }

    public void scadere(ActionListener actionListener) {
        this.scadereButton.addActionListener(actionListener);
    }

    public void inmultire(ActionListener actionListener) {
        this.inmultireButton.addActionListener(actionListener);
    }

    public void impartire(ActionListener actionListener) {
        this.impartireButton.addActionListener(actionListener);
    }

    public void derivare(ActionListener actionListener) {
        this.derivareButton.addActionListener(actionListener);
    }

    public void integrare(ActionListener actionListener) {
        this.integrareButton.addActionListener(actionListener);
    }

    public String getPolinom1() {
        return this.polinom1TextField.getText();
    }

    public String getPolinom2() {
        return this.polinom2TextField.getText();
    }

    public void setRezultatTextField(String s) {
        this.rezultatTextField.setText(s);
    }

    public boolean getCheckPolinom1() {
        return this.polinom1CheckBox.isSelected();
    }

    public boolean getCheckPolinom2() {
        return this.polinom2CheckBox.isSelected();
    }

    public void showNumberError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

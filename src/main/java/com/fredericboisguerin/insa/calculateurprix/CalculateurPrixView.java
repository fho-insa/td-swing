package com.fredericboisguerin.insa.calculateurprix;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CalculateurPrixView extends JFrame {

    private JLabel montantHTLabel = new JLabel("Montant HT : ");
    private JFormattedTextField montantHTTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());

    private JLabel prixArticleLabel = new JLabel("Prix d'un article (€) : ");
    private JTextField prixArticleTextField = new JTextField(10);

    private JLabel QuantiteLabel = new JLabel("Quantité");
    private JTextField QuantiteTextField = new JTextField(10);

    private final CalculateurPrixPresenter presenter;

    public CalculateurPrixView() throws HeadlessException {
        super("Calculateur de prix");
        this.presenter = new CalculateurPrixPresenter(this);

        prixArticleLabel.setLabelFor(prixArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici le montant d'un article");


        QuantiteLabel.setLabelFor(prixArticleTextField);
        QuantiteTextField.setToolTipText("Entrez ici le montant d'un article");


        montantHTTextField.setValue(0);
        montantHTTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantHTTextField);

        JButton computeButton = new JButton("Calculer");
        computeButton.addActionListener(e -> this.presenter.onComputeButtonClicked(QuantiteTextField.getText(),prixArticleTextField.getText()));

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.add(prixArticleTextField);
        contentPane.add(QuantiteTextField);


        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(prixArticleLabel);
        labelPane.add(QuantiteLabel);
        labelPane.add(montantHTLabel);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(prixArticleTextField);
        fieldPane.add(QuantiteTextField);
        fieldPane.add(montantHTTextField);


        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, WEST);
        add(fieldPane, EAST);
        add(computeButton, SOUTH);

        prixArticleTextField.requestFocus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void afficherErreur(String message) {
        showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
    }

    public void display() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void afficherMontantHT(float calculerMontantHT){

        montantHTTextField.setValue(calculerMontantHT);
    }
}

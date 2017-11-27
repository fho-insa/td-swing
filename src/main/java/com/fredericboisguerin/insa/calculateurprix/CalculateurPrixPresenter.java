package com.fredericboisguerin.insa.calculateurprix;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComputeButtonClicked(String Quantite, String prix, String nomDuPays) {

        boolean Erreur = false;

        if (Quantite.equals("") || prix.equals("")) {

            calculateurPrixView.afficherErreur("Champs null ! :)");
            Erreur = true;

        }

        String regexpPrix = "^[0-9.]{1,}$";
        String regexpArticle = "^[0-9]{1,}$";
        Pattern p = Pattern.compile(regexpPrix);
        Pattern p1 = Pattern.compile(regexpArticle);
        Matcher MontantArticle = p.matcher(prix);
        Matcher NbArticle = p1.matcher(Quantite);



        if (!MontantArticle.matches()){
            calculateurPrixView.afficherErreur("Prix erreur ! :)");
            Erreur = true;
        }

        if (!NbArticle.matches()){
            calculateurPrixView.afficherErreur("Quantité Article erreur ! :)");
            Erreur = true;
        }

        if (!Erreur) {
            int Quantit = Integer.parseInt(Quantite);
            float prise = Float.parseFloat(prix);


            Pays pays = Pays.valueOf(nomDuPays);

            double tauxDeTaxe = 0;


            switch (pays) {
                case Allemagne:
                    tauxDeTaxe = 1.19;
                    break;
                case Belgique:
                    tauxDeTaxe = 1.21;
                    break;
                case Danemark:
                    tauxDeTaxe = 1.25;
                    break;
                case Grèce:
                    tauxDeTaxe = 1.23;
                    break;
                case Espagne:
                    tauxDeTaxe = 1.21;
                    break;
                case France:
                    tauxDeTaxe = 1.20;
                    break;
                case Irlande:
                    tauxDeTaxe = 1.23;
                    break;
                case Italie:
                    tauxDeTaxe = 1.22;
                    break;
                case Chypre:
                    tauxDeTaxe = 1.19;
                    break;
                case Luxembourg:
                    tauxDeTaxe = 1.15;
                    break;
                case PaysBas:
                    tauxDeTaxe = 1.21;
                    break;
                case Autriche:
                    tauxDeTaxe = 1.20;
                    break;
                case Portugal:
                    tauxDeTaxe = 1.23;
                    break;
                case Suède:
                    tauxDeTaxe = 1.25;
                    break;

                default:
                    tauxDeTaxe = 1;

            }
            calculerMontant(Quantit, prise, (float) tauxDeTaxe);


        }
    }

    public void calculerMontant(int Quantite, float prix, float tauxRate){


        float calculerMontantHT = Quantite * prix ;
        float calculerMontantTTC = (float)((Quantite * prix)* tauxRate);

        calculateurPrixView.afficherMontantHT(calculerMontantHT);
        calculateurPrixView.afficherMontantTTC(calculerMontantTTC);
    }
}

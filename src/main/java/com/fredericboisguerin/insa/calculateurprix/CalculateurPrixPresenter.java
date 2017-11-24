package com.fredericboisguerin.insa.calculateurprix;



public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComputeButtonClicked(String Quantite, String prix) {

        int Quantit=Integer.parseInt(Quantite);
        float prise = Float.parseFloat(prix);
        calculerMontant(Quantit, prise);

    }

    public void calculerMontant(int Quantite, float prix){

        float calculerMontantHT = Quantite * prix ;

        calculateurPrixView.afficherMontantHT(calculerMontantHT);
    }
}

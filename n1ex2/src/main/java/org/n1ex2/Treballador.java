package org.n1ex2;

public class Treballador {
    private final String nom;
    private final String cognom;
    private final double preuPerHora;

    public Treballador(String nom, String cognom, double preuPerHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuPerHora = preuPerHora;
    }

    public double getPreuPerHora() {
        return preuPerHora;
    }

    public double calcularSou(double horesTreballades) {

        return horesTreballades * preuPerHora;

    }

    @Deprecated
    public void printNom() {
        System.out.println(nom);
    }
}
package org.n1ex2;

public class TreballadorPresencial extends Treballador {
    private static double benzina = 53.4;

    public TreballadorPresencial(String nom, String cognom, double preuPerHora) {
        super(nom, cognom, preuPerHora);
    }

    @Override
    public double calcularSou(double horesTreballades) {

        return horesTreballades * getPreuPerHora() + benzina;

    }

    @Deprecated
    public void printBenzina() {
        System.out.println(benzina);
    }
}

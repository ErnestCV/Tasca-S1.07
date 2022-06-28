package org.n1ex2;

public class TreballadorOnline extends Treballador {
    private static final double TARIFA_INTERNET = 31.99;

    public TreballadorOnline(String nom, String cognom, double preuPerHora) {
        super(nom, cognom, preuPerHora);
    }

    @Override
    public double calcularSou(double horesTreballades) {

        return horesTreballades * getPreuPerHora() + TARIFA_INTERNET;

    }

    @Deprecated
    public void printTarifa() {
        System.out.println(TARIFA_INTERNET);
    }
}

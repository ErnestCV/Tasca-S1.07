package org.n1ex1;

public class Main {
    public static void main(String[] args) {

        Treballador treballador = new Treballador("Ernest", "Company", 20);
        System.out.println(treballador.calcularSou(20));

        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Ernest", "Company", 20);
        System.out.println(treballadorPresencial.calcularSou(20));

        TreballadorOnline treballadorOnline = new TreballadorOnline("Ernest", "Company", 20);
        System.out.println(treballadorOnline.calcularSou(20));
    }
}
package org.n1ex2;

public class Main {
    public static void main(String[] args) {

        Treballador treballador = new Treballador("Ernest", "Company", 20);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Ernest", "Company", 20);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Ernest", "Company", 20);


        treballador.printNom();

    }
}
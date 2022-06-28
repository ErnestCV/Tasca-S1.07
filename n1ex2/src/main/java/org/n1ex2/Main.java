package org.n1ex2;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Ernest", "Company", 20);
        TreballadorOnline treballadorOnline = new TreballadorOnline("Ernest", "Company", 20);

        treballadorOnline.printTarifa();
        treballadorPresencial.printBenzina();

    }
}
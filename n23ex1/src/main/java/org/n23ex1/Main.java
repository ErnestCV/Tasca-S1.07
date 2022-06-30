package org.n23ex1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setNom("Ernest");
        persona.setCognom("Company");
        persona.setEdat(30);

        //El codi que hi ha a sota serialitza l'objecte aplicant la llibreria org.json
//        JSONObject jsonObject = new JSONObject(persona);

        //Fent servir reflection, obtenim el path a través de l'anotació, i escrivim l'arxiu resultant

        SerialitzadorJson serialitzadorJson = new SerialitzadorJson();

        try {
            String jsonString = serialitzadorJson.serialitza(persona);
            String outputPath = serialitzadorJson.getClass().getAnnotation(FitxerSortida.class).path();
            System.out.println("Objecte serialitzat");
            System.out.println("Intentant desar el fitxer a: " + outputPath + "...");

            try (FileWriter fileWriter = new FileWriter(outputPath)) {
                fileWriter.write(jsonString);
                fileWriter.flush();
                System.out.println("Fitxer .json desat");
            }

        } catch (JsonSerializeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
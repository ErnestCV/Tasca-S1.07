package org.n2ex1;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //TODO comenta jsonobject
        //TODO documenta tot

        Persona persona = new Persona();
        persona.setNom("Ernest");
        persona.setCognom("Company");
        persona.setEdat(30);

        JSONObject jsonObject = new JSONObject(persona);

        try (FileWriter fileWriter = new FileWriter("objecte.json")) {
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SerialitzadorJson serialitzadorJson = new SerialitzadorJson();
        try {
            serialitzadorJson.serialitza(persona);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }

        //TODO mira l'anotacio i obtin fitxer/path (mira metodes?)

        if (persona.getClass().isAnnotationPresent(JsonSerializable.class)) {
            System.out.println("S'està serialitzant l'objecte");
        }

    }
}
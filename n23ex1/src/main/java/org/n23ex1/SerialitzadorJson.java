package org.n23ex1;

import static java.util.Objects.requireNonNull;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@FitxerSortida()
public class SerialitzadorJson {

    //https://www.baeldung.com/java-custom-annotation
    //https://dzone.com/articles/creating-custom-annotations-in-java
    //https://www.geeksforgeeks.org/method-class-getparameterannotations-method-in-java/
    public String serialitza(Object object) throws JsonSerializeException {

        //Mirem si existeix l'annotació custom JsonSerializable a Persona (l'objecte a serialitzar) i que l'objecte no és null
        try {
            if (Objects.isNull(object)) {
                throw new JsonSerializeException("No es pot serialitzar un objecte null");
            }

            Class<?> objectClass = requireNonNull(object).getClass();
            if (!objectClass.isAnnotationPresent(JsonSerializable.class)) {
                throw new JsonSerializeException("La classe " + objectClass.getSimpleName() + " no es pot serialitzar");
            }

            //Desem els camps de l'objecte en un map, amb el seu nom com a key
            //Si estan anotats com a JsonElement, els afegim al map
            Map<String, Object> jsonElementsMap = new HashMap<>();

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonElement.class)) {
                    //jsonElementsMap.put(getSerializedKey(field), (String) field.get(object));
                    jsonElementsMap.put(field.getName(), field.get(object));
                }
            }
            // Convertim el map a un JsonString vàlid
            return toJsonString(jsonElementsMap);

        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    //Aplica el format Json a un map d'objectes
    private String toJsonString(Map<String, Object> jsonMap) {
        String jsonString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    //Si volem obtenir el valor de l'anotació en comptes del nom de l'atribut (hem d'haver creat una anotació per cada tipus de valor)

//    private static String getSerializedKey(Field field) {
//        String annotationValue = field.getAnnotation(JsonElement.class).value();
//
//        if (annotationValue.isEmpty()) {
//            return field.getName();
//        } else {
//            return annotationValue;
//        }
//    }
}

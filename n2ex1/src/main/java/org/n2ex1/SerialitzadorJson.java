package org.n2ex1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

//TODO anotar amb file: Myannotation, File file() default el path que vull
public class SerialitzadorJson {

    //https://www.baeldung.com/java-custom-annotation
    //https://dzone.com/articles/creating-custom-annotations-in-java
    public String serialitza(Object object) throws JsonSerializeException {

        try {
            if (Objects.isNull(object)) {
                throw new JsonSerializeException("No es pot serialitzar un objecte null");
            }

            Class<?> objectClass = requireNonNull(object).getClass();
            if (!objectClass.isAnnotationPresent(JsonSerializable.class)) {
                throw new JsonSerializeException("La classe " + objectClass.getSimpleName() + " no es pot serialitzar");
            }

            Map<String, String> jsonElementsMap = new HashMap<>();

            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonElement.class)) {
                    jsonElementsMap.put(getSerializedKey(field), (String) field.get(object));
                }
            }
            System.out.println(toJsonString(jsonElementsMap));
            return toJsonString(jsonElementsMap);

        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private String toJsonString(Map<String, String> jsonMap) {
        String jsonString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\""  + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonElement.class).value();

        if (annotationValue.isEmpty()) {
            return field.getName();
        } else {
            return annotationValue;
        }
    }

}

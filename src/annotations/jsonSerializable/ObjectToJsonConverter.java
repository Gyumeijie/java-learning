package annotations.jsonSerializable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

   public String convertToJson(Object object) throws JsonSerializationException {
      try {

         checkIfSerializable(object);
         initializeObject(object);
         return getJsonString(object);

      } catch (Exception e) {
         throw new JsonSerializationException(e.getMessage());
      }
   }


   private void checkIfSerializable(Object object) throws JsonSerializationException {
      if (Objects.isNull(object)) {
         throw new JsonSerializationException("The object to serialize is null");
      }

      Class<?> cls = object.getClass();
      if (!cls.isAnnotationPresent(JsonSerializable.class)) {
         throw new JsonSerializationException("The class" + cls.getSimpleName()
                 + "is not annotated with JsonSerializable");
      }
   }

   private void initializeObject(Object object) throws Exception {
      Class<?> cls = object.getClass();

      for (Method method : cls.getDeclaredMethods()) {
         if (method.isAnnotationPresent(Init.class)) {
            method.setAccessible(true);
            method.invoke(object);
         }
      }
   }

   private String getJsonString(Object object) throws Exception {
      Class<?> cls = object.getClass();
      Map<String, String> jsonElementsMap = new HashMap<>();

      for (Field field : cls.getDeclaredFields()) {
         field.setAccessible(true);
         if (field.isAnnotationPresent(JsonElement.class)) {
            jsonElementsMap.put(getKey(field), (String) field.get(object));
         }
      }

      String jsonString = jsonElementsMap.entrySet()
                                         .stream()
                                         .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                                         .collect(Collectors.joining(","));
      return "{" + jsonString + "}";

   }

   private String getKey(Field field) {
      String value = field.getAnnotation(JsonElement.class).key();

      return value.isEmpty() ? field.getName():value;
   }
}

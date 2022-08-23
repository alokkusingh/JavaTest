package alok.test.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDeserializerMain {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonString = "[\n" +
                "   {\n" +
                "      \"id\":123,\n" +
                "      \"name\":\"Alok Singh\",\n" +
                "      \"age\":38,\n" +
                "      \"money\":500.49\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":124,\n" +
                "      \"name\":\"Rachna Singh\",\n" +
                "      \"age\":35,\n" +
                "      \"money\":300.23\n" +
                "   },\n" +
                "   {\n" +
                "      \"id\":123,\n" +
                "      \"name\":\"Alok Singh\",\n" +
                "      \"age\":38,\n" +
                "      \"money\":500.49\n" +
                "   }\n" +
                "]";


        ObjectMapper objectMapper = new ObjectMapper();
        /*
        List<CustomClass> list = objectMapper.readValue(jsonString, new TypeReference<List<CustomClass>>() {
        });
        */

        SimpleModule module = new SimpleModule();
        module.addDeserializer(CustomClass.class, new CustomDeserializer());
        objectMapper.registerModule(module);
        List<CustomClass> list = objectMapper.readValue(jsonString, new TypeReference<List<CustomClass>>() {
        });

        System.out.println("Two objects with different values");
        System.out.println(list.get(0).getId() == list.get(1).getId());
        System.out.println(list.get(0).getName() == list.get(1).getName());
        System.out.println(list.get(0).getAge() == list.get(1).getAge());
        System.out.println(list.get(0).getMoney() == list.get(1).getMoney());

        System.out.println("Two objects with same values");
        System.out.println(list.get(0).getId() == list.get(2).getId());
        System.out.println(list.get(0).getName() == list.get(2).getName());
        System.out.println(list.get(0).getAge() == list.get(2).getAge());
        System.out.println(list.get(0).getMoney() == list.get(2).getMoney());

        System.out.println("Two objects");
        System.out.println(list.get(0) == list.get(2));

        System.out.println(list);
    }
}

class CustomDeserializer extends StdDeserializer<CustomClass> {

    private static Map<Double, Double> doublePool = new HashMap<>();

    public CustomDeserializer() {
        this(null);
    }

    @Override
    public CustomClass deserialize(
            JsonParser jsonParser,
            DeserializationContext deserializationContext
    ) throws IOException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Integer id = node.get("id").asInt();
        String name = node.get("name").asText();
        Long age = node.get("age").asLong();
        Double money = node.get("money").asDouble();

        doublePool.putIfAbsent(money, money);


        return new CustomClass(id, name.intern(), age, doublePool.get(money));
    }

    public CustomDeserializer(Class<?> vc) {
        super(vc);
    }
}

class CustomClass {

    private Integer id;
    private String name;
    private Long age;
    private Double money;

    public CustomClass() {

    }

    public CustomClass(Integer id, String name, Long age, Double money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "CustomClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}



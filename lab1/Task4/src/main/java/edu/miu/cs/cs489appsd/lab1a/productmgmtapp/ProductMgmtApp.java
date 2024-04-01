package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thoughtworks.xstream.XStream;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) throws JsonProcessingException {
        Product product1 = new Product(3128874119L,"Banana", LocalDate.of(2023,01,24),124, new BigDecimal(0.55).setScale(2, RoundingMode.DOWN));
        Product product2 = new Product(2927458265L,"Apple", LocalDate.of(2022,12,9),18, new BigDecimal(1.09).setScale(2, RoundingMode.DOWN));
        Product product3 = new Product(9189927460L,"Carrot", LocalDate.of(2023,03,31),89, new BigDecimal(2.99).setScale(2, RoundingMode.DOWN));
        Product[] products = {product1, product2,product3};
        printProducts(products);
    }

    private static void printProducts(Product[] products) throws JsonProcessingException {
        List<Product> prods = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        System.out.println("Printed in JSON format");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String jsonArray = objectMapper.writeValueAsString(prods);
        JsonNode jsonNode = objectMapper.readTree(jsonArray);
        Iterator<JsonNode> iterator =jsonNode.iterator();

        String result = "[";
        while(iterator.hasNext()){
            result += iterator.next().toString() + ",\n";
        }
        result = result.substring(0, result.length()-2) + "]";
        System.out.println(result);
        System.out.println("-----------------------");

        System.out.println("Printed in XML format");

        XStream xstream = new XStream();
        xstream.alias("product", Product.class);

        String xml = xstream.toXML(prods);
        System.out.println(xml);
        System.out.println("-----------------------");

        System.out.println("Printed in Comma-Separated Value(CSV) format");
        prods.stream()
            .map(a -> a.toString())
            .forEach(System.out::println);
    }

}

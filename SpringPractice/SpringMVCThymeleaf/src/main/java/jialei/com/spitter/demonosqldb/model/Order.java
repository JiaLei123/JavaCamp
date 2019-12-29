package jialei.com.spitter.demonosqldb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;


@Document
@Data
public class Order {
    @Id
    private String id;

    @Field("client")
    private String customer;

    private String type;

    private Collection<Item> items = new LinkedHashSet<Item>();
}

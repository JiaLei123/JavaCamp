package jialei.com.spitter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;


@Document
@Data
public class Order implements Serializable {
    @Id
    private String id;

    @Field("client")
    private String customer;

    private String type;

    private Collection<Item> items = new LinkedHashSet<Item>();
}

package jialei.com.spitter.dataaccess.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Spittle")
@NoArgsConstructor
@AllArgsConstructor
public class SpittleDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

    @Column
    private Date created_at;

    @Column
    private Double latitude;

    @Column
    private Double longitude;
}

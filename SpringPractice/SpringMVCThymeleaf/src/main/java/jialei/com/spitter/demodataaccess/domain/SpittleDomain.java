package jialei.com.spitter.demodataaccess.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

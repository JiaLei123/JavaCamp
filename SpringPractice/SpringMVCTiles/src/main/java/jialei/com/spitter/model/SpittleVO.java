package jialei.com.spitter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpittleVO {
    @NotNull
    @Size(min=5, max=140)
    private String message;

    @Min(-180)
    @Max(180)
    private Double longitude;

    @Min(-90)
    @Max(90)
    private Double latitude;
}

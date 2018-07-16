package bd.ac.seu.aj.summer2018.midterm.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"streetAddress", "city", "country", "postalCode"})
@EqualsAndHashCode(of = {"streetAddress", "city", "country", "postalCode"})
public class Address {
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;
}

package org.steve.palko.slps;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message="Street address is required")
    private String streetAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 2, message = "State should be in format XX eg. PA")
    private String state;

    @Digits(integer=5, fraction = 0, message = "Please enter a 5 digit zip code.")
    private String zip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var address = (Address) o;

        if (!Objects.equals(streetAddress, address.streetAddress)) return false;
        if (!Objects.equals(city, address.city)) return false;
        if (!Objects.equals(state, address.state)) return false;
        return Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(streetAddress);
        result = 31 * result + (Objects.hashCode(city));
        result = 31 * result + (Objects.hashCode(state));
        result = 31 * result + (Objects.hashCode(zip));
        return result;
    }

    @Override
    public String toString() {
        return streetAddress + " " + city + ", " + state + " " + zip;
    }
}

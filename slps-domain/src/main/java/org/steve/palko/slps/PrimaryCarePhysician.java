package org.steve.palko.slps;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PrimaryCarePhysician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phoneNumber;
    private String email;

    @Embedded
    private Address address;
    private String practiceName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrimaryCarePhysician that = (PrimaryCarePhysician) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1570255501;
    }
}

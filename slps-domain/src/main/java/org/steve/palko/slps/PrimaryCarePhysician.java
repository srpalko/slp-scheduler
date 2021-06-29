package org.steve.palko.slps;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PrimaryCarePhysician implements Serializable {
    private static final long serialVersionUID = 28288L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Name cannot be blank")
    private String lastName;

    @NotBlank(message = "Phone cannot be blank")
    private String phoneNumber;

    @Email(message = "Not a valid email address")
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

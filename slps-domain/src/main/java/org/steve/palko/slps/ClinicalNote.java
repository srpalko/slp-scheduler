package org.steve.palko.slps;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Embeddable
public class ClinicalNote implements Serializable {
    private static final long serialVersionUID = 221L;
    private String note;
}

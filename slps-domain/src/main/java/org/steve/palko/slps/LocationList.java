package org.steve.palko.slps;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class LocationList {
    private List<Location> locations = new ArrayList<>();

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LocationList that = (LocationList) o;

        return Objects.equals(locations, that.locations);
    }

    @Override
    public int hashCode() {
        return 1014693067;
    }
}

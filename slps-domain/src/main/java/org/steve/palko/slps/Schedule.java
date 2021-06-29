package org.steve.palko.slps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Schedule implements Serializable {
    private static final long serialVersionUID = 123L;

    @OneToMany
    @ToString.Exclude
    private List<Patient> monday = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Patient> tuesday = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Patient> wednesday = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Patient> thursday = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Patient> friday = new ArrayList<>();

    public List<Patient> getDay(DayOfWeek day) {
        List<Patient> daySchedule;
        switch (day) {
            case MONDAY:
                daySchedule = getMonday();
                break;
            case TUESDAY:
                daySchedule = getTuesday();
                break;
            case WEDNESDAY:
                daySchedule = getWednesday();
                break;
            case THURSDAY:
                daySchedule = getThursday();
                break;
            case FRIDAY:
                daySchedule = getFriday();
                break;
            default:
                daySchedule = null;
        }
        return daySchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        var schedule = (Schedule) o;

        if (!Objects.equals(monday, schedule.monday)) return false;
        if (!Objects.equals(tuesday, schedule.tuesday)) return false;
        if (!Objects.equals(wednesday, schedule.wednesday)) return false;
        if (!Objects.equals(thursday, schedule.thursday)) return false;
        return Objects.equals(friday, schedule.friday);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(monday);
        result = 31 * result + (Objects.hashCode(tuesday));
        result = 31 * result + (Objects.hashCode(wednesday));
        result = 31 * result + (Objects.hashCode(thursday));
        result = 31 * result + (Objects.hashCode(friday));
        return result;
    }
}

package com.example.finplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractPersistable<Integer> {
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 64)
    private String name;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String lastName;

    @Column(name = "middle_name")
    @Size(max = 128)
    private String middleName;

    @Column(name = "birthday", nullable = false)
    @NotNull
    private LocalDate birthDay;

    @Column(name = "group_id", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String groupId;

    @Override
    public String toString() {
        return "Student {" +
                " id = " + getId() +
                ", name='" + name + '\'' +
                ", last_name='" + lastName + '\'' +
                ", middle_name='" + middleName + '\'' +
                ", birthday=" + birthDay +
                ", group_id='" + groupId + '\'' +
                '}';
    }
}
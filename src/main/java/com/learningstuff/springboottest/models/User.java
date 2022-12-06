package com.learningstuff.springboottest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.learningstuff.springboottest.jacksons.LocalDateDeserializer;
import com.learningstuff.springboottest.jacksons.LocalDateTimeDeserializer;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;

    @JsonFormat(pattern = "MM-dd-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dob;

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateOfBirth;

    @JsonProperty(access = READ_ONLY)
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty(access = READ_ONLY)
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    public User(long id, String name, LocalDate dob, LocalDateTime dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.dateOfBirth = dateOfBirth;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}

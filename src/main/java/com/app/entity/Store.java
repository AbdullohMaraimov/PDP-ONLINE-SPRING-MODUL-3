package com.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "store")
public class Store{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @NotBlank
    @NonNull
    private String name;
    @NonNull
    @NotBlank
    private String email;
    private String description;
}

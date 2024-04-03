package com.app.entity;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "store")
@Schema(name = "Store", description = "Magazin")
public class Store{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @NotBlank
    @NonNull
    @Parameter(name = "Name", description = "Magazin nomi")
    private String name;
    @NonNull
    @NotBlank

    @Parameter(name = "email", description = "Magazin elektron pochta manzili")
    private String email;

    @Parameter(name = "Tavsif", description = "Magazib haqida qo'shimcha malumotlar")
    private String description;
}

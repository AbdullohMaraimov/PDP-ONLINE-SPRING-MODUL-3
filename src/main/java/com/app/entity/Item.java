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
@Table(name = "items")
@Schema(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @NotBlank
    @NonNull
    @Parameter(name = "Name", description = "Foydalanuvchi ismi")
    private String name;

    @Parameter(name = "Price", description = "Buyum narxi")
    private Integer price;

}

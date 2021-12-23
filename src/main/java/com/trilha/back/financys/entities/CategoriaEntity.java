package com.trilha.back.financys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "tb_categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    @NotNull(message = "Campo nome não pode ser nulo ou vazio")
    @Size(min = 3, max = 15, message = "min 3 a 15 caracteres")
    private String name;

    @NotBlank(message = "Campo de descrição não pode ser nulo ou vazio")
    @NotNull(message = "Campo de descrição não pode ser nulo ou vazio")
    @Size(min = 15, max = 50, message = "min 15 a 50 caracteres")
    private String description;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<LancamentosEntity> lancamentos;

    public CategoriaEntity(int indexOf){ }

}
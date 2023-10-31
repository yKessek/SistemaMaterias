package br.upf.materias.dtos

import br.upf.materias.model.StatusMateria
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class MateriaDTO (
    @field:NotBlank(message = "Matéria sempre deve ter um nome!")
    val nome: String,
    @field:NotNull(message = "Matéria deve ter uma data")
    val data: LocalDate,
    @field:NotBlank(message = "Matéria deve ter uma descrição")
    val descricao: String,
    val status: StatusMateria
)
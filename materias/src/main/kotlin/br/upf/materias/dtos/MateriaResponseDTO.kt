package br.upf.materias.dtos

import br.upf.materias.model.Inscricao
import br.upf.materias.model.StatusMateria
import java.time.LocalDate

data class MateriaResponseDTO (
    val id: Long,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    val status: StatusMateria,
    val inscritos: List<Inscricao>
)
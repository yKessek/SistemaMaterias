package br.upf.materias.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Materia (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val data: LocalDate,
    val descricao: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusMateria,
    @OneToMany(mappedBy = "materia")
    val inscritos: List<Inscricao> = listOf()
)
package br.upf.materias.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Inscricao (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val aluno: Aluno,
    @ManyToOne
    val materia: Materia,
    val data: LocalDateTime = LocalDateTime.now()
)
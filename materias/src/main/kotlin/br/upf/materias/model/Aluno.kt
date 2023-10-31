package br.upf.materias.model

import jakarta.persistence.*

@Entity
data class Aluno (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,

    @OneToMany(mappedBy = "aluno")
    val inscricoes: List<Inscricao> = listOf()
)
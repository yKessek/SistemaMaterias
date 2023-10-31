package br.upf.materias.repository

import br.upf.materias.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlunoRepository: JpaRepository<Aluno, Long> {
}
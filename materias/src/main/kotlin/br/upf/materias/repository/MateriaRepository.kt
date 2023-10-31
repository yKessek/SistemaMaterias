package br.upf.materias.repository

import br.upf.materias.model.Materia
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MateriaRepository: JpaRepository<Materia, Long> {
    fun findByNome(nomeMateria: String, paginacao: Pageable): Page<Materia>
}
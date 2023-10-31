package br.upf.materias.repository

import br.upf.materias.model.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository: JpaRepository<Inscricao, Long> {
}
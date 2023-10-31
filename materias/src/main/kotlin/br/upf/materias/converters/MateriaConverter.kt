package br.upf.materias.converters

import br.upf.materias.dtos.MateriaDTO
import br.upf.materias.dtos.MateriaResponseDTO
import br.upf.materias.model.Materia
import org.springframework.stereotype.Component

@Component
class MateriaConverter {

    fun toMateria(dto: MateriaDTO) : Materia {
        return Materia(
            nome = dto.nome,
            data = dto.data,
            descricao = dto.descricao,
            status = dto.status
        )
    }

    fun toMateriaResponseDTO(materia: Materia): MateriaResponseDTO {
        return MateriaResponseDTO(
            id = materia.id!!,
            nome = materia.nome,
            data = materia.data,
            descricao = materia.descricao,
            status = materia.status,
            inscritos = materia.inscritos
        )
    }

}
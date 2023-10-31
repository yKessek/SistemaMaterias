package br.upf.materias.service

import br.upf.materias.converters.MateriaConverter
import br.upf.materias.dtos.MateriaDTO
import br.upf.materias.dtos.MateriaResponseDTO
import br.upf.materias.exceptions.NotFoundException
import br.upf.materias.repository.MateriaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val ERROR_MESSAGE = "Matéria não encontrada!!!"

@Service
class MateriaService(private val repository: MateriaRepository,
    val converter: MateriaConverter
) {

    fun listar(nomeMateria: String?,
               paginacao: Pageable
    ): Page<MateriaResponseDTO> {
        val materias = if (nomeMateria == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeMateria, paginacao)
        }

        return materias
            .map(converter::toMateriaResponseDTO)
    }

    fun buscarPorId(id: Long): MateriaResponseDTO {
        val materia = repository.findById(id)
            .orElseThrow{ NotFoundException(ERROR_MESSAGE) }
        return converter.toMateriaResponseDTO(materia)
    }

    fun cadastrar(dto: MateriaDTO): MateriaResponseDTO {
        return converter.toMateriaResponseDTO(
            repository.save(converter.toMateria(dto)))
    }

    fun atualizar(id: Long, dto: MateriaDTO) : MateriaResponseDTO {
        val materia = repository.findById(id)
            .orElseThrow{ NotFoundException(ERROR_MESSAGE) }
            .copy(nome = dto.nome,
                data = dto.data,
                descricao = dto.descricao,
                status = dto.status
            )
        return converter.toMateriaResponseDTO(
            repository.save(materia)
        )
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}
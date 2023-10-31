package br.upf.materias.controller

import br.upf.materias.dtos.MateriaDTO
import br.upf.materias.dtos.MateriaResponseDTO
import br.upf.materias.service.MateriaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/materias")
class MateriaController(val service: MateriaService) {

    @GetMapping
    fun listar(@RequestParam(required = false) nomeMateria: String?,
               @PageableDefault(size=10) paginacao: Pageable): Page<MateriaResponseDTO> {
        return service.listar(nomeMateria, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): MateriaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid materia: MateriaDTO,
                  uriBuilder: UriComponentsBuilder): ResponseEntity<MateriaResponseDTO> {
        val materiaResponse = service.cadastrar(materia)
        val uri = uriBuilder.path("/materias/${materiaResponse.id}").build().toUri()
        return  ResponseEntity.created(uri).body(materiaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid materia: MateriaDTO): MateriaResponseDTO {
        return service.atualizar(id, materia)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun daletar(@PathVariable id: Long) {
        service.deletar(id)
    }



}
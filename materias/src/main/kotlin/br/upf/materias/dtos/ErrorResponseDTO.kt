package br.upf.materias.dtos

import java.time.LocalDateTime

data class ErrorResponseDTO (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
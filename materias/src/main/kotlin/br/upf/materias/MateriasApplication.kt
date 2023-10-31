package br.upf.materias

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MateriasApplication

fun main(args: Array<String>) {
	runApplication<MateriasApplication>(*args)
}

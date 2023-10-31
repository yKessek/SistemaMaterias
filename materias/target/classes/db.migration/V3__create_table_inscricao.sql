CREATE TABLE `inscricao` (
`id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
`data` datetime(6) NOT NULL,
`materia_id` bigint NOT NULL,
`aluno_id` bigint NOT NULL,
FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`)
);
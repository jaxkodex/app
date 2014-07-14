-- clean up tables
delete from seccion;
delete from grado;
delete from nivel;
delete from institucion_educativa;
delete from periodo_academico;
delete from turno;

-- preload turno
insert into turno values (1, 'MAÑANA', 'M');
insert into turno values (2, 'TARDE', 'T');

-- preload periodo_academico
insert into periodo_academico values (1, '2014-01-01', '2014-12-31', '2014', true);

-- preload institucion_educativa
insert into institucion_educativa values (1, 'Santa Rosa del Sauce', '¡Educando Contigo!', true);

--- preload nivel
insert into nivel values (1, 1, 'INICIAL');
insert into nivel values (2, 1, 'PRIMARIA');
insert into nivel values (3, 1, 'SECUNDARIA');

-- preload grado
-- Inicial
insert into grado values (1, 1, '4 Años');
insert into grado values (2, 1, '5 Años');
-- Primaria
insert into grado values (3, 2, 'PRIMERO');
insert into grado values (4, 2, 'SEGUNDO');
insert into grado values (5, 2, 'TERCERO');
insert into grado values (6, 2, 'CUARTO');
insert into grado values (7, 2, 'QUINTO');
insert into grado values (8, 2, 'SEXTO');
-- Secundaria
insert into grado values (9, 3, 'PRIMERO');
insert into grado values (10, 3, 'SEGUNDO');
insert into grado values (11, 3, 'TERCERO');
insert into grado values (12, 3, 'CUARTO');
insert into grado values (13, 3, 'QUINTO');

--preload seccion
-- Inicial
insert into seccion values (1, 1, 'Unica');
insert into seccion values (2, 2, 'Unica');
-- Primaria
insert into seccion values (3, 3, 'A');
insert into seccion values (4, 3, 'B');
insert into seccion values (5, 4, 'A');
insert into seccion values (6, 4, 'B');
insert into seccion values (7, 5, 'A');
insert into seccion values (8, 5, 'B');
insert into seccion values (9, 6, 'A');
insert into seccion values (10, 6, 'B');
insert into seccion values (11, 7, 'A');
insert into seccion values (12, 7, 'B');
insert into seccion values (13, 8, 'A');
insert into seccion values (14, 8, 'B');
-- Secundaria
insert into seccion values (15, 9, 'A');
insert into seccion values (16, 9, 'B');
insert into seccion values (17, 10, 'A');
insert into seccion values (18, 10, 'B');
insert into seccion values (19, 10, 'C');
insert into seccion values (20, 11, 'A');
insert into seccion values (21, 11, 'B');
insert into seccion values (22, 12, 'A');
insert into seccion values (23, 12, 'B');
insert into seccion values (24, 13, 'A');
insert into seccion values (25, 13, 'B');


-- preload clase

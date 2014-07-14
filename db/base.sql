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
select * from clase;
insert into clase values (1, 1, 1, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (2, 1, 2, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (3, 1, 3, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (4, 1, 4, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (5, 1, 5, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (6, 1, 6, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (7, 1, 7, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (8, 1, 8, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (9, 1, 9, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (10, 1, 10, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (11, 1, 11, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (12, 1, 12, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (13, 1, 13, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (14, 1, 14, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (15, 1, 15, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (16, 1, 16, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (17, 1, 17, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (18, 1, 18, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (19, 1, 19, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (20, 1, 20, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (21, 1, 21, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (22, 1, 22, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (23, 1, 23, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (24, 1, 24, now(), now(), 1, 0, 0, 0, 0);
insert into clase values (25, 1, 25, now(), now(), 1, 0, 0, 0, 0);
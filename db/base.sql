-- clean up tables
delete from seccion;
delete from grado;
delete from nivel;
delete from institucion_educativa;

-- preload institucion_educativa
insert into institucion_educativa values (1, 'Santa Rosa del Sauce', '¡Educando Contigo!', true);
--- preload nivel
insert into nivel values (1, 1, 'INICIAL');
insert into nivel values (2, 1, 'PRIMARIA');
insert into nivel values (3, 1, 'SECUNDARIA');

-- preload grado
insert into grado values (1, 1, '');
insert into grado values (2, 1, '');
insert into grado values (3, 1, 'PRIMERO');
insert into grado values (4, 1, 'SEGUNDO');

--preload seccion
insert into seccion values (1, 1, 'Unica');
insert into seccion values (2, 2, 'Unica');
insert into seccion values (3, 3, 'A');
insert into seccion values (4, 3, 'B');
insert into seccion values (5, 4, 'A');
insert into seccion values (6, 4, 'B');
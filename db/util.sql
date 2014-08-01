select * from evaluacion;

select * from persona

insert into persona (persona_dni, persona_pnombre) values ('XXXXX', 'asd')

select * from cargo;

select * from observador;
insert into observador values (1, 'XXXXX');

select * from clase;
select * from seccion;
select * from periodo_academico;
select * from turno;
insert into turno values (null, 'MAÑANA', 'MN')
update turno set turno_codigo = 'M';
insert into clase (id_periodo, id_seccion, id_turno, clase_finicio, clase_nhombres,
clase_nmujeres) values (1, 1, 1, now(), 0, 0);

select * from formato_evaluacion; --7
select * from desenvuelve;
insert into desenvuelve values (1, 'XXXXX')
insert into evaluacion (id_formato, id_cargo, persona_dni, id_observador, id_clase)
values (7, 1, 'XXXXX', 1, 1)



select evaluacion0_.id_evaluacion as id_evalu1_6_, evaluacion0_.id_clase as id_clase8_6_, evaluacion0_.id_cargo as id_cargo9_6_, evaluacion0_.persona_dni as persona10_6_, evaluacion0_.evaluacion_areas as evaluaci2_6_, evaluacion0_.evaluacion_denominacon as evaluaci3_6_, evaluacion0_.evaluacion_nhainclusivo as evaluaci4_6_, evaluacion0_.evaluacion_nhasistentes as evaluaci5_6_, evaluacion0_.evaluacion_nmainclusivo as evaluaci6_6_, evaluacion0_.evaluacion_nmasistenetes as evaluaci7_6_, evaluacion0_.id_formato as id_form11_6_, evaluacion0_.id_observador as id_obse12_6_ from Evaluacion evaluacion0_
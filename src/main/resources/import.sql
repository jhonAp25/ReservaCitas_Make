insert into Carrera (descripcion) values ('Desarrollo de sistemas');
insert into Carrera (descripcion) values ('Psicologia');
insert into Carrera (descripcion) values ('Contabilidad');
insert into Carrera (descripcion) values ('Administracion de Empresas');
insert into Carrera (descripcion) values ('Ing. Industrial');

insert into cupos (hora_inicio, hora_fin ,estado) values ( '02:00', '03:00', true );
insert into cupos (hora_inicio, hora_fin ,estado) values ( '03:00', '04:00', true );
insert into cupos (hora_inicio, hora_fin ,estado) values ( '04:00', '05:00', true );
insert into cupos (hora_inicio, hora_fin ,estado) values ( '05:00', '06:00', true );





insert into  Especialidad (descripcion) values ( 'Psicologia' );

insert into  Especialista (nombre, apellido, telefono, correo, fecnac, dni, especialidad_id) values ( 'Katy', 'Bazan' , '897654312', 'bazan@gmail.com', '1995-02-05', '74586936', 1 );

insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('apaza', '75680099', '2000-05-12','joihn','https://i.imgur.com/3mhhSzi.jpg','correo@gmail.com','987654321', 1);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('suarez', '75680099', '2000-05-12','jose','https://i.imgur.com/IKNorjn.jpg','correo@outlook.com','987654321',  1);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('caceres', '75680099', '2000-05-12','Maria','https://i.imgur.com/IKNorjn.jpg','correo@gmail.com','987654321',  2);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('Vazques Huaman', '75680099', '2000-05-12','maria', 'https://i.imgur.com/IKNorjn.jpg','correo@gmail.com','987654321', 5);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('Larico Delgado', '75680099', '2000-05-12','Daniel Carlos','https://i.imgur.com/pMTKt20.jpg','correo@gmail.com','987654321',  4);
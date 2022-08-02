insert into Carrera (descripcion) values ('Desarrollo de sistemas');
insert into Carrera (descripcion) values ('Psicologia');
insert into Carrera (descripcion) values ('Contabilidad');
insert into Carrera (descripcion) values ('Administracion de Empresas');
insert into Carrera (descripcion) values ('Ing. Industrial');




insert into  Especialidad (descripcion) values ( 'Psicologia' );
insert into  Especialidad (descripcion) values ( 'Terapia' );

insert into  Especialista (nombre, apellido, telefono, correo, fecnac, dni, especialidad_id) values ( 'Katy', 'Bazan' , '897654312', 'bazan@gmail.com', '1995-02-05', '74586236', 1 );
insert into  Especialista (nombre, apellido, telefono, correo, fecnac, dni, especialidad_id) values ( 'Estrella', 'Bustillos Estrada' , '897654312', 'bazan@gmail.com', '1995-02-05', '74776936', 1 );
insert into  Especialista (nombre, apellido, telefono, correo, fecnac, dni, especialidad_id) values ( 'Sonia', 'Romero Dulanto' , '897654312', 'bazan@gmail.com', '1995-02-05', '74586123', 2 );

insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id ) values ('apaza', '75680100', '2000-05-12','joihn','https://i.imgur.com/3mhhSzi.jpg','correo@gmail.com','987654321', 1);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('suarez', '75680095', '2000-05-12','jose','https://i.imgur.com/IKNorjn.jpg','correo@outlook.com','987654321',  1 );
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('caceres', '75687865', '2000-05-12','Maria','https://i.imgur.com/IKNorjn.jpg','correo@gmail.com','987654321',  2);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id)  values ('Vazques Huaman', '75440099', '2000-05-12','maria', 'https://i.imgur.com/IKNorjn.jpg','correo@gmail.com','987654321', 5);
insert into estudiante (apellido, dni, fecnac, nombre,foto,correo,telefono, carrera_id) values ('Larico Delgado', '75684562', '2000-05-12','Daniel Carlos','https://i.imgur.com/pMTKt20.jpg','correo@gmail.com','987654321',  4 );

insert into cola (estado , estudiante_id) values ( 'ESPERA' , 1);
insert into cola (estado , estudiante_id) values ( 'ESPERA' , 2);
insert into cola (estado , estudiante_id) values ( 'ESPERA' , 3);
insert into cola (estado , estudiante_id) values ( 'ESPERA' , 4);
insert into cola (estado , estudiante_id) values ( 'CANCELADO' , 5);
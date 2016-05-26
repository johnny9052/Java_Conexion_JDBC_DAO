create table usuario(
cedula varchar(10),
nombre varchar(30),
apellido varchar(30),
edad integer,
primary key(cedula)
)








/*Como se crea una funcion en postgres!!*/
/*CREATE OR REPLACE FUNCTION modificarUsuario(cedula INT,nombre VARCHAR,apellidos VARCHAR,correo VARCHAR,contrasena VARCHAR) RETURNS void AS
    'UPDATE USUARIO SET nombre=$2,apellidos=$3,correo=$4,password=$5  WHERE cedula=$1;'
    language sql;*/


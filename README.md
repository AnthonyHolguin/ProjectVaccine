# ProjectVaccine
ProjectVaccine, coding challenge krugercorp
Esta aplicació fue desarrollada en el IDE Spring tools Suite 4
-Para poder correr esta aplicación en otro ambiente, lo puede correr un ambiente con jdk 1.8_31, que tenga base de datos postgresql.

-La configuración de la conexion a la base de datos está en el archivo aplicacion.yml.

-Debe crear la base de datos en postgres system_vaccine

-Esta aplicación usa JPA, y crea las tablas de la base de datos de acuerdo a las entidades al correr el programa, por lo que va a hacer drop a las tablas cada vez que inicia, esto se hizo así por pruebas.

-Para correr el swagger, debe compilar el codigo e ir al navegador a la url http://localhost:8080/swagger-ui/index.html#/

-Existe un usuario ADMIN y su clave es 1234

Para crear un empleado primero debe iniciar sesión como ADMIN.

-Luego puede crear un empleado con el JSON

{"idEmployee":"1",
"names":"anthony",
"lastNames":"holguin",
"identificationCard":"1313500694",
"email":"anthonybryan199298@gmail.com",

"statusVaccine":"false",
"users":{
        "user_name":"1313500694",
        "password":"1313500694",
        "type":"EM"}
}
-Luego para actualizar los datos se debe iniciar sesion con el usuario, en este caso usuario y clave 1313500694 

Usamos el metodo PUT para actualizar, este JSON de ejemplo

{"idEmployee":"1",
"names":"anthony",
"lastNames":"holguin",
"identificationCard":"1313500694",
"email":"anthonybryan199298@gmail.com",
"birthDate":"1998-04-12",
"homeAddress":"San gabriel-calderon",
"mobilePhone":"0969251941",
"statusVaccine":"false",

"users":{
        "user_name":"1313500694",
        "password":"1313500694",
        "type":"EM"}      
}

-si queremos realizar una busqueda por estado de vacunacion usamos el siguiene url
http://localhost:8080/api/employee/bystatus
-si queremos realizar una consulta por vacuna, se le pasa la id de la vacuna en el path.
http://localhost:8080/api/employee/byvaccine/1
	

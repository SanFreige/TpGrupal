# grupo-12-OO2-2021
Primera parte del TPC, Sistema integrador (versión web con bases de datos)

- Se creó la vista para el login haciendo referencia a los usuarios que hay ya precargados en la bd. Para testear el login, es necesario crear en la base de datos un perfil con el nombre "Admin" y un usuario asignado a este perfil, 
para loguearse, la clave debe estar encriptada con el metodo new BCryptPasswordEncoder().encode(contraseña) sino tira error.

- Dentro de la pestaña "Usuarios" se pueden listar todos los usuarios y los perifles que hay en la base de datos

- Dentro de la pestaña "Agregar Usuarios" se creo un formulario para poder agregar a un nuevo usuario. Las listas desplegables como "Tipo de Documento" y "Tipo de perfil" todavia no tienen ninguna funcionalidad. Con el boton "Registrar" se agrega un nuevo usuario a la BD redireccionando por el momento a la misma pagina sin ninguna alerta.

- El nuevo usuario que se agrega, se carga con la clave encriptada en la bd.

Tareas por terminar
- Corregir el alta de un nuevo usuario con todos sus parametros completos (Tipo de perfil)
- Dentro de la vista de "Usuarios", corregir y agregar nuevos parametros incompletos


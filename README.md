# Desafio#1
## Pipeline que permite crear usuarios en linux
A continuacion se detallan los pasos a seguir para la ejecucion del pipeline:

En el panel de control de Jenkins creamos una nueva tarea

![imagen0](images/00.png)

Seleccionamos pipeline y le damos un nombre por ejemplo "desafio1"

![imagen1](images/01.png)

Configuraciones, en general podemos poner una descripcion del pipeline

![imagen2](images/02.png)

Seleccionamos la opcion "Esta ejecucion debe parametrizarse" y seleccionamos añadir un parametro

![imagen3](images/03.png)

Seleccionamos parametro de cadena, en total van a ser 2 parametros de cadena.

![imagen4](images/04.png)

En nombre ponemos "Nombre" y descripcion "Ingrese el nombre del usuario"

![imagen5](images/05.png)

El segundo parametro de cadena: "Apellido" y descripcion "Ingrese el apellido del usuario"

![imagen6](images/06.png)

El tercer parametro va a ser un parametro de Eleccion en el que podremos elegir entre mas de una opcion, seleccionamos Eleccion

![imagen7](images/07.png)

En nombre ponemos "Departamento", en las opciones debemos poner las opciones una por linea que seran los departamentos a los que van a pertenecer los usuarios y en descripcion "Seleccione el departamento"

![imagen8](images/08.png)

Pasamos a la configuracion del pipeline:

primero en este repositorio de github vamos a copiar la url del repositorio de esta manera:

![imagen9](images/09.png)

en Definition seleccionamos la opcion Pipeline script from SCM y en SCM seleccionamos Git, en repository URL pegamos el link que copiamos en el paso anterior

![imagen10](images/10.png)

en branchs specifier escribimos main

![imagen11](images/11.png)

Y en Script Path escribimos la ruta al script y por ultimo damos click al boton Save

![imagen12](images/12path.png)

seleccionamos la opcion Build with Parameters

![imagen13](images/13.png)

ingresamos tanto el nombre como el apellido del usuario y en las opciones el departamento al que va a pertenecer

![imagen14](images/14.png)

> El programa basicamente crea los grupos, crea los usuarios y le asigna un id y una contraseña y la muestra en pantalla, se puede mejorar a prueba de errores como grupos o usuarios ya existentes, caracteres invalidos o vacios.
> En el directorio public se encuentra el console output de jenkins mostrando que funciona correctamente.

\# Registro de Vehículos – Java Consola



Aplicación de consola desarrollada en Java que permite crear un usuario, registrar vehículos asociados y mostrarlos mediante un menú interactivo.  

Actividad Semana 3 – Taller de Aplicaciones Móviles (AIEP).



\## 🚀 Ejecución



\### Requisitos previos

\- Tener instalado \*\*Java JDK 8 o superior\*\*.

\- Configurar variables de entorno (`JAVA\_HOME` y `Path`) para usar `javac` y `java`.



\### Pasos

```bash

cd src

javac RegistroVehiculosApp.java

java RegistroVehiculosApp



📋 Funcionalidades actuales



Mostrar menú principal con 4 opciones.



Permitir crear usuario con nombre y edad.



Validar identidad del usuario antes de registrar o mostrar vehículos.



Registrar datos de un vehículo (marca, modelo, cilindrada, combustible, capacidad).



Validar entradas y reintentar en caso de error.



Listar vehículos registrados por usuario.



Controlar flujo de ejecución (solo finaliza con la opción 4).





🔮 Funcionalidades futuras



Calcular costo de despacho según reglas de negocio.



Permitir ingresar monto y distancia de compra para calcular despacho.



Mostrar resumen de compra con total.



Permitir login con cuenta Gmail.



Guardar datos en archivo o base de datos.



Administrar múltiples usuarios.





📌 Requerimientos

Funcionales



Mostrar menú principal con opciones 1–4.



Permitir crear usuario (nombre y edad).



Validar identidad antes de registrar o consultar vehículos.



Registrar vehículos con sus datos completos.



Validar entradas y reintentar si son inválidas.



Listar vehículos registrados asociados al usuario.



Controlar salida del programa solo con la opción 4.





No funcionales



Ejecutarse en JVM (portabilidad).



Usar mensajes claros y en español.



Evitar errores por entradas inválidas.



Documentar el código línea por línea.



Mantener trazabilidad en GitHub (README, capturas, issues, project).





👤 Historias de Usuario



HU1 – Crear usuario

Como cliente, quiero registrar mi nombre y edad para poder usar el sistema.

Criterios de aceptación: El sistema valida que edad > 0 y muestra confirmación.



HU2 – Registrar vehículo

Como cliente, quiero ingresar los datos de mi vehículo para que queden registrados a mi nombre.

Criterios de aceptación: Se verifican datos de usuario y se valida cada campo.



HU3 – Listar vehículos

Como cliente, quiero ver la lista de mis vehículos registrados para confirmar la información.

Criterios de aceptación: Si no hay vehículos, se informa; si existen, se muestran con el formato requerido.



📂 Evidencias



docs/capturas\_instalacion.png



docs/capturas\_compilacion.png



docs/capturas\_ejecucion.png



📅 Cronograma inicial

Tarea	Descripción	                       Tiempo (min)

T1	Instalar y configurar JDK	          15

T2	Programar menú y opción salir	          15

T3	Programar opción crear usuario	          15

T4	Programar opción registrar vehículo	  30

T5	Programar opción listar vehículos	  15

T6	Validaciones extra	                  10

T7	Documentar línea por línea	          10

T8	Tomar capturas y evidencias	          10

T9	Redactar README e historias de usuario    15

Total: 135 min		



🛠️ Tecnologías



Lenguaje: Java



Ejecución: Consola / JVM



Control de versiones: Git + GitHub





---




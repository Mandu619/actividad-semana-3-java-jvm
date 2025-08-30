🚀 Ejecución de la aplicación
🔧 Requisitos previos

Instalar Java JDK 8 o superior

Descargar desde Oracle JDK
 o OpenJDK
.

Durante la instalación, anotar la ruta (ejemplo: C:\Program Files\Java\jdk-21).

Configurar variables de entorno (Windows):

Crear variable del sistema JAVA_HOME con la ruta del JDK.

Editar la variable Path y agregar:

%JAVA_HOME%\bin


Guardar y reiniciar la consola.

Verificar instalación:

java -version
javac -version


Si se muestran las versiones, el entorno está listo.

▶️ Pasos para ejecutar el programa

Descargar o clonar este repositorio.

Con git:

git clone https://github.com/TU-USUARIO/actividad-semana-3-java-jvm.git


O descargar como .zip desde GitHub → Code → Download ZIP.

Entrar a la carpeta src:

cd src


Compilar el programa:

javac RegistroVehiculosApp.java


Ejecutar el programa:

java RegistroVehiculosApp


Se mostrará el menú principal:

===== MENÚ PRINCIPAL =====
1. Crear Usuario
2. Ingresar datos de vehículo
3. Mostrar datos de vehículo según usuario
4. Salir

📋 Funcionalidades actuales

Mostrar menú principal con 4 opciones.

Permitir crear usuario con nombre y edad.

Validar identidad del usuario antes de registrar o mostrar vehículos.

Registrar datos de un vehículo (marca, modelo, cilindrada, combustible, capacidad).

Validar entradas y reintentar en caso de error.

Listar vehículos registrados por usuario.

Controlar el flujo de ejecución (solo finaliza con la opción 4).


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

Calcular costos de despacho según reglas (futuro).

Permitir login con cuenta Gmail (futuro).

Guardar datos en archivo/BD (futuro).

Administrar múltiples usuarios (futuro).


No funcionales

Ejecutar en JVM (portabilidad).

Usar mensajes claros en español.

Evitar errores por entradas inválidas.

Documentar el código línea por línea.

Mantener trazabilidad en GitHub (README, capturas, issues, project).

Asegurar seguridad y privacidad en futuros módulos (login con Gmail, persistencia).

👤 Historias de Usuario

HU1 – Crear usuario

Como cliente, quiero registrar mi nombre y edad para poder usar el sistema.

Criterios de aceptación: El sistema valida edad > 0 y muestra confirmación.

HU2 – Registrar vehículo

Como cliente, quiero ingresar los datos de mi vehículo para que queden registrados a mi nombre.

Criterios de aceptación: Se verifican datos de usuario y se valida cada campo.

HU3 – Listar vehículos

Como cliente, quiero ver la lista de mis vehículos registrados para confirmar la información.

Criterios de aceptación: Si no hay vehículos, se informa; si existen, se muestran con el formato requerido.


🛠️ Tecnologías



Lenguaje: Java

Ejecución: Consola / JVM

Control de versiones: Git + GitHub


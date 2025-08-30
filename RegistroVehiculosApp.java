// -------------------------------------------------------------
// Archivo: RegistroVehiculosApp.java
// Propósito: Programa de consola con menú:
// 1) Crear Usuario   2) Ingresar datos de vehículo
// 3) Mostrar datos de vehículo según usuario   4) Salir
// Valida entradas, mantiene un usuario y una lista de vehículos,
// y exige que las opciones sean correctas (solo 4 finaliza).
// -------------------------------------------------------------

import java.util.ArrayList;   // ArrayList: lista dinámica para almacenar vehículos.
import java.util.List;        // List: interfaz para listas.
import java.util.Scanner;     // Scanner: lectura desde la consola (System.in).

// Clase pública principal. Debe coincidir con el nombre del archivo.
public class RegistroVehiculosApp {

    // Clase estática interna para representar al usuario (nombre + edad).
    static class Usuario {
        String nombre; // Campo para el nombre de la persona.
        int edad;      // Campo para la edad de la persona.

        // Constructor: inicializa los campos al crear un objeto Usuario.
        Usuario(String nombre, int edad) {
            this.nombre = nombre; // 'this' se refiere al campo del objeto actual.
            this.edad = edad;
        }
    }

    // Clase estática interna para representar un vehículo y sus datos.
    static class Vehiculo {
        String marca;       // Texto: marca del vehículo.
        String modelo;      // Texto: modelo del vehículo.
        int cilindrada;     // Entero: cilindrada en cc (entero positivo).
        String combustible; // Texto: tipo de combustible (por ejemplo, Gasolina).
        int capacidad;      // Entero: cantidad de pasajeros (entero positivo).

        // Constructor para inicializar un Vehiculo.
        Vehiculo(String marca, String modelo, int cilindrada, String combustible, int capacidad) {
            this.marca = marca;
            this.modelo = modelo;
            this.cilindrada = cilindrada;
            this.combustible = combustible;
            this.capacidad = capacidad;
        }
    }

    // Variables estáticas para mantener el estado global simple del programa.
    static Usuario usuarioActual = null;        // Usuario creado (o null si no existe).
    static List<Vehiculo> vehiculos = new ArrayList<>(); // Lista de vehículos del usuario.

    // Método main: punto de entrada del programa.
    public static void main(String[] args) {
        // Crea un lector para entradas desde la consola.
        Scanner sc = new Scanner(System.in);

        // Bucle infinito para mostrar el menú hasta que el usuario elija "4. Salir".
        while (true) {
            // Muestra el menú principal en consola.
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Ingresar datos de vehículo");
            System.out.println("3. Mostrar datos de vehículo según usuario");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de lo que desea realizar: ");

            // Lee la opción y valida que sea un número entero entre 1 y 4.
            int opcion = leerOpcionMenu(sc, 1, 4); // Método auxiliar que valida rango.

            // Estructura switch para ejecutar la acción elegida.
            switch (opcion) {
                case 1:
                    // Opción 1: crear usuario (pide nombre y edad, confirma y vuelve al menú).
                    crearUsuario(sc);
                    pausar(sc); // Espera Enter para que la persona lea el mensaje.
                    break;

                case 2:
                    // Opción 2: ingresar datos de vehículo (requiere usuario creado).
                    ingresarVehiculo(sc);
                    pausar(sc);
                    break;

                case 3:
                    // Opción 3: mostrar vehículos asociados al usuario verificado.
                    mostrarVehiculosPorUsuario(sc);
                    pausar(sc);
                    break;

                case 4:
                    // Opción 4: salir. Único modo de finalizar la aplicación.
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    sc.close(); // Cierra el recurso Scanner (buena práctica).
                    return;     // 'return' rompe el bucle y termina main.

                // No hace falta 'default' porque leerOpcionMenu asegura 1..4.
            }
        }
    }

    // ------------------------
    // MÉTODOS DE MENÚ / ACCIÓN
    // ------------------------

    // Opción 1: crear usuario (pide nombre y edad y lo guarda en memoria).
    static void crearUsuario(Scanner sc) {
        System.out.println("\n--- Crear Usuario ---");

        // Solicita nombre (no vacío) y edad (> 0).
        String nombre = leerTextoNoVacio(sc, "Ingrese su nombre: ");
        int edad = leerEnteroPositivo(sc, "Ingrese su edad: ");

        // Crea o reemplaza al usuario actual.
        usuarioActual = new Usuario(nombre, edad);

        // Limpia la lista de vehículos si se reemplazó el usuario (opcional).
        vehiculos.clear();

        // Mensaje de confirmación.
        System.out.println("Usuario creado correctamente: " + usuarioActual.nombre + " (" + usuarioActual.edad + " años)");
    }

    // Opción 2: ingresar un vehículo.
    static void ingresarVehiculo(Scanner sc) {
        System.out.println("\n--- Ingresar datos de vehículo ---");

        // Verifica que exista un usuario creado. Si no, ofrece volver al menú.
        if (usuarioActual == null) {
            System.out.println("No existe un usuario creado.");
            System.out.println("Presione Enter para volver al menú...");
            sc.nextLine(); // Espera a que se presione Enter.
            return;        // Vuelve al menú principal.
        }

        // Pide verificación de identidad (nombre y edad deben coincidir).
        String nombre = leerTextoNoVacio(sc, "Ingrese su nombre para continuar: ");
        int edad = leerEnteroPositivo(sc, "Ingrese su edad para continuar: ");

        // Compara con el usuario almacenado.
        if (!nombre.equals(usuarioActual.nombre) || edad != usuarioActual.edad) {
            System.out.println("Los datos no coinciden con el usuario creado.");
            System.out.println("Presione Enter para volver al menú...");
            sc.nextLine();
            return;
        }

        // Solicita los datos del vehículo con validaciones.
        String marca = leerTextoNoVacio(sc, "Ingrese la marca del vehículo: ");
        String modelo = leerTextoNoVacio(sc, "Ingrese el modelo del vehículo: ");
        int cilindrada = leerEnteroPositivo(sc, "Ingrese la cilindrada (en cc, número entero positivo): ");
        String combustible = leerTextoNoVacio(sc, "Ingrese el tipo de combustible: ");
        int capacidad = leerEnteroPositivo(sc, "Ingrese la capacidad en pasajeros (entero positivo): ");

        // Crea el vehículo y lo agrega a la lista del usuario.
        Vehiculo v = new Vehiculo(marca, modelo, cilindrada, combustible, capacidad);
        vehiculos.add(v);

        // Confirma y vuelve al menú.
        System.out.println("Vehículo ingresado correctamente.");
    }

    // Opción 3: mostrar vehículos asociados al usuario verificado.
    static void mostrarVehiculosPorUsuario(Scanner sc) {
        System.out.println("\n--- Mostrar datos de vehículo según usuario ---");

        // Verifica que exista un usuario creado.
        if (usuarioActual == null) {
            System.out.println("No existe un usuario creado.");
            System.out.println("Presione Enter para volver al menú...");
            sc.nextLine();
            return;
        }

        // Pide verificación de identidad (nombre y edad).
        String nombre = leerTextoNoVacio(sc, "Ingrese su nombre: ");
        int edad = leerEnteroPositivo(sc, "Ingrese su edad: ");

        // Valida coincidencia.
        if (!nombre.equals(usuarioActual.nombre) || edad != usuarioActual.edad) {
            System.out.println("Los datos no coinciden con el usuario creado.");
            System.out.println("Presione Enter para volver al menú...");
            sc.nextLine();
            return;
        }

        // Si hay vehículos, listarlos; si no, informar.
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados para este usuario.");
            return;
        }

        // Muestra todos los vehículos asociados.
        System.out.println("\n----- Vehículos del usuario: " + usuarioActual.nombre + " (" + usuarioActual.edad + " años) -----");
        int i = 1; // Contador para enumerar los vehículos.
        for (Vehiculo v : vehiculos) {
            System.out.println("Vehículo #" + (i++));
            System.out.println("La marca que ha ingresado es: " + v.marca);
            System.out.println("El modelo que ha ingresado es: " + v.modelo);
            System.out.println("La cilindrada que ha ingresado es: " + v.cilindrada);
            System.out.println("El tipo de combustible es: " + v.combustible);
            System.out.println("Tiene una capacidad de " + v.capacidad + " pasajeros.");
            System.out.println("---------------------------------------------");
        }
    }

    // ------------------------
    // MÉTODOS AUXILIARES (I/O)
    // ------------------------

    // Lee y valida una opción de menú entre 'min' y 'max'. Si es inválida, repite.
    static int leerOpcionMenu(Scanner sc, int min, int max) {
        while (true) { // Bucle hasta que se ingrese un valor válido.
            String linea = sc.nextLine(); // Lee la línea completa como texto.
            try {
                int valor = Integer.parseInt(linea.trim()); // Intenta convertir a entero.
                if (valor >= min && valor <= max) {
                    return valor; // Valor válido dentro del rango.
                } else {
                    System.out.print("Opción inválida. Ingrese un número entre " + min + " y " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada no numérica. Intente nuevamente (" + min + "-" + max + "): ");
            }
        }
    }

    // Lee un entero positivo (>= 1). Si es inválido, repite.
    static int leerEnteroPositivo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt); // Muestra el mensaje de solicitud.
            String linea = sc.nextLine(); // Captura lo ingresado.
            try {
                int valor = Integer.parseInt(linea.trim()); // Convierte a entero.
                if (valor > 0) { // Valida que sea positivo.
                    return valor;
                } else {
                    System.out.println("El valor debe ser un entero positivo. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido (se esperaba un número entero). Intente nuevamente.");
            }
        }
    }

    // Lee un texto no vacío (no permite cadenas en blanco).
    static String leerTextoNoVacio(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String texto = sc.nextLine(); // Toma la línea completa.
            if (texto != null && !texto.trim().isEmpty()) {
                return texto.trim(); // Devuelve el texto recortado (sin espacios extremos).
            } else {
                System.out.println("El texto no puede estar vacío. Intente nuevamente.");
            }
        }
    }

    // Pausa simple para que la persona lea la salida antes de volver al menú.
    static void pausar(Scanner sc) {
        System.out.println("\nPresione Enter para volver al menú...");
        sc.nextLine(); // Espera Enter.
    }
}

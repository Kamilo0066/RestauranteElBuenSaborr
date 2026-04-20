/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

public class RestauranteElBuenSabor {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean menuActivo = true;

    public static void main(String[] args) {
        mostrarEncabezado();

        while (menuActivo) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            procesarOpcion(opcion);
        }

        scanner.close();
    }

    private static void mostrarEncabezado() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println("========================================");
    }

    private static void mostrarMenu() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                Imprimir.mostrarCarta();
                break;

            case 2:
                agregarProducto();
                break;

            case 3:
                verPedido();
                break;

            case 4:
                generarFactura();
                break;

            case 5:
                nuevaMesa();
                break;

            case 0:
                salir();

                break;

            default:
                System.out.println("Opcion no valida.");
        }
    }

    private static void agregarProducto() {
        System.out.print("Numero de producto: ");
        int numeroProducto = scanner.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        if (numeroProducto < 1 || numeroProducto > Datos.nombresProductos.length) {
            System.out.println("Producto no valido.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad invalida.");
            return;
        }

        if (Datos.estadoMesa == 0) {
            solicitarMesa();
        }

        Datos.cantidadesProductos[numeroProducto - 1] += cantidad;

        System.out.println("Producto agregado correctamente.");
    }

    private static void solicitarMesa() {
        System.out.print("Ingrese numero de mesa: ");
        Datos.numeroMesa = scanner.nextInt();
        Datos.estadoMesa = 1;
    }

    private static void verPedido() {
        if (Utilidades.validar()) {
            Imprimir.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido.");
        }
    }

    private static void generarFactura() {
        if (Utilidades.validar()) {
            Proceso.hacerTodo();
            Imprimir.imprimirFacturaCompleta();
        } else {
            System.out.println("No hay productos para facturar.");
        }
    }

    private static void nuevaMesa() {
        Utilidades.reiniciar();
        System.out.println("Mesa reiniciada.");
    }

    private static void salir() {
        menuActivo = false;
        System.out.println("Hasta luego.");
    }
}
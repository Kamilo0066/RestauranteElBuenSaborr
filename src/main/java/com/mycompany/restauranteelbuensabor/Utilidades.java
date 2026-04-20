/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

public class Utilidades {

    public static double calcular(
            double precio,
            double cantidad,
            double descuento,
            double tasaIva,
            double tasaPropina,
            int numItems,
            boolean aplicarPropina) {

        double resultado = 0;
        double ivaCalculado = 0;
        double subtotalConDescuento = 0;

        resultado = precio * cantidad;

        if (descuento > 0) {
            resultado = resultado - (resultado * descuento);
        }

        ivaCalculado = resultado * tasaIva;
        resultado = resultado + ivaCalculado;

        if (aplicarPropina) {
            resultado = resultado + (resultado * tasaPropina);
        }

        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        subtotalConDescuento = resultado;

        return subtotalConDescuento;
    }

    public static boolean validar() {
        int contadorConProductos = 0;
        int indice = 0;

        while (indice < Datos.cantidadesProductos.length) {
            if (Datos.cantidadesProductos[indice] > 0) {
                contadorConProductos = contadorConProductos + 1;
            }
            indice++;
        }

        if (contadorConProductos == 0) {
            Datos.totalFactura = 0;
            Datos.mensajeTemporal = "";
        }

        return contadorConProductos > 0;
    }

    public static void reiniciar() {
        int indice = 0;
        while (indice < Datos.cantidadesProductos.length) {
            Datos.cantidadesProductos[indice] = 0;
            indice++;
        }
        Datos.totalFactura = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesa = 0;
        Datos.mensajeTemporal = "";
    }
}
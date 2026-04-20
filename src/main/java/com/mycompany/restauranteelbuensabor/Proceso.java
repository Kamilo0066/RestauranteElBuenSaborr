/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

public class Proceso {

    public static double hacerTodo() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double subtotalConDescuento = 0;
        int contadorItems = 0;
        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidadesProductos[indice] > 0) {
                subtotal = subtotal + Datos.preciosProductos[indice] * Datos.cantidadesProductos[indice];
                contadorItems = contadorItems + 1;
            }
            indice++;
        }

        if (contadorItems > 3) {
            if (subtotal > 0) {
                subtotalConDescuento = subtotal - (subtotal * 0.05);
                if (subtotalConDescuento > 50000) {
                    iva = subtotalConDescuento * 0.19;
                    total = subtotalConDescuento + iva;
                    total = total + (total * 0.10);
                } else {
                    iva = subtotalConDescuento * 0.19;
                    total = subtotalConDescuento + iva;
                }
            }
        } else {
            if (subtotal > 50000) {
                iva = subtotal * 0.19;
                total = subtotal + iva;
                total = total + (total * 0.10);
            } else {
                iva = subtotal * 0.19;
                total = subtotal + iva;
            }
        }

        Datos.estadoMesa = 1;
        Datos.totalFactura = total;

        return total;
    }

    public static double procesar(
            double precio,
            double cantidad,
            double descuento,
            double tasaIva,
            double tasaPropina,
            int numItems,
            boolean aplicarPropina) {

        double resultado = 0;
        double iva = 0;
        double propina = 0;
        double ivaCalculado = 0;

        resultado = precio * cantidad;

        if (descuento > 0) {
            resultado = resultado - (resultado * descuento);
        }

        iva = resultado * tasaIva;
        ivaCalculado = iva;
        resultado = resultado + ivaCalculado;

        if (aplicarPropina) {
            propina = resultado * tasaPropina;
            resultado = resultado + propina;
        }

        if (numItems > 3) {
            resultado = resultado - (resultado * 0.01);
        }

        return resultado;
    }
}
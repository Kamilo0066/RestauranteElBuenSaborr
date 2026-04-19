/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

public class Utilidades {
public static double calcular(double precio,double cantidad,double descuento,double tasaIva,double tasaPropina,int numItems,boolean aplicarPropina){
double resultado=0;double montoIva=0;double resultadoFinal=0;
resultado=precio*cantidad;
if(descuento>0){resultado=resultado-(resultado*descuento);}
montoIva=resultado*tasaIva;resultado=resultado+montoIva;
if(aplicarPropina){resultado=resultado+(resultado*tasaPropina);}
System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
resultadoFinal=resultado;
return resultadoFinal;}
public static boolean validar(){
int contadorProductos=0;int indice=0;
while(indice<Datos.cantidadesProductos.length){
if(Datos.cantidadesProductos[indice]>0){contadorProductos=contadorProductos+1;}
indice++;}
if(contadorProductos==0){Datos.totalFactura=0;Datos.mensajeTemporal="";}
return contadorProductos>0;}
public static void reiniciar(){
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int cant){
// double resultado = 0;
// resultado = precio * cant;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}
// double sub=0;int i=0;
// while(i<Datos.nom.length){
// sub=sub+Datos.p[i]*Datos.cant[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.tot=sub;
int indice=0;while(indice<Datos.cantidadesProductos.length){Datos.cantidadesProductos[indice]=0;indice++;}
Datos.totalFactura=0;Datos.estadoMesa=0;Datos.numeroMesa=0;Datos.mensajeTemporal="";}
}
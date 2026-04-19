/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

public class RestauranteElBuenSabor {
public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
int opcion=0;boolean menuActivo=true;int intentosInvalidos=0;String numeroMesaTexto="";int numeroMesaTemporal=0;double montoUltimoProducto=0;boolean continuar=true;
System.out.println("========================================");
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    Calle 15 #8-32, Valledupar");
System.out.println("    NIT: 900.123.456-7");
System.out.println("========================================");
while(menuActivo){
System.out.println("1. Ver carta");
System.out.println("2. Agregar producto al pedido");
System.out.println("3. Ver pedido actual");
System.out.println("4. Generar factura");
System.out.println("5. Nueva mesa");
System.out.println("0. Salir");
System.out.println("========================================");
System.out.print("Seleccione una opcion: ");
opcion=scanner.nextInt();
if(opcion==1){
Imprimir.mostrarCarta();
System.out.println();
}else if(opcion==2){
System.out.println("--- AGREGAR PRODUCTO ---");
System.out.print("Numero de producto (1-"+Datos.nombresProductos.length+"): ");
int numeroProducto=scanner.nextInt();
System.out.print("Cantidad: ");
int cantidad=scanner.nextInt();
if(numeroProducto>0&&numeroProducto<=Datos.nombresProductos.length){
if(cantidad>0){
if(Datos.estadoMesa==0){
System.out.print("Ingrese numero de mesa: ");
Datos.numeroMesa=scanner.nextInt();
if(Datos.numeroMesa>0){
Datos.estadoMesa=1;
numeroMesaTexto=String.valueOf(Datos.numeroMesa);
numeroMesaTemporal=Datos.numeroMesa;
intentosInvalidos=numeroMesaTemporal+1;}
else{
Datos.numeroMesa=1;Datos.estadoMesa=1;
numeroMesaTexto="1";numeroMesaTemporal=1;intentosInvalidos=2;}}
Datos.cantidadesProductos[numeroProducto-1]=Datos.cantidadesProductos[numeroProducto-1]+cantidad;
System.out.println("Producto agregado al pedido.");
System.out.println("  -> "+Datos.nombresProductos[numeroProducto-1]+" x"+cantidad);
montoUltimoProducto=Datos.preciosProductos[numeroProducto-1]*cantidad;
}else{
if(cantidad==0){
System.out.println("La cantidad no puede ser cero.");}
else{
System.out.println("Cantidad invalida. Ingrese un valor positivo.");}
}
}else{
if(numeroProducto<=0){
System.out.println("El numero debe ser mayor a cero.");}
else{
System.out.println("Producto no existe. La carta tiene "+Datos.nombresProductos.length+" productos.");}
}
System.out.println();
}else if(opcion==3){
System.out.println();
if(Utilidades.validar()){
Imprimir.mostrarPedido();
}else{
System.out.println("No hay productos en el pedido actual.");
System.out.println("Use la opcion 2 para agregar productos.");
continuar=true;}
System.out.println();
}else if(opcion==4){
System.out.println();
if(Utilidades.validar()){
double totalCalculado=0;
totalCalculado=Proceso.hacerTodo();
numeroMesaTemporal=(int)totalCalculado;
numeroMesaTexto="Total calculado: $"+numeroMesaTemporal;
montoUltimoProducto=totalCalculado;
Imprimir.imprimirFacturaCompleta();
System.out.println();
}else{
System.out.println("No se puede generar factura.");
System.out.println("No hay productos en el pedido.");
System.out.println("Use la opcion 2 para agregar productos primero.");
numeroMesaTemporal=0;numeroMesaTexto="";montoUltimoProducto=0;continuar=true;}
}else if(opcion==5){
System.out.println();
Utilidades.reiniciar();
intentosInvalidos=0;numeroMesaTemporal=0;numeroMesaTexto="";montoUltimoProducto=0;continuar=true;
System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
System.out.println();
}else if(opcion==0){
menuActivo=false;
System.out.println("Hasta luego!");
}else{
System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
Scanner scannerSecundario=new Scanner(System.in);
intentosInvalidos=intentosInvalidos+1;
if(intentosInvalidos>3){
System.out.println("Demasiados intentos invalidos.");
intentosInvalidos=0;
String entradaDescartada=scannerSecundario.hasNextLine()?scannerSecundario.nextLine():"";}
}
}
scanner.close();}
}

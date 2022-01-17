package com.mycompany.desayunosv03;

import java.util.Scanner;
import models.Producto;

public class Principal {
    
    private static DesayunosDAO dao = new DesayunosDAO();

    public static void main(String[] args) {
        
//        Producto producto1 = new Producto();
//        producto1.setNombre("Pitufo aceite");
//        producto1.setPrecio(1.8);
//        
//        Producto producto2 = new Producto();
//        producto1.setNombre("Pitufo catalana");
//        producto1.setPrecio(2.3);
//        
//        Producto producto3 = new Producto();
//        producto1.setNombre("Pitufo serrano");
//        producto1.setPrecio(2.1);
//        
//        Producto producto4 = new Producto();
//        producto1.setNombre("Pitufo queso");
//        producto1.setPrecio(1.9);
//        
//        Producto producto5 = new Producto();
//        producto1.setNombre("Tostada mantequilla");
//        producto1.setPrecio(1.8);
//        
//        dao.guardarProducto(producto1);
//        dao.guardarProducto(producto2);
//        dao.guardarProducto(producto3);
//        dao.guardarProducto(producto4);
//        dao.guardarProducto(producto5);
        
        
        Menu();
        
    }

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        System.out.println("\n--------------------------------------------------");
        System.out.println("Esta es su aplicacion para la gestion de desayunos, elija una opcion por favor: ");
        System.out.println("\n"
                + "1 - Crear un nuevo pedido \n"
                + "2 - Eliminar un pedido \n"
                + "3 - Mostrar pedidos pendientes de hoy \n"
                + "4 - Marcar un pedido como recogido \n"
                + "5 - Listar la carta \n"
                + "6 - Salir \n");
        System.out.println("--------------------------------------------------");
        eleccion = sc.nextInt();

        while (eleccion != 6) {
            switch (eleccion) {
                case 1:
                    dao.MostrarCarta().forEach(e -> System.out.println(e));
                    System.out.println("Introduzca la Id del prodcucto que desea pedir: ");
                    Long idPedir = sc.nextLong();
                    dao.guardar(idPedir);
                    break;
                case 2:
                    System.out.println("Introduzca el Id del pedido a eliminar:");
                    Long idEliminar = sc.nextLong();
                    dao.borrar(idEliminar);
                    break;
                case 3:
                    dao.MostrarPendientes().forEach(e -> System.out.println(e));
                    break;
                case 4:
                    System.out.println("Introduzca la Id del pedido que se ha recogido: ");
                    Long idRecoger = sc.nextLong();
                    dao.recoger(idRecoger);
                    break;
                case 5:
                    dao.MostrarCarta().forEach(e -> System.out.println(e));
                    break;
                case 6:
                    //No deberia entrar nunca aqui, pero me aseguro por si falla por el motivo que sea.
                    System.out.println("Espero que le haya sido de ayuda, pase un buen dia.");
                    System.exit(0);
                    break;
                default:
                    //Utilizamos el default por si alguien se equivoca al seleccionar la opcion y pide una opcion que no existe, que no se cierre el programa, ya que para eso esta su propia opcion
                    System.out.println("No existe esa opción.");
            }
            System.out.println("\n--------------------------------------------------");
            System.out.println("Esta es su aplicacion para la gestion de desayunos, elija una opcion por favor: ");
            System.out.println("\n"
                    + "1 - Crear un nuevo pedido \n"
                    + "2 - Eliminar un pedido \n"
                    + "3 - Mostrar pedidos pendientes de hoy \n"
                    + "4 - Marcar un pedido como recogido \n"
                    + "5 - Listar la carta \n"
                    + "6 - Salir \n");
            System.out.println("--------------------------------------------------");
            eleccion = sc.nextInt();
        }

    }
    
}

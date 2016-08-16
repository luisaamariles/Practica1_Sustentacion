
package tiendasoft;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luisa Maria Amariles
 */
public class TiendaSoft {

    public static void main(String[] args) {
        int opcion=0;
        int salir=0,contador_obj=0,prod_nn=0,Total_ventas=0;
        String datos;
        Pattern Patron = Pattern.compile("[^A-Za-z ]");
        Matcher Cadena;
        Scanner leer= new Scanner(System.in);
        Funciones arr_productos[] = new Funciones[3];
        int Indicador_prod = 0;
        
        do{
            
            System.out.println("Ingrese la opción que desea ejecutar");
            System.out.println("0. Salir");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Realizar venta");
            System.out.println("6. Mostrar ganancias totales");
            
            opcion=leer.nextInt();
            
            switch(opcion){
            case 0: System.out.println("Hasta luego");
            break;
            case 1:
                while(salir==0){
                    System.out.println("tam:"+arr_productos.length);
                   if(contador_obj==arr_productos.length){
                    System.out.println("No es posible ingresar mas elementos! \n");  
                    salir=1;
                   }else{
                       System.out.println("cont:"+contador_obj);
                    arr_productos[contador_obj]=new Funciones();
                    arr_productos[contador_obj].Agregar_producto();
                    contador_obj++;
                    System.out.println("Digite 0 para continuar agregando productos, de lo contrario digite 1");
                    salir=leer.nextInt();
                   }
                }                                 
            
            break;
            case 2:
                salir=0;//bandera para ingresar de nuevo a agregar productos
                prod_nn=0;
                System.out.println("Ingrese el nombre del producto que desea buscar:");
                datos=leer.next();
                Cadena = Patron.matcher(datos);//Función para encontrar la palabra en el arreglo y mirar si es valida
                while(Cadena.find()){
                        System.out.println("El nombre del producto es invalido!");
                        System.out.println("Ingrese el nombre del producto que desea buscar:");
                        datos=leer.next();
                        Cadena = Patron.matcher(datos);
                 }
                  for(int i=0; i<contador_obj; i++){
                       Indicador_prod=datos.compareTo(arr_productos[i].getProducto());//comparar los datos ingresados con los del arreglo                     
                       if(Indicador_prod==0){
                            arr_productos[i].Buscar_producto(); 
                            prod_nn=1;
                        }
                  }
                  if(prod_nn!=1){
                        System.out.println("El producto no existe \n");
                  }
                  
                  
            break;
            case 3://para dejar libre una posicion poner contador_obj-1
                salir=0;//bandera para ingresar de nuevo a agregar productos
                prod_nn=0;
                System.out.println("Ingrese el nombre del producto que desea eliminar:");
                datos=leer.next();
                Cadena = Patron.matcher(datos);//Función para encontrar la palabra en el arreglo y mirar si es valida
                while(Cadena.find()){
                        System.out.println("El nombre del producto es invalido!");
                        System.out.println("Ingrese el nombre del producto que desea eliminar:");
                        datos=leer.next();
                        Cadena = Patron.matcher(datos);
                 }
                  for(int i=0; i<contador_obj; i++){
                       Indicador_prod=datos.compareTo(arr_productos[i].getProducto());//comparar los datos ingresados con los del arreglo                     
                       if(Indicador_prod==0){
                            arr_productos[i].Eliminar_Producto(); 
                            prod_nn=1;
                        }
                  }
                  if(prod_nn!=1){
                       System.out.println("El producto no existe \n");
                  }
                  
                  
                  if(contador_obj>0){
                    contador_obj=contador_obj-1;
                  }else{
                    System.out.println("No quedan hay productos en la lista! \n"); 
                  }
          
            break;
            case 4:
                salir=0;//bandera para ingresar de nuevo a agregar productos
                for(int i=0; i<contador_obj; i++){                                   
                    arr_productos[i].Buscar_producto();                        
                }
                if(contador_obj==0){
                    System.out.println("No hay productos en la lista! \n");                 
                }
            break;
            case 5:
                salir=0;//bandera para ingresar de nuevo a agregar productos
                prod_nn=0;
                System.out.println("Ingrese el nombre del producto que desea vender:");
                datos=leer.next();
                Cadena = Patron.matcher(datos);//Función para encontrar la palabra en el arreglo y mirar si es valida
                while(Cadena.find()){
                        System.out.println("El nombre del producto es invalido!");
                        System.out.println("Ingrese el nombre del producto que desea vender:");
                        datos=leer.next();
                        Cadena = Patron.matcher(datos);
                 }
                  for(int i=0; i<contador_obj; i++){
                       Indicador_prod=datos.compareTo(arr_productos[i].getProducto());//comparar los datos ingresados con los del arreglo                     
                       if(Indicador_prod==0){
                            arr_productos[i].Realizar_ventas(); 
                            prod_nn=1;
                        }
                  }
                  if(prod_nn!=1){
                        System.out.println("El producto no existe \n");
                  }
                  if(contador_obj==0){
                    System.out.println("No hay productos en la lista! \n");                 
                 }
            
            break;
            case 6:
                salir=0;//bandera para ingresar de nuevo a agregar productos
                for(int i=0; i<contador_obj; i++){   
                    arr_productos[i].Buscar_producto();
                    arr_productos[i].Mostrar_Ganancias(); 
                     
                }
                
                if(contador_obj==0){
                    System.out.println("No hay productos en la lista! \n");                 
                }else{
                    Total_ventas=Total_ventas+arr_productos[contador_obj-1].getAcumulador();
                    System.out.println("El total de las ventas es:"+Total_ventas+" \n");
                }
            
            break;
            default: System.out.println("Opción invalida");            
            break;
            }
        }while(opcion!=0);
        
    }
    
}

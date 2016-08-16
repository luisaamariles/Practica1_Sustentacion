
package tiendasoft;

import java.util.Scanner;

/**
 *
 * @author Luisa Maria Amariles
 */
public class Funciones {
    
     Scanner leer = new Scanner(System.in);
     private String Producto; // nombre del producto
     private int Cantidad;    // cantidad del producto
     private int Valor;   
     private int Venta;
     private int Ventas_totales;
     private int copia_Cantidad;
     private int acumulador;
     

    public String getProducto() {
        return Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public int getValor() {
        return Valor;
    }

    public int getAcumulador() {
        return acumulador;
    }   
     
     public void Agregar_producto(){
        System.out.println("Ingrese el nombre del producto:");
        Producto=leer.next();
        System.out.println("Ingrese la cantidad de productos disponibles:");
        Cantidad=leer.nextInt();
        System.out.println("Ingrese el valor individual del producto:");
        Valor=leer.nextInt();
     }
     
     public void Buscar_producto(){
        System.out.println("Nombre del producto:                  "+Producto);
        System.out.println("Cantidad de productos disponibles:    "+Cantidad);
        System.out.println("Valor por unidad de producto:         $"+Valor+"\n");       
     }
     
     public void Eliminar_Producto(){
         Producto="";
         Cantidad=0;
         Valor=0;
     }
     
     public void Realizar_ventas(){
        System.out.println("Ingrese el numero de productos que desea vender:");
        Venta=leer.nextInt();
        if(Venta>Cantidad){
            System.out.println("No hay productos suficientes para la venta!!");
            Venta=0;
        }else{
            Cantidad=Cantidad-Venta;
            System.out.println("La nueva cantidad del producto "+Producto+"disponible es:"+Cantidad);
            Ventas_totales=Ventas_totales+Venta;
        }
       
     }
     
     public void Mostrar_Ganancias(){
        System.out.println("Unidades vendidas:                    "+Venta+"\n");
        acumulador=(Valor*Venta);
        System.out.println("Total de la venta:                    $"+acumulador+"\n");
        
     }
     
    /* public void Ganancias_totales(){
         System.out.println("Las ventas totales son:         $"+acumulador+"\n");
     }*/
     
}

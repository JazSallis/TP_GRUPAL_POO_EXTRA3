/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra_3;

import Entidades.Cliente;
import Servicios.ClienteService;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EXTRA_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ClienteService cs = new ClienteService();
        
       
        
        for (int i = 0; i < 2; i++) {
            
            cs.registrarCliente();
        }
        
        cs.obtenerClientes();
        
        
        
        System.out.println("Ingrese el ID del cliente a actualizar");
        int idSelec = leer.nextInt();
        
        
        for (Cliente client : cs.getListaClientes()) {
            if (idSelec == client.getId()) {
                
                
                System.out.println("Ingrese su nombre:");
                String nombreNuevo = leer.next();
                
                System.out.println("Ingrese su edad:");
                int edadNueva = leer.nextInt();
                
                System.out.println("Ingrese su altura:");
                double alturaNueva = leer.nextDouble();
                
                System.out.println("Ingrese su peso: ");
                double pesoNuevo = leer.nextDouble();
                
                System.out.println("Ingrese su objetivo:");
                String objNuevo = leer.next();
                
             
              cs.actualizarCliente(idSelec, nombreNuevo, edadNueva, alturaNueva, pesoNuevo, objNuevo);
            }
            
            
        }
        
        cs.obtenerClientes();
        
    }
    
}

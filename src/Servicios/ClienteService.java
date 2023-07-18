/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ClienteService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public ClienteService() {
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    
    
    
    
    public void registrarCliente(){
        Cliente s1 = new Cliente();
        
        
        s1.setId(listaClientes.size()+1);
        
        System.out.println("Ingrese su nombre:");
        s1.setNombre(leer.next());
        
        System.out.println("Ingrese su edad:");
        s1.setEdad(leer.nextInt());
        
        System.out.println("Ingrese su altura:");
        s1.setAltura(leer.nextDouble());
        
        System.out.println("Ingrese su peso: ");
        s1.setPeso(leer.nextDouble());
        
        System.out.println("Ingrese su objetivo:");
        s1.setObjetivo(leer.next());
        
        listaClientes.add(s1);
        
    }
    
    public void obtenerClientes(){
         
        for(Cliente clien : listaClientes){
            System.out.println(clien.toString());
        }
        
    }
    
    public void actualizarCliente(int id, String nombre, int edad, double altura, double peso, String objetivo){
        
        listaClientes.get(id-1).setNombre(nombre);
        listaClientes.get(id-1).setEdad(edad);
        listaClientes.get(id-1).setAltura(altura);
        listaClientes.get(id-1).setPeso(peso);
        listaClientes.get(id-1).setObjetivo(objetivo);
        
    }
    
}

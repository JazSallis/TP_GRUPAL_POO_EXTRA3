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

//Constructor, getter y setter del atributo ArrayList
    public ClienteService() {
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    //Metodos de cliente
    public void registrarCliente() {

        System.out.println("");

        Cliente s1 = new Cliente();

        if (listaClientes.isEmpty()) {
            s1.setId(listaClientes.size() + 1);
        } else {
            s1.setId((listaClientes.get(listaClientes.size() - 1).getId()) + 1);
        }

        System.out.println("Ingrese su nombre:");
        s1.setNombre(leer.next());

        System.out.println("Ingrese su edad:");
        s1.setEdad(leer.nextInt());

        System.out.println("Ingrese su altura en metros:");
        s1.setAltura(leer.nextDouble());

        System.out.println("Ingrese su peso en kg: ");
        s1.setPeso(leer.nextDouble());

        System.out.println("Ingrese su objetivo:");
        s1.setObjetivo(leer.next());

        listaClientes.add(s1);

        System.out.println("Se registró con éxito al cliente " + s1.getNombre() + " con el identificador (ID) número " + s1.getId());

        System.out.println("");

    }

    public void obtenerClientes() {

        System.out.println("");
        for (Cliente clien : listaClientes) {
            System.out.println(clien.toString());

        }
        System.out.println("");

    }

    public void actualizarCliente(int id, String nombre, int edad, double altura, double peso, String objetivo) {

        System.out.println("");

        for (Cliente clien : listaClientes) {
            if (clien.getId() == id) {
                listaClientes.get(id - 1).setNombre(nombre);
                listaClientes.get(id - 1).setEdad(edad);
                listaClientes.get(id - 1).setAltura(altura);
                listaClientes.get(id - 1).setPeso(peso);
                listaClientes.get(id - 1).setObjetivo(objetivo);
            }
        }

        System.out.println("");
    }

    public void eliminarCliente(int id) {
        
        for (Cliente clien : listaClientes){
            if (clien.getId() == id) {
                listaClientes.remove(clien);
            }
        }
        
    }

}

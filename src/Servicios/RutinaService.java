/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Rutina;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class RutinaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Rutina> listaRutinas = new ArrayList<Rutina>();

    //constructor getter y setter del array list
    public RutinaService() {
    }

    public ArrayList<Rutina> getListaRutinas() {
        return listaRutinas;
    }

    public void setListaRutinas(ArrayList<Rutina> listaRutinas) {
        this.listaRutinas = listaRutinas;
    }

    //metodos de rutina
    public void crearRutina(Rutina rutina) {
        listaRutinas.add(rutina);
    }

    public void obtenerRutinas() {
        System.out.println("");
        for (Rutina rut : listaRutinas) {
            System.out.println(rut.toString());

        }
        System.out.println("");
    }

    public void actualizarRutina(int id, String nombre, int duracion, String nivelDificultad, String descripcion) {

        for (Rutina rut : listaRutinas) {
            if (rut.getId() == id) {
                listaRutinas.get(id - 1).setNombre(nombre);
                listaRutinas.get(id - 1).setDuracion(duracion);
                listaRutinas.get(id - 1).setNivelDificultad(nivelDificultad);
                listaRutinas.get(id - 1).setDescripcion(descripcion);
            }
        }

    }
    
    public void eliminarRutina(int id){
        
         for (Rutina rut : listaRutinas) {
              if (rut.getId() == id) {
                  listaRutinas.remove(rut);
              }
         }
    }

}

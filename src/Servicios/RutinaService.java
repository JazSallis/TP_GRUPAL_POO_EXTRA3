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
    private ArrayList<Rutina> listaRutinas = new ArrayList<>();

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
        listaRutinas.forEach((rut) -> {
            System.out.println(rut.toString());
        });
        System.out.println("");
    }

    public void actualizarRutina(int id, String nombre, int duracion, String nivelDificultad, String descripcion) {

        listaRutinas.stream().filter((rut) -> (rut.getId() == id)).map((_item) -> {
            listaRutinas.get(id - 1).setNombre(nombre);
            return _item;
        }).map((_item) -> {
            listaRutinas.get(id - 1).setDuracion(duracion);
            return _item;
        }).map((_item) -> {
            listaRutinas.get(id - 1).setNivelDificultad(nivelDificultad);
            return _item;
        }).forEachOrdered((_item) -> {
            listaRutinas.get(id - 1).setDescripcion(descripcion);
        });

    }
    
    public void eliminarRutina(int id){
        
        listaRutinas.stream().filter((rut) -> (rut.getId() == id)).forEachOrdered((rut) -> {
            listaRutinas.remove(rut);
        });
    }

}

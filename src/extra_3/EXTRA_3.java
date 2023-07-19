/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra_3;

import Entidades.Cliente;
import Entidades.Rutina;
import Servicios.ClienteService;
import Servicios.RutinaService;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EXTRA_3 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ClienteService cs = new ClienteService();
        RutinaService rs = new RutinaService();
        int menuSelec = 100;
        int menuClientSelec = 100;
        int menuRutinaSelec = 100;

//        for (int i = 0; i < 2; i++) {
//
//            cs.registrarCliente();
//        }
//
//        cs.obtenerClientes();
        System.out.println("Bienvenidxs al menú de opciones del GYM más canchero");

        do {

            System.out.println("Presione 1 para ver el menú de clientes");
            System.out.println("Presione 2 para ver el menú de rutinas");
            System.out.println("Presione 0 para salir del sistema");
            menuSelec = leer.nextInt();

            switch (menuSelec) {
                case 1:
                    do {
                        System.out.println("Presione 1 para registrar un cliente");
                        System.out.println("Presione 2 para ver los datos de todos los clientes");
                        System.out.println("Presione 3 para actualizar los datos de un cliente con su número de ID");
                        System.out.println("Presione 4 para eliminar un cliente por su número de ID");
                        System.out.println("Presione 5 para volver al menú anterior");
                        
                        menuClientSelec = leer.nextInt();

                        switch (menuClientSelec) {
                            case 1:
                                cs.registrarCliente();
                                break;
                            case 2:
                                cs.obtenerClientes();
                                break;
                            case 3:
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
                                        break;
                                    }

                                }
                            case 4:
                                System.out.println("Ingrese el número de ID del cliente que desea eliminar");
                                int idDelete = leer.nextInt();
                                System.out.println("Seleccionó el número" + idDelete + ". Es correcto?");
                                System.out.println("1 - Si");
                                System.out.println("2 - No");
                                int DeleteSelect = leer.nextInt();
                                if (DeleteSelect == 1) {
                                    cs.eliminarCliente(idDelete);
                                    System.out.println("Cliente eliminado.");
                                    System.out.println("");
                                }
                                break;
                            case 5:
                                break;
                           
                            default:
                                System.out.println("La opción ingresada no es válida.");
                                break;
                        }

                    } while (menuClientSelec != 0 && menuClientSelec != 5);
                    break;

                case 2:
                    
                    do{
                        
                   
                    System.out.println("Presione 1 para crear una rutina");
                    System.out.println("Presione 2 para visualizar todas las rutinas");
                    System.out.println("Presione 3 para actualizar una rutina segun su ID");
                    System.out.println("Presione 4 para eliminar una rutina");
                    System.out.println("Presione 5 para volver al menú anterior");
    
                    menuRutinaSelec = leer.nextInt();

                    switch (menuRutinaSelec) {

                        case 1:
                            Rutina r1 = new Rutina();

                            if (rs.getListaRutinas().isEmpty()) {
                                r1.setId(rs.getListaRutinas().size() + 1);
                            } else {
                                r1.setId((rs.getListaRutinas().get(rs.getListaRutinas().size() - 1).getId()) + 1);
                            }

                            System.out.println("Ingrese el nombre de la rutina");
                            r1.setNombre(leer.next());

                            System.out.println("Ingrese la duración de la rutina en minutos");
                            r1.setDuracion(leer.nextInt());

                            String dificultadSelec = "";

                            do {
                                System.out.println("Ingrese el nivel de dificultad (bajo / medio / alto ) ");
                                dificultadSelec = leer.next().toLowerCase();

                                if ((dificultadSelec.equals("bajo")) || (dificultadSelec.equals("medio")) || (dificultadSelec.equals("alto"))) {
                                    r1.setNivelDificultad(dificultadSelec);
                                } else {
                                    System.out.println("La dificultad ingresada no es válida.");
                                }

                            } while ((!dificultadSelec.equals("bajo")) && (!dificultadSelec.equals("medio")) && (!dificultadSelec.equals("alto")));

                            System.out.println("Ingrese la descripción de la rutina");
                            r1.setDescripcion(leer.next());

                            rs.crearRutina(r1);
                            
                            System.out.println("Se creó exitosamente la rutina " + r1.getNombre());

                            break;

                        case 2:
                            rs.obtenerRutinas();
                            break;

                        case 3:
                            System.out.println("Ingrese el ID de la rutina a actualizar");
                            int idSelec = leer.nextInt();

                            for (Rutina rut : rs.getListaRutinas()) {
                                if (idSelec == rut.getId()) {

                                    System.out.println("Ingrese el nuevo nombre de la rutina:");
                                    String nombreNuevo = leer.next();

                                    System.out.println("Ingrese la nueva duración de la rutina:");
                                    int duracionNueva = leer.nextInt();

                                    String dificultadSelec1 = "";
                                    String dificultadNueva = "";
                                    do {
                                        System.out.println("Ingrese el nuevo nivel de dificultad (bajo / medio / alto ) ");
                                        dificultadSelec1 = leer.next().toLowerCase();

                                        if ((dificultadSelec1.equals("bajo")) || (dificultadSelec1.equals("medio")) || (dificultadSelec1.equals("alto"))) {
                                            dificultadNueva = dificultadSelec1;
                                        } else {
                                            System.out.println("La dificultad ingresada no es válida.");
                                        }

                                    } while ((!dificultadSelec1.equals("bajo")) && (!dificultadSelec1.equals("medio")) && (!dificultadSelec1.equals("alto")));

                                    System.out.println("Ingrese la nueva descripcion de la rutina:");
                                    String descripcionNueva = leer.next();

                                    rs.actualizarRutina(idSelec, nombreNuevo, duracionNueva, dificultadNueva, descripcionNueva);
                                    break;
                                }
                            }

                        case 4:
                             System.out.println("Ingrese el número de ID de la rutina que desea eliminar");
                                int idDelete = leer.nextInt();
                                System.out.println("Seleccionó el número" + idDelete + ". Es correcto?");
                                System.out.println("1 - Si");
                                System.out.println("2 - No");
                                int DeleteSelect = leer.nextInt();
                                if (DeleteSelect == 1) {
                                    rs.eliminarRutina(idDelete);
                                    System.out.println("Rutina eliminada.");
                                    System.out.println("");
                                }
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("La opción ingresada no es válida.");
                            break;
                    }
                     }while(menuRutinaSelec != 5);
                    
                case 0:
                     System.out.println("Gracias por utilizar nuestros servicios!");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida.");
                    break;
            }

        } while (menuSelec != 0 );
    }

}

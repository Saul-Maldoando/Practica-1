//Equipo Dinamita papá
//Saúl Maldonado Navarro
//Francisco Olvera Hernández
//Gerardo Miguel Quechol Zarate
//Franco Stiven Sosa Luria
//Elías Rodríguez Chimal

import java.util.*;
import java.io.*;

public class EjemploPersona{
      public static int id	= 100;
	    public static void main(String args[]){
	    Scanner sc = new Scanner(System.in);

    RegistroPersona Registro = new RegistroPersona();
	int op;

		do{

            System.out.println("\n");
            System.out.println("\n\tEstructuras de Datos\t");
            System.out.println("\n1.Registrar Persona.");
            System.out.println("\n2.Listar Personas Creadas.");
            System.out.println("\n3.Mostrar Datos de una Persona por ID.");
            //System.out.println("\n4.Borrar Persona.");
            System.out.println("\n4.Cargar Registro desde archivo.");
            System.out.println("\n0.Salir.");
			System.out.print("\nOpcion: ");
			op = sc.nextInt();
            System.out.println("\n----------------------------------------------------\n");

			switch(op){


				case 1:
        System.out.println("\n----------------------------------------------------\n");
	     	System.out.println("Ingrese los datos:");
	     	System.out.print("Nombre:");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.print("Direccion:");
        String direccion = sc.nextLine();
        System.out.print("Telefono:");
        String telefono = sc.nextLine();
        System.out.print("Genero:");
        String genero = sc.nextLine();
        id++;
        Persona sujeto = new Persona(nombre,direccion,telefono,genero,id);
        Registro.GuardarPersona(sujeto);
        Registro.EscribirArchivo(sujeto);
				break;

        case 2:
				Registro.ListarPersonas();
				break;

        case 3:
				System.out.print("\nIngrese el ID de la Persona a buscar: ");
				int s=sc.nextInt();
				Registro.BusquedaID(s);
				break;

				/*case 5:
			  System.out.print("\nIngrese el ID de la Persona a Borrar: ");
				int x=sc.nextInt();
				Registro.BorrarPersona(x);
				break;
        */

        case 4:
        Registro.importar(id);
			  System.out.print("\n¡Hecho!\n");
        break;


				case 0:
			 System.out.println("\n-------------------");
			 System.out.println("|||| Buen Dia. ||||");
			 System.out.println("-------------------\n\n");
				break;


                 default:
			 System.out.println("\n---------------------------------");
			 System.out.println("|||| ERROR - Opcion invalida ||||");
			 System.out.println("---------------------------------\n\n");
			}
		}while(op!=0);
	}
}

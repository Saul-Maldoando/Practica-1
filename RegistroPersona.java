import java.lang.*;
import java.io.*;

class RegistroPersona{
static String s = "Personas.txt";
static DataOutputStream escribir;
static DataInputStream leer;
Persona [] PersonaData;

public RegistroPersona(){
}

public static void CrearArchivo(/*String s*/){
  try{
    escribir=new DataOutputStream(new FileOutputStream(s));
  }
  catch(IOException e){
    System.err.println("No se encontro el archivo"+e.toString());
  }
}


public static void AbrirArchivo(/*String s*/){
  try{
    leer=new DataInputStream(new FileInputStream(s));
  }
  catch(IOException e){
    System.err.println("No se encontro el archivo"+e.toString());
  }
}

public void EscribirArchivo(Persona amigx/*, int n*/){
//  String cadena = String.valueOf(n);
//  String filename = "Persona"+cadena+".txt";
  CrearArchivo(/*filename*/);
  try{
  escribir.writeUTF(amigx.nombre);
  escribir.writeUTF(amigx.direccion);
  escribir.writeUTF(amigx.telefono);
  escribir.writeUTF(amigx.genero);
  escribir.writeUTF("\n");
  escribir.close();
  }catch(IOException e){}
}



public void importar(int id){
  try{
    //String cadena = String.valueOf(id);
    //String filename1 = "Persona"+cadena+".txt";
    AbrirArchivo();
    String nombre1=leer.readUTF();
    String direccion1=leer.readUTF();
    String telefono1=leer.readUTF();
    String genero1=leer.readUTF();
    id++;
    Persona sujeto2 = new Persona(nombre1,direccion1,telefono1,genero1,id);
    GuardarPersona(sujeto2);
    leer.close();

  }catch(IOException e){System.err.println("No se encontro el archivo"+e.toString());}
}


public void GuardarPersona(Persona fig){
        int i;
        if(PersonaData!=null){
			Persona[] Figaux = new Persona[(PersonaData.length+1)];
            for(i=0;i<PersonaData.length;i++)
                Figaux[i]=PersonaData[i];
            Figaux[i]=fig;
            PersonaData=Figaux;
        }else{
            Persona[] Figaux = new Persona[1];
            Figaux[0]= fig;
            PersonaData=Figaux;
        }
    }

public void ListarPersonas(){
		int i;
		String b="borrado";
        if(PersonaData!=null){
			System.out.println("\nPersonas Guardadas: \n");
            for(i=0;i<PersonaData.length;i++){
            if (PersonaData[i].nombre.compareTo(b) != 0){
                Persona Figaux;
				Figaux = PersonaData[i];
				Figaux.mostrar();
			   }
            }
        }else System.out.print("No hay Personas Guardadas.");
	}

public void BusquedaID(int id){
		String b="borrado";
		int i;
		int id2;
		boolean ban = false;

        if(PersonaData!=null){
            for(i=0;i<PersonaData.length;i++){

				id2=PersonaData[i].id;

				if(id == id2){
            if (PersonaData[i].nombre.compareTo(b) == 0){
            System.out.println("No hay Personas Guardadas con el ID: "+id);
            }
        else{
					ban = true;
					PersonaData[i].mostrar();
					System.out.println("\n");
        }
				}

            }
			if(ban==false){
             System.out.println("No hay Personas Guardadas con el ID: "+id);
			}

        }else System.out.print("No hay Personas Guardadas con el ID: "+id);
}

public void BorrarPersona(int id){

		int i;
		int id2;

        if(PersonaData!=null){
            for(i=0;i<PersonaData.length;i++){

				id2=PersonaData[i].id;

				if(id == id2){
					PersonaData[i].nombre="borrado";
          id2 = (id2-1);
					PersonaData[i].id=id2;
					System.out.println("\n");
				}

            }
        }else System.out.print("No hay Personas Guardadas con el ID: "+id);
}



}

public class Persona {

	public String nombre;
	public String direccion;
	public String telefono;
	public String genero;
	public int id;

	public Persona(String nombre, String direccion, String telefono, String genero,int id){
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
		this.genero=genero;
		this.id=id;
	}

	public void mostrar(){
		System.out.println("ID: "+id);
		System.out.println("Nombre: "+nombre);
		System.out.println("Genero: "+telefono);
		System.out.println("Direccion: "+direccion);
		System.out.println("Telefono: "+telefono);
	}
}

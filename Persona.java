
    public class Persona {

    //DECLARACION DE LOS ATRIBUTOS DE CLASE
    String nombre;
    int edad;
    String direccion;

    //CONSTRUCTORES
    /**
     * Constructor por defecto.
     */
    Persona(){
        //constructor vacio.
    }

    /**
     * Este constructor se encarga de inicializar los atributos
     * @param nombre indica el nombre de la persona.
     * @param edad indica la edad de la persona.
     * @param direccion indica la dirección de la persona.
     */
    Persona(String nombre, int edad, String direccion){
        this.nombre = nombre;
        this.edad=edad;
        this.direccion=direccion;
    }

    //METODOS SET Y GET PARA LOS ATRIBUTOS.
    /**
     * Metodo para devolver el nombre de la persona.
     * @return devuelve el nombre de la persona (un String)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para devolver la edad de la persona.
     * @return devuelve la edad de la persona (un numero entero)
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo para devolver la dirección de la persona.
     * @return devuelve la dirección de la persona (un String)
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para establecer el nombre de la persona.
     * @param nombre que se le asignara a la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para establecer la edad de la persona.
     * @param edad que se le asignara a la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo para establecer la direccion de vivienda de la persona.
     * @param direccion que se le asignara a la persona.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}

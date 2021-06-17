import java.util.ArrayList;

/**
 * Esta clase contiene los atributos y metodos de un Movimiento de una cuenta bancaria.
 * @author Sergio Manuel Andujar
 * @version
 */
class Movimiento{

    //DECLARACION DE LOS ATRIBUTOS DE CLASE
    double cantidad;
    String concepto;

    //CONSTRUCTOR
    /**
     * Constructor de la clase que inicializa los atributos.
     * @param pconcepto corresponde al concepto de dicho movimiento.
     * @param pcantidad corresponde a la cantidad con la que vamos a operar.
     */
    Movimiento(String pconcepto, double pcantidad){
        this.concepto=pconcepto;
        this.cantidad=pcantidad;
    }

    //METODOS SET Y GET PARA LOS ATRIBUTOS.
    /**
     * Metodo para devolver la cantidad de dinero de dicho movimiento.
     * @return devuelve la cantidad del movimiento.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Metodo para devolver el concepto de dicho movimiento.
     * @return devuelve el concepto del movimiento.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Metodo para establecer la cantidad del movimiento a realizar.
     * @param cantidad que se le asignara al movimiento.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Metodo para establecer el concepto del movimiento.
     * @param concepto que se le asignara al movimiento.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}


enum TiposEstado{OPERATIVA, CERRADA, INMOVILIZADA, NUMEROS_ROJOS;}

/**
 * Esta clase contiene los atributos y metodos de una cuenta bancaria.
 * @author Sergio Manuel Andujar
 * @version
 */
public class Cuenta {

    //DECLARACION DE LOS ATRIBUTOS DE CLASE
    private final Persona titular;
    private ArrayList<Persona> cotitulares; //Array que contiene los cotitulares de las personas la cuenta.
    private double saldo;
    private int codigo;
    private static int ultimoCodigo = 0;
    private TiposEstado estado;
    private Movimiento[] ultimasOperaciones; //Array que contiene las ultimas operaciones realizadas en la cuenta.
    private final static int numOperaciones=20;
    private int indice=0;


    //CONSTRUCTORES
    /**
     * Establece que cada titular tenga por defecto de saldo 100.
     * @param titular de la cuenta de tipo (Persona<nombre de la clase>).
     */
    Cuenta(Persona titular){
        this(titular, 100.0);
    }

    /**
     * Constructor que asigna el estado de la cuenta como operativa por defecto.
     * Inicializa el titular, el saldo y el array ultimasOperaciones de 20 operaciones.
     * @param titular corresponde al titular con saldo 100.
     * @param saldo corresponde al saldo de la cuenta.
     */
    Cuenta(Persona titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
        codigo = getCodigoCuenta(); // ??????????????????????????????
        this.estado = TiposEstado.OPERATIVA;
        ultimasOperaciones=new Movimiento[numOperaciones];
    }

    /**
     * Constructor para la serie de cotitulares,
     * Inicializa el array de cotitulares.
     * @param titular corresponde al titular con saldo 100.
     * @param cotitular corresponde a los cotitulares que añade al array con la estructura for
     *  y el metodo add(añadir).
     */
    Cuenta(Persona titular, Persona... cotitular){
        this(titular, 100.0);
        cotitulares = new ArrayList<Persona>();
        for(int i=0;i<cotitular.length;i++){
            cotitulares.add(cotitular[i]);
        }
    }

    /**
     * Este metodo get se hará privado para que no pueda ser accesible desde fuera,
     * a no ser que se cree un objeto.
     * @return incrementa el ultimo codigo de la cuenta.
     * */
    private int getCodigoCuenta(){
        return ++ultimoCodigo;
    }


    //METODOS SET Y GET PARA LOS ATRIBUTOS.
    /**
     * Metodo para devolver las ultimas operaciones de la cuenta.
     * @return devuelve las ultimas operaciones de la cuenta.
     */
    public Movimiento[] getUltimasOperaciones() {
        return ultimasOperaciones;
    }

    /**
     * Metodo para devolver el estado de la cuenta.
     * @return devuelve el estado de la cuenta.
     */
    public TiposEstado getEstado() {
        return estado;
    }

    /**
     * Metodo para establecer el estado de la cuenta.
     * @param estado que se le asignara a la cuenta.
     */
    public void setEstado(TiposEstado estado) {
        this.estado = estado;
    }

    /**
     * Metodo para devolver el titular de la cuenta.
     * @return devuelve el titular de la cuenta.
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * Metodo para devolver el saldo de la cuenta.
     * @return devuelve el saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Metodo para devolver el codigo de la cuenta.
     * @return devuelve el codigo de la cuenta.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo para devolver el ultimo codigo de la cuenta.
     * @return devuelve el ultimo codigo de la cuenta.
     */
    public static int getUltimoCodigo() {
        return ultimoCodigo;
    }

    /**
     * Metodo para establecer el saldo de la cuenta.
     * @param saldo que se le asignara a la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo para establecer el ultimo codigo de la cuenta.
     * @param ultimoCodigo que se le asignara a la cuenta.
     */
    public static void setUltimoCodigo(int ultimoCodigo) {
        Cuenta.ultimoCodigo = ultimoCodigo;
    }

    /**
     * Metodo para devolver los cotitulares de la cuenta de una persona.
     * @return devuelve los cotitulares de la cuenta.
     */
    public ArrayList<Persona> getCotitulares() {
        return cotitulares;
    }

    /**
     * Metodo para devolver la posición del cotitular en la lista de cotitulares.
     * @return devuelve la posición del cotitular.
     */
    public Persona getCotitulares(int posicion) {
        return cotitulares.get(posicion);
    }

    /**
     * Metodo que establece varios cotitulares.
     * @param cotitulares corresponde a los cotitulares del array.
     */
    public void setCotitulares(ArrayList<Persona> cotitulares) {
        this.cotitulares = cotitulares;
    }

    /**
     * Metodo que establece un cotitular.
     * @param cotitular corresponde al cotitular que se va a añadir al array cotitulares.
     * Se añade con el metodo add.
     */
    public void setCotitular(Persona cotitular){
        cotitulares.add(cotitular);
    }

    /**
     *Metodo que añade una lista de cotitulares al array cotitulares.
     * @param cot corresponde a la lista de cotitulares que se añaden al array cotitulares
     * con la estructura for.
     */
    public void addCotitulares(Persona... cot){
        for(int i=0;i<cot.length;i++){
            cotitulares.add(cot[i]);
        }
    }


    /**
     * Metodo toString para la clase Cuenta
     * @return Devuelve una concatenacion del nombre del titular, el saldo y el codigo de la cuenta.
     */
    @Override
    public String toString(){
        return "Nombre titular "+titular.getNombre()+" Saldo "+saldo+" Códig cuenta "+codigo;
    }


    //SE PRODUCE UNA SOBRECARGA DEL METODO REINTEGRO E INGRESO
    /**
     *
     * @param concepto
     * @param cantidad
     */
    public void reintegro (String concepto, double cantidad){
        if(this.saldo>cantidad){
            this.saldo = this.saldo - cantidad; // resta una cantidad al valor del saldo
            if(indice>=numOperaciones){
                indice=0;
            }
            ultimasOperaciones[indice++] = new Movimiento(concepto, cantidad*(-1));
        }

    }

    public void reintegro (double cantidad){
        if(this.saldo>cantidad){
            this.saldo = this.saldo - cantidad;
            if(indice>=numOperaciones){
                indice=0;
            }
            ultimasOperaciones[indice++] = new Movimiento("Reintegro en cuenta", cantidad*(-1));
        }

    }

    public void reintegro (String concepto,double... cantidad){
        for(int i=0;i<cantidad.length;i++){
            if(this.saldo>cantidad[i]){
                this.saldo = this.saldo - cantidad[i];
                if(indice>=numOperaciones){
                    indice=0;
                }
                ultimasOperaciones[indice++] = new Movimiento (concepto, cantidad[i]*(-1));
            }
        }

    }

    public void reintegro (double... cantidad){
        for(int i=0;i<cantidad.length;i++){
            if(this.saldo>cantidad[i]){
                this.saldo = this.saldo - cantidad[i];
                if(indice>=numOperaciones){
                    indice=0;
                }
                ultimasOperaciones[indice++] = new Movimiento ("Reintegro en cuenta", cantidad[i]*(-1));
            }
        }

    }

    public void ingreso (double cantidad){
        this.saldo = this.saldo + cantidad;
        if(indice>=numOperaciones){
            indice=0;
        }
        ultimasOperaciones[indice++] = new Movimiento("Ingreso en cuenta", cantidad);


    }

    public void ingreso (String concepto, double cantidad){
        this.saldo = this.saldo + cantidad;
        if(indice>=numOperaciones){
            indice=0;
        }
        ultimasOperaciones[indice++] = new Movimiento(concepto, cantidad);


    }

    public void ingreso (double... cantidad){
        for(int i=0;i<cantidad.length;i++){
            this.saldo = this.saldo + cantidad[i];
            if(indice>=numOperaciones){
                indice=0;
            }
            ultimasOperaciones[indice++] = new Movimiento("Ingreso en cuenta",cantidad[i]);
        }

    }

    public void ingreso (String concepto, double... cantidad){
        for(int i=0;i<cantidad.length;i++){
            this.saldo = this.saldo + cantidad[i];
            if(indice>=numOperaciones){
                indice=0;
            }
            ultimasOperaciones[indice++] = new Movimiento(concepto,cantidad[i]);
        }

    }

}

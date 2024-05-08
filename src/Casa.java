public class Casa {
    String poblacion;
    String direccion;
    int numHabitacion;
    double preciopordia;
    String codigo;
    boolean esAlta;

    public Casa(String poblacion, String direccion, int numHabitacion, double preciopordia, String codigo){
        this.esAlta=true;
        this.codigo=codigo;
        this.direccion=direccion;
        this.numHabitacion=numHabitacion;
        this.poblacion=poblacion;
        this.preciopordia=preciopordia;
    }

    
}

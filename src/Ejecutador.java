import java.util.Scanner;
public class Ejecutador {
    /* 
     
A continuación se implementa una tabla dispersa para almacenar un conjunto de elementos:
Casas Rurales de la comarca La Alcarria. La resolución de colisiones se realiza formando una
secuencia de posiciones aplicando el método de exploración cuadrática.
Los elementos de la tabla son objetos con los siguientes datos: población, dirección,

numHabitacion, precio por día y código de identificación. El código, normalmente 5 carac-
teres, tiene una relación biunívoca con la Casa Rural; por ello, se elige como campo clave.

Los campos población y dirección son de tipo cadena; y numHabitacion, precio de tipo int
y double respectivamente.

La clase TablaDispersa consta de un array de referencias a los objetos CasaRural. El tama-
ño de la tabla está en función del número de Casas conocido, 50. Entonces, el tamaño elegido es el

número primo 101. Cada posición de la tabla contiene null o bien la referencia a un objeto Casa
Rural. Se ha tomado la decisión de que los elementos dados de baja permanezcan en la tabla (para
no perder información histórica); por ello, se añade el atributo esAlta, que si está activo (true)
indica que es un alta; en caso contrario (false) se dio de baja. El número de elementos que hay
en la tabla, incluyendo las bajas, se almacena en la variable numElementos; además, se añade la
variable factorCarga, de tal forma que cuando se alcance el 0.5 se pueda generar un aviso. */
    static public void ingresarDatos (Tablahash tabla, Scanner ingreso){
        String codigo, poblacion, direccion;
        double precio, codigoDescifrado;
        int numHabitacion, indicehash;
        System.out.println("Ingrese el codigo de la casa (Dato unívoco)");
        codigo=ingreso.nextLine();

        System.out.println("Ingrese la población de la casa");
        poblacion=ingreso.nextLine();

        System.out.println("Ingrese la direccion de la casa");
        direccion=ingreso.nextLine();

        System.out.println("Ingrese el precio por dia de la casa");
        precio=ingreso.nextDouble();

        System.out.println("Ingrese la cantidad de habitaciones de la casa");
        numHabitacion=ingreso.nextInt();

        Dispersion d = new Dispersion();  

        codigoDescifrado= d.descifrarClave(codigo);

        indicehash= d.dispersar(codigoDescifrado, tabla.M);

        indicehash= tabla.solucionarColision(codigo, indicehash);

        Casa instanciaCasa = new Casa(poblacion, direccion, numHabitacion, precio, codigo);

        tabla.insertar(instanciaCasa, indicehash);
    }
    static public void mostrarMenu(){
        System.out.println("MENU DEL PROGRAMA\n 1. Insertar una casa\n 2. Eliminar una casa\n 3. Mostrar una casa\n 4. Salir");
    }
    
    static public void darDeBaja (Tablahash tabla, Scanner ingreso){
        String clave;
        double clavedescifrada;
        int hasheo;
        System.out.println("Ingrese el código de la casa que quiere dar de baja");
        clave= ingreso.nextLine();
        Dispersion d = new Dispersion();  
        clavedescifrada= d.descifrarClave(clave);
        hasheo=d.dispersar(clavedescifrada, tabla.M);
        tabla.eliminar(hasheo);
    }

public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Tablahash tabla= new Tablahash();
        String menu="0";
        while (!menu.equals("4")){
            mostrarMenu();
            menu = teclado.nextLine();
            switch (menu){
                case "1":
                    ingresarDatos(tabla, teclado);
                    break;
                case "2":
                    darDeBaja(tabla, teclado);
                break;
                case "3":
                    tabla.mostrar();
                break;
                case "4":
                    System.out.println("FIN DEL PROGRAMA");
                break;
                default:
                break;
            }
        }
    }
}

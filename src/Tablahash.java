public class Tablahash {
    Casa[] tabla;
    int M;
    int numElementos;
    double factorCarga;

    public Tablahash (){
        this.M=101;
        tabla= new Casa[M];
        for (int i=0; i<tabla.length;i++){
            tabla[i]= null;
        }
        this.numElementos=0;
        this.factorCarga=0;
    }
    public boolean revisarCodigo(String codigo){
        Dispersion disper = new Dispersion();
        double codigoDescifrado= disper.descifrarClave(codigo);
        int indiceHash= disper.dispersar(codigoDescifrado, M);
        if (tabla[indiceHash]== null){
            return true;
        }
        else{
            if(tabla[indiceHash].codigo.equals(codigo)){
                System.out.println("El codigo ingresado está en uso");
                return false;
            }
        }
        return true;
    }
    public int solucionarColision(String codigoAsolucionar, int indice){
        int i=0;
        while (tabla[indice]!= null &&(tabla[indice].codigo.equals(codigoAsolucionar))){
            i++;
            indice = indice + i*i;
        indice = indice % M; // considera el array como circular
        }
        if(i==0){
            System.out.println("No hubo colisiones");
        }
        else{
            System.out.println ("Hubo colision, nuevo hash: " + indice);
        }
        return indice;
    }

    public void insertar(Casa r, int posicion){
        tabla[posicion]=r;
        numElementos++;
        factorCarga= (double) numElementos/M;
        if (factorCarga > 0.5){
            System.out.println("!! Factor de carga supera el 50%.!!\n Conviene aumentar el tamaño." );
        }
    }

    public void eliminar(int i){
        if(tabla[i].esAlta==true){
            tabla[i].esAlta=false;
            System.out.println("Se ha podido dar de baja la casa con éxito.");
        }
        else{
            System.out.println("No se ha podido dar de baja la casa.");
        }
    }
    public void mostrar(){
        int band=1;
        for(int i=0; i<M; i++){
            if(tabla[i]!=null){
                band=0;
                System.out.println("CASA NRO " + i + " CODIGO: " + tabla[i].codigo + " ESTADO: " + tabla[i].esAlta);
            }
        }
        if(band==1){
            System.out.println("La tabla hash está vacía.");
        }
    }

   
   
}


public class Dispersion {
    double R= 0.618034; //razon aurea
    public double  descifrarClave (String clave){
        double num=0;
        for (int i=0;i< Math.min(clave.length(),10);i++){
            num= num*27 + (int)clave.charAt(i);
        }
        if (num<0){
            num= -num;
        }
        System.out.println("La clave pasada a numero entero es: " + num);
        return num;
    }
    public int dispersar (double clavedescifrada, int M){
        int hasheo=0;
        double auxiliardecimal=0;
        auxiliardecimal= clavedescifrada * R - Math.floor(R * clavedescifrada);
        hasheo= (int)(M * auxiliardecimal);
        System.out.println("El hasheo es: " + hasheo);
        return hasheo;
    }
   
   

}

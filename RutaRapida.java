
import java.util.Scanner;

public class RutaRapida {

    public static void main(String[] args) {
        int carros= carros();

        String[] placas = new String[carros];
        placas = arregloPlacas(placas);
        double[] kilometros = new double[carros];
        kilometros = arregloKilometros(kilometros);
        double[] galones = new double[carros];
        galones = arregloGalones(galones);
        double promedioRendimiento=calcularRendimientoPromedio(kilometros,galones);
        System.out.println("El promedio de la flota es de "+promedioRendimiento+"km/galon");
        
    }
    public static String[] arregloPlacas(String[] arregloPlaca) {// es string
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arregloPlaca.length; i++) {
            System.out.println("Ingrese el valor de la placa del carro " + (i + 1));
            arregloPlaca[i] = sc.next();//usamos next para que al devolver el metodo no de error, pues next es string
        }
        return arregloPlaca;
    }
    public static int carros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos carros/datos va a analizar:");
        int carros = sc.nextInt();
        return carros;
    }

    public static double[] arregloKilometros(double[] arregloKilometros) {// el parametro debe ser igual a lo que demos en main o no funciona
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arregloKilometros.length; i++) {
            do {
                System.out.println("Ingrese los kilometros del carro " + (i + 1));
                arregloKilometros[i] = sc.nextDouble(); // usamos nextDouble() para números decimales por ende la entrada debe ser con ,
                if (arregloKilometros[i] < 0) {
                    validar();
                }
            } while (arregloKilometros[i] < 0);
        }
        return arregloKilometros;// aqui devolvemos
    }

    public static double[] arregloGalones(double[] arregloGalones) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arregloGalones.length; i++) {
            do {
                System.out.println("Ingrese los galones del carro " + (i + 1));
                arregloGalones[i] = sc.nextDouble();//aca lo mismo
                if (arregloGalones[i] < 0) {
                    validar();
                }
            } while (arregloGalones[i] < 0);
        }
        return arregloGalones;
    }

    public static void validar() {
        System.out.println("ingrese un valor positivo");
    }

    public static double calcularRendimientoPromedio(double[] arregloKilometros, double[] arregloGalones) {//aca usamos dos arreglos de antes y sumamos sus datos y con eso calculamos el rendimiento  
        double totalkm=0;
        double totalgalones=0;
        for(int i=0;i<arregloKilometros.length;i++){//suma
            totalkm=totalkm+arregloKilometros[i];           
        }
        for(int i=0;i<arregloGalones.length;i++){
        totalgalones=totalgalones+arregloGalones[i];
    }
        double rendimientoPromedio=totalkm/totalgalones;//suma
        return rendimientoPromedio;
    }
    public static void mostrarVehiculosIneficientes(String[] arregloPlaca, double[] arregloKilometros, double[] arregloGalones, double limiteRendimiento) {
        int carros= carros();
        int[] promediosIndividuales= new int[carros];
        int[] deficiencias= new int[carros];
        int deficienciasCarros=0;
        for(int i=0;i<promediosIndividuales.length;i++){
            promediosIndividuales[i]=(int) (arregloKilometros[i]/arregloGalones[i]);         
        }
        for(int i=0;i<promediosIndividuales.length;i++){
            if(promediosIndividuales[i]<limiteRendimiento){
                deficiencias[deficienciasCarros]=i;
                deficienciasCarros++;
            }
        }
        System.out.println("se encontraron "+deficienciasCarros);
        for(int i=0; i<deficienciasCarros;i++){
             System.out.println("Deficiencia en el carro" +  + " con temperatura: " + temperaturas[anomalias[k]]);
        }

    }
}

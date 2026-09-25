package ejercicios;
import java.util.Scanner;
public class MonitorClimaticoRegional {

    public static void main(String[] args) {
        double[] rivera = Datos("Rivera", false, 20, 35);
    double[] neiva = Datos("Neiva", false, 25, 40);
    double[] campoalegre = Datos("Campoalegre", false, 18, 32);

    // 2. Comparaciones directas
    System.out.println("\n--- COMPARACIONES ---");
    compararSubestaciones("rivera", rivera, "neiva", neiva);
    compararSubestaciones("Neiva", neiva, "Campoalegre", campoalegre);

    // 3. Reportes individuales completos
    reporteMensual("Rivera", rivera);
    reporteMensual("Neiva", neiva);
    reporteMensual("Campoalegre", campoalegre);
}
    public static double[] Datos(String nombre, boolean esManual, double min, double max) {
        double[] temps = new double[12];
        Scanner sc = new Scanner(System.in);
        if (esManual) {
            for (int i = 0; i < temps.length; i++) {
                do {
                    System.out.println("Ingrese los valores de el mes " + (i + 1) + "para la estacion de " + nombre + ":");
                    temps[i] = sc.nextDouble();
                    if (temps[i] < min || temps[i] > max) {
                        System.out.println("Su valor excede el maximo (" + max + ")o minimo(" + min + ")");
                    }
                } while (temps[i] < min || temps[i] > max);
            }
        } else {
            for (int i = 0; i < temps.length; i++) {
                temps[i] = Math.random() * (max - min) + min;
            }
        }
        System.out.println("Sus datos por mes para la estacion de " + nombre + " son:");
        for (int i = 0; i < temps.length; i++) {
            System.out.println("mes " + (i + 1) + ": " + temps[i]);
        }
        return temps;
    }

    public static double calcularPromedio(double[] temperaturas) {
        double suma = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            suma = suma + temperaturas[i];
        }
        double prom = suma / temperaturas.length;
        return prom;
    }

     public static void compararSubestaciones(String nombre1, double[] t1, String nombre2, double[] t2) {
    // 1. Corregimos las variables para que prom1 sea de t1 y prom2 de t2
    double prom1 = calcularPromedio(t1);
    double prom2 = calcularPromedio(t2);

    // 2. Imprimimos directamente con System.out.println
    if (prom1 > prom2) {
        System.out.println(nombre1 + " fue más cálida que " + nombre2);
    } else if (prom2 > prom1) {
        System.out.println(nombre2 + " fue más cálida que " + nombre1);
    } else {
        System.out.println("Ambas estaciones tuvieron la misma temperatura promedio.");
    }
}

    public static int[] detectarAnomalias(double[] temperaturas) {
        // 1. Calculamos el promedio del año
        double prom = calcularPromedio(temperaturas);

        // 2. Definimos los límites (+20% y -20%)
        double limiteSuperior = prom * 1.20;
        double limiteInferior = prom * 0.80;

        int[] anomalias = new int[12];
        int contadorAnomalias = 0;

        // 3. Revisamos mes a mes
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > limiteSuperior || temperaturas[i] < limiteInferior) {
                anomalias[contadorAnomalias] = i; // Guardamos la posición del mes (0 a 11)
                contadorAnomalias++;
            }
            
        }
        // IMPRIMIR LAS ANOMALÍAS DE FORMA FÁCIL:
    System.out.println("Se encontraron " + contadorAnomalias + " anomalías:");
    for (int k = 0; k < contadorAnomalias; k++) {
        System.out.println(" - Anomalía en el mes " + (anomalias[k] + 1) + " con temperatura: " + temperaturas[anomalias[k]]);
    }

        // 4. Retornamos el arreglo con los índices de los meses anómalos
        return anomalias;
    }
    public static void reporteMensual(String nombre, double[] temperaturas) {
    System.out.println("\n==========================================");
    System.out.println("   REPORTE CLIMÁTICO ANUAL: " + nombre.toUpperCase());
    System.out.println("==========================================");

    // 1. Mostrar temperaturas de todos los meses
    System.out.println("Temperaturas mensuales:");
    double mayor = temperaturas[0];
    double menor = temperaturas[0];
    int mesMayor = 1;
    int mesMenor = 1;

    for (int i = 0; i < temperaturas.length; i++) {
        System.out.println("  Mes " + (i + 1) + ": " + temperaturas[i] + "°C");

        // Buscar el mayor
        if (temperaturas[i] > mayor) {
            mayor = temperaturas[i];
            mesMayor = i + 1;
        }
        // Buscar el menor
        if (temperaturas[i] < menor) {
            menor = temperaturas[i];
            mesMenor = i + 1;
        }
    }

    // 2. Promedio y Estadísticas
    double promedio = calcularPromedio(temperaturas);
    System.out.println("------------------------------------------");
    System.out.println("Promedio Anual: " + promedio + "°C");
    System.out.println("Mayor temperatura: Mes " + mesMayor + " (" + mayor + "°C)");
    System.out.println("Menor temperatura: Mes " + mesMenor + " (" + menor + "°C)");

    // 3. Anomalías
    System.out.println("------------------------------------------");
    detectarAnomalias(temperaturas);
}
    
}

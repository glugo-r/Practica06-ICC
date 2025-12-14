import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumaParalela {

    // Función a sumar
    public static long f(long i) {
        return i * i + 3 * i + 1;
    }

    // Tarea que ejecuta cada hilo
    static class SumaTarea implements Runnable {
        private long inicio;
        private long fin;
        private long resultado;

        public SumaTarea(long inicio, long fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public void run() {
            long suma = 0;
            for (long i = inicio; i <= fin; i++) {
                suma += f(i);
            }
            resultado = suma;
        }

        public long getResultado() {
            return resultado;
        }
    }

    // Suma usando N hilos
    public static long sumaConHilos(int nHilos) throws InterruptedException {

        List<Thread> hilos = new ArrayList<>();
        List<SumaTarea> tareas = new ArrayList<>();

        long total = 1_000_000;
        long rango = total / nHilos;

        long inicio = 1;
        long fin = rango;

        for (int i = 0; i < nHilos; i++) {

            if (i == nHilos - 1) {
                fin = total;
            }

            SumaTarea tarea = new SumaTarea(inicio, fin);
            Thread hilo = new Thread(tarea);

            tareas.add(tarea);
            hilos.add(hilo);

            hilo.start();

            inicio = fin + 1;
            fin += rango;
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        long sumaTotal = 0;
        for (SumaTarea t : tareas) {
            sumaTotal += t.getResultado();
        }

        return sumaTotal;
    }

    // Suma fija con 1 hilo directo
    public static long suma1HiloFijo() {
        long suma = 0;
        for (long i = 1; i <= 1_000_000; i++) {
            suma += f(i);
        }
        return suma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingresa el número de hilos: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Error: el número de hilos debe ser mayor que 0.");
                return;
            }

            System.out.println("\nCalculando...\n");

            // 2) Cálculo con 1 hilo
            long inicio1 = System.nanoTime();
            long resultado1 = suma1HiloFijo();
            long fin1 = System.nanoTime();
            long tiempo1 = fin1 - inicio1;

            // Cálculo con N hilos
            long inicioN = System.nanoTime();
            long resultadoN = sumaConHilos(n);
            long finN = System.nanoTime();
            long tiempoN = finN - inicioN;

            // Resultados
            System.out.println("=========== RESULTADOS ===========");

            System.out.println("Resultado 1 hilo:  " + resultado1);
            System.out.println("Resultado con " + n + " hilos:      " + resultadoN + "\n");

            System.out.println("Tiempo con 1 hilo: " 
                + tiempo1 + " ns  (" + (tiempo1 / 1_000_000.0) + " ms)");
            System.out.println("Tiempo con " + n + " hilos: " 
                + tiempoN + " ns  (" + (tiempoN / 1_000_000.0) + " ms)");

            System.out.println("\n========= COMPARACIÓN =========");
            System.out.println("Hilos\tTiempo (ms)");
            System.out.println("1\t" + (tiempo1 / 1_000_000.0));
            System.out.println(n + "\t" + (tiempoN / 1_000_000.0));

            System.out.println("\n¿Hubo aceleración?");
            if (tiempoN < tiempo1)
                System.out.println("Sí, el programa fue más rápido con " + n + " hilos.");
            else
                System.out.println("No hubo aceleración");

        } catch (Exception e) {
            System.out.println("Error: ingresa un número válido.");
        }

        sc.close();
    }
}


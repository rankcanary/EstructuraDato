package metodos;

import java.util.Arrays;

public class metodos implements TDA {

    private byte idc;
    private byte p;
    int datos[];

    public metodos(byte idc){
        datos = new int[idc];
        p=-1;
        this.idc = idc;
    }

    @Override
    public boolean arrayVacio() {
        return (p==-1);
    }

    @Override
    public boolean espacioArray() {
        return (p<=idc);
    }

    @Override
    public void vaciarArray() {
        datos = new int[idc];
        p=-1;
    }

    @Override
    public void almacenaDatos() {
        for(int i =0; i<datos.length;i++){
            datos[i] = generaRandom(10, 99);
            p++;
        }
    }

    @Override
    public String impresionDatos() {
        String cad="";
        for (int i = 0; i<=p; i++){
            cad+= i+"=>[" + datos[i] + "]" + "\n";
        }
        return "\n" + cad;
    }

    @Override
    public void burbujaSeñal() {
        boolean señal;
        int iteraciones = 0;
        int n = datos.length;
        
        do {
            señal = false;
            
            for (int i = 0; i < n - 1; i++) {
                if (datos[i] > datos[i + 1]) {
                    // Intercambiar elementos datos[i] y datos[i + 1]
                    int temp = datos[i];
                    datos[i] = datos[i + 1];
                    datos[i + 1] = temp;
                    señal = true;
                    iteraciones++;
                }
            }
            
            n--;
        } while (señal);
        
        System.out.println("Cantidad de ciclos: " + iteraciones);
    }

    @Override
    public void dobleBurbuja() {
        boolean señal;
        int longitud = datos.length;

        for (int i = 0; i < longitud - 1; i++) {
            señal = false;

            for (int j = 0; j < longitud - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    intercambiarElementos(j, j + 1);
                    señal = true;
                }
            }

            if (!señal) {
                break;
            }
        }
    }

    private void intercambiarElementos(int indice1, int indice2) {
        int temp = datos[indice1];
        datos[indice1] = datos[indice2];
        datos[indice2] = temp;
    }

    @Override
    public void shellIncreDecre() {
        int incremento = datos.length / 2;

        while (incremento > 0) {
            for (int i = incremento; i < datos.length; i++) {
                int temp = datos[i];
                int j = i;

                while (j >= incremento && datos[j - incremento] > temp) {
                    datos[j] = datos[j - incremento];
                    j -= incremento;
                }

                datos[j] = temp;
            }

            incremento /= 2;
        }
    }

    @Override
    public void seleDirecta() {
        int n = datos.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                minIndex = (datos[j] < datos[minIndex]) ? j : minIndex;
            }

            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = datos[i];
        datos[i] = datos[j];
        datos[j] = temp;
    }


    @Override
    public void inserDirecta() {
        int n = datos.length;

        for (int i = 1; i < n; i++) {
            int j = i;

            while (j > 0 && datos[j - 1] > datos[j]) {
                intercambiarElementos2(j, j - 1);
                j--;
            }
        }
    }

    private void intercambiarElementos2(int indice1, int indice2) {
        int temp = datos[indice1];
        datos[indice1] = datos[indice2];
        datos[indice2] = temp;
    }


    @Override
    public void binaria() {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];
            int j = i;
            
            while (j > 0 && datos[j - 1] > temp) {
                datos[j] = datos[j - 1];
                j--;
            }
            
            datos[j] = temp;
        }
    }


    @Override
    public void heapSort() {
        for (int i = datos.length / 2 - 1; i >= 0; i--) {
            heapify(datos, datos.length, i);
        }
        for (int i = datos.length - 1; i > 0; i--) {
            int temp = datos[0];
            datos[0] = datos[i];
            datos[i] = temp;
            heapify(datos, i, 0);
        }
    }

    public static void heapify(int[] datos, int length, int raiz) {
        int mayor = raiz;
        int izq = 2 * raiz + 1;
        int der = 2 * raiz + 2;

        if (izq < length && datos[izq] > datos[mayor]) {
            mayor = izq;
        }

        if (der < length && datos[der] > datos[mayor]) {
            mayor = der;
        }

        if (mayor != raiz) {
            swap(datos, raiz, mayor);
            heapify(datos, length, mayor);
        }
    }

    private static void swap(int[] datos, int i, int j) {
        int temp = datos[i];
        datos[i] = datos[j];
        datos[j] = temp;
    }


    @Override
    public void quicksortRecursivo() {
        QSR(datos, 0, datos.length - 1);
    }

    public static void QSR(int[] datos, int menor, int mayor) {
        if (menor < mayor) {
            int varIndex = particion(datos, menor, mayor);
            QSR(datos, menor, varIndex - 1);
            QSR(datos, varIndex + 1, mayor);
        }
    }

    public static int particion(int[] datos, int menor, int mayor) {
        int var = datos[mayor];
        int i = menor;
        for (int j = menor; j < mayor; j++) {
            if (datos[j] <= var) {
                int temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
                i++;
            }
        }
        int temp = datos[i];
        datos[i] = datos[mayor];
        datos[mayor] = temp;
        return i;
    }

    @Override
    public void radix() {
        int max = getMax(datos);
        int exp = 1;
        while (max / exp > 0) {
            conteo(datos, exp);
            exp *= 10;
        }
    }

    public static void conteo(int[] datos, int exp) {
        int n = datos.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (datos[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (datos[i] / exp) % 10;
            output[count[digit] - 1] = datos[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, datos, 0, n);
    }

    public static int getMax(int[] datos) {
        int max = datos[0];
        for (int num : datos) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public void intercalacion() {
        int n = datos.length;
        
        if (n < 2) {
            return;
        }
        
        for (int i = 1; i < n; i++) {
            int elemento = datos[i];
            int j;
            
            for (j = i - 1; j >= 0 && datos[j] > elemento; j--) {
                datos[j + 1] = datos[j];
            }
            
            datos[j + 1] = elemento;
        }
    }

    
    @Override
    public void mezclaDirecta() {
        int n = datos.length;
        int[] temp = new int[n];
        int tamArr = 1;

        while (tamArr < n) {
            for (int inicio = 0; inicio < n - tamArr; inicio += 2 * tamArr) {
                int medio = inicio + tamArr;
                int fin = Math.min(inicio + 2 * tamArr, n);
                combinar(datos, temp, inicio, medio, fin);
            }

            tamArr *= 2;
        }
    }

    
    public static void combinar(int[] datos, int[] temp, int inicio, int medio, int fin) {
        int[] tempArray = Arrays.copyOfRange(datos, inicio, fin); // Crear una copia temporal del subarreglo
        int i = 0, j = medio - inicio, k = inicio;

        while (i < (medio - inicio) || j < (fin - inicio)) {
            if (j == (fin - inicio) || (i < (medio - inicio) && tempArray[i] <= tempArray[j])) {
                datos[k] = tempArray[i];
                i++;
            } else {
                datos[k] = tempArray[j];
                j++;
            }
            k++;
        }
    }



    @Override
    public int generaRandom(int min, int max) {
        return (int)((max - min + 1) * Math.random()+ min);
    }
}
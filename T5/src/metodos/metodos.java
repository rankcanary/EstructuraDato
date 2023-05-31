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
        int iteraciones=0;
        for (int i = 0; i < datos.length - 1; i++) {
            señal = false;
            for (int j = 0; j < datos.length - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    // Intercambiar elementos datos[j] y datos[j + 1]
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                    señal = true;
                    iteraciones++;
                }
            }
            if (!señal) 
                break;
        }
        System.out.println("Cantidad de ciclos: + " +iteraciones);
    }

    @Override
    public void dobleBurbuja() {
        boolean señal;
        for (int i = 0; i < datos.length / 2; i++) {
            señal = false;
            for (int j = i; j < datos.length - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    // Intercambiar elementos datos[j] y datos[j + 1]
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                    señal = true;
                }
            }
            if (!señal) {
                break;
            }
            señal = false;
            for (int j = datos.length - i - 2; j > i; j--) {
                if (datos[j] < datos[j - 1]) {
                    int temp = datos[j];
                    datos[j] = datos[j - 1];
                    datos[j - 1] = temp;
                    señal = true;
                }
            }
            if (!señal) {
                break;
            }
        }
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
                if (datos[j] < datos[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = datos[i];
                datos[i] = datos[minIndex];
                datos[minIndex] = temp;
            }
        }
    }


    @Override
    public void inserDirecta() {
        int n = datos.length;
        for (int i = 1; i < n; i++) {
            int key = datos[i];
            int j = i - 1;

            // Desplazamiento de elementos mayores que la clave
            while (j >= 0 && datos[j] > key) {
                datos[j + 1] = datos[j];
                j--;
            }

            // Insertar la clave en la posición correcta
            datos[j + 1] = key;
        }
    }


    @Override
    public void binaria() {
        for (int i = 1; i < datos.length; i++) {
            int temp = datos[i];
            int j = i - 1;
            while (j >= 0 && datos[j] > temp) {
                datos[j + 1] = datos[j];
                j--;
            }
            datos[j + 1] = temp;
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
        int izq = 2 * raiz + 1;
        int der = 2 * raiz + 2;
        int mayor = raiz;
        if (izq < length && datos[izq] > datos[mayor]) {
            mayor = izq;
        }
        if (der < length && datos[der] > datos[mayor]) {
            mayor = der;
        }
        if (mayor != raiz) {
            int temp = datos[raiz];
            datos[raiz] = datos[mayor];
            datos[mayor] = temp;
            heapify(datos, length, mayor);
        }
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
        for (int num : datos) {
            count[(num / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(datos[i] / exp) % 10] - 1] = datos[i];
            count[(datos[i] / exp) % 10]--;
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
            int j = i - 1;
            
            while (j >= 0 && datos[j] > elemento) {
                datos[j + 1] = datos[j];
                j--;
            }
            
            datos[j + 1] = elemento;
        }
    }
    
    @Override
    public void mezclaDirecta() {
        int n = datos.length;
        int[] temp = new int[n];
        for (int tamArr = 1; tamArr < n; tamArr *= 2) {
            for (int inicio = 0; inicio < n - tamArr; inicio += 2 * tamArr) {
                int medio = inicio + tamArr;
                int fin = Math.min(inicio + 2 * tamArr, n);
                combinar(datos, temp, inicio, medio, fin);
            }
        }
    }
    
    public static void combinar(int[] datos, int[] temp, int inicio, int medio, int fin) {
        int[] tempArray = Arrays.copyOfRange(datos, inicio, fin); // Crear una copia temporal del subarreglo
        int i = 0;
        int j = medio - inicio;
        int k = inicio;
        
        while (i < (medio - inicio) && j < (fin - inicio)) {
            if (tempArray[i] <= tempArray[j]) {
                datos[k] = tempArray[i];
                i++;
            } else {
                datos[k] = tempArray[j];
                j++;
            }
            k++;
        }
        
        while (i < (medio - inicio)) {
            datos[k] = tempArray[i];
            i++;
            k++;
        }
        
        while (j < (fin - inicio)) {
            datos[k] = tempArray[j];
            j++;
            k++;
        }
    }


    @Override
    public int generaRandom(int min, int max) {
        return (int)((max - min + 1) * Math.random()+ min);
    }
}
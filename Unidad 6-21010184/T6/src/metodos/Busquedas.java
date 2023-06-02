package metodos;

public class Busquedas {
	public static boolean secuencialLineal(int a[], int valor){
	    int i = 0;
	    while(i < a.length && a[i] != valor){
	        i++;
	    }
	    return i < a.length;
	}

	public static int secuencialBinaria(int[] a, int valor) {
	    int inf = 0;
	    int sup = a.length - 1;
	    int mitad = 0;

	    do {
	        mitad = (inf + sup) / 2;

	        if (valor == a[mitad]) {
	            return mitad;
	        } else if (valor < a[mitad]) {
	            sup = mitad - 1;
	        } else {
	            inf = mitad + 1;
	        }
	    } while (inf <= sup);

	    return -1;
	}

	public static int kmp(char[] texto, char[] pat) {
	    int n = texto.length;
	    int m = pat.length;
	    int[] lps = new int[m];
	    int tam = 0;
	    for (int i = 1; i < m; i++) {
	        if (pat[i] == pat[tam]) {
	            lps[i] = ++tam;
	        } else if (tam != 0) {
	            tam = lps[tam - 1];
	            i--;
	        } else {
	            lps[i] = 0;
	        }
	    }
	    int j = 0;
	    for (int i = 0; i < n; i++) {
	        if (pat[j] == texto[i]) {
	            if (++j == m) {
	                return i - j + 1;
	            }
	        } else if (j != 0) {
	            j = lps[j - 1];
	            i--;
	        }
	    }
	    return -1;
	}

	public static int jumpSearch(int a[], int valor) {
	    int n = a.length;
	    int salto = (int) Math.sqrt(n);
	    int inicio = 0;
	    int fin = salto;
	    while (a[Math.min(fin, n) - 1] < valor) {
	        inicio = fin;
	        fin += salto;
	        if (inicio >= n)
	            return -1;
	    }
	    for (int i = inicio; i < Math.min(fin, n); i++) {
	        if (a[i] == valor)
	            return i;
	    }
	    return -1;
	}

	public static int interpolacion(int[] a, int valor) {
	    int inicio = 0;
	    int fin = a.length - 1;

	    while (inicio <= fin && valor >= a[inicio] && valor <= a[fin]) {
	        if (inicio == fin) {
	            return (a[inicio] == valor) ? inicio : -1;
	        }
	        int position = inicio + ((valor - a[inicio]) * (fin - inicio)) / (a[fin] - a[inicio]);
	        if (a[position] == valor) {
	            return position;
	        } else if (a[position] < valor) {
	            inicio = position + 1;
	        } else {
	            fin = position - 1;
	        }
	    }
	    return -1;
	}


	public static int busquedaExponencial(int[] a, int valor) {
	    int tamaño = a.length;
	    if (a[0] == valor) {
	        return 0;
	    }

	    int i = 1;
	    while (i < tamaño) {
	        if (a[i] > valor) {
	            break;
	        }
	        i *= 2;
	    }

	    int inicio = i / 2;
	    int fin = Math.min(i, tamaño - 1);
	    return busquedaBinaria(a, valor, inicio, fin);
	}


	public static int busquedaBinaria(int[] a, int clave, int inicio, int fin) {
	    while (inicio <= fin) {
	        int medio = (inicio + fin) / 2;

	        if (a[medio] == clave) {
	            return medio;
	        }

	        if (a[medio] > clave) {
	            fin = medio - 1;
	        } else {
	            inicio = medio + 1;
	        }
	    }

	    return -1;
	}



	public static int fibonacciSearch(int[] a, int target) {
	    int fib2 = 0;
	    int fib1 = 1;
	    int fib = fib2 + fib1;

	    while (fib < a.length) {
	        int temp = fib2;
	        fib2 = fib1;
	        fib1 = fib;
	        fib = fib2 + fib1;
	    }

	    int offset = -1;
	    while (fib > 1) {
	        int i = Math.min(offset + fib2, a.length - 1);

	        if (a[i] < target) {
	            fib = fib1;
	            fib1 = fib2;
	            fib2 = fib - fib1;
	            offset = i;
	        } else if (a[i] > target) {
	            fib = fib2;
	            fib1 = fib1 - fib2;
	            fib2 = fib - fib1;
	        } else {
	            return i;
	        }
	    }

	    return (fib1 == 1 && a[offset + 1] == target) ? offset + 1 : -1;
	}

    public static String imprimeOrdenados(int a[]) {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            cad.append(i).append("[").append(a[i]).append("]").append("\n");
        }
        return "\n" + cad.toString();
    }

    public static String imprimeOrdenados(char a[]) {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            cad.append("[").append(a[i]).append("]");
        }
        return "\n" + cad.toString();
    }



}

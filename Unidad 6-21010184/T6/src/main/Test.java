package main;
import tools.*;
import metodos.*;
import javax.swing.*;
import java.util.Arrays;
import metodos.Busquedas;



public class Test {
    public static void main(String[] args) {

        String menu = "Secuencial Lineal,Secuencial Binaria,Knuth Morris Pratt,Busqueda Salto,Interpolacion,Exponencial,Busqueda Fibonacci,Salir";
        menu3(menu);

    }
    public static String boton(String menu) {
        String valores[]=menu.split(",");
        int n;
        n = JOptionPane.showOptionDialog(null," SELECCIONA DANDO CLICK ", " M E N U",
                JOptionPane.NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,
                valores,valores[0]);
        return ( valores[n]);
    }

    public static void menu3(String menu)
    {
        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case "Secuencial Lineal":
                	int[] SL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                	toolsList.imprimePantalla("Busqueda de un numero del 1 al 10.");

                	byte numeroBuscado = toolsList.leerByte("Numero a buscar:");
                	boolean elementoExiste = Busquedas.secuencialLineal(SL, numeroBuscado);

                	if (elementoExiste) {
                	    toolsList.imprimePantalla("El elemento existe");
                	} else {
                	    toolsList.imprimePantalla("El elemento no existe");
                	}

                    break;
                    
                    
                case "Secuencial Binaria":
                	int[] SB = {30, 40, 1, 20, 10};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(SB));

                	int[] SBOrdenados = Arrays.copyOf(SB, SB.length);
                	Arrays.sort(SBOrdenados);
                	toolsList.imprimePantalla("Arreglo ordenado: " + Busquedas.imprimeOrdenados(SBOrdenados));

                	int dato = toolsList.leerInt("Encuentra dato: ");
                	int indice = Busquedas.secuencialBinaria(SBOrdenados, dato);
                	if (indice < 0) {
                	    toolsList.imprimePantalla("El dato existe");
                	} else {
                	    toolsList.imprimePantalla("El dato no existe.");
                	}

                    break;
                    
                case "Knuth Morris Pratt":
                	char[] texto = {'A','B','C','D','E','I','P','N','A','A','D'};
                	char[] patron = {'D','E','I'};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(texto));
                	toolsList.imprimePantalla("Patron a buscar: " + Busquedas.imprimeOrdenados(patron));

                	boolean patronExiste = Busquedas.kmp(texto, patron) >= 0;
                	toolsList.imprimePantalla(patronExiste ? "El patron existe" : "El patron no existe.");

                    break;
                case "Busqueda Salto":
                	int[] JS = {10, 13, 15, 26, 28, 50, 56, 88, 94, 127, 159, 356, 480, 567, 689, 699, 780, 850, 956, 995};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(JS));

                	int numeroBuscado1 = toolsList.leerInt("Número a buscar:");
                	int indiceEncontrado = Busquedas.jumpSearch(JS, numeroBuscado1);

                	if (indiceEncontrado >= 0) {
                	    toolsList.imprimePantalla("El dato existe");
                	} else {
                	    toolsList.imprimePantalla("El dato no existe.");
                	}

                    break;
                case "Interpolacion":
                	int[] ITP = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(ITP));

                	int numeroBuscado2 = toolsList.leerInt("Numero a buscar:");
                	int indiceEncontrado1 = Busquedas.interpolacion(ITP, numeroBuscado2);

                	if (indiceEncontrado1 >= 0) {
                	    toolsList.imprimePantalla("El dato existe");
                	} else {
                	    toolsList.imprimePantalla("El dato no existe.");
                	}

                    break;
                case "Exponencial":
                	int[] EXP = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(EXP));

                	int numeroBuscado3 = toolsList.leerInt("Numero a buscar:");
                	int indiceEncontrado2 = Busquedas.interpolacion(EXP, numeroBuscado3);

                	if (indiceEncontrado2 >= 0) {
                	    toolsList.imprimePantalla("El dato existe");
                	} else {
                	    toolsList.imprimePantalla("El dato no existe.");
                	}

                    break;
                case "Busqueda Fibonacci":
                	int[] BF = {10,13,15,26,28,50,56,88,94,127,159,356,480,567,689,699,780};
                	toolsList.imprimePantalla(Busquedas.imprimeOrdenados(BF));

                	int numeroBuscado4 = toolsList.leerInt("Numero a buscar:");
                	int resultadoBusqueda3 = Busquedas.fibonacciSearch(BF, numeroBuscado4);

                	if (resultadoBusqueda3 >= 0) {
                	    toolsList.imprimePantalla("El dato existe");
                	} else {
                	    toolsList.imprimePantalla("El dato no existe.");
                	}

                    break;

                case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
}

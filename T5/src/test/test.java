package test;
import javax.swing.*;

import metodos.metodos;
import tools.tools;
public class test {
    public static void main(String[] args) throws Exception {
        String menu = "Llenar,Imprimir,Vaciar,Burbuja,Shell,SeleccionDirecta"+",InsercionDirecta,Binaria,HeapSort,QuickSortRecursivo,Radix,Intercalacion,Mezcla Directa,Salir";
        menu3(menu);
    }
    public static String desplegable(String menu) {
        String valores[]=menu.split(",");
        String res=
                (String)JOptionPane.showInputDialog(null,"M E N U","Selecciona opcion:",
                        JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
        return(res);
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
        metodos dato = new metodos((byte)10);
        String sel="";
        do {
            sel=desplegable(menu);
            switch(sel){
                case "Llenar":
                    if(dato.espacioArray()){
                        dato.almacenaDatos();
                        tools.imprimePantalla(dato.impresionDatos());
                    }
                    else 
                        tools.imprimeErrorMsg("Arreglo Lleno.");
                break;
                case "Imprimir":
                    if(!dato.arrayVacio())
                        tools.imprimePantalla(dato.impresionDatos());
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Vaciar":
                    if(!dato.arrayVacio()){
                        dato.vaciarArray();
                        tools.imprimePantalla("Arreglo vaciado.");
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Burbuja":
                    if(!dato.arrayVacio()){
                        String s="";
                        do {
                            s=boton("BurbujaSeñal,BurbujaDoble,Salir");
                            switch(s){
                                case "BurbujaSeñal":
                                    tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                                    dato.burbujaSeñal();
                                    tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                                break;
                                case "BurbujaDoble":
                                    tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                                    dato.dobleBurbuja();
                                    tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                                break;
                                case "Salir":
                                break;
                            }
                        }while(!s.equalsIgnoreCase("Salir"));
                    }
                    else 
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");  
                break;
                case "Shell":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.shellIncreDecre();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "SeleccionDirecta":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.seleDirecta();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "InsercionDirecta":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.inserDirecta();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Binaria":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.binaria();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "HeapSort":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.heapSort();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "QuickSortRecursivo":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.quicksortRecursivo();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Radix":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.radix();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Intercalacion":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.intercalacion();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;
                case "Mezcla Directa":
                    if(!dato.arrayVacio()){
                        tools.imprimePantalla("Arreglo desordenado:\n"+dato.impresionDatos());
                        dato.mezclaDirecta();
                        tools.imprimePantalla("Arreglo ordenado:\n"+dato.impresionDatos());
                    }
                    else
                        tools.imprimeErrorMsg("Arreglo Vacio.\nFavor de seleccionar LLenar.");
                break;       
                case "Salir":

                break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
}
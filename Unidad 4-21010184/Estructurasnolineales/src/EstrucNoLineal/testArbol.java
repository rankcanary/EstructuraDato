package EstrucNoLineal;

import EntradaSalida.toolsList;

import javax.swing.*;

import ArbolBin.ArbolBin;
import ArbolBin.Nodito;

public class testArbol {
    public static void main(String[] args) {
        String menu = "Insertar,Recorridos,Buscar,Hojas,Altura,Ver,Salir";
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

        ArbolBin <Integer> arbol;
        arbol = new ArbolBin();

        String sel="";
        do {
            sel=boton(menu);
            switch(sel){
                case"Insertar":
                    arbol.insertarArbol(toolsList.leerInt("Dato"));
                    break;
                case"Recorridos":
                	toolsList.imprimePantalla(arbol.preorden(arbol.getRaiz())+"\n"+
                    		"pos"+arbol.posorden(arbol.getRaiz())+"\n"+
                    		"en"+arbol.enorden(arbol.getRaiz())+"\n"+
                    		"in"+arbol.inorden(arbol.getRaiz()));          
                	break;
                	
                case"Buscar":
                	//toolsList.imprimePantalla(arbol.buscarDato(null, 0));
                	if (arbol.arbolVacio()) {
						toolsList.imprimeErrorMsg("Arbol vacio");
					} else {
						int datoBuscar = toolsList.leerInt("Ingresa valor a buscar");
						Nodito resultado = arbol.buscarDato(arbol.getRaiz(), datoBuscar);

						if (resultado != null) {
							toolsList.imprimePantalla("El dato " + datoBuscar + " se encuentra en el arbol");
						} else {
							toolsList.imprimePantalla("El dato " + datoBuscar + " no se encuentra en el �rbol");
						}
					}
                    break;
                    
                case"Hojas":
                	if (arbol.arbolVacio()) {
						toolsList.imprimeErrorMsg("Arbol vacio");
					} else {				
						toolsList.imprimePantalla("Las hojas del arbol son: \n" + arbol.imprimirHojas(arbol.getRaiz()));
						toolsList.imprimePantalla("Los interiores del arbol son: \n" + arbol.imprimirNodInter(arbol.getRaiz()));
						
					}
                    break;
                    
                case"Altura":
                	if (arbol.arbolVacio()) {
						toolsList.imprimeErrorMsg("Arbol vacio");
					} else {
						toolsList.imprimePantalla("La altura del arbol es: \n" + arbol.obtenerAltura(arbol.getRaiz()));
					}
                    break;
                    
                case"Ver":
                	if (arbol.arbolVacio()) {
						toolsList.imprimeErrorMsg("Arbol vacio");
					} else {
						System.out.println("La estructura del arbol es la siguiente: \n");
						arbol.Recursivo(arbol.getRaiz(), 0);
					}
                    break;
                    
                case "Salir":;  break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
}


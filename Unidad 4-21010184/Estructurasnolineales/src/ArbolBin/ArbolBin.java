package ArbolBin;

public class ArbolBin<T> {

    private Nodito raiz;

    public ArbolBin(){
        raiz = null;
    }

    public Nodito getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodito raiz) {
        this.raiz = raiz;
    }

    public boolean arbolVacio(){
        return raiz==null;
    }

    public void vaciarArbol(){
        raiz=null;
    }

    public void insertarArbol(T info){
        Nodito p = new Nodito(info);
        if(arbolVacio())
            raiz = p;
        else{
            Nodito padre = buscarPadre(raiz,p);
            if ((int) p.info >= (int) padre.info)   
            	padre.setDer(p);
            else
                padre.setIzq(p);
        }
    }

    public Nodito buscarPadre(Nodito actual,Nodito p){
        Nodito padre = null;
        while(actual!=null){
            padre = actual;
            if((int)p.info>=(int)padre.info)
                actual = padre.getDer();
            else
                actual = padre.getIzq();
        }
        return padre;
    }

    public String preorden(Nodito r){
        if(r!=null){
            return r.info + " - " + preorden(r.izq) + " - " + preorden(r.der);
        }
        else
            return " ";
    }
    
    public String posorden (Nodito r) {
		 if (r!=null) {
			 return posorden(r.izq)+" - "+posorden(r.der)+" - "+r.info;
					 
		 }
		 else return " ";
	 }
	 
	 
	 public String inorden(Nodito r) {
		 if (r!=null) {
			 return inorden(r.izq)+" - "+r.info+" - "+inorden(r.der);
					 
		 }
		 else return " ";
	 }
	 
	 
	 
	 public String enorden(Nodito r) {
		 if (r!=null) {
			 return enorden(r.der)+" - "+r.info+" - "+enorden(r.izq);
					 
		 }
		 else return " ";
	 }
	 
	 public Nodito buscarDato(Nodito r, int dato) {
		 while(r!=null) {
			 if(r.getInfo().equals(dato)) {
				 return r;
			 } else {
				 int i =(int)r.info;
				 if(dato>i) {
					 r=r.getDer();
				 }else {
					 r=r.getIzq();
				 }
			 }
		 }
		 return r;
	 }
	 
	  public String imprimirHojas(Nodito nodo) {
		    StringBuilder cad = new StringBuilder();
		    imprimirHojasRecursivo(nodo, cad);
		    return cad.toString();
		}
	  
	  private void imprimirHojasRecursivo(Nodito nodo, StringBuilder cad) {
		    if (nodo == null) {
		        return;
		    }
		    if (nodo.izq == null && nodo.der == null) {
		        cad.append(nodo.info).append(" ");
		    }
		    imprimirHojasRecursivo(nodo.izq, cad);
		    imprimirHojasRecursivo(nodo.der, cad);
		}

	 public String imprimirNodInter(Nodito nodo) {
			String cad = "";
			if (nodo != null) {
				if (nodo.izq != null || nodo.der != null) {
					if(nodo.info!=raiz.info)
					cad = nodo.info + " ";
				}
				return cad + imprimirNodInter(nodo.izq) + imprimirNodInter(nodo.der);
			} else {
				return "";
			}
		}
	 
	 public int obtenerAltura(Nodito nodo) {
		    if (nodo == null) {
		        return 0;
		    } else {
		        int alturaIzq = obtenerAltura(nodo.izq);
		        int alturaDer = obtenerAltura(nodo.der);
		        return Math.max(alturaIzq, alturaDer) + 1;
		    }
		}
	 
	 public static void Recursivo(Nodito node, int level) {
		    if (node == null) {
		        return;
		    }

		    Recursivo(node.der, level + 1);

		    StringBuilder indentation = new StringBuilder();
		    for (int i = 0; i < level; i++) {
		        indentation.append("    ");
		    }
		    String prefix = (level == 0) ? "" : indentation.toString() + "I------";
		    System.out.println(prefix + node.info);
		  Recursivo(node.izq, level + 1);
		}

	 public void imprimirArbol(Nodito nodo, String prefijo, boolean esUltimo) {
		    if (nodo == null) {
		        return;
		    }
		    String separador = esUltimo ? "I__" : "I--";
		    String nuevoPrefijo = prefijo + (esUltimo ? "    " : "|   ");
		    imprimirArbol(nodo.der, nuevoPrefijo, false);
		    System.out.println(prefijo + separador + nodo.info);
		    nuevoPrefijo = prefijo + (esUltimo ? "|   " : "    ");
		    imprimirArbol(nodo.izq, nuevoPrefijo, true);
		}
	
		
	 
	 
	 
}

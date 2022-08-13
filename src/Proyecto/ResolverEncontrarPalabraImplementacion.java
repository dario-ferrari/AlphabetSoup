package Proyecto;

import Libreria.Posicion;
import Libreria.ResolverEncontrarPalabraInterface;

import java.util.ArrayList;

public class ResolverEncontrarPalabraImplementacion implements ResolverEncontrarPalabraInterface {

    public ResolverEncontrarPalabraImplementacion() {
    }

    public ArrayList<Posicion> resolverEncontrarPalabra(char[][] matrizLetras, int longX, int longY, String palabraBuscar) {
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for (int f=0; f<longX; f++) {
            for(int c=0; c<longY; c++) {
                if (posiciones.size()<palabraBuscar.length()) {
                    posiciones.clear();
                    backtracking(matrizLetras, f, c, palabraBuscar, 0, "", "", posiciones, longX, longY);
                }
            }
        }
        return posiciones;
    }

    private void backtracking (char[][]matrizLetras, int filas, int columnas, String palabra, int etapa, String flag, String actual, ArrayList<Posicion> posiciones, int longX, int longY){
        if (palabra.length()==etapa) {
            return;
        }
        if (filas>=longX || columnas>=longY || palabra.charAt(etapa)!=matrizLetras[filas][columnas]) {
            return;
        }
        if (flag == actual || actual == "") {
            Posicion pos=new Posicion();
            pos.posX=filas;
            pos.posY=columnas;
            posiciones.add(pos);
            actual=flag;
        }
        flag="Horizontal";
        backtracking(matrizLetras, filas, columnas+1, palabra, etapa+1, flag, actual, posiciones, longX, longY);
        flag="Vertical";
        backtracking(matrizLetras, filas+1, columnas, palabra, etapa+1, flag, actual, posiciones, longX, longY);
        flag="Diagonal";
        backtracking(matrizLetras, filas+1, columnas+1, palabra, etapa+1, flag, actual, posiciones, longX, longY);
    }
}

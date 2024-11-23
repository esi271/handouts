/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e03;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/genera_quadrato_magico/Testo.md">testo</a>,
 */
public class GeneraQuadratoMagico {

  /** . */
  private GeneraQuadratoMagico() {}
  /** 
   * Genera un quadrato magico.
   * Un quadrato magico è una forma speciale in cui la somma per ogni riga e colonna è uguale
   * 
   * @param args N la misura del lato del quadrato
   */
    public static void main(String[] args) {
      final int N = Integer.parseInt(args[0]);
      int[][] quad_mad = new int[N][N];

      int numero = 2;
      int riga = 0;
      int colonna = N/2;
      quad_mad[riga][colonna] = 1;
      while (numero<=N*N) {
          
          int newRiga, newColonna;
          newRiga = (riga-1+N)%N;
          newColonna = (colonna+1)%N;
        
        if (quad_mad[newRiga][newColonna]==0){
            quad_mad[newRiga][newColonna] = numero;
            riga = newRiga;
            colonna = newColonna;
        } else {
            newRiga = (riga+1)%N;
            quad_mad[newRiga][colonna] = numero;
            riga = newRiga;
        }
        
        numero++;
      }

      for (int[] row : quad_mad) {
        for (int elem : row) {
          System.out.print(elem+" ");
        }
        System.out.println("");
      }
    }
}

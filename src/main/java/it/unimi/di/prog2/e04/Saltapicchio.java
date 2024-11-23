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

package it.unimi.di.prog2.e04;

import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/saltapicchio/Testo.md">testo</a>, ma
 * senza il vincolo sul valore massimo per `N`.
 */
public class Saltapicchio {

  /** . */
  private Saltapicchio() {}
  /** 
   * Il metodo stampa "saltapicchio" se la sequenza di lunghezza N è un saltapicchio.
   * Un saltapicchio è una sequenza di numeri in cui la differenza in valore assoluto delle coppie successive assume tutti i
   * possibili valori tra 1 e N-1.
   * 
   * @param args N la lunghezza della sequenza
   */
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    boolean[] isSaltapicchio = new boolean[N];
    int[] sequenza = new int[N];
    
    try (Scanner s = new Scanner(System.in)){
      int i = 0;
      while (s.hasNext()){
        int x = s.nextInt();
        sequenza[i] = x;
        i++;
      }
    }

    for (int i = 0; i < N-1; i++) {
        int res = Math.abs(sequenza[i]-sequenza[i+1]);
        if (res<N){
          isSaltapicchio[res] = true;
        }
    }

    boolean check = true;

    for (int i = 1; i < N; i++) {
        if (!isSaltapicchio[i]){
          check = false;
        }
    }

    if (check){
      System.out.println("saltapicchio");
    }

  }

}

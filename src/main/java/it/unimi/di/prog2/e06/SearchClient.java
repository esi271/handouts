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

package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.2 di PDJ. */
public class SearchClient {

  /** . */
  private SearchClient() {}

  // Il main fi questa classe legge dal flusso di ingresso una sequenza di
  // interi (separati da spazi) e, assumendo che sia ordinata in ordine
  // crescente, emette nel flusso d'uscita la posizione dell'intero specificato
  // sulla linea di comando (se presente nell'input), o -1 viceversa.
  /** 
   * 
   * Cerca il numero x nell'array a. Restituisce -1 se x non è presente.
   * L'array a deve essere ordinato in ordine crescente.
   * 
   * @param args il numero da cercare
   * 
   */

   public static void main(String[] args){
    
    List<Integer> numeri = new ArrayList<>();
    int x = Integer.parseInt(args[0]);

    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        numeri.add(s.nextInt());
      }
    }
    
    int[] a = new int[numeri.size()];
    
    for (int i = 0; i < numeri.size(); i++) {
        a[i] = numeri.get(i);
    }

    boolean trovato = false;
    int index = -1;

    for (int i = 0; i<a.length; i++) {
        if (a[i] == x) {
            index = i;
            trovato = true; 
        } 
    }

    if (trovato) {
      System.out.println(index);
    } else {
      System.out.println("-1");
    }
    
   }
  
}

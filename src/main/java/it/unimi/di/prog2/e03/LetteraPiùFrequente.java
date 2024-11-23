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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
public class LetteraPiùFrequente {

  /** . */
  private LetteraPiùFrequente() {}
  /** 
   * 
   * Trova la lettera più frequente nella frase scritta.
   * 
   * @param args non usato
   *
   */
  public static void main(String[] args) {
    HashMap<Character, Integer> occorrenze = new HashMap<Character, Integer>();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String parola = s.nextLine();
        for (Character c : parola.toCharArray()) {
            if (c!=' '){
              occorrenze.put(c, occorrenze.getOrDefault(c, 0)+1);
            }
        }
      }
    }

    int lettera_piu_frequente = 0;

    for (Map.Entry<Character, Integer> coppia : occorrenze.entrySet()){
      lettera_piu_frequente = Math.max(lettera_piu_frequente, coppia.getValue());
    }

    System.out.println(lettera_piu_frequente);

  }

}

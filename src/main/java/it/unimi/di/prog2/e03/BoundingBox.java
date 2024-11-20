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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 */
public class BoundingBox {

  /** . */
  private BoundingBox() {}



  public static void main(String[] args) {
    List<String> linee = new ArrayList<>();
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String linea = s.nextLine();
        linee.add(linea);
      }
    }
    int sinistra, destra, sopra, sotto;
    sinistra = linee.get(0).length();
    destra = 0;
    sopra = linee.size();
    sotto = 0;

    for (int i = 0; i < linee.size(); i++) {
        for (int j = 0; j < linee.get(i).length(); j++){
          if (linee.get(i).charAt(j) == '*'){
            sinistra = Math.min(sinistra, j);
            destra = Math.max(destra, j);
            sopra = Math.min(sopra, i);
            sotto = Math.max(sotto, i);
          }
        }
    }

    int altezza = sotto - sopra + 1;
    int larghezza = destra - sinistra + 1;
    System.out.println(altezza+" "+larghezza);

  }


}

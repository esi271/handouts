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

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/nave_spaziale/Testo.md">testo</a>.
 */
public class NaveSpaziale {

  /** . */
  private NaveSpaziale() {}

  // Se String[] args è il vettore che contiene gli argomenti sulla linea
  // di comando, potete convertire i primi due in numeri interi con le
  // dichiarazioni (e inizializzazioni) seguenti
  //
  // int from = Integer.parseInt(args[0]);
  // int to = Integer.parseInt(args[1]);
  //
  // non c'è bisogno di importare alcun package per poter usare Integer.
  /**
   *  
   * Date due coordinate x e y in uno spazio monodimensionale il metodo stampa
   * la serie di comandi più veloce per arrivare da x a y.
   * I comandi sono:
   * P: 1 passo
   * S: viene quadruplicata la coordinata corrente
   * 
   * @param args le coordinate from e to
   */
  public static void main(String[] args) {
      int from = Integer.parseInt(args[0]);
      int to = Integer.parseInt(args[1]);

      StringBuilder comandi = new StringBuilder();
      while (to>from){
        if (to%4==0&&to/4>=from) {
          comandi.append('S');
          to/=4;
        } else {
          comandi.append('P');
          to--;
        }
      }

      System.out.println(comandi.reverse().toString());

  }

}

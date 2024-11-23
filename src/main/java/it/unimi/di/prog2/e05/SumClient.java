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

package it.unimi.di.prog2.e05;

/** Esercizio 3.2 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}

  // Aggiunga qui un main che invochi il metodo sum (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.2 di PDJ.

  // Il main riceve un elenco di interi come parametri sulla linea di comando e
  // ne emette la somma nel flusso d'ingresso.
  /**
   * 
   * Client per il metodo Sum di Num
   *  
   * @param args i numeri da sommare
   */
  public static void main(String[] args) {

      int[] numeri = new int[args.length];

      for (int i = 0;i<args.length;i++){
        numeri[i] = Integer.parseInt(args[i]);
      }

      System.out.println(Num.Sum(numeri));

  }

}

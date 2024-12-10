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

package it.unimi.di.prog2.e10;

import java.util.Objects;

import javax.print.attribute.standard.MediaSize;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  /** numerator p */
  public final int numerator;
  /** denominator q can't be 0 */
  public final int denominator;

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   * @throws IllegalArgumentException if {@code denominator} is 0.
   */
  public RationalNumber(int numerator, int denominator) {
    if (denominator == 0) throw new IllegalArgumentException("denominator cannot be 0");
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /** 
   * Returns the greatest common divisor between two numbers
   * @param a first number
   * @param b second number
   * @return the gcd of the two numbers
   */
  private int gcd(int a, int b) {
    while (b!=0) {
      int temp = b;
      b = a%b;
      a = temp;
    }
    return a;
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    return new RationalNumber(
      numerator + other.numerator, denominator + other.denominator
    );
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return new RationalNumber(
      numerator * other.numerator, denominator * other.denominator
    );
  }

  @Override
  public String toString() {
    return numerator+"/"+denominator;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof RationalNumber other)) return false;
    return this.numerator == other.numerator && this.denominator == other.denominator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

}

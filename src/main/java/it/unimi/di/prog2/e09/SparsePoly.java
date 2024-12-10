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
package it.unimi.di.prog2.e09;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import it.unimi.di.prog2.h08.impl.NegativeExponentException;

/**
 * {@code SparsePoly}s are immutable polynomials with integer coefficients such
 * that the number of nonzero coefficient is small with respect to the degree.
 *
 * <p>
 * A typical {@code Poly} is \( p = c_0 + c_1 x + c_2 x^2 + \cdots + c_n x^n \).
 */
public class SparsePoly {

    /**
     * A record holding a non zero term of the polynomial.
     *
     * @param coeff the coefficient.
     * @param degree the degree.
     */
    public record Term(int coeff, int degree) {

        /**
         * Builds a term.
         *
         * @throws NegativeExponentException if if {@code degree} &lt; 0.
         */
        public Term  { // using the compact constructor
            if (degree < 0) {
                throw new NegativeExponentException("A term cannot have a negative exponent.");
            }
            if (coeff == 0) {
                throw new IllegalArgumentException("A term cannot have a zero coefficient.");
            }
        }
    }

    /**
     * The array of terms (in increasing non-zero degree).
     */
    private final List<Term> terms;

    /**
     * Initializes this to be the zero polynomial, that is \( p = 0 \).
     */
    public SparsePoly() {
        terms = Collections.emptyList();
    }

    /**
     * Initializes this to be the polynomial \(p = cx^n\).
     *
     * @param c the coefficient.
     * @param n the degree.
     * @throws NegativeExponentException if {@code n} &lt; 0.
     */
    public SparsePoly(int c, int n) throws NegativeExponentException {
        terms = c == 0 ? Collections.emptyList() : List.of(new Term(c, n));
    }

    /**
     * Initializes this to be the polynomial from a list of terms in increasing
     * degree order.
     *
     * @param lst the not {@code null} list, not containing {@code null}s and in
     * increasing degree order.
     */
    private SparsePoly(final List<Term> l) {
        terms = Collections.unmodifiableList(l);
    }

    /**
     * Returns the coefficient of the term of given exponent.
     *
     * @param d the exponent of the term to consider.
     * @return the coefficient of the considered term.
     */
    public int coeff(int d) {
        if (d < 0 || d > degree()) {
            return 0;
        }
        int i = findByDegree(this.terms, d);
        return i != -1 ? this.terms.get(i).coeff : 0;
    }

    /**
     * Returns the index of the term of the given degree
     *
     * @param l the list
     * @param d the degree
     * @return the index of the term in the list, -1 if not found
     */
    private static int findByDegree(List<Term> l, int d) {
        for (int i = 0; i < l.size(); i++) {
            int degree = l.get(i).degree;
            if (degree == d) {
                return i;
            }
            if (degree > d) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Returns the degree of this polynomial.
     *
     * @return the largest exponent with a non-zero coefficient; returns 0 if
     * this is the zero {@code
     *     Poly}.
     */
    public int degree() {
        return terms.isEmpty() ? 0 : terms.getLast().degree;
    }

    /**
     * Adds a term in the list of increasing order by degree.
     *
     * If there's already a term of the same degree then the two will be summed
     * or removed if the coefficient is 0.
     *
     * @param l the list
     * @param term the term added to the list
     */
    private static void addTerm(List<Term> l, Term term) {
        if (term.coeff == 0) {
            return;
        }
        int ind = findByDegree(l, term.degree);
        if (ind != -1) {
            int c = l.get(ind).coeff + term.coeff;
            if (c != 0) {
                l.set(ind, new Term(c, term.degree));
            } else {
                l.remove(ind);
            }
        } else {
            ind = 0;
            while (ind < l.size() && l.get(ind).degree < term.degree) {
                ind++;
            }
            l.add(ind, term);
        }
    }

    /**
     * Performs polynomial addition.
     *
     * <p>
     * If \( p \) is this polynomial, returns \( p + q \).
     *
     * @param q the polynomial to add to this one.
     * @return the sum among this and the given polynomial.
     * @throws NullPointerException if {@code q} is {@code null}.
     */
    public SparsePoly add(SparsePoly q) throws NullPointerException {
        Objects.requireNonNull(q, "Poly cannot be null");
        List<Term> res = new LinkedList<>(this.terms);
        for (Term t : q.terms) {
            addTerm(res, t);
        }
        return new SparsePoly(res);
    }

    /**
     * Performs polynomial multiplication.
     *
     * <p>
     * If \( p \) is this polynomial, returns \( p q \).
     *
     * @param q the polynomial to multiply by this one.
     * @return the product among this and the given polynomial.
     * @throws NullPointerException if {@code q} is {@code null}.
     */
    public SparsePoly mul(SparsePoly q) throws NullPointerException {
        Objects.requireNonNull(q, "Poly cannot be null");
        List<Term> res = new LinkedList<>();
        for (Term qterm : q.terms) {
            for (Term tterm : this.terms) {
                addTerm(res, new Term(qterm.coeff * tterm.coeff, qterm.degree + tterm.degree));
            }
        }
        return new SparsePoly(res);
    }

    /**
     * Performs polynomial subtraction.
     *
     * <p>
     * If \( p \) is this polynomial, returns \( p - q \).
     *
     * @param q the polynomial to subtract from this one.
     * @return the subtraction among this and the given polynomial.
     * @throws NullPointerException if {@code q} is {@code null}.
     */
    public SparsePoly sub(SparsePoly q) throws NullPointerException {
        Objects.requireNonNull(q, "Poly cannot be null");
        return add(q.minus());
    }

    /**
     * Returns the negate polynomial.
     *
     * <p>
     * If \( p \) is this polynomial, returns \( -p \).
     *
     * @return this polynomial multiplied by \( -1 \).
     */
    public SparsePoly minus() {
        List<Term> res = new LinkedList<>();
        for (Term t : this.terms) {
            res.add(new Term(-t.coeff, t.degree));
        }
        return new SparsePoly(res);
    }
}

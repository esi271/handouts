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

/**
 * A <em>queue</em> is a mutable data structure that provides access to its
 * elements in first-in/first-out order.
 *
 * <p>
 * A <em>bounded</em> queue has an upper bound, established when a queue is
 * created, on the number of elements that can be stored in the queue.
 */
public class BoundedIntQueue {

    // EXERCISE: complete following the specification (with particular attention
    // to the eventual exceptions) and provide an implementation (including the
    // equals, hashCode, and toString methods); add methods that are adequate to
    // the specification.
    // Given the boundedness constraint, it is not allowed to use any Java
    // Collection Framework class. An array can be used to store the elements in a
    // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).
    /**
     * the queue
     */
    private int[] queue;
    /**
     * points to the index of the first element of the queue -1 if the queue is
     * empty
     */
    private int head;
    /**
     * points to the last element of the queue
     */
    private int tail;

    /**
     * Creates a new bounded queue with the given capacity.
     *
     * @param capacity the capacity of the queue.
     * @throws IllegalArgumentException if {@code capacity} is negative.
     */
    public BoundedIntQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can't be negative.");
        }
        queue = new int[capacity];
        head = -1;
        tail = 0;
    }

    /**
     * Determines if the queue is empty
     *
     * @return true if its empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Determines if the queue is full
     *
     * @return true if its full, false otherwise.
     */
    public boolean isFull() {
        return tail == head;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements.
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (isFull()) {
            return queue.length;
        }
        return (tail - head + queue.length) % queue.length;
    }

    /**
     * Adds an element to the queue.
     *
     * @param x the element to add.
     * @throws IllegalStateException if the queue is full.
     */
    public void enqueue(int x) {
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        }
        if (head == -1) {
            head = 0;
        }
        queue[tail] = x;
        tail = (tail + 1) % queue.length;
    }

    /**
     * Removes the element at the head of the queue.
     *
     * @return the element at the head of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        int number = queue[head];
        head = (head + 1) % queue.length;
        if (head == tail) {
            head = -1;
            tail = 0;
        }
        return number;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "BoundedIntQueue: []";
        }
        final StringBuilder sb = new StringBuilder("BoundedIntQueue: [");
        int i = head, n = 0;
        while (n < size() - 1) {
            sb.append(queue[i] + ", ");
            i = (i + 1) % queue.length;
            n += 1;
        }
        sb.append(queue[i] + "]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 0;
        int i = head, n = 0;
        while (n < size()) {
            result = 31 * result + Integer.hashCode(queue[i]);
            i = (i + 1) % queue.length;
            n += 1;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BoundedIntQueue other)) {
            return false;
        }
        if (size() != other.size()) {
            return false;
        }
        int i = head, j = other.head, n = 0;
        while (n < size()) {
            if (queue[i] != other.queue[j]) {
                return false;
            }
            i = (i + 1) % queue.length;
            j = (j + 1) % other.queue.length;
            n += 1;
        }
        return true;
    }

}

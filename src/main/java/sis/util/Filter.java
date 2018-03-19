package sis.util;

interface Filter<T> {
    boolean apply(T value);
}

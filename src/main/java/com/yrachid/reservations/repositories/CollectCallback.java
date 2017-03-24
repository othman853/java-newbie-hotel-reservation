package com.yrachid.reservations.repositories;

@FunctionalInterface
public interface  CollectCallback<T> {

    void collect(T collector);
}

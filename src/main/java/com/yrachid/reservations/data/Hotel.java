package com.yrachid.reservations.data;

import com.yrachid.reservations.repositories.CollectCallback;

import java.util.Collection;
import java.util.stream.Collectors;

public class Hotel {

    public final int id;
    public final String name;
    public final int rating;
    public final Collection<HotelPrice> prices;

    private Hotel(HotelCollector collector) {
        this.id = collector.id;
        this.name = collector.name;
        this.rating = collector.rating;
        this.prices = collector.prices;
    }

    public Collection<HotelPrice> pricesByCustomerType(CustomerType customerType) {
        return prices
                .stream()
                .filter(price -> price.customerType.equals(customerType))
                .collect(Collectors.toList());
    }

    public static class HotelCollector {

        private int id;
        private String name;
        private int rating;
        private Collection<HotelPrice> prices;

        public HotelCollector id(int id) {
            this.id = id;
            return this;
        }

        public HotelCollector name(String name) {
            this.name = name;
            return this;
        }

        public HotelCollector rating(int rating) {
            this.rating = rating;
            return this;
        }

        public HotelCollector prices(Collection<HotelPrice> prices) {
            this.prices = prices;
            return this;
        }
    }

    public static Hotel hotel(CollectCallback<HotelCollector> collectCallback) {
        HotelCollector collector = new HotelCollector();
        collectCallback.collect(collector);

        return new Hotel(collector);
    }

}

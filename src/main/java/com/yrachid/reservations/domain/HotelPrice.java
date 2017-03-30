package com.yrachid.reservations.domain;


import com.yrachid.reservations.repositories.CollectCallback;

public class HotelPrice {

    public final double value;
    public final CustomerType customerType;
    public final DayType dayType;

    private HotelPrice(HotelPriceCollector collector) {
        this.value = collector.value;
        this.customerType = collector.customerType;
        this.dayType = collector.dayType;
    }

    public static class HotelPriceCollector {

        private double value;
        private CustomerType customerType;
        private DayType dayType;

        public HotelPriceCollector value(double value) {
            this.value = value;
            return this;
        }

        public HotelPriceCollector customerType(CustomerType customerType) {
            this.customerType = customerType;
            return this;
        }

        public HotelPriceCollector dayType(DayType dayType) {
            this.dayType = dayType;
            return this;
        }
    }

    public static HotelPrice hotelPrice(CollectCallback<HotelPriceCollector> callback) {
        HotelPriceCollector collector = new HotelPriceCollector();
        callback.collect(collector);
        return new HotelPrice(collector);
    }
}

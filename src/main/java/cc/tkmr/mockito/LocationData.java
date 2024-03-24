/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

public class LocationData {

    private String state;
    private String city;
    private String streetName;
    private String addressComplement;
    private String district;
    private String zipCode;

    public LocationData(final String state, final String city, final String streetName, final String addressComplement, final String district) {
        this.state = state;
        this.city = city;
        this.streetName = streetName;
        this.addressComplement = addressComplement;
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public String getDistrict() {
        return district;
    }

    public String getZipCode() {
        return zipCode;
    }
}

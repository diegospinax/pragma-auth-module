package co.pragma.webflux_auth.domain.user.valueObjects.support;

public class Address {

    private String country;
    private String city;
    private String streetName;
    private String streetNumber;

    public Address(String country, String city, String streetName, String streetNumber) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public void validateAddress() {
        String countryCityRegex = "^\\p{L}+(?:[_']\\p{L}+)*$";
        String streetRegex = "^[\\p{L}\\d]+(?:[_']([\\p{L}\\d]+))*$";

        validateAddressField(countryCityRegex, country);
        validateAddressField(countryCityRegex, city);
        validateAddressField(streetRegex, streetName);
        validateAddressField("^#\\d{2}-\\d{2}$", streetNumber);
    }

    private void validateAddressField (String regex, String field) {
        if (!field.matches(regex)) {
            throw new RuntimeException();
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}

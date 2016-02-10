package travel;

import java.util.ArrayList;

public class Travel {

    private static String[] addresses;
    private static ArrayList<Address> addressesFormat = new ArrayList<>();
    private static String street;
    private static String streetNumber;

    public static String travel(String ad, String zc) {
        street = ""; streetNumber = "";
        addresses = ad.split(",");
        formatAddresses();
        return fillZipCodeAddresses(zc) ?String.format("%s:%s/%s", zc, street, streetNumber) : String.format("%s:/", zc);
    }

    private static boolean fillZipCodeAddresses(String zc) {
        addressesFormat.stream().filter(address -> address.zipCode().equals(zc)).forEach((address) -> {
            addStreet(address.street());
            addStreetNumber(address.streetNumber());
        });
        removeCommas();
        return !street.equals("");
    }

    private static void formatAddresses() {
        addressesFormat.clear();
        for (String address : addresses) {
            addressesFormat.add(new Address(zipCode(address), streetNumber(address), street(address)));
        }
    }

    private static void addStreet(String st) {
        street += st + ",";
    }

    private static void addStreetNumber(String number) {
        streetNumber += number + ",";
    }

    private static void removeCommas() {
        streetNumber = (!streetNumber.equals("")) ?  streetNumber.substring(0, streetNumber.length() -1) : "";
        street = (!street.equals("")) ? street.substring(0, street.length() -1) : "";
    }

    private static String zipCode(String address) {
        return address.substring(address.length() - 8);
    }

    private static String street(String address) {
        return address.substring(address.indexOf(" ") +1, address.length() -9);
    }

    private static String streetNumber(String address) {
        return address.substring(0, address.indexOf(" "));
    }

    private static class Address {

        private String zipCode;
        private String street;
        private String streetNumber;

        public Address(String zipCode, String streetNumber, String street) {
            this.zipCode = zipCode;
            this.streetNumber = streetNumber;
            this.street = street;
        }

        public String zipCode() {
            return zipCode;
        }

        public String street() {
            return street;
        }

        public String streetNumber() {
            return streetNumber;
        }
    }
}

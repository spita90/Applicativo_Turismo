class Posizione {

    private double lat;
    private double lon;

    Posizione(double lat, double lon) {
        if (lat >= 0 && lon >= 0) {
            this.lat = lat;
            this.lon = lon;
        } else {
            this.lat = 0;
            this.lon = 0;
        }

    }


    double getLat() {
        return lat;
    }

    void setLat(double lat) {
        if (lat >= 0) {
            this.lat = lat;
        }
    }

    double getLon() {
        return lon;
    }

    void setLon(double lon) {
        if (lon >= 0) {
            this.lon = lon;
        }
    }

}

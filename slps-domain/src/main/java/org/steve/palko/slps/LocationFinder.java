package org.steve.palko.slps;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocationFinder {
    public Location findLocation(Address address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("").build();
        GeocodingResult[] results = GeocodingApi.geocode(context, address.toString()).awaitIgnoreError();
        var latLng = results[0].geometry.location;
        var location = new Location();
        location.setLatitude(latLng.lat);
        location.setLongitude(latLng.lng);
        location.setPlaceId(results[0].placeId);
        context.shutdown();
        return location;
    }
}

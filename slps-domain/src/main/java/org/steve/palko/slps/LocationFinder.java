package org.steve.palko.slps;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class LocationFinder {
    public Location findLocation(Address address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAr4ia9Od2D3LXJhll0mIdQHVrSMKJoMsc").build();
        GeocodingResult[] results = GeocodingApi.geocode(context, address.toString()).awaitIgnoreError();
        if (results.length == 0) {
            return null;
        }
        var latLng = results[0].geometry.location;
        var location = new Location();
        location.setLatitude(latLng.lat);
        location.setLongitude(latLng.lng);
        location.setPlaceId(results[0].placeId);
        context.shutdown();
        return location;
    }
}

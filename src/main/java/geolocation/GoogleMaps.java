package geolocation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.GeocodingResult;
import model.Address;

import java.io.IOException;

/**
 * Created by ivan on 29.08.17.
 */
public class GoogleMaps implements IGoogleMaps {

    private static final String GOOGLE_API_KEY = "AIzaSyCoBMARXKngMO8pxCsnl6kwCRwMsBC5NDs";

    public String getAddressFormatetPoint(Address address) {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(GOOGLE_API_KEY).build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, address.toFormatedAddress()).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(results[0].formattedAddress);

    }

    @Override
    public long  getDistanceBetweenTwoPoints(Address firstFormatAddress, Address secondFormatAddress) {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(GOOGLE_API_KEY).build();
        DistanceMatrix distanceMatrix = null;
        try {
            distanceMatrix = DistanceMatrixApi.newRequest(context)
                    .origins(firstFormatAddress.toFormatedAddress())
                    .destinations(secondFormatAddress.toFormatedAddress()).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        DistanceMatrixRow[] rows = distanceMatrix.rows;
        DistanceMatrixRow firstRow = rows[0];
        Distance distance = firstRow.elements[0].distance;
        return distance.inMeters;
    }


}

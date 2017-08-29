package geolocation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import model.Address;

import java.io.IOException;

/**
 * Created by ivan on 29.08.17.
 */
public class GoogleMaps {

    //String address = new Address("Київ", "Борщагівська", "146" ).toFormatedAddress();

    private static final String GOOGLE_API_KEY = "AIzaSyCoBMARXKngMO8pxCsnl6kwCRwMsBC5NDs";

    public String getAddressPoint(Address address) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder().apiKey(GOOGLE_API_KEY).build();
        GeocodingResult[] results = GeocodingApi.geocode(context, address.toFormatedAddress()).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(results[0].formattedAddress);
    }


}

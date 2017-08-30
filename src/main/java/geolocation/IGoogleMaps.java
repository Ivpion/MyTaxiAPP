package geolocation;

import com.google.maps.errors.ApiException;
import model.Address;

import java.io.IOException;

/**
 * Created by ivan on 29.08.17.
 */
public interface IGoogleMaps {

    String getAddressFormatetPoint(Address address) throws InterruptedException, ApiException, IOException;

    long getDistanceBetweenTwoPoints(Address firstFormatAddress, Address secondFormatAddress) throws InterruptedException, ApiException, IOException;
}

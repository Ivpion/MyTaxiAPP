import com.google.maps.errors.ApiException;
import geolocation.GoogleMaps;
import model.Address;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ivan on 29.08.17.
 */
public class GeolocationTests {
    Address myAddress = new Address("Київ", "Борщагівська", "146");
    String address = new Address("Київ", "Борщагівська", "146" ).toFormatedAddress();

    @Test
    public void testGetAddressPoint(){
        try {
            String resAddress =  new GoogleMaps().getAddressPoint(myAddress);
            resAddress = resAddress.substring(1,resAddress.length()-1);
            System.out.println(resAddress);
            Assert.assertEquals("Borshchahivska St, 146, Kyiv, Ukraine",resAddress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

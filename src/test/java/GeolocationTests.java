import geolocation.GoogleMaps;
import model.Address;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ivan on 29.08.17.
 */
public class GeolocationTests {
    Address firstAddress = new Address("Київ", "Борщагівська", "146");
    Address secondAddress = new Address("Київ", "Леся Курбаса", "2");
    String address = new Address("Київ", "Борщагівська", "146" ).toFormatedAddress();

    @Test
    public void testGetAddressPoint(){
            String resAddress1 =  new GoogleMaps().getAddressFormatetPoint(firstAddress);
            resAddress1 = resAddress1.substring(1,resAddress1.length()-1);
            System.out.println(resAddress1);
            String resAddress2 = new GoogleMaps().getAddressFormatetPoint(secondAddress);
            resAddress2 = resAddress2.substring(1,resAddress2.length()-1);
            Assert.assertEquals("Borshchahivska St, 146, Kyiv, Ukraine",resAddress1);
            Assert.assertEquals("Lesya Kurbasa Ave, 2, Kyiv, Ukraine", resAddress2);


    }

    @Test
    public void testGetDistanceBetweenTwoPoints(){
        long  res = new GoogleMaps().getDistanceBetweenTwoPoints(firstAddress, secondAddress);

       Assert.assertEquals(4391, res);
    }
}

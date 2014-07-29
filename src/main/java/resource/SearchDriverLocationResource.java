package resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import msg.Driver;
import msg.DriverLocation;
import msg.DriverSearchResult;
import msg.postcode.service.Postcode;
import msg.postcode.service.PostcodeResponse;

import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/driver/location") @Produces(MediaType.APPLICATION_JSON)
public class SearchDriverLocationResource {

    @GET @Timed
    public List<DriverLocation> search(@QueryParam("ageRange") Optional<String> ageRange) {
        final Client httpClient = Client.create();
        DriverSearchResult response = httpClient.resource("http://localhost:8280/driver")
                .get(DriverSearchResult.class);

        return Lists.transform(response.getResults(), new Function<Driver, DriverLocation>() {
            @Nullable @Override
            public DriverLocation apply(@Nullable Driver input) {
                if (input.getAddress().getRealPostCode() != null) {
                    String url = "http://localhost:9000/postcode/" + input.getAddress().getRealPostCode();
                    List<Postcode> postcodeList = httpClient
                            .resource(url).get(new GenericType<List<Postcode>>() {});
                    return new DriverLocation(input, postcodeList.get(0).coord);
                } else {
                    return new DriverLocation(input);
                }
            }
        });
    }
}

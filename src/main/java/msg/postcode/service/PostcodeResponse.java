package msg.postcode.service;

import java.util.List;

public class PostcodeResponse {

    private List<Postcode> results;

    public PostcodeResponse() {}

    public PostcodeResponse(List<Postcode> results) {
        this.results = results;
    }

    public List<Postcode> getResults() {
        return results;
    }

    public void setResults(List<Postcode> results) {
        this.results = results;
    }
}

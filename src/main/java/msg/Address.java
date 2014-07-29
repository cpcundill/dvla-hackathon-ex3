package msg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.StringUtils;

public class Address {

    private String postCode;
    private String uPostCode;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getuPostCode() {
        return uPostCode;
    }

    public void setuPostCode(String uPostCode) {
        this.uPostCode = uPostCode;
    }

    @JsonIgnore
    public String getRealPostCode() {
        if (!StringUtils.isBlank(postCode))
            return postCode.replace(" ", "");
        else
            return uPostCode.replace(" ", "");
    }
}

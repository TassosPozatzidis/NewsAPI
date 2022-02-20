
package NewsAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ip",
    "location",
    "domains",
    "as",
    "isp"
})
@Generated("jsonschema2pojo")
public class IpDetails {

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("domains")
    private List<String> domains = null;
    @JsonProperty("as")
    private As as;
    @JsonProperty("isp")
    private String isp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IpDetails() {
    }

    /**
     * 
     * @param as
     * @param ip
     * @param isp
     * @param domains
     * @param location
     */
    public IpDetails(String ip, Location location, List<String> domains, As as, String isp) {
        super();
        this.ip = ip;
        this.location = location;
        this.domains = domains;
        this.as = as;
        this.isp = isp;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("as")
    public As getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(As as) {
        this.as = as;
    }

    @JsonProperty("isp")
    public String getIsp() {
        return isp;
    }

    @JsonProperty("isp")
    public void setIsp(String isp) {
        this.isp = isp;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

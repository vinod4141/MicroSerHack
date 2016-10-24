
package com.emirates.cds.eligibility.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tripid",
    "flightno",
    "pnr",
    "passenger",
    "distance"
})
public class Eligibility {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tripid")
    private String tripid;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("flightno")
    private String flightno;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pnr")
    private String pnr;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("passenger")
    private String passenger;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("distance")
    private String distance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tripid
     */
    @JsonProperty("tripid")
    public String getTripid() {
        return tripid;
    }

    /**
     * 
     * (Required)
     * 
     * @param tripid
     *     The tripid
     */
    @JsonProperty("tripid")
    public void setTripid(String tripid) {
        this.tripid = tripid;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The flightno
     */
    @JsonProperty("flightno")
    public String getFlightno() {
        return flightno;
    }

    /**
     * 
     * (Required)
     * 
     * @param flightno
     *     The flightno
     */
    @JsonProperty("flightno")
    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pnr
     */
    @JsonProperty("pnr")
    public String getPnr() {
        return pnr;
    }

    /**
     * 
     * (Required)
     * 
     * @param pnr
     *     The pnr
     */
    @JsonProperty("pnr")
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The passenger
     */
    @JsonProperty("passenger")
    public String getPassenger() {
        return passenger;
    }

    /**
     * 
     * (Required)
     * 
     * @param passenger
     *     The passenger
     */
    @JsonProperty("passenger")
    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The distance
     */
    @JsonProperty("distance")
    public String getDistance() {
        return distance;
    }

    /**
     * 
     * (Required)
     * 
     * @param distance
     *     The distance
     */
    @JsonProperty("distance")
    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tripid).append(flightno).append(pnr).append(passenger).append(distance).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Eligibility) == false) {
            return false;
        }
        Eligibility rhs = ((Eligibility) other);
        return new EqualsBuilder().append(tripid, rhs.tripid).append(flightno, rhs.flightno).append(pnr, rhs.pnr).append(passenger, rhs.passenger).append(distance, rhs.distance).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}


package com.emirates.cds.vehicle.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vehicleno",
    "serviceproviderid",
    "pnr",
    "leadpassenger",
    "pickup",
    "destination",
    "noofbaggages",
    "noofpassenger"
})
public class Vehicles {

    /**
     * Save the vehicles
     * (Required)
     * 
     */
    @JsonProperty("vehicleno")
    @JsonPropertyDescription("")
    private String vehicleno;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("serviceproviderid")
    private String serviceproviderid;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pnr")
    private Object pnr;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("leadpassenger")
    private String leadpassenger;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pickup")
    private String pickup;
    /**
     * pick up/drop otff point
     * (Required)
     * 
     */
    @JsonProperty("destination")
    @JsonPropertyDescription("")
    private String destination;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("noofbaggages")
    private Integer noofbaggages;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("noofpassenger")
    private Integer noofpassenger;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Save the vehicles
     * (Required)
     * 
     * @return
     *     The vehicleno
     */
    @JsonProperty("vehicleno")
    public String getVehicleno() {
        return vehicleno;
    }

    /**
     * Save the vehicles
     * (Required)
     * 
     * @param vehicleno
     *     The vehicleno
     */
    @JsonProperty("vehicleno")
    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The serviceproviderid
     */
    @JsonProperty("serviceproviderid")
    public String getServiceproviderid() {
        return serviceproviderid;
    }

    /**
     * 
     * (Required)
     * 
     * @param serviceproviderid
     *     The serviceproviderid
     */
    @JsonProperty("serviceproviderid")
    public void setServiceproviderid(String serviceproviderid) {
        this.serviceproviderid = serviceproviderid;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pnr
     */
    @JsonProperty("pnr")
    public Object getPnr() {
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
    public void setPnr(Object pnr) {
        this.pnr = pnr;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The leadpassenger
     */
    @JsonProperty("leadpassenger")
    public String getLeadpassenger() {
        return leadpassenger;
    }

    /**
     * 
     * (Required)
     * 
     * @param leadpassenger
     *     The leadpassenger
     */
    @JsonProperty("leadpassenger")
    public void setLeadpassenger(String leadpassenger) {
        this.leadpassenger = leadpassenger;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pickup
     */
    @JsonProperty("pickup")
    public String getPickup() {
        return pickup;
    }

    /**
     * 
     * (Required)
     * 
     * @param pickup
     *     The pickup
     */
    @JsonProperty("pickup")
    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    /**
     * pick up/drop otff point
     * (Required)
     * 
     * @return
     *     The destination
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * pick up/drop otff point
     * (Required)
     * 
     * @param destination
     *     The destination
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The noofbaggages
     */
    @JsonProperty("noofbaggages")
    public Integer getNoofbaggages() {
        return noofbaggages;
    }

    /**
     * 
     * (Required)
     * 
     * @param noofbaggages
     *     The noofbaggages
     */
    @JsonProperty("noofbaggages")
    public void setNoofbaggages(Integer noofbaggages) {
        this.noofbaggages = noofbaggages;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The noofpassenger
     */
    @JsonProperty("noofpassenger")
    public Integer getNoofpassenger() {
        return noofpassenger;
    }

    /**
     * 
     * (Required)
     * 
     * @param noofpassenger
     *     The noofpassenger
     */
    @JsonProperty("noofpassenger")
    public void setNoofpassenger(Integer noofpassenger) {
        this.noofpassenger = noofpassenger;
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
        return new HashCodeBuilder().append(vehicleno).append(serviceproviderid).append(pnr).append(leadpassenger).append(pickup).append(destination).append(noofbaggages).append(noofpassenger).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Vehicles) == false) {
            return false;
        }
        Vehicles rhs = ((Vehicles) other);
        return new EqualsBuilder().append(vehicleno, rhs.vehicleno).append(serviceproviderid, rhs.serviceproviderid).append(pnr, rhs.pnr).append(leadpassenger, rhs.leadpassenger).append(pickup, rhs.pickup).append(destination, rhs.destination).append(noofbaggages, rhs.noofbaggages).append(noofpassenger, rhs.noofpassenger).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

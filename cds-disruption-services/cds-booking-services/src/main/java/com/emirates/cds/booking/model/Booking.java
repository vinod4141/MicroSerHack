
package com.emirates.cds.booking.model;

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
    "flighno",
    "pnr",
    "passenger",
    "airport",
    "destination",
    "noofbaggages",
    "pickuptime"
})
public class Booking {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("flighno")
    private String flighno;
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
    @JsonProperty("pax")
    private String passenger;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("airport")
    private String airport;
    /**
     * pick up/drop off point
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
    private String noofbaggages;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pickuptime")
    private String pickuptime;
    
    @JsonProperty("paxcount")
    private String paxCount;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("vehicleid")
    private String vehicleid;    
       
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The flighno
     */
    @JsonProperty("flightno")
    public String getFlighno() {
        return flighno;
    }

    /**
     * 
     * (Required)
     * 
     * @param flighno
     *     The flighno
     */
    @JsonProperty("flightno")
    public void setFlighno(String flighno) {
        this.flighno = flighno;
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
     *     The airport
     */
    @JsonProperty("airport")
    public String getAirport() {
        return airport;
    }

    /**
     * 
     * (Required)
     * 
     * @param airport
     *     The airport
     */
    @JsonProperty("airport")
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * pick up/drop off point
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
     * pick up/drop off point
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
    public String getNoofbaggages() {
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
    public void setNoofbaggages(String noofbaggages) {
        this.noofbaggages = noofbaggages;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pickuptime
     */
    @JsonProperty("pickuptime")
    public String getPickuptime() {
        return pickuptime;
    }

    /**
     * 
     * (Required)
     * 
     * @param pickuptime
     *     The pickuptime
     */
    @JsonProperty("pickuptime")
    public void setPickuptime(String pickuptime) {
        this.pickuptime = pickuptime;
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
        return new HashCodeBuilder().append(flighno).append(pnr).append(passenger).append(airport).append(destination).append(noofbaggages).append(pickuptime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Booking) == false) {
            return false;
        }
        Booking rhs = ((Booking) other);
        return new EqualsBuilder().append(flighno, rhs.flighno).append(pnr, rhs.pnr).append(passenger, rhs.passenger).append(airport, rhs.airport).append(destination, rhs.destination).append(noofbaggages, rhs.noofbaggages).append(pickuptime, rhs.pickuptime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @JsonProperty("paxcount")
	public String getPaxCount() {
		return paxCount;
	}
    
    @JsonProperty("paxcount")
	public void setPaxCount(String paxCount) {
		this.paxCount = paxCount;
	}

    @JsonProperty("status")
	public String getStatus() {
		return status;
	}

    @JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("vehicleid")
	public String getVehicleid() {
		return vehicleid;
	}

	@JsonProperty("vehicleid")
	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

}

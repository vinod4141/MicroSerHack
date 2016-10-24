package com.emirates.cds.vehicle.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
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
	"ancilaryfeature",
	"make",
	"model",
    "vehicleno",
    "serviceproviderid",
    "noofbaggages",
    "noofpassenger"
})
@DynamoDBTable(tableName = "VEHICLE_MASTER")
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
    @JsonProperty("make")
    private Object make;
    @DynamoDBAttribute(attributeName = "make")
    public Object getMake() {
		return make;
	}

	public void setMake(Object make) {
		this.make = make;
	}
	
	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@JsonProperty("ancilaryfeature")
	public String getAncilaryfeature() {
		return ancilaryfeature;
	}

	public void setAncilaryfeature(String ancilaryfeature) {
		this.ancilaryfeature = ancilaryfeature;
	}

	/**
     * 
     * (Required)
     * 
     */
    @JsonProperty("model")
    private String model;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ancilaryfeature")
    private String ancilaryfeature;
  
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

   

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vehicleno).append(serviceproviderid).append(noofbaggages).append(noofpassenger)
        		.toHashCode();
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
        return new EqualsBuilder().append(vehicleno, rhs.vehicleno).append(serviceproviderid, rhs.serviceproviderid)
        		.append(noofbaggages, rhs.noofbaggages).append(noofpassenger, rhs.noofpassenger).isEquals();
    }

}

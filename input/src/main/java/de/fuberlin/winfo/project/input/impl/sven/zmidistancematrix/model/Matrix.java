
package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "mode",
    "distanceUnit",
    "routingMatrix",
    "mapVersion",
    "id",
    "mapName",
    "timeUnit",
    "consumptionUnit"
})
public class Matrix {

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("distanceUnit")
    private String distanceUnit;
    @JsonProperty("routingMatrix")
    private List<List<String>> routingMatrix = new ArrayList<List<String>>();
    @JsonProperty("mapVersion")
    private String mapVersion;
    @JsonProperty("id")
    private long id;
    @JsonProperty("mapName")
    private String mapName;
    @JsonProperty("timeUnit")
    private String timeUnit;
    @JsonProperty("consumptionUnit")
    private String consumptionUnit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The mode
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    public Matrix withMode(String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * 
     * @return
     *     The distanceUnit
     */
    @JsonProperty("distanceUnit")
    public String getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * 
     * @param distanceUnit
     *     The distanceUnit
     */
    @JsonProperty("distanceUnit")
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public Matrix withDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
        return this;
    }

    /**
     * 
     * @return
     *     The routingMatrix
     */
    @JsonProperty("routingMatrix")
    public List<List<String>> getRoutingMatrix() {
        return routingMatrix;
    }

    /**
     * 
     * @param routingMatrix
     *     The routingMatrix
     */
    @JsonProperty("routingMatrix")
    public void setRoutingMatrix(List<List<String>> routingMatrix) {
        this.routingMatrix = routingMatrix;
    }

    public Matrix withRoutingMatrix(List<List<String>> routingMatrix) {
        this.routingMatrix = routingMatrix;
        return this;
    }

    /**
     * 
     * @return
     *     The mapVersion
     */
    @JsonProperty("mapVersion")
    public String getMapVersion() {
        return mapVersion;
    }

    /**
     * 
     * @param mapVersion
     *     The mapVersion
     */
    @JsonProperty("mapVersion")
    public void setMapVersion(String mapVersion) {
        this.mapVersion = mapVersion;
    }

    public Matrix withMapVersion(String mapVersion) {
        this.mapVersion = mapVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
    }

    public Matrix withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The mapName
     */
    @JsonProperty("mapName")
    public String getMapName() {
        return mapName;
    }

    /**
     * 
     * @param mapName
     *     The mapName
     */
    @JsonProperty("mapName")
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public Matrix withMapName(String mapName) {
        this.mapName = mapName;
        return this;
    }

    /**
     * 
     * @return
     *     The timeUnit
     */
    @JsonProperty("timeUnit")
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * 
     * @param timeUnit
     *     The timeUnit
     */
    @JsonProperty("timeUnit")
    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Matrix withTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
        return this;
    }

    /**
     * 
     * @return
     *     The consumptionUnit
     */
    @JsonProperty("consumptionUnit")
    public String getConsumptionUnit() {
        return consumptionUnit;
    }

    /**
     * 
     * @param consumptionUnit
     *     The consumptionUnit
     */
    @JsonProperty("consumptionUnit")
    public void setConsumptionUnit(String consumptionUnit) {
        this.consumptionUnit = consumptionUnit;
    }

    public Matrix withConsumptionUnit(String consumptionUnit) {
        this.consumptionUnit = consumptionUnit;
        return this;
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

    public Matrix withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mode).append(distanceUnit).append(routingMatrix).append(mapVersion).append(id).append(mapName).append(timeUnit).append(consumptionUnit).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Matrix) == false) {
            return false;
        }
        Matrix rhs = ((Matrix) other);
        return new EqualsBuilder().append(mode, rhs.mode).append(distanceUnit, rhs.distanceUnit).append(routingMatrix, rhs.routingMatrix).append(mapVersion, rhs.mapVersion).append(id, rhs.id).append(mapName, rhs.mapName).append(timeUnit, rhs.timeUnit).append(consumptionUnit, rhs.consumptionUnit).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

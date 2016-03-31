
package de.fuberlin.winfo.project.model.input.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
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
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "points",
    "applicationKey",
    "mode"
})
public class MatrixJsonRequest {

    @JsonProperty("points")
    private String points;
    @JsonProperty("applicationKey")
    private String applicationKey;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The points
     */
    @JsonProperty("points")
    public String getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    @JsonProperty("points")
    public void setPoints(String points) {
        this.points = points;
    }

    public MatrixJsonRequest withPoints(String points) {
        this.points = points;
        return this;
    }

    /**
     * 
     * @return
     *     The applicationKey
     */
    @JsonProperty("applicationKey")
    public String getApplicationKey() {
        return applicationKey;
    }

    /**
     * 
     * @param applicationKey
     *     The applicationKey
     */
    @JsonProperty("applicationKey")
    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public MatrixJsonRequest withApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
        return this;
    }

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

    public MatrixJsonRequest withMode(String mode) {
        this.mode = mode;
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

    public MatrixJsonRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(points).append(applicationKey).append(mode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MatrixJsonRequest) == false) {
            return false;
        }
        MatrixJsonRequest rhs = ((MatrixJsonRequest) other);
        return new EqualsBuilder().append(points, rhs.points).append(applicationKey, rhs.applicationKey).append(mode, rhs.mode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Performance {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("typePerformance")
    @Expose
    private TypePerformance typePerformance;
    @SerializedName("sport")
    @Expose
    private Sport sport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePerformance getTypePerformance() {
        return typePerformance;
    }

    public void setTypePerformance(TypePerformance typePerformance) {
        this.typePerformance = typePerformance;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

}
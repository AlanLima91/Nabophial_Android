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

    /**
     * No args constructor for use in serialization
     *
     */
    public Performance() {
    }

    /**
     *
     * @param id
     * @param typePerformance
     * @param name
     * @param sport
     */
    public Performance(Integer id, String name, TypePerformance typePerformance, Sport sport) {
        super();
        this.id = id;
        this.name = name;
        this.typePerformance = typePerformance;
        this.sport = sport;
    }


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
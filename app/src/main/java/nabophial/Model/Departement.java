package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Departement {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private Region region;

    /**
     * No args constructor for use in serialization
     *
     */
    public Departement() {
    }

    /**
     *
     * @param region
     * @param id
     * @param name
     */
    public Departement(Integer id, String name, Region region) {
        super();
        this.id = id;
        this.name = name;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
package nabophial.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("departement")
    @Expose
    private Departement departement;

    /**
     * No args constructor for use in serialization
     *
     */
    public City() {
    }

    /**
     *
     * @param id
     * @param name
     * @param departement
     */
    public City(Integer id, String name, Departement departement) {
        super();
        this.id = id;
        this.name = name;
        this.departement = departement;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

}
package at.gv.ooe.ietservice.entity;

import javax.persistence.*;

/**
 * Created by alexandervollovec on 13.05.17.
 */

@NamedQueries({
        @NamedQuery(name = "ConfigurationItem.findAllByDept", query = "select ci from ConfigurationItem ci")
})

@Entity
public class ConfigurationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;


    /* RechenZentrumINFormationsnr.*/
    private String rZINF;
    private String descirption;
    private String ownerName;
    private String location;
    private String roomNo;
    private String category;
    private String product;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    private
    Department department;

    public ConfigurationItem() {
    }

    public ConfigurationItem(String rZINF, String descirption, String ownerName, String location, String roomNo, String category, String product, String status, Department department) {
        this.setrZINF(rZINF);
        this.setDescirption(descirption);
        this.setOwnerName(ownerName);
        this.setLocation(location);
        this.setRoomNo(roomNo);
        this.setCategory(category);
        this.setProduct(product);
        this.setStatus(status);
        this.setDepartment(department);
    }

    @Override
    public String toString() {
        return "ConfigurationItem{" +
                "rZINF='" + getrZINF() + '\'' +
                ", descirption='" + getDescirption() + '\'' +
                ", ownerName='" + getOwnerName() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", roomNo='" + getRoomNo() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", product='" + getProduct() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getrZINF() {
        return rZINF;
    }

    public void setrZINF(String rZINF) {
        this.rZINF = rZINF;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

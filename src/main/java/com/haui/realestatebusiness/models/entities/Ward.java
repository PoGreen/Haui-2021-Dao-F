package com.haui.realestatebusiness.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "wards")
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefix")
    private String prefix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ward")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ward")
    private List<Building> buildings = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Account> getAdmins() {
        return accounts;
    }

    public void setAdmins(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}

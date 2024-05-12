package com.befit;

public class befit {
    private Long id;
    private String name;
    private String składniki;
    private String opis_przyg;

    public befit(Long id,
                 String name,
                 String składniki,
                 String opis_przyg) {
        this.id = id;
        this.name = name;
        this.składniki = składniki;
        this.opis_przyg = opis_przyg;
    }

    public befit(String name, String składniki, String opis_przyg) {
        this.name = name;
        this.składniki = składniki;
        this.opis_przyg = opis_przyg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkładniki() {
        return składniki;
    }

    public void setSkładniki(String składniki) {
        this.składniki = składniki;
    }

    public String getOpis_przyg() {
        return opis_przyg;
    }

    public void setOpis_przyg(String opis_przyg) {
        this.opis_przyg = opis_przyg;
    }

    @Override
    public String toString() {
        return "befit{"+
                "id="+id+
                ",name='"+name+"'\'" +
                ",skladniki='"+składniki+"'\'" +
                ",opis_przyg='"+opis_przyg+"'\'" +
                '}';
    }
}

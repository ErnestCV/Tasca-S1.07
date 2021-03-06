package org.n23ex1;

@JsonSerializable
public class Persona {
    @JsonElement
    private String nom;
    @JsonElement
    private String cognom;
    @JsonElement
    private int edat;

    public Persona() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }
}

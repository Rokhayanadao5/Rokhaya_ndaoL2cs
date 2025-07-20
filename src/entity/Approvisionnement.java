package entity;

import java.time.LocalDate;
import java.util.List;

public class Approvisionnement {
    private int id;
    private String reference;
    private LocalDate date_appros;
    private String observation;
    private int quantite;
    private double prixUnitaire;
    private double montant;
    private List<Fournisseur> fournisseurs;
    private List<Article> articles;

    public Approvisionnement(int id, String reference, LocalDate date_appros, String observation,
                            int quantite, double prixUnitaire, double montant,
                            List<Fournisseur> fournisseurs, List<Article> articles) {
        this.id = id;
        this.reference = reference;
        this.date_appros = date_appros;
        this.observation = observation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montant = montant;
        this.fournisseurs = fournisseurs;
        this.articles = articles;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public LocalDate getDate_appros() { return date_appros; }
    public void setDate_appros(LocalDate date_appros) { this.date_appros = date_appros; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public List<Fournisseur> getFournisseurs() { return fournisseurs; }
    public void setFournisseurs(List<Fournisseur> fournisseurs) { this.fournisseurs = fournisseurs; }

    public List<Article> getArticles() { return articles; }
    public void setArticles(List<Article> articles) { this.articles = articles; }

    @Override
    public String toString() {
        return "Approvisionnement{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", date_appros=" + date_appros +
                ", observation='" + observation + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", montant=" + montant +
                ", fournisseurs=" + fournisseurs +
                ", articles=" + articles +
                '}';
    }
}
package service;

import entity.Fournisseur;
import java.util.ArrayList;
import java.util.List;

public class FournisseurService {

    public List<Fournisseur> initialiserFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur(1, "Papeterie Dakar"));
        fournisseurs.add(new Fournisseur(2, "Librairie Soleil"));
        fournisseurs.add(new Fournisseur(3, "Fournitures Express"));
        // Ajoute d'autres fournisseurs si besoin
        return fournisseurs;
    }
}

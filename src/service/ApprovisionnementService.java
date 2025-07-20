package service;

import entity.Approvisionnement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApprovisionnementService {
    private List<Approvisionnement> approvisionnements = new ArrayList<>();

    public void enregistrerApprovisionnement(Approvisionnement approvisionnement) {
        double montant = approvisionnement.getPrixUnitaire() * approvisionnement.getQuantite();
        approvisionnement.setMontant(montant);
        approvisionnements.add(approvisionnement);
    }

    public List<Approvisionnement> listerApprovisionnements() {
        return approvisionnements;
    }

    public List<Approvisionnement> filtrerParPeriode(LocalDate du, LocalDate au) {
        List<Approvisionnement> resultat = new ArrayList<>();
        for (Approvisionnement a : approvisionnements) {
            LocalDate dateAppro = a.getDate_appros();
            if ((dateAppro.isEqual(du) || dateAppro.isAfter(du)) &&
                (dateAppro.isEqual(au) || dateAppro.isBefore(au))) {
                resultat.add(a);
            }
        }
        return resultat;
    }
}

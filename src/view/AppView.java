package view;

import service.ApprovisionnementService;
import entity.Approvisionnement;
import java.time.LocalDate;
import java.util.List;

public class AppView {
    private ApprovisionnementService approService;

    public AppView(ApprovisionnementService approService) {
        this.approService = approService;
    }

    public void afficherApprovisionnements() {
        List<Approvisionnement> list = approService.listerApprovisionnements();
        for (Approvisionnement a : list) {
            System.out.println(a);
        }
    }

    public void afficherApprovisionnementsParPeriode(LocalDate du, LocalDate au) {
        List<Approvisionnement> list = approService.filtrerParPeriode(du, au);
        for (Approvisionnement a : list) {
            System.out.println(a);
        }
    }
}

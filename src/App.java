import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import service.ArticleService;
import service.FournisseurService;
import service.ApprovisionnementService;
import entity.Article;
import entity.Fournisseur;
import entity.Approvisionnement;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArticleService articleService = new ArticleService();
        FournisseurService fournisseurService = new FournisseurService();
        ApprovisionnementService approService = new ApprovisionnementService();

        int choix;
        do {
            choix = menu();
            switch (choix) {
                case 1:
                    // Enregistrer un approvisionnement
                    System.out.println("Référence : ");
                    String ref = scanner.nextLine();
                    System.out.println("Observation : ");
                    String obs = scanner.nextLine();
                    System.out.println("Date (AAAA-MM-JJ) : ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    // Sélection du fournisseur
                    List<Fournisseur> fournisseursList = fournisseurService.initialiserFournisseurs();
                    System.out.println("Sélectionnez un fournisseur :");
                    for (int i = 0; i < fournisseursList.size(); i++) {
                        System.out.println((i + 1) + "- " + fournisseursList.get(i));
                    }
                    int fournisseurIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consomme le retour à la ligne
                    Fournisseur fournisseurChoisi = fournisseursList.get(fournisseurIndex);

                    // Sélection des articles
                    List<Article> articlesList = articleService.initialiserArticles();
                    List<Article> articlesChoisis = new ArrayList<>();
                    String choixArticle;
                    do {
                        System.out.println("Sélectionnez un article (entrez le numéro) :");
                        for (int i = 0; i < articlesList.size(); i++) {
                            System.out.println((i + 1) + "- " + articlesList.get(i));
                        }
                        int articleIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                        articlesChoisis.add(articlesList.get(articleIndex));
                        System.out.println("Ajouter un autre article ? (o/n) :");
                        choixArticle = scanner.nextLine();
                    } while (choixArticle.equalsIgnoreCase("o"));

                    double prixUnitaire = 0;
                    int quantite = 0;
                    for (Article article : articlesChoisis) {
                        System.out.println("Prix unitaire pour " + article.getLibelle() + " : ");
                        prixUnitaire = Double.parseDouble(scanner.nextLine());
                        System.out.println("Quantité pour " + article.getLibelle() + " : ");
                        quantite = Integer.parseInt(scanner.nextLine());
                    }

                    List<Fournisseur> fournisseurs = new ArrayList<>();
                    fournisseurs.add(fournisseurChoisi);

                    Approvisionnement appro = new Approvisionnement(
                        approService.listerApprovisionnements().size() + 1,
                        ref, date, obs, quantite, prixUnitaire, 0, fournisseurs, articlesChoisis
                    );
                    approService.enregistrerApprovisionnement(appro);
                    System.out.println("Approvisionnement enregistré !");
                    break;
                case 2:
                    List<Approvisionnement> list = approService.listerApprovisionnements();
                    for (Approvisionnement a : list) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.println("Date début (AAAA-MM-JJ) : ");
                    LocalDate du = LocalDate.parse(scanner.nextLine());
                    System.out.println("Date fin (AAAA-MM-JJ) : ");
                    LocalDate au = LocalDate.parse(scanner.nextLine());
                    List<Approvisionnement> filtres = approService.filtrerParPeriode(du, au);
                    for (Approvisionnement a : filtres) {
                        System.out.println(a);
                    }
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 4);

        scanner.close();
    }

    public static int menu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1- Enregistrer un approvisionnement");
        System.out.println("2- Lister les approvisionnements");
        System.out.println("3- Filtrer les approvisionnements par période");
        System.out.println("4- Quitter");
        System.out.print("Votre choix : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre !");
            scanner.next();
        }
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour à la ligne
        return choix;
    }
}
package core;

import java.util.HashMap;
import java.util.Map;

import service.ArticleService;
import service.FournisseurService;
import service.ApprovisionnementService;

public class Container {
    private Map<String, Object> container = new HashMap<>();

    public Container() {
        container.put("ArticleService", new ArticleService());
        container.put("FournisseurService", new FournisseurService());
        container.put("ApprovisionnementService", new ApprovisionnementService());
        // Ajoute d'autres services si besoin
    }

    public Object getDependency(String key) {
        return container.get(key);
    }
}
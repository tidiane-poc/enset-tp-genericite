package genericite;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    static final List<Produit> produits = new ArrayList<>();
    @Override
    public void add(Produit o) {
        var produit = findById(o.getId());
        if (produit != null) {
            System.out.println("Produit déjà existant avec l'id: " + o.getId());
            return;
        }
        produits.add(o);
    }

    @Override
    public Produit findById(long id) {
        var produit = produits.stream().filter(p -> p.getId() == id).findFirst();
        return produit.orElse(null);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public void delete(long id) {
        var produit = findById(id);
        if (produit != null) {
            produits.remove(produit);
            System.out.println("Produit supprimé avec succès.");
        }else {
            System.out.println("Produit non trouvé avec l'id: " + id);
        }
    }
}

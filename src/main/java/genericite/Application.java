package genericite;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        IMetier<Produit> metier = new MetierProduitImpl();

        log("********************************************");
        log("Application de gestion des produits");
        log("********************************************");

        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        while(choix != 5){
            showMenu();
            log("Veuillez saisir votre choix: ");
            choix = scanner.nextInt();
            switch (choix){
                case 1:
                    log("Liste des produits: ");
                    metier.getAll().forEach(produit -> log(produit.toString()));
                    break;
                case 2:
                    log("Rechercher un produit par son id: ");
                    log("Veuillez saisir l'id du produit: ");
                    long id = scanner.nextLong();
                    var produit = metier.findById(id);
                    if(produit != null){
                        log("Produit trouvé: " + produit);
                    }else{
                        log("Produit non trouvé avec l'id: " + id);
                    }
                    break;
                case 3:
                    log("Ajouter un nouveau produit dans la liste: ");
                    log("Veuillez saisir l'id du produit: ");
                    long idProduit = scanner.nextLong();
                    scanner.nextLine();
                    log("Veuillez saisir le nom du produit: ");
                    String nomProduit = scanner.nextLine();
                    log("Veuillez saisir la marque du produit: ");
                    String marqueProduit = scanner.nextLine();
                    log("Veuillez saisir la description du produit: ");
                    String descriptionProduit = scanner.nextLine();
                    log("Veuillez saisir le prix du produit: ");
                    double prixProduit = scanner.nextDouble();
                    log("Veuillez saisir le nombre en stock du produit: ");
                    int nombreEnStockProduit = scanner.nextInt();
                    Produit produit1 = new Produit(idProduit, nomProduit, marqueProduit, prixProduit, descriptionProduit, nombreEnStockProduit);
                    metier.add(produit1);
                    log("Produit ajouté avec succès.");
                    break;
                case 4:
                    log("Supprimer un produit par id: ");
                    log("Veuillez saisir l'id du produit à supprimer: ");
                    long idProduitSupprimer = scanner.nextLong();
                    metier.delete(idProduitSupprimer);

                    break;
                case 5:
                    log("Merci pour votre visite.");
                    break;
                default:
                    log("Choix invalide.");
            }
        }
    }

    static void log(String message){
        System.out.println(message);
    }
    static void showMenu(){
        log("\n1. Afficher la liste des produits.");
        log("2. Rechercher un produit par son id.");
        log("3. Ajouter un nouveau produit dans la liste.");
        log("4. Supprimer un produit par id.");
        log("5. Quitter ce programme.");
    }
}

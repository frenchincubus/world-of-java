# World Of Java : Wrath of Oracle


Le but de cet exercice est de développer un petit jeu de rôle.
 
 Pensez a gitter ce petit projet! 
 En le documentant vous aurez tout ce qu'il faut savoir en Java!
 ___
 ## Exercice 1 : Création d'un personnage
 
1.1 Créer une classe Personnage:
* Definir les attributs d'instances suivants:
  - int pointDeVie
  - int degat
  - string nom
* Créer un constructeur qui affecte ces attributs en les passant dans les paramétres
     
1.2 Créer une méthode ***public Personnage personnageFactory()*** dans la classe Program (pour l'instant...)
```java
/**
* Créer un personnage avec touss ses attributs. 
* Demande a l'utilisateur d'entrer le nom du personnage.
* retour: une instance de la classe Personnage correctement instancié.
**/
public static personnageFactory(){
    // Demander a l'utilisateur un nom de personnage
    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'être choisi par l'utilisateur)
    // Retourner l'instance du personnage
}
```
Elle a pour but de retourner une instance de personnage en demandant a l'utilisateur d'entrer un nom dans la console. 

1.3 Surcharger la méthode ***public string toString()*** personnage sous le format : "nom:[this.nom], pointDeVie:[this.pointDeVie], attaque:[this.attaque]"
___
## Exercice 2 : Création du monde!
 
2.1: Créer une classe static Monde. 

Cette classe représentera le monde de notre jeu. Elle n'a pas vocation à être instancié et doit etre accéssible depuis n'importe quelle classe.

 2.2: Déplacer la methode PersonnageFactory dans cette classe.

 PersonnageFactory doit etre accessible depuis n'importe quelle classe. Elle fera partie des nombreuses Factory.

 2.3: Créer une methode ***public static void afficherInformations()*** pour afficher les informations du monde.

 Pour l'instant, afficher le personnage

 ```java
static class Monde 
{

    public static Personnage personnageFactory()
    {
        // TODO
    }

    public static void afficherInformations()
    {
        // TODO
    }
}
```

___
 ## Exercice 3: Les monstres!!!
 
 3.1: Créer une classe Monstre héritant de la classe Personnage

 L'héritage est la plus forte des dependances en POO. Il sera vite problematique d'utiliser cette methode

```java
class Monstre : Personnage 
{
    public Monstre(string nom, int pointDeVie, int degats): this(nom, pointDeVie, degats)
    {

    }
}
```

3.2: Creer une classe abstraite Combattant
```java
    abstract class AbstractCombattant
    {
        public String nom;
        public int pointDeVie;
        public int degats;

        public Combattant(string nom, int pointDeVie, int degat){
            //TODO
        }

        public String toString()
        {
            return $"nom:{nom}, pdv:{PointDeVie}, degats:{degats}";
        }
    }
```
3.3: Heriter la classe personnage avec AbstractCombattant et toutes les methodes et attributs qui font doublons.

3.4: Changer l'heritage de la classe Monstre avec AbstractCombattant


___
## Exercice 4: La premiere guerre!!!
 
### 4.1: Generation de Monstre

4.1.1: Ajouter à la classe ***Monde*** la methode:
```java
public static Monster MonstreFactory()
{
    // Creer un string pour le nom de votre monstre
    // Creer une instance Monstre avec sont constructeur complet
    // retourner le monstre
}
```

4.1.2: Pour créer le nom de votre monstre:

Creer dans la classe Monde
```java
public static String[] debutNom = new string[]{
    "chat","chien","chaton",...
};

public static String[] finNom = new string[]{
    " mechant"," de feu"," de la mort",...
};
```

Utiliser la classe ***Random.Next()***
```java
String nom = this.debutNom[new Random().next(this.debutNom.Length)] + idem pour les fin de mots
```
 
### 4.2: La methode Combat
4.2.1: Creer une methode "Combat" dans la classe Monde.
```java
public static void combat(Personnage personnage, Monstre monstre)
{
    // TODO
}
```
     
4.2.2: Dans cette méthode, faire jouer a tour de rôles les deux ennemis:
Chacun son tour, le Combattant enlève son nombre d'attaque a l'adversaire.
Il affiche dans la console son nom, ainsi que ses degats.
Le combat s'arrête quand l'un des deux Combattant a moins de 0 pointDeVie et
affiche la victoire à son adversaire.
```java
// definir un boolean turn
while(/* verifier si les deux adversaires ont encore de la vie*/) {
    if (turn) {
        personnage.pdv -= monstre.degats
    }
    else {
        // faire l'inverse
    }
}
```
 4.3: Testez votre code:
 ```java
public static void main(String[] args)
{
    Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
}
```
     
## Exercice 5: Un peu d'ordre.
 
 5.1: Creer une interface ***ICombattant*** qui prototype les methodes:
```java
interface ICombattant
{
    public void attaquer(ICombattant adversaire);
    public void defendre(int degats);

    // Getters et Setters
    public getNom();
    public getDegats();
    public getPointDeVie();
    public setNom(String nom);
    public setDegats(int degats);
    public setPointDeVie(int pointDeVie);
}
```
     
 5.2: Implémenter l'interface dans la classe ***AbstractCombattant***.
 ```java
abstract class AbstractCombattant : ICombattant
{
    ...
    
    public void attaquer(ICombattant adversaire)
    {
        // Appeler la methode Defence de l'adversaire en passant en Params.
        // Afficher un message pour notifier de l'attaque
    }

    public void defendre(int degats)
    {
        // Soustraire aux points de vie les degats passé en params
    }
}
```

 5.3: Changer la methode Combat en
 ```java
public static void combat(ICombattant combattant1, ICombattant combattant2)
{
    // Changer la methode en appelant la methode Attaque des Combattants au lieu des monstres et personnages
}
```

## Exercice 6: POWERRRR!!!!
 
 6.1: Creer une interface "IAttaque" ayant comme methode:
```java
interface IAttaque
{
    public int LancerAttaque(ICombattant lanceur, ICombattant cible);

    // Getters et Setters
    public getNom();
    public getDescription();
    public getChanceToucher();
    public setNom(String nom);
    public setDescription(int description);
    // Chance de toucher doit être compris entre 0 et 100 obligatoirement
    public setChanceToucher(double chanceToucher); 
}

```
     
 6.2: Créer une classe BasicAttaque
 ```java
class BasicAttaque : IAttaque
{
    public int degats;

    public basicAttaque(int degats, double chanceToucher)
    {
        ...
    }
    ...

    public void lancerAttaque(ICombattant lanceur, ICombattant cible)
    {
        // Avec un nombre aleatoire random compris entre 0 et 100
        // si random < chanceToucher
            // retourner lanceur.Degats
        // sinon renvoyer 0 et afficher un message d'echec
    }

}
```

___ 
 Exercice 7: Les classes!!
 
 7.1: Creer une classe ***Classe*** ayant comme attributs une liste d'attaques et un nom.

 7.2: Creer une methode ***getAttaque()*** qui renvoie une attaque de la liste des attaques choisie aleatoirement

 7.3: Creer un constructeur avec en params le nom et la liste d'Attaque.
 ```java
class Classe
{
    public String nom;
    public List<IAttaque> attaques = // init list

    public Classe(string nom, IAttaque[] attaques)
    {
        // Todo
    }

    public IAttaque getAttaque()
    {
        // recuperer une attaque parmis les attaques de la classe
    }

    public 
}
```
 
 7.4: Ajouter un attribut Classe dans la classe Personnage en attribut d'instance et ajouter aux params du constructeur.
 
 Changer aussi la methode personnageFactory() pour définir une classe.
 
 7.5: Changer la methode Attaquer pour utiliser le getAttaque() de la classe et passer le resultat de la methode LancerAttaque de l'Attaque dans les arguments de la methode defendre.

 7.6: Nettoyer votre code en supprimant les attributs inutiles.

 7.7: Testez votre code
 
 ___
 Exercice 8: Choisir une classe
 
 8.1: Créer un attribut static dictionnaire<String,Classe> classes dans la classe Monde. Creer une methode getClasse(string)
 ```java
public static Classe GetClasse(string nom)
{
    return //La classe avec le nom : "nom"
}
```

 8.2: Creer des classes et ajouter les a la liste classes.
 Pour ajouter une valeur a un dictionnaire:
```java
this.classes.add(nom, new Classe(...));
```
___
8.2: Changer la methode pour personnageFactory pour demander la classe du personnage grâce a la methode GetClasse et un scanner

___
 Exercice 9: Les groupes
 
 9.1: Creer une classe Groupe implé mentant ICombattant ayant en attribut une liste de ICombattant

 9.2: Creer une methode AddCombattant(ICombattant) qui ajoute un compatant a la liste
    
 9.3: Implementer les methodes:
     9.3.1: EstMort() qui renvoie vrai si tout les Combattant de l'equipe sont mort
     
     9.3.2: Attaque() qui choisie un Combattant aleatoire et attaque avec le Combattant enemie
     
     9.3.3: Defence() qui defend avec un Combattant aleatoire.
     
 9.4: Dans la classe Monde
     9.4.1: Creer un attribue List<Monstre> monstres et l'initialiser avec un certain nombre de monstre
     
     9.4.2: Creer une methode Groupe CreationGroupeMonstre(int nombreMonstre) qui creer un groupe de monstre
     avec les "nombreMonstre" monstres choisies aleatoirement dans la liste de monstre
     
     9.4.3: Creer une methode Groupe CreationGroupePersonnage(int nombrePersonnage) qui creer un groupe
     en ajoutant "nombrePersonnage" Personnage creer avec la methode de creation de personnage
___
 Exercice 10: Menu et Creation de classe par l'utilisateur
 
 10.1: Creer une methode "Genese" dans la classe Monde qui affiche le texte suivant (sans saut de ligne)
 ```
     ---***--- Bonjour ---***---
     Choisir une option:
     1: Lancer un combat 1v1
     2: Lancer un combat de groupe
     3: One vs World Hardcore Edition
     4: Informations
     ----------------------------
     >>> 
```

 10.2: Creer une methode Combat1v1() qui lance un combat entre un personnage et un monstre en appelant la methode Combat
 
 10.3: Creer une methode CombatGroupe qui demande la taille des groupes et lance un combat
     entre un groupe de personnage et un groupe de monstre.
     
 10.4: Creer une methode CombatSolo qui demande la taille du groupe enemie et lance une partie
     entre un personnage et un groupe de monstre
     
 10.5: Creer une methode Information qui affiche les informations des monstres dans la liste de monstre
     Des classes disponnibles ainsi que leurs attaques
 
 10.6: Dans la methode Genese lancer la methode methode en fonction de la reponse du joueur
 
 10.7: Dans les methodes attaquer des attaques basiques ajouter un affichage
     "[attaquant.nom] utilise [attaque.nom] et inflige [degat] a [cible.nom]" s'il reussit sont attaque
     sinon "[attaquant.nom] rate [attaque.nom]"
     et suprimer les ancients affichages
 
 ### 10.8: Dans la classe Monde:
10.8.1: Creer une methode CreationClasse()

10.8.2: Ajouter un tableau d'attaque a votre Monde

10.8.3: Dans la methode demander un nom a l'utilisateur

10.8.4: Afficher le nom le descriptif de 2 attaques aleatoires et les stocker dans
une liste d'attaques. Puis demander a l'utilisateur de choisir l'une des deux.
Recomencer jusqu'a avoir ajouter 14 attaques ou defences

10.8.5: Ajouter la classe dans la liste des classes et revenir au menu principal
___
 Exercice 11: Hold the door!!
 
 11.1: Creer une nouvelle interface Sort qui implemente les getter des attributs nom et definition et une methode Information.
 
 11.2: implementer Sort dans l'interface Attaque
 
 11.3: Creer une interface Defence qui implemente l'interface Sort et qui definie la methode int Defence(int degat, ICombattant defenceur)
 
 11.4: Creer une classe ParadeDefence qui implemente l'interface Defence
     11.4.1: Ajouter un attribut Decimal parade qui est compris entre 0 et 1
     
     11.4.2: Creer un constructeur qui prend en params tout les attributs
     
     11.4.3: Implementer la methode Defence:
         retourne 0 si la parade passe sinon degat
         
 11.5: Creer une classe AbsorbeDefence qui implemente l'interface Defence
     11.5.1: ajouter l'attribut decimal coefHeal et decimal coefDegat
     
     11.5.2: idem 11.4.2
     
     11.5.3: Implementer methode Defence:
         retourne degat*coefDegat et rend au defenceur degat*coefHeal
         
 11.6: Creer une classe Defence de la meme maniere qui diminue en pourcentage les degats
 
 11.7: Et une qui diminue les degat avec une valeur fixe.
 
 11.8: Dans la classe Classe ajouter une liste de Defence, en la passant en parametre du constructeur
     et ajouter une methode GetDefence() qui renvoie une defence aleatoirement
     
 11.9: Dans la methode Defence de la classe Personnage appeler la methode GetDefence de la classe
     et enlever au personnage defence.Defence(degat)
     
 11.10: Changer la methode CreationClasse en choisissant aleatoirement deux sorts.
     Soit de la defence soit de l'attaque
___
 Exercice 12:
 Implementer des Attaques:
     * une qui renvoie des degats et qui soigne le lanceur (VampirismAttaque)
     * une qui a des chances de critique (qui double ses degats) (CritiqueAttaque)
     * une qui inglige des degat aussi au lanceur (SacrificeAttaque)
     
 Exercice 13(optionnel): Un vrai Jeu
 13.1: Ajouter des attaques:
     [Nom                ][Type                  ][Valeurs]
     Coup blanc          || BasicAttaque         || degat: 10 toucher:0.9
     Coup fatal          || BasicAttaque         || degat: 22 toucher:0.5
     Coup Null           || BasicAttaque         || degat: 5  toucher:0.5
     Coup Precis         || CriticAttaque        || degat: 7  critic:0.5
     Coup MongoDB        || CriticAttaque        || degat: 20 critic:0.7
     Sacrifice           || SacrificeAttaque     || degat: 30 degatLanceur: 10
     CCroisillon         || VampirismAttaque     || degat: 5 heal: 10
     Candide             || VampirismAttaque     || degat: -10 heal:20 (oui on soigne l'adversaire)
     Soin                || VampirismAttaque     || degat:0 heal:15
     Oups                || SacrificeAttaque     || degat:0 degatLanceur:10
     ...
 13.2: Ajouter des defences de la meme maniere.
 
 13.3: Creer des classes avec vos attaques et defences
 ___
 Exercice 14:
 COMMENTEZ VOTRE CODE!!! ET DOCUMENTER VOS METHODES ET CLASSES!! L'INDENTATION... et faites des testes
 ___
 Exervice 15: LE DONJON!!! 
 15.1: Creer une interface Salle qui implemente la methode Entrer(ICombattant Combattant)
 
 15.2: Creer une classe FontaineSalle qui implemente l'interface Salle le methode Entre qui soigne 
     tout les Combattants du groupe (ajout d'une methode Soin(int soin) dans les ICombattant conseillé)
 
 15.3: Creer une classe MonstreCombatSalle qui implemente Salle avec la methode Entrer qui lance un 
     combat contre un groupe de mostres.
 
 15.4: Creer une classe Donjon qui possede:
     + un nom
     + une definition
     - un tableau de Salle
     
 15.5: Creer une methode Entrer(ICombattant Combattant) qui fait entrer le groupe dans chaque salles
     une par une. A chaque Salle afficher "Salle numero ## du donjon ??". Si le groupe meurt resortir 
     du donjon.
 
 15.6: Creer une methode CreateDonjon dans votre Monde qui creer des donjons aleatoirement.

   ___  
 Exercice 16: Amelioration des classes et des statistiques:
 16.1: Ajouter aux classes et Combattant les attributs: int pointDeVieMax, pointAction, pointActionParTour.
     16.1.1: La vie du joueur ne peut depasser pointDeVieMax
     16.1.2: Les caracteristiques du Combattant sont definie par celle de sa classe
     16.1.3: mettre a jour la creation de Classe en fonction
     16.1.4: Ajouter aux attaque un cout de point d'action.
     16.1.5: a chaque tour, au moment de chosir l'attaquant d'un groupe, ajoute pointActionParTour
         aux pointAction du Combattant.
     16.1.6: L'attaquant qui joue est celui qui a le plus grand nombres de point d'actions
     16.1.7: retire a l'attaquant le cout des pointAction de l'attaque
 16.2: Quand un personnage revient a la vie, il recupere ses pointDeVieMax
 
 16.3: Mettre a jour le code et les valeurs
 
 16.4: Changer la liste de classe en dictionnaire et faire les changement adequoite.
 ___
 Exercice 17: Personnage vraiment jouable
 17.1: Creer une classe JoeurPersonnage qui herite de la classe Personnage
 
 17.2: Override la methode Attaque pour que le joueur puisse choisir une attaque:
     17.2.1: Afficher 3 Attaques parmis toutes les attaques de la classe
     
     17.2.2: Demander a l'utilisateur de choisir une attaque
     
     17.2.3: lancer l'attaque
     
 17.3: Equilibrer les attaques dans les classes. Une attaque peut etre ajouté plusieur fois
     pour avoir plus de chance d'etre pioché.
 
 17.4: Creer une methode CreateJoueur() qui creer un jour comme lancienne methode.
 
 17.5: L'ancienne methode permet maintenant de creer un simple Personnage aleatoirement
 
 17.6: Ameliorer l'affichage des combats:
     A chaque action affiche un message en fonction de l'attaque ou defence
     A chaque affiche les informations sur les groupes et leurs pdv
     
 
 Exercice 18: Ajout des niveaux
 18.1: Dans la l'interface ICombattant, ajouter les attributs niveaux et experiences
 
 18.2: Dans la methode set d'experience de la classe Personnage definir aussi le niveau comme
     (par exemple) log(experience*50+1)
 
 18.3: Dans les sorts doivent avoir un attribut niveauMinimun, niveauMaximum
 
 18.3: Quand un Combattant demande une Attaque a sa classe, il pense en plus en params son niveau
     La classe renvoie alors une attaque ou le niveau de lattaquant est entre niveauMin et niveauMax
 
 18.4: idem Defence
 
 18.5: Les ICombattant implementes une nouvelle methode ValeurExperience qui renvoie
     le quart de l'experience d'un Personnage
 
 18.6: Ajoute l'experience a chaques Combattant de l'equipe gagnante du combat
 
 Exercice 19(Optionnel): Pour ceux qui veulent concurencer les plus grands
 Mettre en place un systeme de tests unitaires
 Mettre en place une connexion a une base de données pour sauvegarder les parties(Prochainement)
 Mettre en place une un systeme d'Object
 Mettre en place un serveur pour jouer en reseaux
 Mettre en place un systeme de royaumes regroupant des Guildes, avec une carte et des factions de joueurs
 Mettre en place une interface graphique
 Mettre en place un chat
 Appeler le jeu World of Aston: Wrath of the CSharp
 
 Exercice 20: Les lyceens de la base de donnée (ADO)
 to bo continued...
 
 Exercice 21: Le coeur pas net (.NET Core)
 soon th
 
 Exercice 22: Etre React(JS)
 Pas moi
     
 Exercice 23: Et ben c'est bieng...
 Bravo, vous avez terminé la formation java





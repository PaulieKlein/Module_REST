# Module_REST

Le projet a été réalisé avec STS (JAVA,REST,EJB,JPA,serveur wildfly), Sublime Text (HTML5, CSS3, ANgularJS).

##Descrition

Projet réalisé en 3 partie : 

###1) BankonetREST
Cette partie a été réalisée sur STS et utlise le serveur wildfly, REST,EJB,JPA,CDI,JAVA. Elle fait la liaison entre
la base de données et les parties bankonet-client-maven et public. elle dispose de méthodes : getAll, get, post, put et delete
<br>
###2) bankonet-client-maven
Cette partie a été réalisée sur STS et utilise REST,JAVA,CDI.Il s'agit d'une application console où l'on peut lister les employés, 
rechercher un employer par son id et de créer un employé (nom,prenom, adresse(numero,rue,ville)
###3) public
Cette partie a été réalisée sur Sublime text et utilise HTML5, ANgularJS,Bootstrap,CSS3.Il s'agit d'une application web où l'on peut
lister tous les employer contenue dans la base de données,rechercher un employer par son id et de créer un employé 
(nom,prenom, adresse(numero,rue,ville), modifier un employé, supprimer un employé.
##Pré-requis

###I) Serveur
####1)Installation de wildfly pour BankonetREST
création d'un nouvel utilisateur avec l'invite de commande<br>
création d'une datasource<br><br>
####2)Installation de node.js pour public
invides de commande : lr-http-serveur ou lr-http-serveur  -p (port)<br> en étant à la racine du dossier de la partie public
####3)Installation de wamp serveur, easyPHP<br> 
pour avoir PHPMyAdmin
####4)Invites de commande pour bankonet-client-maven
utilisation de la console en étant à la racine du dossier bankonet-client-maven : <br>
mvn package <br>
java -jar file.jar

###II) PHPMyAdmin
Création d'une base de données vide (la table "employe" est créée automatiquement)

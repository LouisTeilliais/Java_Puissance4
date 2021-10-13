# Puissance 4 - JAVA
***

## Présentation du sujet

Ce projet consistait a créer un puissance 4, qui dans un premier temps devait être jouable dans la console puis dans un second, en réseau. Pour le projet nous étions 2 : **Louis TEILLIAIS** & **Tao BOURMAUD**. Le projet s'est étendu sur 10 séances en plus des capsules de cours. 

Il fallait donc réaliser un jeu inspiré des règles du puissance 4, en local et en réseau. Il y'avait quelques spécification de jeu, un menu qui propose de lancer en local, en réseau en mode "serveur" et en mode "client" en se connectant a un adresse IP. La grille fait une taille de 8 par 6, il n'y a que deux joueurs. Les tours doivent s'alterner, un tour se joue lorsque un joueur choisis une colonne et que le pion se met au plus bas de celle-ci.
Le jeu s'arrête lorsque le joueur aligne N pions, horizontalement, verticalement ou en diagonale, un message s'affiche lorsque on a un vainqueur. 
SI personne n'a gagné, le jeu s'arrête à égalité. 

Les livrables était donc : 

- Un fichier Readme 
- Un dépot GIT 
- La documentation HTML (étape 4 BONUS)
- Une vidéo de présentation (10 minutes). 
***

## Structure du code

Le code est structuré simplement, une classe 🠖 un fichier. Tout cela est dans le fichier **puissance4/src/main/java/puissance4**, dans le fichier **/src**, on a aussi les fichiers de test dans **/test**, que l'on a pas. Il y'a également le dossier **/target** qui contient tout les fichiers **.class**. Dans le dossier **/src** il y'a aussi le **pom.xml**. A la racine on a aussi le **.gitignore** qui sert à ne pas tout envoyer sur GIT

*** 

## Compiler et lancer le jeu 

Pour compiler le programme, il suffit de lancer dans le terminal  la commande **javac puissance4/App.java** dans le dossier **/Java_Puissance4** cela va "compiler et mettre a jour" tout les fichiers utiles au bon fonctionnement du programme. 

Une fois que ceci est fait il ne reste plus que a lancer la commande **java puissance4.App** et le programme va ce lancer et vous n'avez plus qu'a jouer.
***
## BON JEU !
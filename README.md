# ZooRanking

## Informations du projet
* Nom : **ZooRanking**
* Problématique :

    **Comment rendre les zoos plus attractifs et inviter une certaine population à les visiter à l’aide d’une application ludique et informative utilisable depuis chez soi tout en sensibilisant aux différentes problématiques en lien avec les zoos ?**


## Fonctionnalités
| Fonctionnelles | Non Fonctionnelles |
|----------------|--------------------|
|Lecture des zoos stockés dans un fichier Json|Mise à jour du fichier Json suite à l'ajout d'un avis de l'utilisateur|
|Sélection d'un zoo sur une carte fictive|Utilisation de l'API officielle de Google Maps |
|Visualisation des zoos dans une liste |Tri automatique de la liste des zoos par leur classement|
|Affichage automatique des informations d'un zoo dans une interface dédiée||


---
## Mode d'emploi

Pour récupérer la dernière version du projet, effectuez dans un terminal :
```shell
git clone https://forgens.univ-ubs.fr/gitlab/e2103929/zoo_android.git
```
ou alternativement via ssh si le protocole https n'est pas supporté/autorisé :
```shell
git clone git@forgens.univ-ubs.fr:e2103929/zoo_android.git
```

### Récupération d'un package compilé au préalable
* rendez vous sur la [page des releases](https://forgens.univ-ubs.fr/gitlab/e2103929/zoo_android/-/releases/Release) du projet et téléchargez le fichier `.apk`
* transférez le fichier vers votre périphérique (mail, bluetooth, câble USB, etc..)
* sur votre périphérique, utilisez votre gestionnaire de fichier pour retrouver le fichier transféré précédemment, puis installez le paquet. 

### Compilation en package d'application (`.apk`)
* téléchargez et importez une version du projet dans intelliJ
* Sélectionner dans la barre de menu **Build > Build Bundle(s)/APK(s) > Build APK(s)**
* une fois l'application compilée et packagée, ouvrez l'onglet "**Event Log**" situé en bas à droite de l'interface
* Un message "**Module 'zooappturquoise.app': locate or analyze the APK.** est normalement affiché
* cliquez sur **locate** pour ouvrir l'emplacement ou le fichier `.apk` a été crée

### Compilation & test de l'application sur un appareil de test dédié
* téléchargez et importez une version du projet dans intelliJ
* Branchez un périphérique android via un câble usb à votre ordinateur
* Assurez vous que le débogage usb du périphérique android est bien activé (voir menu développeur) et qu'il est bien dévérouillé
* Dans intelliJ, appuyez sur "**Run App**" ou effectuez le raccourci clavier `Maj+F10` (Windows/Linux) / `^R` (MacOs) 

# Projet POEC JAVA CLERMONT 2022 - ACCSetup

##Description :

L'application permet, via une base de données technique (voitures, circuits) à un utilisateur enregistré de créer des sessions de roulage (qui sont une classe Java)
auxquelles sont liées des valeurs de réglage de la voiture (classe Java).

##Scénario d'utilisation :

- Connexion de l'utilisateur.
- L'utilisateur accède à un menu permettant de gérer les sessions liées à son compte d'utilisateur : consulter une session existant, créer une nouvelle session, mettre à jour une session existant, supprimer une session.

##Scénario de création de session :

Via le menu principal, l'utilisateur enregistré clique sur le bouton "créer une session".

Il accède à un premier menu, où il choisit la voiture et la piste sur laquelle il roule et clique sur un bouton "créer réglage".

Il accède à un second menu, où il a accès aux valeurs de la classe réglage qu'il peut modifier. Une foix ces choix faits, il peut sauvegarder son réglage avec un bouton "sauvegarder réglage".

##Fonctions de l'application :

- Un utilisateur peut se connecter/déconnecter avec un identifiant/mot de passe sécurisé. (PRIO 0)

- Un utilisateur peut créer un compte, ou le supprimer, ce qui entraîne la destruction des sessions liées (PRIO 0)

- Un utilisateur peut avoir une session liée à son profil. (PRIO 0)

- Une session est liée à un réglage, une voiture et une piste. (PRIO 0)

- Un utilisateur peut gérer sa/ses sessions (CRUD - PRIO 0)

- Un utilisateur peut gérer un réglage lié à une session (PRIO 0)

- Un utilisateur peut avoir plusieurs sessions liées à son profil (PRIO 1)

- Une session peut avoir plusieurs réglages liés (PRIO 1)

- Un utilisateur peut ajouter des commentaires à un réglage (PRIO 1)

- Un utilisateur peut spécifier la température la météo et l'état de la piste pour la session via des listes (PRIO 1)

- Un utilisateur peut consulter les différents réglages d'une même session (PRIO 1)

Use case : Microservice de gestion des garages, véhicules et accessoires Renault
Contexte
Renault souhaite développer un microservice de gestion des informations relatives aux garages affiliés à son réseau. Ce microservice doit répondre à plusieurs besoins fonctionnels et inclure des contraintes métiers spécifiques.
Objectifs Fonctionnels
1.	Gestion des garages :
o	Création, modification et suppression de garages.
o	Récupération d’un garage spécifique (par ID).
o	Liste paginée de tous les garages, avec possibilité de tri (par nom, ville, etc.).
2.	Gestion des véhicules :
o	Ajout, modification et suppression de véhicules associés à un garage.
o	Lister les véhicules d’un garage spécifique.
o	Possibilité de lister tous les véhicules d’un modèle donné dans plusieurs garages.
3.	Gestion des accessoires :
o	Ajout, modification et suppression d'accessoires associés à un véhicule.
o	Lister les accessoires d’un véhicule.
4.	Requêtes de recherche :
o	Rechercher des garages en fonction de critères spécifiques, tels que :
	Type de véhicule pris en charge.
	Disponibilité d'un accessoire particulier dans au moins un véhicule.
Contraintes Métiers
1.	Quota de stockage des véhicules dans un garage :
Chaque garage peut stocker au maximum 50 véhicules.
2.	Partage des modèles de véhicules :
Un même modèle de véhicule peut être stocké dans plusieurs garages.
3.	Informations obligatoires :
o	Garage : name, address, telephone, email, horaires_ouverture.
1.	horaires_ouverture => Map<DayOfWeek, List<OpeningTime>>
2.	OpeningTime => {startTime : LocalDate, endTime : LocalDate}
o	Véhicule : brand, année de fabrication, type_carburant.
o	Accessoire : nom, description, prix, type.
Tâches Techniques attendus
•	Modéliser le problème
•	Développer au moins une API REST complète
•	Gérer les contraintes métiers
•	Réaliser des tests unitaires et d'intégration
•	Ajouter un publisher de véhicule (qui sera ajouté au moment de la création)
•	Implémenter un consumer qui consomme les événements publiés

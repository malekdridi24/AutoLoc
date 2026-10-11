# AutoLoc API

Application Spring Boot de gestion de location de véhicules.

## Architecture
- `domain` : entités JPA
- `repository` : repositories Spring Data JPA pour toutes les entités
- `service` : interfaces de services
- `service/impl` : implémentations des services
- `controller` : API REST CRUD pour Client et Vehicule

## CRUD Véhicules
- `GET /api/vehicules` : lister
- `GET /api/vehicules/{id}` : afficher par identifiant
- `POST /api/vehicules` : créer
- `PUT /api/vehicules/{id}` : modifier
- `DELETE /api/vehicules/{id}` : supprimer

## CRUD Clients
- `GET /api/clients` : lister
- `GET /api/clients/{id}` : afficher par identifiant
- `POST /api/clients` : créer
- `PUT /api/clients/{id}` : modifier
- `DELETE /api/clients/{id}` : supprimer

Configurer MySQL dans `src/main/resources/application.properties`, puis lancer `./mvnw spring-boot:run` (Windows : `mvnw.cmd spring-boot:run`).

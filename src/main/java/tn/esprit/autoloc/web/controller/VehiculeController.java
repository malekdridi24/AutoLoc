package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name="Gestion des Vehicules")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    private IVehiculeService VehiculeService;

    @Operation(description = "Récupérer tous les véhicules")
    @GetMapping("/retrieve-all-vehicules")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des véhicules récupérée avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erreur interne du serveur",
                    content = @Content
            )
    })
    public List<Vehicule> getVehicules() {return VehiculeService.retrieveAllVehicules();}

    @Operation(description = "affiche d'une vehicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = " Vehicule Trouve",
                    content = @Content(mediaType ="application/json",
                    schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404",description = "vehicule non troubve",content = @Content)

    })
    @GetMapping("/vehicule/{idVehicule}")
    @ResponseBody
    public Vehicule getVehiculeById(@Parameter(description = "id du véhicule à rechercher")@PathVariable("idVehicule") Long idVehicule) {return VehiculeService.retrieveVehicule(idVehicule);}

    @Operation(description = "ajout vehicule")
    @PostMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule ajouté avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class))
            ),
            @ApiResponse(responseCode = "400",
                    description = "Données invalides",
                    content = @Content
            )
    })
    public Vehicule addVehicule(@RequestBody Vehicule v) { return VehiculeService.addVehicule(v);}

    @Operation(description = "supprim vehicule")
    @DeleteMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Supprimé"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    public void removeVehicule(@Parameter(description = "id du véhicule à supprimer")@RequestParam Long idVehicule) {
        VehiculeService.removeVehicule(idVehicule);
    }

    @Operation(description = "Modification de vehicule")
    @PutMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Modifee"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    public Vehicule modifyVehicule(@RequestBody Vehicule v) { return VehiculeService.modifyVehicule(v); }



}

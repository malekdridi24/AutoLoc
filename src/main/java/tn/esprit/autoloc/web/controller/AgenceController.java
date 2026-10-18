package tn.esprit.autoloc.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name=" Gestion des Agence")
@AllArgsConstructor
@RestController
@RequestMapping("/Agence")
public class AgenceController {

    IAgenceService agenceService;

    @Operation(description = "List-all-Agences")
    @GetMapping("/ListAllAgences")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des Agence récupérée avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erreur interne du serveur",
                    content = @Content
            )
    })
    public List<Agence> listAllAgences() {return agenceService.findAll();}

    @Operation(description = "Creation d Agence")
    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence ajouté avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class))
            ),
            @ApiResponse(responseCode = "400",
                    description = "Données invalides",
                    content = @Content
            )
    })
    public Agence create(@RequestBody Agence A) {return agenceService.create(A);}

    @Operation(description = "Update agence")
    @PutMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Modifee"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    public Agence update(@RequestBody Agence A) {return  agenceService.update(A);}

    @Operation(description = "retrieveAgence")
    @GetMapping("RetriveAgences/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = " agence Trouve",
                    content = @Content(mediaType ="application/json",
                            schema = @Schema(implementation = Agence.class))),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404",description = "Agece non troubve",content = @Content)

    })
    public Agence retrieveAgence(@Parameter(description = "id du Agence à rechercher")@PathVariable("id") Long id) {return agenceService.retrieveAgence(id);}

    @Operation(description = "Delete Agence")
    @DeleteMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Supprimé"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    public void delete(@Parameter(description = "id du agence à supprimer ")@RequestParam("id") Long id) {agenceService.delete(id);}
}


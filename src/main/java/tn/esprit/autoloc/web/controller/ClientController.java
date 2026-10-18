package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name="Gestion des clients ")
@RestController
@AllArgsConstructor
@RequestMapping("/Client")
public class ClientController {

    private IClientService clientService;

    @Operation(description = "affichage des clients ")
    @GetMapping("/retrieve-All-Clients")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Liste des clients récupérée avec succès",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erreur interne du serveur",
                    content = @Content
            )
    })
    public List<Client> getClients() {return clientService.retrieveAllClients();}

    @Operation(description = "retrieve-Client")
    @GetMapping("/retrieve-Client/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = " client Trouve",
                    content = @Content(mediaType ="application/json",
                            schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404",description = "Client non troubve",content = @Content)

    })
    public Client getClient(@Parameter(description = "id du client à rechercher")@PathVariable("id") Long id)  {return clientService.retrieveClient(id); }

    @Operation (description = "Ajout Client")
    @PostMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client ajouté avec succès",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))
            ),
            @ApiResponse(responseCode = "400",
                    description = "Données invalides",
                    content = @Content
            )
    })
    public Client addClient(@RequestBody Client c) { return clientService.addClient(c); }

    @Operation(description = "Delete Client")
    @DeleteMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Supprimé"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    public void removeClient(@Parameter(description = "id du client  a supprimer ")@RequestParam Long id) {clientService.removeClient(id);}

    @Operation(description = "Modification du client")
    @PutMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Modifee"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })

    public Client updateClient(@RequestBody Client c) { return clientService.updateClient(c); }

}


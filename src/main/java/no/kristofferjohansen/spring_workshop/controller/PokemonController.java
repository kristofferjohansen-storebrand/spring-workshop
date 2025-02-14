package no.kristofferjohansen.spring_workshop.controller;

import no.kristofferjohansen.spring_workshop.domain.dto.PokemonDto;
import no.kristofferjohansen.spring_workshop.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(path = "/choose")
    public ResponseEntity<String> choosePokemon(@RequestParam(defaultValue = "Pikachu", required = false) final String pokemon) {
        return ResponseEntity.ok(String.format("%s, I choose you!", pokemon));
    }

    @PostMapping(path = "/pokedex")
    public ResponseEntity<String> postPokedex(@RequestBody final PokemonDto pokemonDto) {
        return ResponseEntity.ok(pokemonDto.getDexEntry());
    }

    @PostMapping(path = "/climb")
    public ResponseEntity<String> postClimbEverest(@RequestBody final PokemonDto pokemonDto) {
        final int i = pokemonService.getPokemonToReachSummit(pokemonDto);

        return ResponseEntity.ok(String.format("You need to stack %d %s to reach the top of Mount Everest!", i, pokemonDto.name()));
    }
}

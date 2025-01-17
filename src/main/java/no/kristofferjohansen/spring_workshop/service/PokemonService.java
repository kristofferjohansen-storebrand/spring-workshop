package no.kristofferjohansen.spring_workshop.service;

import no.kristofferjohansen.spring_workshop.domain.dto.PokemonDto;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private static final int MOUNT_EVEREST_HEIGHT = 8849;

    public int getPokemonToReachSummit(final PokemonDto pokemonDto) {
        return (int) Math.ceil(MOUNT_EVEREST_HEIGHT / pokemonDto.height());
    }
}

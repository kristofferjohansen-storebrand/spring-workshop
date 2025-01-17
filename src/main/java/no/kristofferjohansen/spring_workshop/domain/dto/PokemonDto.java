package no.kristofferjohansen.spring_workshop.domain.dto;

public record PokemonDto(String name, double weight, double height) {

    public String getDexEntry() {
        return String.format("%s is %.2f cm tall and weighs %.2f kg!", name, height, weight);
    }
}

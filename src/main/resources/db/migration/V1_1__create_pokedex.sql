create table pokemon (
    id uuid primary key not null,
    name text not null,
    created_date_time timestamp not null,
    revision_date_time timestamp not null
);

create table pokemon_form (
    id uuid primary key not null,
    pokemon_id uuid not null,
    type1 text not null,
    type2 text,
    height int not null,
    weight int not null,
    foreign key (pokemon_id) references pokemon (id)
);

insert into pokemon (id, name, created_date_time, revision_date_time) values (gen_random_uuid(), 'Bulbasaur', now(), now());
insert into pokemon_form (id, pokemon_id, type1, type2, height, weight) values (gen_random_uuid(), (select x.id from pokemon x where x.name = 'Bulbasaur'), 'Grass', 'Poison', 7, 69);
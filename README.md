## PokeApi Pokedex

Atrapalos a todos, pokedex desarrollada usando como base los endpoints Api del sitio https://pokeapi.co/, carga una lista de Pokemons de un total de 1302 (incluye megaevoluciones, gigamax etc), si pinchas cada pokémon podrás ver el detalle de cada uno, ofreciendo descripción de habilidades, tipos, stats, sprites, grito del mismo, etc.

El resultado se ve reflejado en un LazyColumn con 20 primeros Pokémons, incluye paginación (usando key offert ofrecida por el sitio) con 2 botones de navegación "Atras" y "Siguiente" con carga de lista de 20 Pokémons.

# Para construir este proyecto se basaron en arquitectura y patrones:

- MVI.
- Patrón Singleton
- SOLID
- Kotlin.
- Jetpack Compose.
- Corrutinas o flows.
- Inyección de dependencias con Dagger2 (Automáticas).
- Retrofit.
- Clean Architecture.

![Screenrecorder-2024-04-09-13-44-58-841](https://github.com/NicolasAvilaB/PokeApiPokedex/assets/36216299/29463f29-092f-4b7d-86db-a8fb50a7e3c2)

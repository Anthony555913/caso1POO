#Especificación
**battleFlield**
- X int
- Y int

**controlJuego**
- Equipo1 Equipo
- Equipo2 Equipo
- CalDistancia(mutante Mmutante1,mutante Mutante2)
- DefinirAcciones()
- Run()

**Equipo**
- Integrantes list<PerrsonaMutante>
- CanIntegrantes int
- Color string
- Vivos int
- EstadoEquipo bolean=true 


**PerrsonaMutante**
- Id int
- Estado bolean 
- Vida int=100
- Defensa int
- PoderMutante poder 
- EstadoInmune bolean //puede o no resibir un ataque
- EstadoDefencivo bolean
- usarPoder()
- defenderse()
- detectarMutanteEneigo()
- mover()
- get()
- set()

**Poder<<inreface>>**
- usarPoder()

**PoderMutante extend<< Poder>>**
- usarPoder() //cada poder debería tener una forma de movimiento diferente


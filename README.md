#Especificación
**Tablero**
- Equipo1 Equipo
- Equipo2 Equipo
- Tablero list< Casilla>
- calcularDanno(PerrsonaMutante)

**Equipo**
- Integrantes list<PerrsonaMutante>
- Color string
- Vivos int

**Casilla**
- X int
- Y int
- estadoMutante bolean 

**PerrsonaMutante**
- Id int
- Estado bolean 
- Vida int=100
- Defensa int
- PoderMutante poder 
- EstadoInmune bolean 
- UbicacionActual Ubicación
- EstadoDefencivo bolean
- usarPoder()defenderse
- get()
- set()

**Poder<<inreface>>**
- usarPoder()

**PoderMutante extend<< Poder>>**
- usarPoder() //cada poder debería tener una forma de movimiento diferente


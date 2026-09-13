#Especificación

**ControlJuego**
- -Equipo1: Equipo
- -Equipo2: Equipo
- -Tablero: BattleField
- +CalDistancia(PersonaMutante Mutante1,PersonaMutante Mutante2)
- +DefinirAcciones()
- +Run()
- +get()
- +set()

**BattleField**
- -X: int
- -Y: int
- +set()
- +get()

**Equipo**
- -Integrantes: list<PersonaMutante>
- -CanIntegrantes: int
- -Color: string
- -Vivos: int
- -EstadoEquipo: boolean=true 
- +get()
- +set()



**PersonaMutante**
- -Id: int
- -Estado: boolean
- -Vida: int = 100
- -Defensa: int
- -PoderMutante: Poder
- -EstadoDefensivo: boolean
- -ModoInmune: boolean = false // puede o no ser atacado
- +UsarPoder()
- +Mover()
- +get()
- +set()

**Poder<<interface>>**
- +UsarPoder()

**PoderMutante extends<< Poder>>**
- +UsarPoder() //cada poder debería tener una forma de movimiento diferente
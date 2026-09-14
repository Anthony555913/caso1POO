#Especificación

**ControlJuego**
- -Equipo1: Equipo
- -Equipo2: Equipo
- -Tablero: BattleField
- -CanIntegrantePorEquipo int
- +CalDistancia(PersonaMutante Mutante1,PersonaMutante Mutante2)
- +PlayGame()
- +IniciarVariables()
- +CrearEquipos()
- +IniciarTablero()
- +MoverMutantes()
- +DefinirAccion()//llama a CalDistancia
- +EjecutarAccion()
- +CalcularEstadoEquipo()
- +Get()
- +Set()

**BattleField**
- -X: int
- -Y: int
- +Set()
- +Get()

**Equipo**
- -Integrantes: list<PersonaMutante>
- -CanIntegrantes: int
- -Color: string
- -Vivos: int
- -EstadoEquipo: boolean=true 
- +RestarIntegrantes()
- +Get()
- +Set()



**PersonaMutante**
- -Id: int
- -Estado: boolean
- -Vida: int = 100
- -Defensa: int
- -X: int
- -Y: int
- -PoderMutante: Poder
- -ModoInmune: boolean = false // puede o no ser atacado
- +UsarPoder()
- +Mover()
- +Get()
- +Set()

**Poder<<abstract>>**
- -danno int
- +UsarPoder()

**PoderMutante extends<< Poder>>**
- +UsarPoder() //cada poder debería tener una forma de movimiento diferente
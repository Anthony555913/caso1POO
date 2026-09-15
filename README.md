#Especificación

**ControlJuego package Control**  
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

**BattleField package BattleField** 
- -X: int
- -Y: int
- +Set()
- +Get()

**Equipo package Team** 
- -Integrantes: PersonaMutante list
- -CanIntegrantes: int
- -Color: string
- -Vivos: int
- -EstadoEquipo: boolean=true 
- +RestarIntegrantes()
- +Get()
- +Set()



**PersonaMutante package Model** 
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

**Poder<<abstract>> package Power** 
- -danno int
- +UsarPoder()
- +Get()
- +Set()

**PoderMutanteFuerte extends<< Poder>>** package Power
- +UsarPoder() 

**PoderMutanteMedio extends<< Poder>> package Power**
- +UsarPoder() 

**PoderMutanteDebil extends<< Poder>> package Power**
- +UsarPoder() 
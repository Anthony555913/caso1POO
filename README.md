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
- +RestarVivos()
- +Get()
- +Set()



**PersonaMutante package Model** 
- -Id: int
- -Estado: boolean
- -Vida: int = 100
- -Defensa: int
- -X: int
- -Y: int
- -AtaqueAumento: int
- -PoderMutante: Poder
- +UsarPoder()
- +Mover()
- +Get()
- +Set()

**Poder<<abstract>> package Molde** 
- -danno int
- +UsarPoder()
- +Get()
- +Set()

**PoderMutanteFuerte extends<< Poder>>** package Molde
- +UsarPoder() 

**PoderMutanteMedio extends<< Poder>> package Molde**
- +UsarPoder() 

**PoderMutanteDebil extends<< Poder>> package Molde**
- +UsarPoder() 


codigo UML:
classDiagram
    namespace Control {
        class ControlJuego {
            -Equipo1 : Equipo
            -Equipo2 : Equipo
            -Tablero : BattleField
            -CanIntegrantePorEquipo : int
            +CalDistancia(Mutante1 : PersonaMutante, Mutante2 : PersonaMutante)
            +PlayGame()
            +IniciarVariables()
            +CrearEquipos()
            +IniciarTablero()
            +MoverMutantes()
            +DefinirAccion()
            +EjecutarAccion()
            +CalcularEstadoEquipo()
            +Get()
            +Set()
        }
    }

    namespace BattleField {
        class BattleField {
            -X : int
            -Y : int
            +Get()
            +Set()
        }
    }

    namespace Team {
        class Equipo {
            -Integrantes : List~PersonaMutante~
            -CanIntegrantes : int
            -Color : string
            -Vivos : int
            -EstadoEquipo : boolean = true
            +RestarIntegrantes()
            +Get()
            +Set()
        }
    }

    namespace Model {
        class PersonaMutante {
            -Id : int
            -Estado : boolean
            -Vida : int = 100
            -Defensa : int
            -X : int
            -Y : int
            -PoderMutante : Poder
            -ModoInmune : boolean = false
            +UsarPoder()
            +Mover()
            +Get()
            +Set()
        }
    }

    namespace Molde {
        class Poder {
            <<abstract>>
            -danno : int
            +UsarPoder()
            +Get()
            +Set()
        }

        class PoderMutanteFuerte {
            +UsarPoder()
        }

        class PoderMutanteMedio {
            +UsarPoder()
        }

        class PoderMutanteDebil {
            +UsarPoder()
        }
    }

    ControlJuego "1" o-- "2" Equipo : contiene
    ControlJuego "1" o-- "1" BattleField : contiene
    Equipo "1" o-- "*" PersonaMutante : contiene
    PersonaMutante "1" o-- "1" Poder : tiene
    Poder <|-- PoderMutanteFuerte : extends
    Poder <|-- PoderMutanteMedio : extends
    Poder <|-- PoderMutanteDebil : extends
#Especificación

**controlJuego**
- -Equipo1 Equipo
- -Equipo2 Equipo
- -tablero battleFlield
- +CalDistancia(mutante Mmutante1,mutante Mutante2)
- +DefinirAcciones()
- +Run()
- +get()
- +set()

**battleFlield**
- -X int
- -Y int
- +set()
- +get()

**Equipo**
- -Integrantes list<PerrsonaMutante>
- -CanIntegrantes int
- -Color string
- -Vivos int
- -EstadoEquipo bolean=true 
- +get()
- +set()



**PerrsonaMutante**
- -Id int
- -Estado bolean 
- -Vida int=100
- -Defensa int
- -PoderMutante poder 
- -EstadoDefencivo bolean
- -ModoInmune bolean= false //puede o no ser atacado 
- +UsarPoder()
- +detectarMutanteEneigo()
- +Mover()
- +get()
- +set()

**Poder<<inreface>>**
- +UsarPoder()

**PoderMutante extend<< Poder>>**
- +UsarPoder() //cada poder debería tener una forma de movimiento diferente


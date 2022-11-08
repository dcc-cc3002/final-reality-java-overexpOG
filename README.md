Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

## instrucciones de uso

El programa todabia no tiene una version que se pueda correr, por lo que para probar que los distintos metodos
funcionen correctamente se pueden probar los distintos test que se hicieron para cada metodo (que estan en la 
carpeta test).

## desarrollo

A continuación se va a proceder a listar los detalles mas importantes de los cambios hechos, pero estos no
van a estar ordenados secuencialmente en el tiempo.

- se mantuvo el codigo de la carpeta exceptions.
- se creo una carpeta uml, con un 
  [Uml.png](https://github.com/dcc-cc3002/final-reality-java-overexpOG/blob/0e05140fe9f7ea0d5c6896d3ceab586c7fa55c07/uml/Uml.png) 
  que contiene el UML del programa.
- Se le agregan las licencias y se le coloca mi nombre en autor en las diversas clases.
- los getters y setters que estaban en privado se cambiaron a publicos pues estos metodos se crearon para que
  se usaran desde fuera de la clase por lo que no tenia sentido que fueran privados.
- se puso finals a variables que iban a ser constantes que estaban sin final (tambien se puso final @NotNull
  a todos los que tenian @NotNull final, para que en todos se vean igual, aun que no se cual es el correcto).
- se crea una nueva interfaz para Mage que extiende de PlayerCharacter, esta interfaz representa a los personajes
  del jugador que pueden usar magia (tienen Mp).
- se crea una nueva interfaz para Common que extiende de PlayerCharacter, esta interfaz representa a los 
  personajes del jugador que no pueden usar magia.
- se crea una nueva interfaz para NonPlayableCharacter que extiende de de GameCharacter, esta interfaz representa
  a los personajes que no son jugables por el jugador (tienen peso ya que no equipan armas).
- se crea una clase abstracta de mago AbstractMage que implementa Mage (BlackMage y WhiteMage heredan de esta clase).
- se crea una clase abstracta de personajes no jugables AbstractNonPlayableCharacter que implementa
  NonPlayableCharacter (Enemy hereda de esta clase).
- se mantiene los metodos addToQueue en privado pues solo se creo para usarse en waitTurn.
- los metodos de addToQueue y waitTurn se mantienen en AbstractCharacter, y se crea un metodo auxiliar distinto para
  los AbstractPlayerCharacter y AbstracNonPlayableCharactert esto pues si se agregara un nuevo tipo de personaje de la 
  manera anterior se tendria que modificar el codigo, de esta manera solo se programaria un nuevo metodo auxiliar en este 
  nuevo tipo de personaje (siendo un codigo extendible), debido a esto se modifico el codigo de waitTurn.
- al toString, hashCode y equals de los personajes, se les modifico para que tuvieran el nombre, maxHp, currentHp,
  defense, weight, maxMp, currentMp ordenados de esa forma a la hora de printear o para ver si dos personajes son 
  iguales (si un personaje no tiene una de las variables anteriores, se omite y se sigue a la siguiente), se le
  agrega toString a Enemy.
- se le coloca un minimo de weight a AbstractWeapon y a Enemy de 1 (en el constructor), tirando un error 
  si no cumple.
- se le coloca un minimo de defense a AbstractCharacter de 0 (en el constructor), tirando un error si no cumple.
- se le coloca un minimo de maxHp a AbstractCharacter de 1 (en el constructor), tirando un error si no cumple.
- se le colca un minimo de maxMp a AbstarctMage de 1 (en el constructor), tirando un error si no cumple.
- Se elimino la clase Weapon y el enum con los distintos tipos, en vez de ello se preferio crear una interfaz Weapon,
  un AbstractWeapon y cada arma por separado, esto se hace pues cuando se quiera agregar nuevas armas, en vez de
  modificar el enum, solo se crea una nueva clase del arma que se quiera crear (asi no se modifica el codigo, si no 
  que solo se extiende) que herede de AbstractWeapon la cual implementa Weapon.
- A la interfaz GameCharacter se dividio en 2, ActionTurn que contiene waitTurn y GameCharacter que contiene el 
  resto, esto lo hice ya que a mi juicio los GameCharacter no son los unicos que podrian llegar a esperar por su
  turno (por ejemplo, podria haber escenarios que hagan acciones sobre los personajes o cosas asi), por lo que
  esperar por un turno lo considere algo que implementan los personajes del juego pero no son los unicos y por
  ello lo separe y puse que GameCharacter extiende de ActionTurn.
- se modifico equip, para que se equipara el arma solo si el personaje se puede equipar el arma, en caso contrario
  tira un error, para ello se utilizo double dispatch, por lo que se crearon los metodos isEquippable para cada 
  personaje y sus diversas conbinaciones para los distintos personajes (es decir isEquippablePersonaje por ejemplo
  isEquippableThief).
- se elimina el codigo que sirve de ejemplo y se crea una carpeta test, con varios test que prueban el buen 
  funcionamientos de los distintos metodos.
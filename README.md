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

Para correr el programa, hay que correr desde la carpeta donde se tenga el programa
./final-reality-java-overexpOG/src/main/java/cl.uchile.dcc/Main (el punto indica la ruta anterior
a la carpeta desde donde se tiene el programa), este programa va a correr un codigo en el que pruebe
los metodos hechos por el programa (como se esta todabia en una fase temprana, solo se usan prints
para ver que los metodos hechos funcionen correctamente).

## desarrollo

A continuación se va a proceder a listar los detalles mas importantes de los cambios hechos, pero estos no
van a estar ordenados secuencialmente en el tiempo, si no que van a estar ordenados segun su relevancia
(de menos importante a mas importante, con el main al final).

- se mantuvo el codigo de la carpeta exceptions.
- Se le agregan las licencias y se le coloca mi nombre en autor en las diversas clases.
- los getters y setters que estaban en privado se cambiaron a publicos pues estos metodos se crearon para que
  se usaran desde fuera de la clase por lo que no tenia sentido que fueran privados.
- se puso finals a variables que iban a ser constantes que estaban sin final (tambien se puso final @NotNull
  a todos los que tenian @NotNull final, para que en todos se vean igual, aun que no se cual es el correcto).
- se mantiene el metodo addToQueue en privado pues solo se creo para usarse en waitTurn (en AbstractAddingQueue).
- al toString, hashCode y equals de los personajes, se les modifico para que tuvieran el nombre, maxHp, currentHp,
  defense, weight, maxMp, currentMp ordenados de esa forma a la hora de printear o para ver si dos personajes son 
  iguales (si un personaje no tiene una de las variables anteriores, se omite y se sigue a la siguiente), se le
  agrega toString a Enemy.
- se le coloca un minimo de weight a AbstractWeapon y a Enemy de 1 (en el constructor), tirando un error 
  si no cumple.
- se le coloca un minimo de defense a AbstractCharacter de 0 (en el constructor), tirando un error si no cumple.
- se le coloca un minimo de maxHp a AbstractCharacter de 1 (en el constructor), tirando un error si no cumple.
- se le colca un minimo de maxMp a AbstarctMage de 1 (en el constructor), tirando un error si no cumple.
- AbstractCharacter se dividio en 2, ya que considere que contenia 2 funcionalidades dentro de si, crear
  las variables que definen al personaje y un metodo para unirse a una cola, por lo que a AbstractCharacter le
  quite los metodos de addToQueue y waitTurn (por esto, ya no necesitaba pasarle el paramtero turnQueue a su
  constructor), centrandose ahora en crear las variables que definen al personaje con sus getters y setters,
  luego tambien cree una nueva clase abstracta AbstractAddingQueue que defina los metodos de meter los personajes
  a la cola (esta ultima clase heredando de la primera, pues de la otra forma me tiraba error, aun que yo pienso
  que lo que realmente hay que hacer, es crear una clase abstracta que contenga la forma de añadir objetos a la
  cola en base a su caracteristica peso y AbstractCharacter herede de esta por que los personajes se pueden añadir
  a la cola, pero creo que aun no pasan una forma de hacer eso, digo que lo haria asi por que se podrian llegar a 
  colocar otras cosas que se agreguen a la cola que no sean pj, como un daño del ambiente o algo asi).
- se creo la clase abstracta AbstractMage que contiene maxMp y currentMp como variables del personaje, por lo que
  tambien se crean sus getters y setters, luego los personajes del jugador que sean magos heredan de AbstractMage 
  en vez de AbstractPlayerCharacter (BlackMage y WhiteMage).
- Se elimino la clase Weapon y el enum con los distintos tipos, en vez de ello se preferio crear una interfaz Weapon,
  un AbstractWeapon y cada arma por separado, esto se hace pues cuando se quiera agregar nuevas armas, en vez de
  modificar el enum, solo se crea una nueva clase del arma que se quiera crear (asi no se modifica el codigo, si no 
  que solo se extiende) que herede de AbstractWeapon la cual implementa Weapon.
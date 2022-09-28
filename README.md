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
- los getters y setters que estaban en privado se cambiaron a publicos pues estos metodos se crearon para que
  se usaran desde fuera de la clase por lo que no tenia sentido que fueran privados.
- notar que el metodo de addToQueue se mantuvo en privado pues solo se creo para usarse en waitTurn.
- AbstractCharacter se dividio en 2, ya que considere que contenia 2 funcionalidades dentro de si, crear
  las variables que definen al personaje y un metodo para unirse a una cola, por lo que a AbstractCharacter le
  quite los metodos de addToQueue y waitTurn (por esto, ya no necesitaba pasarle el paramtero turnQueue a su
  constructor), centrandose ahora en crear las variables que definen al personaje con sus getters y setters,
  luego tambien cree una nueva clase abstracta AbstractAddingQueue que defina los metodos de meter los personajes
  a la cola (esta ultima clase heredando de la primera, pues )

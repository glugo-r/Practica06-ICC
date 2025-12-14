Gabriel Lugo Rosete

Tabla Comparativa (Aproximado):
1 hilo: 5-8 ms 
2 hilos: 9 ms
4 hilos: 15 ms
8 hilos: 30 ms

• ¿Se volvió más rápido el programa?
No se volvió más rápido, esto porque, tarda tiempo la creación de hilos, y al crear más hilos adicionales tienen que competir por los recursos, además la operación realizada no es muy complicada, así que el crear hilos y dividirla entre ellos no compensa el tiempo y costo de hacerlo, por lo que en este caso el tener más hilos no resultó en que se volviera más rápido. 

• ¿Qué problemas encontraste al manejar datos compartidos?
El problema principal fue que no se generaran condiciones de carrera, como que no escribieran el valor los hilos en una variable compartida, y evitar que se hiciera una suma incorrecta al final, mediante la sincronización.

• ¿Qué aprendiste sobre los programas que usan mas de un hilo?
Aprendí sobre el uso de los hilos y como y cuando son mejores utilizados para acelerar los cálculos y velocidad de un programa. AL igual que dependiendo de la complejidad del problema a resolver pueden no ser necesarios, ya que si se utiliza una cantidad excesiva de hilos, pueden empeorar la velocidad del programa.Además junto con ello puede haber dificultades y consideraciones como la sincronización y evitar condiciones de carrera para que no haya resultados incorrectos o bloqueos.

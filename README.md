# Practica06-ICC

## Objetivo
Dividir un problema matemático en sub-tareas que se ejecuten en paralelo mediante hilos y, después, combinar los resultados correctamente.

## Descripción:
<img width="464" height="241" alt="image" src="https://github.com/user-attachments/assets/b82148f5-143d-4d37-a04f-0da40409111a" />

El programa usa N hilos (N configurable por el usuario) donde cada hilo se encarga de un rango específico de la suma.

Cada hilo calcula su parte de la suma y guarda su resultado parcial. 

Se utilizan mecanismos de sincronización para evitar condiciones de carrera.

El hilo principal espera a que los hilos terminen, suma los resultados e imprime el resultado final.

El programa también mide:
- Tiempo total con 1 hilo.
- Tiempo total con N hilos

## Tecnologías utilizadas
Java

## Instrucciones de Ejecución
Compilar desde src: "javac SumaParalela.java"

Ejecutar Programa desde src: "java SumaParalela"

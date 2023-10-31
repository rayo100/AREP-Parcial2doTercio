# Parcial2doTercio-AREP

Diseñé, construya y despliegue un aplicación web para investigar la conjetura de Collatz. El programa debe estar desplegado en un microcontenedor Docker corriendo en AWS. 
Las tecnologías usadas en la solución deben ser maven, git, github, maven, sparkjava, html5, y js. No use liberías adicionales.

1. Incluya instrucciones de cómo clonarlo, compilarlo, y ejecutarlo.
2. Descripción del proyecto en el README con pantalazos que muestren el funcionamiento.
3. Descripción de cómo correrlo en EC2
4. Video de menos de un minuto del funcionamiento (lo puede tomar con el celular una vez funcione o con teams)

## Cómo correrlo en tu equipo

´´´
Para clonarlo, ve a tu directorio de preferencia y escribe el siguiente comando

git clone https://github.com/rayo100/Parcial2doTercio-AREP.git

Luego, digita el comando 

cd Parcial2doTercio-AREP

Finalmente

mvn clean install

Para correrlo desde un dispositivo con sistema operativo Windows, corre el siguiente comando

java -cp "target/classes;target/dependency/*" org.example.CollaztService

Para correrlo desde un dispositivo con sistema operativo Linux o Apple, corre el siguiente comando

java -cp "target/classes:target/dependency/*" org.example.CollaztService
´´´
Al realizar los pasos anteriores dirigete al browser e ingresa al siguiete enlace http://localhost:5000/index.html

Te debería aparecer algo así

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/c6e9d9ce-3467-4e28-ae11-33f2600b4a28)

Ahora puedes probar con cualquier número y ver la secuencia de Collazt

## Probando la funcionalidad 

![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/be3b692e-e6cd-4c3e-95d3-d2f0a60bf8ac)
![image](https://github.com/rayo100/Parcial2doTercio-AREP/assets/89558695/e920f210-4daa-4599-903c-9ba0b92a4091)

## Cómo correrlo en EC2






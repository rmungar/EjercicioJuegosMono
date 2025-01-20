## a) ¿Qué ventajas e inconvenientes encuentras al usar una base de datos documental con MongoDB?

    Las bases de datos documentales, o en este caso MongoDB, nos permiten tener una gran variedad de estructuras de datos, nos proporcionan bastante flexibilidad y una gran escalabilidad. 
    Por lo contrario, las consultas son mucho mas extensas y complicadas, lo que nos obliga a tener que realizar consultas que por otro lado serían automáticas de forma manual y una gran complejidad a la hora de usar claves foráneas.

## b) ¿Cuáles han sido los principales problemas que has tenido al desarrollar la aplicación?

    Uno de los problemas que me he encontrado al desarrollar la aplicación es la posibilidad de que el campo que busco en la estructura de datos no es exactamente igual al que estoy introduciendo.
    Otro bien sería a la hora de actualizar los datos, los nombres, los valores, los tipos de datos y las referencias son muy estrictas y es fácil equivocarse y confundir cualquiera de estos valores.
    
## c) ¿Cómo solucionarías el problema de la inconsistencia de datos en una base de datos documental? (El hecho de que en los documentos de una colección no sea obligatorio seguir un esquema único)

    Considero que una de las soluciones más efectivas sería llevar a cabo validaciones dentro de la aplicación para que las estructuras cumplan con un mínimo de consistencia. Esta solución es muy tediosa y laborosa,
    pero permitiría llevar a cabo su proposito.
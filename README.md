## Banking Challenge

Este repositorio contiene mi solución al ejercicio propuesto.

### Ejercicio 1

Se proporciona el fichero java SqlETL, que lee el fichero de datos proporcionado y lo escribe en una base de datos postrgresql. Dicha base de datos puede levantarse usando el archivo docker-compose.yml proporcionado.

### Ejercicio 2

Se proporciona el fichero QueriesETL, que partiendo de los datos proporcionados ejecuta una serie de consultas en spark para obtener los datos solicitados. Los datos se incluyen a continuación.

#### Consulta 1

| age | count |
| --- | ----- |
| 31 | 71 |

#### Consulta 2

| age | marital | sum(balance) |
| --- | ------- | ------------ |
| 30 | single | 414492|

#### Consulta 3

| contact | count |
| -------- | ----- |
| cellular | 3160 |

#### Consulta 4
En este caso se muestran solo los 20 primeros resultados

|campaign| marital|          job|      avg(balance)|max(balance)|min(balance)|
| -------- | -------- | ------------- | ------------------ | ------------ | ------------ |
|       1|divorced|       admin.|1027.2736842105264|       12039|        -637|
|       1|divorced|  blue-collar|1000.7301587301587|       10613|        -473|
|       1|divorced| entrepreneur|            458.75|        2908|        -934|
|       1|divorced|    housemaid|             893.0|        3701|           0|
|       1|divorced|   management| 1833.965811965812|       17964|        -449|
|       1|divorced|      retired|1813.4157303370787|       37127|        -779|
|       1|divorced|self-employed|3924.3333333333335|       52587|           0|
|       1|divorced|     services| 577.9180327868852|        5571|        -752|
|       1|divorced|   technician|1128.1780821917807|        6835|        -357|
|       1|divorced|   unemployed|          965.4375|        3354|           5|
|       1| married|       admin.| 1312.846625766871|       20011|        -444|
|       1| married|  blue-collar|1232.5805243445693|       19447|       -1489|
|       1| married| entrepreneur|2682.0227272727275|       51439|        -627|
|       1| married|    housemaid| 1440.704918032787|       11219|           0|
|       1| married|   management|1894.5831842576029|       34230|       -6847|
|       1| married|      retired| 2768.041379310345|       81204|        -492|
|       1| married|self-employed|1661.2643678160919|       14144|        -497|
|       1| married|     services|1430.5922330097087|       20928|        -538|
|       1| married|      student|1146.8333333333333|        3503|           0|
|       1| married|   technician|1512.4142857142858|       16992|       -1944|

#### Consulta 5

| job | count |
| ---------- | ----- |
| blue-collar | 33 |

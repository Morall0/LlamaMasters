---
lang: es

# Metadata variables
title: "Colecciones"
subtitle: "en Java"
author: 
    - "Alan Mauricio Morales López"
    - "Jesús Yael Caballero Antunez"
    - "Alfonso D`Hernan Rodríguez Zuluaga"
date: "02 de octubre de 2023"

# Variables for LaTeX
documentclass: article
geometry:
- top=25.4mm
- left=25.4mm
- right=25.4mm
- bottom=25.4mm
papersize: letter

numbersections: true
autoEqnLabels: true

# First Line indent
indent: true
first-line-indent:
  size: 2em
  auto-remove: true
  set-metadata-variable: true
  set-header-includes: true
  remove-after:
    - BlockQuote
    - CodeBlock
    - DefinitionList
    - HorizontalRule
  dont-remove-after: 
    - Table
    - BulletList
    - OrderedList
  remove-after-class: 
    - statement
  dont-remove-after-class: 

# figureTitle: "Figura"
# tableTitle: "Tabla"
# figPrefix: "fig."
# eqnPrefix: "ec."
# tblPrefix: "tbl."
# loftitle: "# Lista de figuras"
# lotTitle: "# Lista de tablas"
...
# Colecciones

Java contiene un framework de colecciones que provee al usuario estructuras de datos básicas y una serie de algoritmos para trabajar con ellas, con el objetivo de que el usuario no tenga que escribirlas por sí mismo.

El framework de colecciones es una arquitectura unificada para representar y manipular colecciones. Está constituido primordialmente por interfaces de colecciones que representan diferentes tipos de colecciones, como conjuntos (Set), listas (List) y mapas (Map), los cuales son la base del framework. Además, contiene métodos estáticos con algoritmos muy útiles para las colecciones como el ordenamiento o la búsqueda.

Las interfaces de colecciones están divididas en dos grupos, las subinterfaces que se derivan directamente de java.util.Collection y las subinterfaces de colecciones basadas en java.util.map, las cuales no son realmente colecciones, sin embargo, contienen operaciones collection-view las cuales les permiten ser manipuladas como colecciones.

## Interfaz *Collection*

Una colección, representa un grupo de objetos, conocidos como elementos; algunas permiten duplicar elementos y otras no; algunas están ordenadas y otras desordenadas. 

La interfaz Collection es la raíz en la jerarquía de colecciones. Es importante saber que el JDK no provee ninguna implementación directa de la interfaz Collection, sino que a partir de ella se deriva en subinterfaces más específicas. Su utilidad directa en el código se da cuando se trabaja con las subinterfaces de Collection y es necesaria la máxima generalidad para recibirlas y manipularlas.

Collection tiene las siguientes subinterfaces:

- List
- Queue
- Set

Como se mencionó anteriormente, la interfaz Map también  se puede manipular como una colección, sin embargo, no es una subinterfaz de Collection.

Los constructores de las clases de propósito general que son implementación de Collection deben de tener dos constructores estándar. Un constructor vacío que crea una colección vacía y un constructor con un solo argumento de tipo Collection, el cual crea una nueva colección con los mismo elementos que la colección recibida en el argumento, es decir, permite copiar cualquier colección, produciendo en una nueva equivalente del tipo que se desee (siempre y cuando sea subinterfaz o clase proveniente de una subinterfaz de Collection).

Algunas implementaciones tienen restricciones sobre los elementos que contienen, como que no pueden ser null o tienen restricciones en el tipo de sus elementos.

### Interfaz List

La interfaz List refiere a aquellas clases que crean colecciones cuya principal característica es que los elementos a almacenar tengan un cierto orden, es debido a esto que también se le conocen por el nombre de secuencias. La organización que presentan los valores guardados corresponde a la de posiciones indexadas, haciendo referencia a que los elementos contarán con una posición dentro de la secuencia definida mediante un valor entero numérico conforme se vayan ingresando a ella.

A partir de un orden indexado que se basa en la forma en que se manejan los arreglos del lenguaje, es decir, son enumeraciones que comienzan desde cero y van incrementando una unidad por posición hasta alcanzar el tamaño de la colección reducido en uno, las listas permiten múltiples métodos para la inserción, eliminación y acceso eficiente de elementos con el uso de índices. 

A diferencia de otros tipos de colecciones, como aquellas catalogadas dentro de la interfaz set, las listas permiten almacenar elementos duplicados. Además, también se debe considerar que son iterables, pues se puede ingresar a cada uno de sus elementos de manera secuencial a partir del uso de bucles, como lo puede ser las estructuras iterativas foreach, en contraste con las implementaciones de la interfaz Map, HashMap y TreeMap.

List cuenta con cuatro clases principales que generan sus propias implementaciones del concepto de secuencia, además de que añaden métodos propios para la manipulación de las colecciones desarrolladas a partir de ellas. Estas colecciones a investigar se tratan de:

- LinkedList
- ArrayList
- Vector
- Stack

De modo que se reconocerán las principales características de cada una, así como las herramientas que facilitan para un manejo eficiente de las mismas.

#### LinkedList:

La primera implementación a investigar de la interfaz es la clase LinkedList, la cual se caracteriza por ser una representación de una lista doblemente ligada, estructura de datos estudiada previamente en la materia precedente donde los elementos se encuentran conectados con sus vecinos, de modo que no existe una única dirección en la que se pueda visitar los elementos de la colección. 

Considerando la propiedad principal de la clase, se puede concluir en varias más, de modo que se pueden encontrar varias ventajas de su uso. Uno de ellos, por ejemplo, es que al tener cada elemento referencias tanto al valor anterior como al posterior, las operaciones de inserción y eliminación se vuelven muy eficientes en cualquier lugar de la colección. También se puede hacer hincapié en que no se tiene que establecer una capacidad inicial que delimite la cantidad de elementos a contener, pues se pueden añadir tantos valores como uno desee al final de la lista doblemente ligada.

Aun cuando la clase tiene varias cualidades que logran una mayor versatilidad en su manipulación, como lo pueden ser sus métodos que permiten la implementación de otras estructuras de datos como las pilas y las colas, se tiene que tomar en cuenta algunas desventajas de peso al momento de emplearlas. Una de ellas sería la lentitud en el acceso de los elementos almacenados, pues aunque se puedan encontrar los elementos cercanos a los extremos de la colección de manera casi inmediata, el visitar valores que se hallen cada vez más cerca al medio costará un mayor tiempo debido a la iteración lineal que sigue todos los enlaces desde el principio o el final para alcanzarlos.

Otro punto negativo a considerar es la falta de sincronización que poseen estas estructuras de datos. Aunque no se ha visto todavía en la materia, es importante saber que las LinkedLists no es sincronizada, lo que significa que is múltiples hilos acceden a ellas simultáneamente, y al menos uno de ellos la modifica estructuralmente, es decir, cambia su capacidad al añadir o remover uno o varios elementos, la sincronización se tendrá que hacer por parte del desarrollador. De otra forma, pueden ocurrir problemas de concurrencia como lecturas o escrituras de valores inconsistentes entre hilos.

Los primeros métodos son aquellos que permiten ingresar elementos dentro de una lista ligada. La gran mayoría de ellos poseen en su nombre la palabra add, haciendo referencia a la operación que realizan. Para ingresar un único elemento, se tiene a los métodos add() y addFirst(), los cuales no regresarán ningún valor tras su llamada. Para el primer método existe una sobrecarga, puesto que en caso de pasarle como único parámetro el objeto a guardar en la colección, este hará la inserción al final de la lista, mientras que si se manda además un índice, se agrega el objeto en la posición definida por él. Para el segundo método nombrado, se hace la inserción al principio de la colección.

Si se desea hacer la misma acción, pero ahora no únicamente con un elemento, sino con un conjunto de ellos almacenados en una colección, se hace uso del método addAll(), que hace la inserción de todos los elementos internos de la colección pasada como parámetro a la lista ligada. Al ser un método sobrecargado, existe la versión que recibe un índice que indica la posición en la que se comenzarán a ingresar los valores guardados. A diferencia de los métodos de inserción que no retornan ningún valor, estos sí lo hacen, pues mediante un valor booleano verdadero indican si la llamada al método concluyó en cambios dentro de la linkedList. 

Se debe precisar que aquellos métodos de inserción que reciben el índice donde se colocará el elemento a guardar generan un desplazamiento de aquellos valores previamente guardados en la lista ligada, de tal modo que los índices de los elementos posteriores al o a los ingresados será incrementado por la cantidad de casillas que se tuvieron que mover. 

Además de estos métodos que realizan la incorporación de elementos existen algunos otros más, como addLast(), que hace es completamente equivalente a la versión de add() que sólo recibe el objeto a guardar, y push(), que de igual forma es un método equivalente, pero en este caso a addFirst().
	
Pasando a los métodos de acceso principales de la clase, se tienen todos aquellos que contienen en el nombre la palabra get. Comenzando con el método estándar de esta sección, se tiene a get(), el cual sólo recibe un valor numérico entero que representa el índice del elemento a visitar dentro de la colección. Las otras dos versiones de este método son getFirst() y getLast(), que son casos específicos donde se quiere conocer al elemento guardado que se encuentra en la primera posición o en la última respectivamente. Todos estos métodos retornarán el elemento a buscar.

Otros métodos que efectúan la acción de encontrar elementos en la colección son peek(), peekFirst() y peekLast(), los cuales realizan exactamente lo mismo que los métodos get, con la diferencia de que el primer método no recibe ningún índice, pues retorna siempre el elemento guardado en la primera posición de la colección. Los últimos dos hacen lo mismo que getFirst() y getLast(), con la diferencia que regresan un valor nulo en el escenario donde la lista ligada esté vacía.

Para los escenarios donde se conozca al elemento guardado, pero no su índice, se emplean los métodos indexOf que recorrerán la colección para retornar el valor que define a la posición del valor conocido. Existen dos métodos de este tipo, indexOf() y lastIndexOf(). La diferencia que existe entre estas dos herramientas es el valor que se devolverá en casos donde el valor del cual se quiere conocer su índice se halla repetido dentro de la lista ligada. Para el primer método señalado, este regresará a su llamada el índice de la primera posición de inicio a fin de la colección donde se halle un valor igual al pasado como parámetro. Por el lado de lastIndexOf(), se tiene que el valor a retornar será el índice de la última posición que contenga al elemento que sea igual al pasado.

Los métodos que se dedican a la eliminación de elementos llevan en su nombre la palabra remove. Comenzando por el más simple de ellos, se tiene a remove(), al cual se le aplica sobrecarga para tener tres versiones de este. La primera de ellas no requiere de parámetros, ya que simplemente quita al primer elemento que se encuentre en la lista ligada y lo devuelve a la llamada. La segunda de ellas requiere de un parámetro de tipo entero que representa el índice del elemento a eliminar; de igual forma, también retorna el valor removido de la colección. La última versión trabaja con un parámetro que sea igual al objeto a eliminar, de modo que se quitará de al primer elemento de inicio a fin que cumpla con la igualdad; este, en lugar de retornar el elemento eliminado, se regresa un valor booleano verdadero si la lista se ve alterada tras la llamada del método.

También se tienen los métodos removeFirst() y removeLast(), los cuales quitan de la lista ligada el primer o el último elemento respectivamente, para después devolverlo en la llamada. Por último, se pueden agregar a la lista los métodos removeFirstOcurrence() y removeLastOcurrence(), que se dedican a eliminar valores dentro de la lista que son iguales a los pasados como parámetros cuando existen de forma repetida. El primero hace la eliminación del primero que se encuentre al visitar cada posición de la lista ligada de inicio a fin, mientras que el segundo remueve la última ocurrencia.

Se tienen otros métodos como poll(), pollFirst() y pollLast() que funcionan igual que aquellos que contienen en su nombre la palabra peek, con la diferencia que en lugar de únicamente acceder a los elementos de la lista y retornarlos en la llamada, posteriormente se eliminan de la colección. Otro método que también se puede usar para eliminar elementos es pop() que es equivalente a removeFirst(). Ya si se desea vaciar por completo la lista ligada, existe el método clear(), que no retorna ningún valor tras su llamada.

Es importante señalar que, al igual que cómo ocurre en los métodos de inserción de elementos, el eliminar elementos de una lista ligada genera un cambio estructural en ella, de modo que los elementos que se encontraran después de aquel que se eliminó tendrán que ser desplazados una posición hacia la izquierda, es decir, sus índices se verán decrementados en una unidad por cada elemento eliminado antes que ellos.

Algunos métodos extra que son de gran utilidad en la manipulación de estos contenedores son size(), contains(), toArray() y set(). El primero de ellos retorna un valor numérico entero que representa la cantidad de valores que contiene la lista que lo llame, de modo que no requiere de ningún parámetro para su funcionamiento. contains() sirve para determinar si existe un elemento igual al pasado como parámetro dentro de la colección; en caso afirmativo, devuelve un valor verdadero, de otro modo, regresa uno falso. toArray() crea un arreglo que contenga los elementos de la linkedList en el mismo orden en que fueron agregados, es decir, con los índices de manera ascendente. El último de los nombrados recibe el índice de un elemento a reemplazar por aquel que se pase como parámetro segundo; en su llamada regresará el valor que la posición indicada contenía previo a la sobreescritura.

#### ArrayList:

Al igual que la clase antes explicada, ArrayList es una de las implementaciones más utilizadas de la interfaz. Esta se caracteriza por generar colecciones que funcionan como los arreglos que el mismo lenguaje de programación ofrece, pero con la diferencia de que estos son capaces de ser redimensionados, además de que se pueden aplicar varios de los métodos que existen en las clases de List, como aquellas que se describieron para LinkedList. 

La manera en que este tipo de colecciones trabaja es que se crea una lista que se encuentra respaldada por un arreglo subyacente, de modo que la forma en que se puede manipular la lista que contiene los elementos es como si se tratara de un arreglo como tal. Esto es de gran ayuda en el acceso de valores dentro de la colección, pues mediante índices esta acción se ejecuta bajo una complejidad temporal constante al trabajarse como arreglo. Con esta ventaja también viene una desventaja, pues las acciones de inserción y eliminación serán mucho menos eficientes que en la clase previa, ya que los elementos externos a estas operaciones deben ser desplazados casilla a casilla ya sea para hacer espacio para elementos nuevos o llenarlo en caso de remover algunos.

Un atributo interesante de este tipo de colecciones es su capacidad, que no hay que confundir con el número de elementos que contiene. La capacidad de una ArrayList hace referencia al tamaño que tendrá el arreglo subyacente a la lista para poder guardar elementos, es decir, por una parte se tiene la cantidad de valores que guarda actualmente la lista, mientras que por otra se tienen posiciones libres para ingresar aún más por parte del arreglo. Cuando se crea y se añaden valores a una colección de este tipo, su capacidad siempre es ajustada para que sea por lo menos igual de grande a lo requerido para contener los valores almacenados. Conforme se vayan añadiendo más elementos a guardar, la capacidad va creciendo automáticamente.

El ajuste de la capacidad, aunque se realiza automáticamente, existe el método ensureCapacity() que permite ajustarla manualmente antes de ingresar una cantidad grande de elementos a almacenar al pasarle como parámetro la cantidad mínima de elementos que tiene que poder almacenar la colección. Esta práctica permite que al momento de hacer la inserción de valores, se reduzca la cantidad de reasignaciones y expansión de la capacidad para cada nuevo elemento.

Al igual que las listas doblemente ligadas incorporadas en la interfaz List, este tipo de colecciones no son sincronizadas, por lo que en caso de cambios estructurales hechos por algún hilo de los tantos que accedan a los elementos, puede generar problemas de lectura y escritura. Del mismo modo, si se quiere evitar un escenario así, se tiene que hacer la sincronización de forma manual.

De los nuevos métodos de eliminación de elementos a observar, se tiene primero a removeAll(), el cual se encarga de borrar todo elemento que exista en la colección que hace la llamada y la que exista en la colección que se le da como parámetro. Si hubo algún cambio en la colección a la cual se le aplicó el método, este devolverá un valor verdadero. Después se tiene a removeIf(), que consiste en remover los elementos de la colección que satisfagan la condición que se le dé como parámetro a este método; de igual forma, retorna un booleano para los mismos casos.

removeRange() sirve para borrar una cantidad de elementos que existan dentro de un intervalo delimitado por dos índices que se le pasan como parámetros. Para el caso del índice inferior, el elemento que esté en la posición definida por este será tomado en cuenta para la eliminación, caso contrario con el índice superior, pues el elemento que coincida con esa posición no será tomado en cuenta para la operación. 

retainAll() es un método de eliminación que funciona de manera contraria a removeAll(), pues en lugar de quitar los elementos que coincidan en la lista a la que se le aplicará la operación y la que se le pase como parámetro, lo que realizará este método es borrar todos los elementos que no coincidan con la colección de parámetro. Los elementos que existan en ambas colecciones se mantendrán en la lista sobre la que se está haciendo la eliminación de valores. De la misma manera que los métodos previos, si se realiza alguna modificación a la lista que hace la llamada, el valor de retorno será verdadero.

Pasando a métodos más misceláneos, se presenta a forEach(), el cual se dedica a realizar una serie de instrucciones que se le pasan como parámetro escritas entre llaves para ejecutarlas sobre cada uno de los elementos almacenados en la colección. Tras su ejecución, no se regresará ningún valor a la llamada. Es algo muy parecido a la estructura iterativa homónima. También se tiene al método isEmpty(), que no requiere de ningún parámetro y cuya finalidad es determinar si la lista se halla vacía o no; en caso de que sí lo esté, se retorna un valor verdadero, de otro modo será falso.

subList() es un método que se encarga de generar una lista “copia” a partir de la que realiza la llamada del método dentro de un intervalo delimitado por índices, siendo el inferior incluyente y el superior excluyente. Se escribe copia entre comillas debido a que la lista generada no guarda elementos independientes de la lista original, sino que se encuentran enlazados a partir de referencias. Es decir que, si se hace algún cambio en el intervalo delimitado ya sea en la colección original o en la copia los cambios se verán reflejados en la otra. El valor de retorno al ser una lista, se le pueden aplicar métodos como si fuera una lista distinta, no obstante, dichos métodos no tienen que referir a cambios estructurales, ya que no se asegura un resultado preciso. 

Como último método extra se tiene a trimToSize(), cuya tarea es reducir la capacidad del arreglo subyacente de la colección hasta que converja con el número de elementos que guarda la lista, esto con el fin de minimizar el almacenamiento perdido que se puede generar a partir de la instancia de una arrayList o posterior al uso del método ensureCapacity() y sabiendo que hay casillas del elemento que no fueron utilizadas. Es preciso considerar que este método no regresa ningún valor tras su llamada.

#### Vector:

La clase Vector implementa un arreglo creciente de objetos. Esto significa que se le puede dar el mismo manejo al momento de acceder a los elementos que contiene con el uso de índices, además de que posee la ventaja de poder expandirse o comprimirse según lo requerido para añadir o eliminar elementos dentro de sí después de haber sido creado. 

Para que un vector optimice la cantidad de espacio que va a emplear, tienen que cuidar la capacidad que poseen y el incremento de esta. Al igual que lo que pasaba con la clase ArrayList, la capacidad del vector tiene que ser siempre lo suficientemente grande para contener los elementos guardados, es decir, su tamaño, aunque suele ser mayor para considerar la inserción de más componentes. Por el otro lado, la capacidad al ser dinámica, también se fija cuántas casillas nuevas se incrementarán al incrementar la capacidad.

Una de las mayores ventajas del uso de vectores es que, a diferencia de LinkedList y ArrayList, esta clase ya se encuentra sincronizada por defecto. Esto significa que ya existe una protección automática para operaciones multihilo. Esto se logra a partir de bloquear los hilos que accedan a la colección cuando la cantidad es considerable, de modo que se garantiza la consistencia de los elementos guardados. 

En la actualidad, aun cuando los  vectores siguen formando parte de la API de java y siguen siendo funcionales, es importante que se consideran como herramientas obsoletas por la misma razón de ser sincronizadas, ya que esta seguridad proporcionada automáticamente ser muy costosa en el rendimiento, además de que en varias aplicaciones no es necesario esta garantía. 

Aparte de todos los métodos previamente explicados, los vectores contienen algunos más que pueden ser de utilidad al momento de manejarlos. Por ejemplo, containsAll() sirve para revisar si todos los elementos contenidos en la colección que se le pase como parámetro existen dentro del vector, en caso de que esto sea verdadero, devuelve esto en forma booleana.

copyInto() es un método que no retorna nada en su llamada, ya que no lo necesita para hacer la copia de todos los elementos del vector a un arreglo que se le pase como parámetro. Hay que considerar para este método que el tamaño del arreglo donde se ingresarán los valores copiados tiene que ser del mismo tamaño o menor al del vector para que no exista ningún error al exceder la capacidad de la colección estática.

También se implementa equals(), el cual sirve para comparar dos colecciones perteneciente a la interfaz de listas para detectar si ambas contienen los mismos elementos almacenados en el mismo orden en el que fueron insertados. En caso de que las condiciones se cumplan, se obtiene un valor booleano verdadero como retorno, de otro modo, se consigue uno falso. Para que opere este método, es necesario que la colección que se comparará con aquella que hace la llamada sea pasada como parámetro.

Otros métodos de importancia pueden ser capacity(), que permite conocer la cantidad de casillas que posee el vector al realizar la llamada en forma de un valor numérico entero y que es distinto del número de elementos que contiene la colección, y toString(), el cual retorna una representación del vector en forma de cadena para poder visualizar los elementos contenidos en él.

#### Stack:

La clase stack es una extensión de Vector, la cual se caracteriza por ser la representación de una pila, aquella estructura de datos se rige por la regla de que el último elemento que entra a la colección debe ser el primero en salir. Esta clase permite tratar vectores como pilas mediante los métodos de push() y pop(), que ya han sido tratados en la clase LinkedList, además de unos cuantos más como peek(), empty() y search().

Los últimos dos métodos son implementaciones que existen solo para Stack, siendo el primero para conocer si la colección está vacía, retornando un valor booleano verdadero en dicho caso y falso en cualquier otro; mientras que el segundo se encarga de brindar la distancia que existe desde el último elemento ingresado a la colección hasta aquel almacenado que sea igual al objeto que se le pasa como parámetro a search(). Es decir, busca dentro del stack el objeto que sea igual al del parámetro y cuenta la cantidad de elementos que lo separan del tope de la pila.

De la misma forma que ya no se recomienda implementar la clase Vector a programas actuales, el uso de Stack es impráctico debido a la poca cantidad de operaciones que proporciona para la manipulación de este tipo de colecciones, además de contar con los problemas que posee la clase de la cual se extiende. Es por ello que, en caso de simular una pila con una colección, existen otras clases e incluso otras interfaces de colecciones que brindan una mayor eficiencia y eficacia, como lo puede ser la interfaz Deque.

### Interfaz set

Un set en Java es una colección que no puede contener elementos repetidos. Como set es una interfaz que se deriva directamente de la interfaz Collection, significa que los únicos métodos con los que opera es con parte de aquellos que se encuentran en la segunda interfaz mencionada. Lo que le da unicidad a Set como una colección derivada de Collection, aparte de su restricción sobre la duplicidad de objetos, es que tiene una forma de operar sus métodos “equals” y “hashCode”, de forma que dos objetos que se derivan de set, aunque sus formas de ser declaradas en el código sean diferentes, sean comparables de una forma confiable.

Dentro de las clases que se derivan de Set, tenemos a HashSet, LinkedHashSet y HashTree. A grandes rasgos, las diferencias que marcan a cada uno de los tres son:

- HashSet: el más rápido de los tres, al costo de no tener un orden marcado en su organización interna.
- LinkedHashSet: Una versión de HashSet menos rápida pero que tiene una organización basada en el orden en que se introdujeron los datos que la componen.
- HashTree: La versión más lenta de las tres clases, funciona de una manera similar a como funciona un Heap, pues subdivide los elementos que contiene en “ramas”.

De modo que se reconocerán las principales características de cada una, así como las herramientas que facilitan para un manejo eficiente de las mismas.

#### HashSet:

Siendo la clase más rápida de las tres que se encuentran en Set, HashSet es una derivación de dicha interfaz que hace uso de una tabla hash. Como se mencionó anteriormente, iterar sobre los elementos que se incluyen en este tipo de set no garantiza que el orden en el que se presenten los datos sea igual al orden en el que se introdujeron.

Para que exista una consistencia buena en el orden de impresión de datos, es importante hacer que los parámetros de su constructor tengan un tamaño adecuado (tamaño inicial bajo, carga inicial alta), de manera que se pueda optimizar el rendimiento de organización.

Es importante tener en mente que esta clase no se sincroniza por sí sola. Es decir, que si se hace threading sobre de un objeto derivado de esta clase y este se modifica, debe de hacerse una sincronización haciendo uso de un objeto que pueda encapsular o envolver a un objeto (más comúnmente). De igual manera, también existen problemas al tratar de modificar a un objeto de tipo HashSet con un iterador modificado, pues este avienta una excepción cuando se trata de hacer alguna modificación por fuera del método .remove del mismo iterados previamente creado. Esta filosofía, llamada “fail-fast”, se hace para que el objeto no presente comportamientos impredecibles. 

Los métodos principales de esta clase son: HashSet.add (añade un elemento al HashSet), HashSet.clear (borra todos los elementos del HashSet), HashSet.clone (única de HashSet, regresa una versión reducida del HashSet a clonar, con la versión clonada no conteniendo a los elementos que tiene el HashSet original), HashSet.iterator (crea un iterador del objeto que se tiene en mano y lo retorna), HashSet.remove (remueve el objeto que se pasa como parámetro del HashSet, de ser que este lo contenga), y HashSet.spliterator (regresa un objeto de tipo spliterator que contiene a los elementos de la lista. Un objeto spliterator es aquél que itera sobre una partición de los elementos de una colección). Cabe notar que, a pesar de que la mayoría de los métodos anteriores se comparten con la clase madre, Set, estos no están listados como heredados de esta, sino como propios de la clase HashSet, dando a entender que el funcionamiento del HashSet es único, de alguna manera.

El aspecto más importante a considerar en la implementación de estos objetos es el hecho de que el orden impreso a pantalla de los objetos no es el mismo orden en el que se introdujeron. Es decir, que si no es necesario trabajar con una filosofía FIFO, entonces se pueden implementar este tipo de listas sin ningún problema al funcionamiento interno del programa. SIn embargo, de ser este el caso, entonces implementar HashSet en el programa sería poco óptimo. Lo mismo se puede decir de programas que son dependientes del threading para su funcionamiento, pues se necesitaría mucho más espacio de memoria para poder tener todos los elementos del HashSet sincronizados. También es necesario tener en mente que, si el programa va a necesitar una cantidad considerable de iteraciones sobre HashSets creados, entonces los HashSets deben de ser consistentes a lo largo de la corrida del programa, sin necesitar de modificaciones más que de remover elementos.

#### LinkedHashSet:

Es una forma de implementar a la interface Set de una forma parecida a la que se implementa HashSet. Sin embargo, la diferencia entre ambas de estas clases radica en que, mientras HashSet hace uso de una tabla hash para su funcionamiento fundamental, LinkedHashSet hace uso de una lista doblemente ligada. Esto significa que, al costo de un poco menos de eficiencia, LinkedHashSet regresa los elementos que contiene de manera predecible, de manera que tanto el usuario como el programador sabrán, dependiendo de cómo se manejan las cosas, cómo se encuentra el orden de los objetos en el Set. Cabe mencionar que el reinsertar un objeto (es decir, tener un objeto en el LinkedHashSet, removerlo y luego volver a insertarlo) no afecta el orden de impresión a pantalla posterior a dicha operación.

Si se declara un LinkedHashTree como una copia de un Set proveído, se pueden hacer las operaciones necesarias con el LinkedHashTree y, al final de todas estas, el orden con el que se presentarán los datos de este LinkedHashTree será el mismo que el del set originalmente dado.

Una diferencia entre la iteración sobre los elementos de una LinkedHashSet y un HashSet radica en el tiempo que le toma el ser iterado a cada objeto. El tiempo que tarde en iterarse una LinkedHashSet es dependiente de qué tan grande sea este, mientras que el tiempo que tarda en iterarse una HashSet es dependiente de la capacidad de este, por lo que normalmente iterar sobre una HashSet es más lento que iterar sobre una LinkedHashSet.

Fuera de los aspectos previamente mencionados, LinkedHashSet es prácticamente igual a una HashSet, pues también se debe de envolver en un objeto de otra colección para sincronizarse de ser que se haga threading, así como declarar un iterador y modificar la LinkedHashSet.

Los métodos que contiene esta clase son mayoritariamente heredados de HashSet, así como de otras colecciones en Java. Es decir, todos los métodos mencionados en la sección de HashSet también son aplicables aquí. Realmente el único método que es único de esta clase es Spliterator, pero fuera de este todos los demás métodos son heredados de alguna otra clase. Sin embargo, es un buen momento para mencionar los métodos que son únicos de Set, pues estos también son heredados por esta clase. 

Entre estos, están: Set.equals (compara dos objetos heredados de la interfaz Set. Debido a la filosofía de precisión que se adoptó al hacer esta función en Set, equals puede comparar dos objetos derivados de Set y determinar si existe igualdad entre estos), Set.hashCode (regresa los hashCodes de un objeto derivado de Set. Es importante mencionar que, como el hashCode de un objeto derivado de Set es la suma de los hashcodes de cada uno de sus elementos, esto significa que el método equals compara la igualdad de los hashcodes de dos objetos derivados de Set), Set.isEmpty (verifica si un objeto), Set.retainAll (borra todos los elementos del Set que no estén contenidos en la colección pasada como parámetro), y Set.size (regresa el tamaño del Set). Cabe mencionar que todos aquellos métodos que no se mencionaron en la lista anterior se encuentran mencionados en los métodos principales de HashSet, los cuáles están declarados como propios de HashSet en vez de haber sido heredados de Set.

Una cosa que se debe de considerar antes de hacer uso de esta clase es el hecho de que se usa una lista doblemente ligada para la administración de los datos. Es decir, se debe de hacer una comparación entre el espacio de memoria disponible y la importancia que tiene el mantener la organización de los datos, pues mantener una filosofía FIFO a lo largo del programa viene al costo de ocupar más espacio de memoria. Fuera de este aspecto, las demás consideraciones que se deben de hacer antes de hacer uso de esta clase se comparten con la clase HashSet.

#### SortedSet:

Antes de hablar sobre la última clase que implementa Set, es necesario hablar de una subinterfaz que provee Set, la cual es SortedSet. Esta interfaz es, a grandes rasgos, una versión de Set que nos provee con el ordenamiento e iteración ascendente (o en su defecto, aquél proveído por el usuario haciendo uso de un objeto tipo Comparator). Cabe mencionar que todos los elementos encontrados en este tipo de Set deben de ser comparables entre sí (es decir, ningún par de elementos en este tipo de Set debe de arrojar una excepción al usar el método compareTo). También cabe mencionar que su forma de operar es fundamentalmente diferente a aquella de Set, pues Set hace uso de equals para su operación fundamental, mientras que SortedSet hace uso de la función compareTo, por lo que es muy importante para el funcionamiento consistente de SortedSet que la función compareTo sea consistente con equals.

#### TreeHash:

Siendo la última versión de implementar Set mencionada en esta lista, se basa en la clase TreeMap para su funcionamiento. Como se deriva de SortedSet, comparte la forma en que organiza los elementos desde un principio con esta. A diferencia de las otras dos formas de implementar un Set, las cuales proveen una complejidad temporal constante con las operaciones básicas estipuladas de un Set suponiendo que los contenidos se dividen equitativamente entre los espacios de memoria dados a estos, TreeSet garantiza una complejidad temporal constante de log(n) para cada operación básica efectuada con un objeto de este tipo. 

## Interfaz *Map*

Un map es un objeto que mapea claves con valores. Cada valor tiene una clave única, por lo que un map no puede contener claves repetidas.

La interfaz Map proporciona tres collection views, que permiten visualizar el contenido del map como un conjunto de claves, una colección de valores o un conjunto de mapeos clave-valor.

El orden de un map está definido como el orden en que cada iterador en el los collection views del mapa devuelven sus elementos. Algunas implementaciones de map, como la clase TreeMap, garantizan un orden concreto, a diferencia de la clase HashMap.

Todas las clases que son implementaciones generales de map deben tener dos constructores estándar. Un constructor vacío que crea un mapa vació y un constructor con un solo argumento de tipo Map, que crea un nuevo map con los mismos mapeos clave-valor que el map recibido como argumento, es decir, permite copiar cualquier map, produciendo en uno nuevo equivalente de la clase (debe ser implementación de map) que se desee.

Algunas implementaciones de map tienen restricciones en las claves y valores que pueden contener o tienen restricciones sobre el tipo de sus claves. 

La interfaz map tiene las siguientes implementaciones directas:

- AbstractMap
- HashMap
- LinkedHashMap

Y como subinterfaces tiene a:

- SortedMap
- NavigableMap (subinterfaz de SortedMap)

    Las cuales se implementan en las clases de:

    - TreeMap
    - ConcurrentSkipListMap

    Estas dos últimas tambien son una subclase de AbstractMap

### AbstractMap:

Provee la implementación esqueleto de la interfaz map para minimizar el esfuerzo requerido para implementar la interfaz map en subclases de AbstractMap las cuales son HashMap, TreeMap y ConcurrentSkipListMap (cuando se trabaja con programación paralela).

### HashMap:

Es una tabla hash basada en la implementación de la interfaz map (AbstractMap). Provee todas las operaciones opcionales de map y permite claves y valores nulos. A grandes rasgos, HashMap es equivalente a la clase Hashtable, excepto que HashMap no asíncrona (no apta para programación concurrente) y permite nulos.

HashMap no garantiza un orden en el map; en particular, no garantiza que el orden será el mismo a través del tiempo.

Proporciona un tiempo constante en el desempeño para las operaciones básicas (get y put), asumiendo que la función hash dispersa los elementos apropiadamente entre las cubetas. Las iteraciones sobre los Collection views requieren un tiempo proporcional a la capacidad de la instancia de HashMap (el número de cubetas) más su tamaño (el número de mapeos clave-valor).

Una instancia de HashMap tiene dos parámetros que afectan su rendimiento: la capacidad inicial y el factor de carga. La capacidad es el número de cubetas en la tabla hash, y la capacidad inicial es simplemente es la capacidad en el momento en el momento en el que se crea la tabla hash. El factor de carga es una medida de que tan llena puede estar la tabla antes de que su capacidad aumente automáticamente. Cuando el número de entradas en la tabla hash excede el producto del valor de carga con la capacidad en ese momento determinado, la tabla hash es rehasheada (su estructura interna se rehace) de modo que la tabla hash tiene el doble de cubetas.

Como regla general el valor por defecto para el factor de carga es de (.75) el cual ofrece un buen equilibrio entre el costo del tiempo y el espacio. Valores mayores reducen el espacio de sobrecarga pero incrementan el costo de búsqueda. El número esperado de entradas en el map y su factor de carga deberían tomarse en cuenta cuando se establece su capacidad inicial, de tal manera que se minimice el número de operaciones de rehash. Si la capacidad inicial es mayor a el número máximo de entradas dividido entre el factor de carga, nunca habrán operaciones rehash.

Sus constructores son los siguientes. El constructor vacío de HashMap crea una instancia con una capacidad inicial de 16 y el factor de carga por defecto de 0.75. El segundo constructor es en el que se puede definir la capacidad inicial, con el cual se crea una instancia con la capacidad indicada y un factor de carga por defecto (0.75). El tercer constructor permite crear una instancia con la capacidad inicial y el factor de carga ingresados. Por último, el último constructor permite crear una nueva instancia a partir de otra instancia que sea una implementación de la interfaz Map.

Los principales métodos son los siguientes. Además del constructor, existe el método newHashMap() el cual es igualmente estático. Este método recibe como parámetro el número de mapeos que habrán en el HashMap, es decir, el número de elementos clave-valor, y devuelve una nueva instancia de HashMap vacía creado para dicho número de elementos.

El método put() asocia el valor especificado en la clave especificada, permitiendo ingresar dicho elemento clave-valor al HashMap; recibe como primer argumento la clave y como segundo elemento el valor. Si el HashMap previamente contenía un mapeo para la clave (la clave ya estaba relacionada con un valor) el valor antiguo es reemplazado. El método retorna el valor antiguo asociado con la clave o null en caso de que no existiera un mapeo para la clave.

El método get() retorna el valor asociado a una clave o null en caso de que el map no contenga un mapeo para dicha clave. Recibe como parámetro un objeto que representa la clave que está asociada al valor que se desea obtener.

El método remove() permite eliminar del map, el mapeo para una clave específica, es decir, elimina el elemento clave-valor. Como parámetros de entrada recibe el objeto que representa la clave. Si dicha clave tiene un mapeo clave-valor, el método retorna dicho elemento clave-valor, por otra parte, si la clave no está mapeada con un valor, el método retorna null.

replace() es un método propio de la interfaz Map, al igual que remove(). Dicho método, como lo dice su nombre, reemplaza el elemento clave-valor para la clave específicada sólo si dicha clave se encuentra mapeada a un valor en el momento de llamar al método replace. Recibe como parámetros la clave y el valor que será asociado a dicha clave. El valor de retorno es el valor anteriormente mapeado a la clave o null en caso de que la clave no estuviera mapeada a ningún valor.

Otros dos métodos muy útiles son containsKey() y containsValue(), el cual retorna un booleano. Recibe como parámetro un objeto que representa la clave asociada al valor que se desea obtener y retorna verdadero en caso de contener un mapeo para la clave específica.

Los métodos que permiten ver nuestras claves, los valores, o las asociaciones clave-valor, son entrySet(), keySet() y values(). El método entrySet() retorna una vista en forma de Set de los mapeos (elementos clave-valor) contenidos en el map.. El método keySet() retorna una vista en forma de Set de las claves contenidas en el map. Por último, el método values() retorna una Collection (interfaz, por lo que se puede usar cualquier subinterfaz de Collection) con una vista de los valores contenidos en el map. Estas Collection views del map son un reflejo de él, por lo que si el map cambia, las Collection views serán modificadas y viceversa.

Por último, otros métodos que son de bastante utilidad son isEmpty() y size(). El método isEmpty() retorna un booleano, el cual tendrá valor verdadero en caso de que el map no contenga ningún elemento clave-valor y falso en caso de que sí. En el caso del método size, este retorna el número de elementos clave-valor contenidos en el map.

### LinkedHashMap:

Es una subclase derivada de HashMap, por lo que contiene los mismos métodos, la diferencia esta en que LinkedHashMap es una implementación de una tabla hash y una lista enlazada de la interfaz Map, con un orden de encuentro bien definido. Esta implementación difiere de HashMap en que mantiene una lista doblemente enlazada que recorre todos sus elementos. Esta lista enlazada define el orden de encuentro (el orden de iteración), que normalmente es el orden en el que las claves se insertaron en el mapa (orden de inserción). La entrada insertada más recientemente (la más antigua) se encuentra en primer lugar, y la entrada más joven está al final.

### TreeMap:

Es la representación de un arbol rojo-negro, el cual es un tipo de arbol de busqueda binaria que tiene como atributo extra para cada nodo el color. Es adecuado cuando se necesita un map ordenado y se necesitan realizar operaciones de búsqueda y navegación más avanzadas. 

Además de ser una subclase de AbstractMap al igual que HashMap, es una implementación de la subinterfaz de Map, NavigableMap, por lo que significa que sus elementos tienen un orden orden absoluto de acuerdo al “orden natural” de sus claves y además que tiene métodos que permiten navegar a través de él.

Esta implementación asegura un costo de tiempo log(n) para los métodos containsKey(), get(), put() y remove(). 

Tiene cuatro constructores. El primero crea una instancia vacía de TreeMap, usando el “orden natural de sus claves”. El segundo constructor permite crear una nueva instancia vacía ordenada acorde al comparador (Comparator) dado. El tercer y el cuarto constructor permite crear una nueva instancia de TreeMap a partir de la interfaz Map (con cualquier implementación directa de Map) y también a partir de la interfaz SortedMap, es decir, se puede crear una instancia con otra instancia de TreeMap o para programación concurrente, con una instancia de ConcurrentSkipListMap.

Los métodos que contiene son una combinación de los que hereda de AbstractMap y de la subinterfaz NavigableMap, es decir, contiene los métodos get(), put(), remove(), replace(), containsKey(), constainsValue(), isEmpty(), size() y los métodos Collection View que son entrySet(), keySet() y values(). La diferencia es que esta clase contiene también métodos propios de NavigableMap y SortedMap, lo que lo hace especialmente útil en situaciones en las que se requiere orden y acceso eficiente a los elementos.

Los métodos que provienen de la interfaz NavigableMap son  ceilingEntry() el cual es un método que devuelve una entrada mapeada cuya clave es la menor clave mayor o igual a la clave especificada como parámetro. Permite buscar elementos en el map que estén "justo después" de una clave dada. El método floorEntry() es similar al método anterior, pero devuelve la entrada mapeada cuya clave es la mayor clave menor o igual a la clave especificada. Esto permite buscar elementos en el map que estén "justo antes" de una clave dada.

El método higherEntry() devuelve una entrada mapeada cuya clave es la menor clave estrictamente mayor que la clave especificada. Resulta de utilidad para encontrar el elemento siguiente a la clave dada como argumento. Por otra parte, el método lowerEntry() es similar al método anterior, pero devuelve la entrada mapeada cuya clave es la mayor clave estrictamente menor que la clave especificada como parámetro. De manera similar al anterior, resulta de utilidad para encontrar el elemento anterior a una clave dada.

El último método proveniente de la interfaz NavigableMap es descendingMap() el cual devuelve una vista inversa del TreeMap, lo que significa que los elementos se presentan en orden descendente en lugar de orden ascendente.

Los métodos que provienen de la interfaz SortedMap son los siguientes. El método comparator() devuelve el comparador (Comparator) utilizado para ordenar las claves en el map. Esto es útil para saber cómo se están ordenando los elementos.

El método firstKey() devuelve la primera clave en el map, que es la clave más baja según el orden natural o el comparador especificado.Por otro lado, lastKey() devuelve la última clave en el map, que es la clave más alta según el orden natural o el comparador especificado.

Otros métodos son headMap() que devuelve una vista de submapa que contiene todas las claves menores que la clave pasada como argumento. Esto permite obtener un subconjunto del map basado en un rango de claves De manera similar tailMap() devuelve una vista de submapa que contiene todas las claves mayores o iguales a la clave pasada como argumento. Esto también permite obtener un subconjunto del map basado en un rango de claves.

# Referencias

I.  AbstractMap (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractMap.html 

I.  ArrayList (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html 

I.  Collection (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html 

I.  Collections Framework Overview. (s. f.). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html 

I.  HashMap (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre 30, 2023, de https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html  

I.  HashSet (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre 30, 2023, de https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashSet.html 

I.  LinkedHashMap (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre 30, 2023, de https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/LinkedHashMap.html 

I.  LinkedHashSet (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre 30, 2023, de https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedHashSet.html 

I.  LinkedList (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html 

I.  List (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, https://docs.oracle.com/javase/8/docs/api/java/util/List.html 

I.  Map (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html  

I.  Morris, J. (1998). Data Structures and Algorithms: Red-Black trees. Electrical Engineering and Computer Science. Recuperado 30 de septiembre de 2023, de https://www.eecs.umich.edu/courses/eecs380/ALG/red_black.html 

I.  Outline of the collections framework. (s. f.). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/technotes/guides/collections/reference.html 

I.  Stack (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html 

I.  The Set Interface (The JavaTM Tutorials > Collections > Interfaces). (n.d.). ORACLE. Recuperado en Septiembre 30, 2023, from https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html 

I.  TreeMap (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre 30, 2023, de https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeMap.html 

I.  TreeSet (Java SE 17 & JDK 17). (2023, Julio 10). Java API. Recuperado en Septiembre https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeMap.html30, 2023, de https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeSet.html 

I.  Vector (Java Platform SE 8 ). (2023, 14 junio). Java API. Recuperado 30 de septiembre de 2023, de https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

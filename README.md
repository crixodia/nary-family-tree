---
layout: post
title: "Árbol genealógico familiar en java: Una aplicación de árboles generales o n-arios"
date: 2021-04-09 15:14:00 -0500
categories: structures java tutorial gui
language: es
image: /assets/images/thumbnail-trees.png
---
Quizá ya habrás implementado un árbol binario en java, lo cual es fácil. Por otra parte, los áboles n-arios se caracterizan por la posibilidad de tener n hijos. A continuación crearemos una aplicación a este tipo de dato con árboles genealógicos.

- [Árboles n-arios o generales](#árboles-n-arios-o-generales)
- [Árbol genealógico](#árbol-genealógico)
- [Definiendo los objetos](#definiendo-los-objetos)
  - [Nodo](#nodo)
  - [Árbol](#árbol)
  - [Archivos: Guardar y cargar árboles](#archivos-guardar-y-cargar-árboles)
  - [Unicidad del objeto de prueba](#unicidad-del-objeto-de-prueba)
- [Interfaz gráfica de usuario](#interfaz-gráfica-de-usuario)
- [Descarga el proyecto](#descarga-el-proyecto)

## Árboles n-arios o generales

En pocas palabras, un árbol n-ario es una estrucutura de datos abstracta no lineal y jerárquica cuya definición se puede plantear recursivamente con una colección de nodos. Estos nodos tendrán una lista que referencian a su vez a otros nodos.

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/arbol-nario.png" style="display:block; margin-left: auto; margin-right:auto;" alt="Representación gráfica árbol nario">

## Árbol genealógico

Una de sus aplicaciones se basa en el árbol genealógico. Pues cumple con los requisitos de un árbol n-ario (jerarquía, relaciones padre - hijo).

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/family-tree.png" style="display:block; margin-left: auto; margin-right:auto;" alt="Ejemplo de árbol familiar">

## Definiendo los objetos

Dado que es un árbol genealógico, implementaremos un objeto genérico para esto. Y el árbol en sí como se especifica a continuación. Es necesario recalcar que los métodos implementados en la clase árbol pueden cambiar dependiendo de tus necesidades y del tipo de objeto que se use como valor en los nodos.

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/uml.png" style="display:block; margin-left: auto; margin-right:auto;" alt="Ejemplo de árbol familiar">

### Nodo

El nodo de nuestro árbol es sencillo de implementar. Tal y como lo especifica su estructura, usaremos un objeto padre, otro para la raíz y una lista de objetos hijos.

El método para añadir nodos está dado por:

```java
public Node add(Object o){
    Node newNode = new Node(o);
    this.children.add(newNode);
    return newNode;
}
```
Mira la clase [Node](https://github.com/crixodia/nary-family-tree/blob/master/ArbolGen/src/CapaNegocio/Node.java).

### Árbol

La dificultad de este proyecto radica en la implementación del árbol. Dado que los árboles se podrán almacenar en archivos hay que diseñar un parser que traduzca el árbol a texto y otro para el proceso inverso. Además, para visualizar el árbol en la GUI también es necesario implementar un parser que permita traducirlo a un objeto tipo `DefaultMutableTreeNode`.

Para esta labor me basé en el siguiente [pseudocódigo](https://stackoverflow.com/questions/21735468/parse-indented-text-tree-in-java). Para entenderlo debes tener nociones básicas de pilas. Puede revisar el código fuente del método `text2DTree(string)`.

```python
definir pila
pila.push(primera línea)
while existan objetos
    S1 = pila.peek()
    S2 = leer objeto
    if profundidad(S1) < profundidad(S2)
        S1.addChild(S2)
        pila.push(S2)
    else
        while profundidad(S1) >= profundidad(S2) Y pila.size() >= 2
            pila.pop()
            S1 = pila.peek()
    S1.addChild(S2)
    pila.push(S2)
return pila.get(0)
```
### Archivos: Guardar y cargar árboles

Luego, el proceso de leer los archivos se simplifica al guardar el padre de cada elemento. Solo hay que tratar el archivo según el formato especificado. Para este caso tenemos cada nodo en una línea diferente, su padre y el valor separados por `,` y los atributos del objeto por `:`

```
Aang:Katara:0:0
Aang:Katara,Tenzin:Pema:0:0
Tenzin:Pema,Meelo::0:0
Tenzin:Pema,Jinora::0:0
Tenzin:Pema,Ikki::0:0
Aang:Katara,Bumi::0:0
Aang:Katara,Kya::0:0
```
Cuando leemos línea por línea podemos obtener su padre y el valor del nodo para luego ejecutar `addNewNode(padre, valor)`. Trasladado a la línea dos del formato de ejemplo `addNewNode(Aang, Tenzin)`.

Para guardar los árboles también nos valemos del puntero al nodo padre. De esta forma solo hay que recorrer el árbol entero en pre-orden e ir concatenando el padre y el valor del nodo según el formato especificado.

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/tree-traversal.png" style="display:block; margin-left: auto; margin-right:auto;" width="500px" alt="Recorrido de árbol en pre-orden">

Los métodos de búsqueda, remoción, profundidad y modificación pueden ser consultados en la clase [Tree](https://github.com/crixodia/nary-family-tree/blob/master/ArbolGen/src/CapaNegocio/Tree.java).

### Unicidad del objeto de prueba

Surge la interrogante ¿Qué pasa si el hijo tiene el mismo identificador (nombre) que el padre? Para este ejemplo comprobamos la unicidad en función de su cónyuge. Es decir, cuando comparemos los objetos se verificará que los nombre de ambos objetos y los nombres de sus cónyuges sean iguales. Si es así, entonces ambos objetos son iguales. Para ello sobreescribimos el método `equals(o)`.

```java
@Override
public boolean equals(Object obj) {
    GenObj aux = (GenObj) obj;
    return nombre.equals(aux.nombre) && conyuge.equals(aux.conyuge);
}
```

## Interfaz gráfica de usuario

La interfaz gráfica nos permitirá crear, modificar, insertar, eliminar; guardar y abrir archivos, y visualizar los atributos de los valores en cada nodo.

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/gui.jpg" style="display:block; margin-left: auto; margin-right:auto;" alt="Recorrido de árbol en preorden">

Puedes [descargar](https://github.com/crixodia/nary-family-tree/tree/master/examples) ejemplos de árboles y abrirlos para probar la funcionalidad.

<img src="https://github.com/crixodia/nary-family-tree/raw/master/assets/open.jpg" style="display:block; margin-left: auto; margin-right:auto;" alt="Recorrido de árbol en preorden">

## Descarga el proyecto

Descarga el proyecto completo en [GitHub](http://github.com/crixodia/nary-family-tree). Para cualquier sugerencia o aclaración [@crixodia](https://twitter.com/crixodia)

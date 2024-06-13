package com.example.apuntescompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


//NOTA IMPORTANTE: Recordar hacer antes de cualquier cosa relacionada con los constraint layout, importarlos en el gradle.
@Composable
fun ConstraintExample1() { //Funcion que contendra el constraint layout
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {//Constraint Layout definido

        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs() //Se pueden definir varios componentes a la vez si son del mismo tipo

        Box(modifier = Modifier //Modificamos la primera caja
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {//"constrainsAs" sirve para indicarle a la caja que va a enlazarse con una variabe o componente creado antes
                top.linkTo(parent.top) //De aqui a abajo, son las uniones de tipo constraint de cada lado a algo que este en el layout
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })

        Box(modifier = Modifier //Modificamos la segunda caja
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom) //Aqui ya se usa conexion de constraint layout con otra caja, en vez que con el parent
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier //Modificamos la tercera caja
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier //Modificamos la cuarta caja
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })

        Box(modifier = Modifier //Modificamos la quinta caja
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })

    }
}

@Composable
fun ConstraintExampleGuie() { //Funcion para explicar como funcionan las guias
    ConstraintLayout(Modifier.fillMaxSize()) {//Creamos el constraint layout
        // val startGuide = createGuidelineFromTop(16.dp) //Una forma de definir una guia

        val boxRed = createRef() //Creamos una caja
        val topGuide = createGuidelineFromTop(0.1f) //Creamos una guia por la parte de arriba que ocupe siempre el 10% de cualquier dispositivo donde se ejecute la aplicacion
        val startGuide = createGuidelineFromStart(0.25f) //Creamos otra guia por la parte izquierda que ocupe el 25%

        Box(modifier = Modifier //Creamos y modificamos la caja
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide) //La conectamos a la guia
                start.linkTo(startGuide)
            })
    }
}


@Composable
fun ConstraintBarrier() { //Funcion para explicar como funcionan las barreras
    ConstraintLayout(Modifier.fillMaxSize()) { //Creamos el constraint layout
        val (boxRed, boxGreen, boxYellow) = createRefs() //Se crean 3 variables de cajas
        val barrier = createEndBarrier(boxRed, boxGreen) //Y a estos dos se les va a crear una barrera al lado derecho

        Box(modifier = Modifier //Creamos y modificamos una caja
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start, margin = 16.dp) //Se puede agregar margen aqui mismo donde se conecta la caja
            })

        Box(modifier = Modifier //Creamos y modificamos otra caja
            .size(225.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box( //Creamos y modificamos la ultima caja
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier) //El lado izquierdo de esta caja estara conectado a la barrera
                })
    } //Como tal, se podria decir que las barreras sirven para evitar que una caja se sobreponga en otra, aunque no se tenga clara del to-do su funcionalidad en casos reales
}

@Preview
@Composable
fun ConstraintChainsExample() { //Funcion para explicar las cadenas
    ConstraintLayout(Modifier.fillMaxSize()) {//Creacion del constraint layout
        val (boxRed, boxGreen, boxYellow) = createRefs() //Creacion de las variables de cajas

        Box(modifier = Modifier //Creacion y modificacion de la primera caja
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier //Creacion y modificacion de la segunda caja
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)
            })

        Box(modifier = Modifier //Creacion y modificacion de la tercera caja
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(boxRed, boxGreen, boxRed, chainStyle = ChainStyle.Spread)
        //Creacion de una cadena. Una cadena tiene como funcion, conectar varios componentes entre si como un grupo...
        //...En este caso, es una cadena horizontal por las posiciones de las cajas, se pone cuales seran los componentes...
        //...A conectar, y el tipo de conexion, ya sea que todas esten unidas y separadas, o unidas sin separacion.
    }
}
package com.example.apuntescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apuntescompose.ui.theme.ApuntesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApuntesComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyRow(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyColumn() {
    //Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
    //Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
    //Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
    //Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
    //}


    Column( //Una columna, es como la representacion del linear layout en orientacion vertical
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .weight(1f) //Aqui, el peso significa que ocupara una unidad junto con los demas valores de la columna
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .weight(2f) //2f significa que ahora seran 2 unidades o el doble de 1f, y las demas van a acortar su propio tamaño para poder acomodarse

        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )

        Text( //Asignar un valor en la columna
            "Ejemplo1",
            modifier = Modifier.background(Color.Cyan)
        )
    }
}

@Composable
fun MyRow(
    modifier: Modifier = Modifier
) { //Son la version horizontal del Linear Layout por asi decirlo
    //Row (Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) { //Tienen las mismas caracteristicas que una columna
    //Text(text = "Ejemplo1")
    //Text(text = "Ejemplo2")
    //Text(text = "Ejemplo3")
    //}

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()) //Tambien tienen scroll al lado horizontal
    ) {
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyBox(
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center) {//Caja, el equivalente a un frame layout
        Box(
            modifier = Modifier //Dentro, ponemos otra caja con las caracteristicas que se estan viendo
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll( //Para poder deslizar hacia abajo o arriba
                    rememberScrollState() //Que al reiniciar la app, no olvide que se puede deslizar
                ), contentAlignment = Alignment.BottomCenter
        ) {//Alinea el contenido de la caja de adentro
            Text("Holaa,ejemplo") //La cual, va a tener este texto
        }
    }
}

@Composable
fun MyComplexLayout() { //Funcion que va a utilizar los otros layouts juntos
    Column(Modifier.fillMaxSize()) {//Primero, una columna que ocupe toda la pantalla
        Box( //Dentro de la columna, ira una primera caja
            Modifier
                .fillMaxWidth() //Aqui le decimos que ocupe toda la anchura
                .weight(1f) //Le decimos que va a tener un peso de 1 ya que se va a dividir el peso con otros layouts
                .background(Color.Magenta), contentAlignment = Alignment.Center) {//Color de fondo magenta y centrar contenido ya que se va a poner un texto
            Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
        }

        MySpacer(size = 30) //Traemos la funcion del spacer y le decimos que tendra altura de 30dp

        Row( //Creamos el segundo layout el cual sera una fila
            Modifier
                .fillMaxWidth() //Maximo de anchura
                .weight(1f)) {//Peso de 1
            Box(modifier = Modifier //Y dentro de la fila, va a ir otra caja
                .weight(1f) //La cual tendra un peso ya que se hara otra caja despues
                .fillMaxHeight() //Que llene el maximo de altura
                .background(Color.Red), contentAlignment = Alignment.Center){//Color a la caja y centrar para poner texto
                Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
            }
            Box(modifier = Modifier //Segunda caja de la fila
                .weight(1f) //Peso de 1
                .fillMaxHeight() //Maximo de altura
                .background(Color.Blue), contentAlignment = Alignment.Center) {//Color de fondo y centrar contenido
                Text(text = "Hola, soy Nicolas Juez") //Texto de la segunda caja
            }
        }
        Box( //Segunda caja de los 3 layouts principales
            Modifier
                .fillMaxWidth() //Maximo de anchura
                .weight(1f) //Peso de 1
                .background(Color.Yellow), contentAlignment = Alignment.BottomCenter) {//Color de fondo y centrar contenido para texto
            Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
        }
    }
}

@Composable
fun MySpacer(size:Int){ //Para los spacer, los cuales son espacios pequeños dentro de la apk, se suele hacer una funcion aparte, en esta se establece altura editable
    Spacer(modifier = Modifier.height(size.dp)) //Modificador para poder editar la altura
}

@Preview( showSystemUi = true) //Mostrar preview completa para lo que se este viendo
@Composable
fun MyPreview() {
    MyComplexLayout()
}

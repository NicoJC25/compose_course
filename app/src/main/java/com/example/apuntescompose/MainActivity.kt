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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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

                    var myText by remember { mutableStateOf("") } //Para entender esta parte, esperar a la seccion 5

                    MyStateHoistingTextField(
                        name = myText, //Para entender esta parte, esperar a la seccion 5
                        {myText = it}, //Para entender esta parte, esperar a la seccion 5
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


//Seccion 2: Layouts en Jetpack Compose
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
                .background(Color.Magenta), contentAlignment = Alignment.Center
        ) {//Color de fondo magenta y centrar contenido ya que se va a poner un texto
            Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
        }

        MySpacer(size = 30) //Traemos la funcion del spacer y le decimos que tendra altura de 30dp

        Row( //Creamos el segundo layout el cual sera una fila
            Modifier
                .fillMaxWidth() //Maximo de anchura
                .weight(1f)
        ) {//Peso de 1
            Box(
                modifier = Modifier //Y dentro de la fila, va a ir otra caja
                    .weight(1f) //La cual tendra un peso ya que se hara otra caja despues
                    .fillMaxHeight() //Que llene el maximo de altura
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {//Color a la caja y centrar para poner texto
                Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
            }
            Box(
                modifier = Modifier //Segunda caja de la fila
                    .weight(1f) //Peso de 1
                    .fillMaxHeight() //Maximo de altura
                    .background(Color.Blue), contentAlignment = Alignment.Center
            ) {//Color de fondo y centrar contenido
                Text(text = "Hola, soy Nicolas Juez") //Texto de la segunda caja
            }
        }
        Box( //Segunda caja de los 3 layouts principales
            Modifier
                .fillMaxWidth() //Maximo de anchura
                .weight(1f) //Peso de 1
                .background(Color.Yellow), contentAlignment = Alignment.BottomCenter
        ) {//Color de fondo y centrar contenido para texto
            Text(text = "Hola, soy Nicolas Juez") //Texto de la caja
        }
    }
}

@Composable
fun MySpacer(size: Int) { //Para los spacer, los cuales son espacios pequeños dentro de la apk, se suele hacer una funcion aparte, en esta se establece altura editable
    Spacer(modifier = Modifier.height(size.dp)) //Modificador para poder editar la altura
}

//Seccion 3: Estados en Compose
@Composable
fun MyStateExample(modifier: Modifier = Modifier) { //Funcion que explica los estados, metodos que se pueden usar para almacenar en memoria cosas
    // var counter = remember { mutableStateOf(0) } //Primero, se crea un contador que sera un estado mutable, tendrá como caracteristica tambien la palabra remember, para que no olvide la cantidad de veces que ha sido pulsado
    // val counter = rememberSaveable { mutableStateOf(0) } //rememberSaveable va a permitir que, asi sea cambie de rotacion la pantalla, no se pierdan los datos del contador (ciclo de vida de android)
    var counter by rememberSaveable { mutableStateOf(0) } //Utilizamos by para usar el state property (getValue, setValue)
    Column( //Creamos y definimos una columna
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally //Tambien puede tener modificaciones horizontales, aunque no todas
    ) {
        // Button(onClick = { counter.value += 1 }) {//Creamos un boton que al clickear, aumente en 1 el valor del contador
        Button(onClick = { counter += 1 }) {//Retiramos el .value si se esta usando el state property (getValue, setValue)
            Text(text = "Pulsar") //El texto del boton
        }
        Text(text = "He sido pulsado ${counter} veces") //Texto que ira debajo del boton, al ser un estado, se tiene que llamar al valor del estado como tal
    }
}

//Seccion 4: Componentes Text y TextField
@Composable
fun MyText(
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo xd") //Forma basica de poner un texto
        Text(text = "Esto es un ejemplo xd", color = Color.Cyan) //Forma de asignar color a un texto
        Text(
            text = "Esto es un ejemplo xd",
            fontWeight = FontWeight.ExtraBold
        ) //Forma de asignar una decoracion de fuerza del texto, en este caso que tenga mucha negrilla
        Text(
            text = "Esto es un ejemplo xd",
            fontWeight = FontWeight.Light
        ) //Aqui, que sea algo mas delgado y claro el texto
        Text(
            text = "Esto es un ejemplo xd",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        ) //Se pueden hacer estilos propios, en este caso, un estilo propio de letra cursiva
        Text(
            text = "Esto es un ejemplo xd",
            textDecoration = TextDecoration.LineThrough
        ) //Este metodo es para asignar una decoracion como una linea a traves del texto
        Text(
            text = "Esto es un ejemplo xd",
            textDecoration = TextDecoration.Underline
        ) //Aqui es con una linea por debajo, como subrayado
        Text(
            text = "Esto es un ejemplo xd",
            textDecoration = TextDecoration.combine( //Se pueden combinar varios tipos de decoracion del texto
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                ) //Como en este caso, la linea de por medio y la linea de debajo
            )
        )

    }
}

@Composable
fun MyTextField() { //Funcion de explicacion del TextField, equivalente al EditText de xml
    var myText by remember { mutableStateOf("") } //Creamos un estado ya que es necesario, para pasarlo como valor del TextField. Recordar importar getValue y setValue si se va a usar el by
    TextField(
        value = myText,
        onValueChange = {
            myText = it
        }) //Creamos el TextField, pasamos por valor el estado y que cuando se cambie algo, que ahora el estado sea equivalente al texto que el usuario escribio en el TextField
}

@Composable
fun MyTextFieldAdvance( //Funcion para mostrar una version mas avanzada de los TextField
    modifier: Modifier = Modifier
) {
    var myText by remember { mutableStateOf("") } //State

    TextField(value = myText, onValueChange = {//Creamos el TextField y pasamos de valor el estado
        myText =
            if (it.contains("a")) { //Y que cuando se escriba algo, si se escribio alguna palabra que tenga la letra "a"
                it.replace(
                    "a",
                    ""
                ) //Que la letra a se reemplace con un espacio vacio o en resumidas cuentas, que se borre
            } else { //Si no
                it //Entonces que se pueda escribir normal esa otra letra
            }
    },
        label = { Text(text = "Introduzca su nombre ") }) //Label sirve como placeholder para indicar que se debe escribir en el textfield
}

@OptIn(ExperimentalMaterial3Api::class) //Import necesario en esta funcion, ya que el metodo "outlinedTextFieldColors esta deprecado y no deja usarse en modo normal"
@Composable
fun MyTextFieldOutlined( //Funcion para explicar este textfield. Lo que hace es que aparece una linea alrededor del textfield, linea que se puede cambiar de color al editar el texto
    modifier: Modifier = Modifier
) {
    var myText by remember { mutableStateOf("") } //State

    OutlinedTextField(
        value = myText,
        onValueChange = {
            myText = it
        }, //Definicion del outlinedtextfield, practicamente es lo mismo que el textfield normal
        modifier = Modifier.padding(24.dp), //Padding para que no este pegado arriba ni a la izquieda
        label = { Text(text = "Escribe lo que quieras") }, //Placeholder
        colors = TextFieldDefaults.outlinedTextFieldColors( //Se usa este metodo para cambiar los colores de las lineas cuando hay o no texto escrito y recordar que es deprecable el metodo
            focusedBorderColor = Color.Magenta, //Cambio cuando haya algo escrito
            unfocusedBorderColor = Color.Blue //Para cuando no haya nada escrito
        )
    )
}

//Seccion 5: State hoisting
@Composable
fun MyStateHoistingTextField( //Funcion para hacer state hoising, o, en resumidas cuentas, volver el state en un padre
    name: String, //El name o el state, se le pasa como parametro, el name estara ubicado en la clase padre
    onValuedChanged: (String) -> Unit, //Se le pasa la lambda tambien como parametro
    modifier: Modifier = Modifier
) {
    TextField(
        value = name, //Se pasa como value el name
        onValueChange = { //Cuando se escriba algo
            onValuedChanged(it) }) //Se pasa la funcion que se paso antes como parametro
}

@Preview(showSystemUi = true) //Mostrar preview completa para lo que se este viendo
@Composable
fun MyPreview() {
    MyTextFieldOutlined()
}

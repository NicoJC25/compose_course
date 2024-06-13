package com.example.apuntescompose

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
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
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                //var myText by remember { mutableStateOf("") } //Para entender esta parte, esperar a la seccion 5

                MyTriStatusCheckedBox()
                val myOptions = getOptions(
                    listOf(
                        "Ejemplo 1",
                        "Nicolas Juez",
                        "Hola"
                    )
                ) //Se crea un objeto mandando solo los nombres de cada checkbox. Explicacion en la seccion 9

                myOptions.forEach {
                    MyCheckBoxAdvanced(it) //Por cada nombre en el objeto creado arriba, que haga tambien un checkbox con ese nombre. Explicacion en la seccion 9
                }

                //MyStateHoistingTextField(
                //name = myText, //Para entender esta parte, esperar a la seccion 5
                //{ myText = it }, //Para entender esta parte, esperar a la seccion 5
                // modifier = Modifier.padding(innerPadding)
                //)
                //}
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

//NOTA: Revisar el archivo de constraintLayout antes de seguir con esta seccion
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
            onValuedChanged(it)
        }) //Se pasa la funcion que se paso antes como parametro
}

//Seccion 6: Componente Button
@Composable
fun MyButtonExample(modifier: Modifier = Modifier) { //Funcion para mostrar un boton de prueba
    var enabled by rememberSaveable { mutableStateOf(true) } //State booleano que tendra funcion mas adelante
    Column( //Columna
        Modifier //Adaptando la columna
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button( //Declaracion del boton
            // onClick = { Log.i("Nicolas Juez", "Esto es un ejemplo") }, //La funcion "onClick" es para indicar que haga algo al clickear, en este caso, que ejecute ese texto en el LogCat
            onClick = {
                enabled = false
            }, //Cuando se de click al boton, que el state de antes pase a ser falso
            enabled = enabled, //enabled es un metodo de los botones que sirve para deshabilitarlo, aqui le estamos diciendo que su valor sera igual al del state que creamos antes y recordar que es un booleano
            colors = ButtonDefaults.buttonColors( //Se puede usar esta linea de codigo para establecer colores en diferentes partes del boton
                contentColor = Color.Blue, //ContentColor es para establecer el color de lo que haya dentro del boton, en este caso, el texto
                containerColor = Color.Magenta //ContainerColor es para cambiar el color del fondo del boton como tal
            ),
            border = BorderStroke(
                5.dp,
                Color.Cyan
            ) //BorderStroke asigna una borde al boton tambien customizable, en este caso se establece que tan grande sera el borde y el color del mismo
        ) {
            Text(text = "Hola") //Texto que va dentro del boton
        }

        OutlinedButton( //Boton que tiene una caracteristica parecida al OutilinedTextField, que tiene un borde propio
            onClick = { enabled = false }, //Mismas caracteristicas que el boton anterior
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.Magenta,
                disabledContainerColor = Color.Red, //Se puede asignar un color al contenedor cuando este desactivado
                disabledContentColor = Color.Blue //Al igual que al contenido
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {//TextButton lo unico que tiene es que por defecto viene sin fondo y sin bordes
            Text(text = "Boton de texto")
        }
    }
}

//Seccion 7: Componente Image
@Composable
fun MyImage(modifier: Modifier = Modifier) { //Funcion de ejemplo para la explicacion de las imagenes
    Image( //Creamos la imagen
        painter = painterResource(id = R.drawable.ic_launcher_background), //Se le pasa el id de donde esta la imagen
        contentDescription = "Imagen fondo defecto", //Descripcion de la imagen
        alpha = 0.5f //Alpha es un metodo para asignar una cantidad de opacidad, por ejemplo, aqui se le asigna un 50% de opacidad
    )
}

@Composable
fun MyImageAdvance(modifier: Modifier = Modifier) { //Funcion para explicar mas a fondo cosas que se pueden hacer con las imagenes
    Image( //Creamos la imagen
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Imagen fondo defecto",
        modifier = Modifier //Se pueden aplicar modificadores
            .clip(CircleShape) //Clip sirve para asignarles diferentes formas a toda la imagen o a una parte de la imagen
            //.clip(RoundedCornerShape(25.dp)) //Otra forma que viene por defecto en clip
            .border(
                5.dp,
                Color.Red,
                CircleShape
            ) //Border sirve para asignar un borde a la imagen, con el color que uno quiera y si es necesario, se asigna una forma usada para que se acomode a la forma
    )
}

//NOTA: Recordar que si se quiere usar un catalago mas amplio de iconos, hacer la implementacion en el gradle
@Composable
fun MyIconExample(modifier: Modifier = Modifier) { //Funcion de muestra de los iconos
    Icon( //Creacion del icono
        imageVector = Icons.Rounded.Star, //Ruta donde se encuentra el vector. Revisar la ruta y de guia la pagina de Material Design de iconos de Google para saber los nombres de los iconos que uno quiera
        contentDescription = "Icono de estrella", //Descripcion del icono
        tint = Color.Red //Tint sirve para colorear el icono de otro colo
    )
}

//Seccion 8: Componente ProgressBar
@Composable
fun MyProgress(modifier: Modifier = Modifier) { //Funcion de ejemplo para mostrar las barras de progreso
    var showLoading by rememberSaveable { mutableStateOf(false) } //State que tendra uso mas adelante
    Column( //Columna
        Modifier //Modificadores de la columna
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center, //Centrado verticalmente
        horizontalAlignment = Alignment.CenterHorizontally //Centrado horizontalmente
    ) {
        if (showLoading) { //Si el state es true
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            ) //Esta barra de progreso es de forma circular. Se puede editar su color y grosor
            LinearProgressIndicator( //Esta es la barra de progreso comun
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                contentColorFor( //Se puede editar varias caracteristicas, adicional, esta la funcion ContentColorFor
                    backgroundColor = Color.Green //Esta funcion permite cambiar el color de fondo de la barra
                )
            )
        }

        Button(onClick = {
            showLoading = !showLoading
        }) {//Boton que al clickear, cambia el state a true o false
            Text(text = "Cargar Pelicula") //Texto del boton
        }
    }
}

@Composable
fun MyProgressAdvance(modifier: Modifier = Modifier) { //Funcion para mostrar funciones mas avanzadas de las progress
    var progressStatus by rememberSaveable { mutableStateOf(0f) } //State que tendra uso mas adelante
    Column( //Columna
        Modifier.fillMaxSize(), //Modificadores
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus) //Progress es una funcion para indicarle una cantidad fija o dinamica de progreso de la barra, en este caso, sera el state declarado arriba

        Row(Modifier.fillMaxWidth()) {//Creacion de una fila
            Button(onClick = { progressStatus += 0.1f }) {//Primer boton, que aumentara un 10% el progreso
                Text(text = "Incrementar") //Texto del boton
            }
            Button(onClick = { progressStatus -= 0.1f }) {//Segundo boton, que disminuira un 10% del progreso
                Text(text = "Disminuir") //Texto del boton
            }
        }
    }
}

//Seccion 9: Componentes de control de seleccion
@Composable
fun MySwitch(modifier: Modifier = Modifier) { //Funcion de muestra de los botonoes tipo switch
    var SwitchState by rememberSaveable { mutableStateOf(true) } //State de switch que tendra uso mas adelante

    Switch( //Creacion del switch
        checked = SwitchState, //Checked es para verificar si se mueve el botoncito a la derecha o izquierda, se manda un booleano
        onCheckedChange = {
            SwitchState = !SwitchState
        }, //OnCheckedChange es para que ejecute una accion al activar o desactivar
        enabled = true, //Enabled para habilitar o deshabilitar el boton
        colors = SwitchDefaults.colors( //Esta linea sirve para acceder a la configuracion de todos los posibles cambios de los colores del switch
            uncheckedThumbColor = Color.Red, //Color para la bolita cuando este a la izquierda
            uncheckedTrackColor = Color.Magenta, //Color para el fondo cuando la bolita este a la izquierda
            checkedThumbColor = Color.Green, //Color para la bolita cuando este a la derecha
            checkedTrackColor = Color.Cyan, //Color para el fondo cuando la bolita este a la derecha
            disabledCheckedThumbColor = Color.Yellow, //Color para la bolita cuando este a la izquieda y aparte si el boton esta deshabilitado
            disabledCheckedTrackColor = Color.Yellow, //Color para el fondo cuando la bolita este a la izquierda y aparte si el boton esta deshabilitado
            disabledUncheckedThumbColor = Color.Yellow, //Color para la bolita cuando este a la derecha y aparte si el boton esta deshabilitado
            disabledUncheckedTrackColor = Color.Yellow //Color para el fondo cuando la bolita este a la derecha y aparte si el boton esta deshabilitado
        )
    )
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) { //Funcion de ejemplo para las checkboxs
    var CheckBoxState by rememberSaveable { mutableStateOf(true) } //State que sera usado mas adelante

    Checkbox( //Definicion de la checkbox
        checked = CheckBoxState, //Checked para indicar si esta marcada o no, se pasa solo booleano
        onCheckedChange = {
            CheckBoxState = !CheckBoxState
        }, //Al clickear, que cambie el estado del checked
        enabled = true, //Enabled para activar o desactivar la box
        colors = CheckboxDefaults.colors( //De esta forma accedemos a todas las posibles ediciones de color de la checkbox
            checkedColor = Color.Red, //Color para el fondo cuando este marcada
            uncheckedColor = Color.Green, //Color para el fondo cuando no este marcada
            checkmarkColor = Color.Black //Color para el chulo
        )
    )
}

@Composable
fun MyCheckBoxWithText(modifier: Modifier = Modifier) { //Funcion de ejemplo para mostrar como asignar texto a las checkbox
    var CheckBoxState by rememberSaveable { mutableStateOf(false) } //State que sera usado mas adelante

    Row(Modifier.padding(8.dp)) {//Row
        Checkbox(
            checked = CheckBoxState,
            onCheckedChange = {
                CheckBoxState = !CheckBoxState
            }) //Indicacion de que ejecutar al dar click a la checkbox
        Spacer(modifier = Modifier.width(8.dp)) //Spacer para dividir la checkbox del texto
        Text(
            text = "Esto es un ejemplo",
            Modifier.padding(top = 16.dp)
        ) //Texto asignado a la checkbox
    }
}

//NOTA: Para la siguiente funcion, revisar el archivo "CheckInfo"
@Composable
fun MyCheckBoxAdvanced(
    checkInfo: CheckInfo,
    modifier: Modifier = Modifier
) { //Funcion para mostrar union entre checkbox de forma avanzada. Se pasa un objeto tipo CheckInfo como parametro
    Row(Modifier.padding(8.dp)) {//Row
        Checkbox(checked = checkInfo.selected, //Se utiliza como parametro del checked, el state dado en la variable "selected"
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }) //Se asigna que se active y desactive la casilla cuando se oprima de acuerdo al valor de la variable "onCheckedChange" del objeto CheckList
        Spacer(modifier = Modifier.width(8.dp)) //Spacer para dividir la checkbox del texto
        Text(
            text = checkInfo.title,
            Modifier.padding(top = 16.dp)
        ) //Texto asignado a la checkbox de acuerdo al texto en la variable "title" del objeto CheckInfo
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> { //Funcion que va a retornar de forma automatica los objetos tipo CheckedInfo
    return titles.map {//Se va a retornar un mapeado de los titulos
        var CheckedStatus by rememberSaveable { mutableStateOf(false) } //State del objeto establecido automaticamente
        CheckInfo( //Objeto CheckInfo
            title = it, //El titulo sera uno pasado en la lista que se ingresó como parametro de la funcion
            selected = CheckedStatus, //El estado sera el que se indico arriba con el state
            onCheckedChange = { myNewStatus ->
                CheckedStatus = myNewStatus
            } //Y el cambio se hará manualmente en la función donde se traiga el objeto
        )
    }
}

@Composable
fun MyTriStatusCheckedBox() { //Funcion de ejemplo para mostrar como funciona una checkbox con 3 estados
    var checkedStatus by rememberSaveable { mutableStateOf(ToggleableState.Off) } //State que se usara despues

    TriStateCheckbox(state = checkedStatus, onClick = { //Definicion de la checkbox con 3 estador
        checkedStatus = when (checkedStatus) { //Cuando se de click, el estado pasara a cambiar de acuerdo a lo que asignemos en el ciclo when
            ToggleableState.On -> { //Si el estado es "On", que pase a ser off
                ToggleableState.Off
                //Aqui puede ir mas logica de codigo si llega a ser necesaria
            }
            ToggleableState.Off -> ToggleableState.Indeterminate //Si el estado es off, que pase a ser indeterminado
            ToggleableState.Indeterminate -> ToggleableState.On //Si el estado es indeterminado, que pase a ser On
        }
    })
}

@Composable
fun MyRadioButton(){
    Row {

    }
}

@Preview(showSystemUi = true) //Mostrar preview completa para lo que se este viendo
@Composable
fun MyPreview() {
    MyTriStatusCheckedBox()
}

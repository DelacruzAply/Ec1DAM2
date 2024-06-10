package pe.edu.idat.ec1dam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun Dni() {
    var birthYear by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Verificar si debe sacar DNI", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = birthYear,
            onValueChange = { birthYear = it },
            label = { Text("Año de Nacimiento") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val year = birthYear.text.toIntOrNull()
            if (year != null) {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                val age = currentYear - year
                message = if (age >= 18) {
                    "Debe sacar su DNI"
                } else {
                    "No debe sacar su DNI"
                }
            } else {
                message = "Por favor ingrese un año válido"
            }
        }) {
            Text("Verificar")
        }
        //Al hacer clic en el botón "Verificar", se toma el año de nacimiento
        // ingresado y se calcula la edad de la persona. Si la persona tiene 18 años
        // o más, se muestra el mensaje "Debe sacar su DNI", de lo contrario, se muestra
        // "No debe sacar su DNI"


        Spacer(modifier = Modifier.height(16.dp))


        Text(message)
    }
}
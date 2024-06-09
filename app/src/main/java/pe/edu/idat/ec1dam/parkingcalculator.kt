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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec1dam.ui.theme.Ec1DAMTheme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ec1DAMTheme {
    }
}

@Composable
fun ParkingCalculatorScreen() {
    var hours by remember { mutableStateOf(TextFieldValue("")) }
    var minutes by remember { mutableStateOf(TextFieldValue("")) }
    var cost by remember { mutableStateOf(0.0) }

    val ratePerHour = 1500.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Calculadora de Estacionamiento", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = hours,
            onValueChange = { hours = it },
            label = { Text("Horas") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = minutes,
            onValueChange = { minutes = it },
            label = { Text("Minutos") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val hoursValue = hours.text.toDoubleOrNull() ?: 0.0
            val minutesValue = minutes.text.toDoubleOrNull() ?: 0.0
            val totalHours = hoursValue + (minutesValue / 60)
            cost = Math.ceil(totalHours) * ratePerHour
        }) {
            Text("Calcular Costo")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text("Costo: S/.${String.format("%.2f", cost)}")
    }
}
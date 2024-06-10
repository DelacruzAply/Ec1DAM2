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
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.idat.ec1dam.ui.theme.Ec1DAMTheme


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ec1DAMTheme {
    }
}
@Composable
fun PromedioScreen() {
    var grade1 by remember { mutableStateOf(TextFieldValue("")) }
    var grade2 by remember { mutableStateOf(TextFieldValue("")) }
    var grade3 by remember { mutableStateOf(TextFieldValue("")) }
    var grade4 by remember { mutableStateOf(TextFieldValue("")) }
    var average by remember { mutableStateOf(0.0) }
    var removedGrade by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Calculadora de Promedio de Notas", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Nota 1") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Nota 2") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Nota 3") }
        )


        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = grade4,
            onValueChange = { grade4 = it },
            label = { Text("Nota 4") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val grades = listOf(
                grade1.text.toDoubleOrNull() ?: 0.0,
                grade2.text.toDoubleOrNull() ?: 0.0,
                grade3.text.toDoubleOrNull() ?: 0.0,
                grade4.text.toDoubleOrNull() ?: 0.0
            ).sorted()

            removedGrade = grades.first() // La nota más baja

            val filteredGrades = grades.drop(1) // Eliminar la nota más baja

            if (filteredGrades.size == 3) {
                average = (filteredGrades[0] * 0.2) + (filteredGrades[1] * 0.3) + (filteredGrades[2] * 0.5)
            }
        }) {
            Text("Calcular Promedio")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Nota eliminada: ${String.format("%.2f", removedGrade)}")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Promedio: ${String.format("%.2f", average)}")
    }
}
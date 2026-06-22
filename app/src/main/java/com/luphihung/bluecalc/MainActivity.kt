package com.luphihung.bluecalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.luphihung.bluecalc.ui.theme.BlueCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlueCalcTheme {
                BlueCalcApp()
            }
        }
    }
}

@Composable
private fun BlueCalcApp() {
    var firstInput by remember { mutableStateOf("") }
    var secondInput by remember { mutableStateOf("") }
    var firstError by remember { mutableStateOf<String?>(null) }
    var secondError by remember { mutableStateOf<String?>(null) }
    var selectedOperation by remember { mutableStateOf<CalculatorOperation?>(null) }
    var expression by remember { mutableStateOf<String?>(null) }
    var resultText by remember { mutableStateOf<String?>(null) }

    val emptyFirstMessage = stringResource(R.string.error_empty_first)
    val emptySecondMessage = stringResource(R.string.error_empty_second)
    val invalidNumberMessage = stringResource(R.string.error_invalid_number)
    val divideByZeroMessage = stringResource(R.string.error_divide_by_zero)
    val resultExpressionFormat = stringResource(R.string.result_expression)
    val spacingLarge = dimensionResource(R.dimen.spacing_large)
    val spacingMedium = dimensionResource(R.dimen.spacing_medium)
    val backgroundColor = colorResource(R.color.bluecalc_background)

    fun clearCalculator() {
        firstInput = ""
        secondInput = ""
        firstError = null
        secondError = null
        selectedOperation = null
        expression = null
        resultText = null
    }

    fun handleOperationClick(operation: CalculatorOperation) {
        firstError = null
        secondError = null
        selectedOperation = null
        expression = null
        resultText = null

        val firstValue = parseOperandInput(
            value = firstInput,
            emptyMessage = emptyFirstMessage,
            invalidMessage = invalidNumberMessage
        ) { firstError = it }
        val secondValue = parseOperandInput(
            value = secondInput,
            emptyMessage = emptySecondMessage,
            invalidMessage = invalidNumberMessage
        ) { secondError = it }

        if (firstValue == null || secondValue == null) return
        if (operation == CalculatorOperation.Divide && secondValue == 0.0) {
            secondError = divideByZeroMessage
            return
        }

        val result = CalculatorEngine.calculate(firstValue, secondValue, operation)
        selectedOperation = operation
        resultText = CalculatorEngine.formatNumber(result)
        expression = String.format(
            resultExpressionFormat,
            CalculatorEngine.formatNumber(firstValue),
            operation.symbol,
            CalculatorEngine.formatNumber(secondValue),
            resultText.orEmpty()
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backgroundColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(spacingLarge),
            verticalArrangement = Arrangement.spacedBy(spacingLarge)
        ) {
            AppHeader()
            OperandInputCard(
                firstInput = firstInput,
                secondInput = secondInput,
                firstError = firstError,
                secondError = secondError,
                onFirstInputChanged = {
                    firstInput = it
                    firstError = null
                },
                onSecondInputChanged = {
                    secondInput = it
                    secondError = null
                }
            )
            OperationGrid(
                selectedOperation = selectedOperation,
                onOperationClick = ::handleOperationClick
            )
            CalculationResultCard(
                expression = expression,
                resultText = resultText
            )
            TextButton(
                onClick = ::clearCalculator,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .semantics { contentDescription = "Clear calculator inputs and result" },
                contentPadding = PaddingValues(horizontal = spacingLarge, vertical = spacingMedium)
            ) {
                Text(
                    text = stringResource(R.string.clear),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun AppHeader() {
    val spacingMedium = dimensionResource(R.dimen.spacing_medium)
    val iconSize = dimensionResource(R.dimen.icon_large)
    val iconBackground = colorResource(R.color.bluecalc_primary_container)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(iconSize)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.corner_medium)))
                .background(iconBackground),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_calculator),
                contentDescription = stringResource(R.string.calculator_icon_description),
                modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
            )
        }
        Spacer(modifier = Modifier.width(spacingMedium))
        Column {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(R.string.subtitle),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun OperandInputCard(
    firstInput: String,
    secondInput: String,
    firstError: String?,
    secondError: String?,
    onFirstInputChanged: (String) -> Unit,
    onSecondInputChanged: (String) -> Unit
) {
    SectionCard {
        Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_medium))) {
            NumberInput(
                value = firstInput,
                label = stringResource(R.string.first_number),
                error = firstError,
                onValueChanged = onFirstInputChanged
            )
            NumberInput(
                value = secondInput,
                label = stringResource(R.string.second_number),
                error = secondError,
                onValueChanged = onSecondInputChanged
            )
        }
    }
}

@Composable
private fun NumberInput(
    value: String,
    label: String,
    error: String?,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = error)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}

@Composable
private fun OperationGrid(
    selectedOperation: CalculatorOperation?,
    onOperationClick: (CalculatorOperation) -> Unit
) {
    val spacingMedium = dimensionResource(R.dimen.spacing_medium)

    Column(verticalArrangement = Arrangement.spacedBy(spacingMedium)) {
        Text(
            text = stringResource(R.string.operation_section_title),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Row(horizontalArrangement = Arrangement.spacedBy(spacingMedium)) {
            OperationButton(
                operation = CalculatorOperation.Add,
                selected = selectedOperation == CalculatorOperation.Add,
                modifier = Modifier.weight(1f),
                onClick = onOperationClick
            )
            OperationButton(
                operation = CalculatorOperation.Subtract,
                selected = selectedOperation == CalculatorOperation.Subtract,
                modifier = Modifier.weight(1f),
                onClick = onOperationClick
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(spacingMedium)) {
            OperationButton(
                operation = CalculatorOperation.Multiply,
                selected = selectedOperation == CalculatorOperation.Multiply,
                modifier = Modifier.weight(1f),
                onClick = onOperationClick
            )
            OperationButton(
                operation = CalculatorOperation.Divide,
                selected = selectedOperation == CalculatorOperation.Divide,
                modifier = Modifier.weight(1f),
                onClick = onOperationClick
            )
        }
    }
}

@Composable
private fun OperationButton(
    operation: CalculatorOperation,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: (CalculatorOperation) -> Unit
) {
    val label = stringResource(operation.labelRes)
    val selectedDescription = if (selected) stringResource(R.string.selected_operation_description, label) else label
    val colors = if (selected) {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    } else {
        ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        )
    }

    ElevatedButton(
        onClick = { onClick(operation) },
        modifier = modifier
            .height(dimensionResource(R.dimen.operation_button_height))
            .semantics { contentDescription = selectedDescription },
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_medium)),
        colors = colors,
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = dimensionResource(R.dimen.elevation_low)
        )
    ) {
        Text(
            text = label,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun CalculationResultCard(
    expression: String?,
    resultText: String?
) {
    SectionCard(containerColor = colorResource(R.color.bluecalc_result_background)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_small))
        ) {
            Text(
                text = expression ?: stringResource(R.string.result_placeholder),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = resultText ?: stringResource(R.string.result_default_symbol),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun SectionCard(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_large)),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.elevation_medium))
    ) {
        Box(modifier = Modifier.padding(dimensionResource(R.dimen.spacing_large))) {
            content()
        }
    }
}

private fun parseOperandInput(
    value: String,
    emptyMessage: String,
    invalidMessage: String,
    setError: (String?) -> Unit
): Double? {
    val trimmedValue = value.trim()
    if (trimmedValue.isEmpty()) {
        setError(emptyMessage)
        return null
    }

    return trimmedValue.toDoubleOrNull() ?: run {
        setError(invalidMessage)
        null
    }
}

@Preview(showBackground = true)
@Composable
private fun BlueCalcPreview() {
    BlueCalcTheme {
        BlueCalcApp()
    }
}

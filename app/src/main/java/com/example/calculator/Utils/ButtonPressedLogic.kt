
// Function to evaluate the expression (you write this function manually)
fun evaluateExpression(expression: String): String {
    return try {
        // Replace any invalid characters or handle syntax before evaluating
        val result = calculateExpression(expression)
        formatResult(result)
    } catch (e: Exception) {
        "Error"
    }
}

// A simple manual evaluator that handles basic arithmetic
fun calculateExpression(expression: String): Double {
    var expr = expression.replace("\\s".toRegex(), "")

    val squareRegex = Regex("([0-9]+(?:\\.[0-9]+)?)\\^2")
    while (squareRegex.containsMatchIn(expr)) {
        val match = squareRegex.find(expr)!!
        val base = match.groupValues[1].toDouble()
        val squared = base * base
        expr = expr.replaceFirst(match.value, squared.toString())
    }

    var result = expr.toDoubleOrNull()
    if (result == null) {
        val operatorRegex = Regex("([0-9]+(?:\\.[0-9]+)?)([\\+\\-\\*/])([0-9]+(?:\\.[0-9]+)?)")
        while (operatorRegex.containsMatchIn(expr)) {
            val match = operatorRegex.find(expr)!!
            val operand1 = match.groupValues[1].toDouble()
            val operator = match.groupValues[2]
            val operand2 = match.groupValues[3].toDouble()

            val intermediateResult = when (operator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> operand1 / operand2
                else -> 0.0
            }

            expr = expr.replaceFirst(match.value, intermediateResult.toString())
        }

        result = expr.toDoubleOrNull()
    }

    return result ?: 0.0
}


// Format result to remove decimals if it's a whole number
fun formatResult(result: Double): String {
    return if (result % 1 == 0.0) {
        result.toInt().toString() // Remove decimal if it's a whole number
    } else {
        result.toString() // Show decimal if it's a float
    }
}

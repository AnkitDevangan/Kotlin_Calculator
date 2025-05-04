Calculator App in Kotlin and Jetpack Compose
Project Description:
The Calculator App is a simple, yet efficient, calculator built using Kotlin and Jetpack Compose. This app allows users to perform basic arithmetic calculations such as addition, subtraction, multiplication, and division. The user interface is modern and interactive, designed using Jetpack Compose, which allows for declarative UI design and better performance.

The app provides both light and dark themes, which can be toggled based on the user's preference. It features a dynamic color scheme, supporting modern Android features like edge-to-edge display and responsive layouts, making it suitable for different screen sizes and resolutions.

Key Features:
Basic Arithmetic Operations:

Addition, subtraction, multiplication, division.

Real-time calculation of expressions like 5 + 2 or 7 * 3.

Input Handling:

Users can enter numbers and operators through the on-screen keypad.

Includes a "Clear" button to reset the input, and a "Backspace" button to remove the last character entered.

Switch Between Light and Dark Mode:

A simple toggle switch allows the user to switch between Light and Dark modes, adjusting the app’s color scheme dynamically.

Dark mode ensures comfortable viewing in low-light environments.

Responsive Layout:

The layout adapts to different screen sizes, providing an optimal experience across a variety of devices.

The use of Jetpack Compose enables a flexible and scalable UI design.

Error Handling:

If an invalid expression is entered (such as division by zero or incorrect syntax), the app displays an error message (Error) instead of crashing.

Edge-to-Edge Display:

The app supports edge-to-edge layout, providing a clean, modern user experience with minimal UI distractions.

Technologies Used:
Kotlin: The app is written entirely in Kotlin, a modern programming language for Android development.

Jetpack Compose: The UI is built using Jetpack Compose, which is a modern, fully declarative UI toolkit for building Android apps. It simplifies UI development and leads to more maintainable code.

Material3: The app uses Material3 components like Text, Switch, and Button to maintain consistency and follow Google's design principles.

State Management: The app utilizes Jetpack Compose's remember and mutableStateOf for handling UI state changes, like the calculation result and input values.

Dark Mode: The app supports dynamic dark and light themes, which automatically adjust based on system settings or user preferences.

Basic Logic:
Input Parsing:
The input expression is parsed as a string, and basic mathematical operations are evaluated using Kotlin’s built-in operators and functions.

Expression Evaluation:
The app parses the entered expression (like 5 + 3 * 2) and evaluates it using simple logic and algorithms for operator precedence (multiplication and division are evaluated before addition and subtraction).

Error Handling:
The logic includes basic error handling to catch cases like empty input, invalid syntax, or attempts to divide by zero.

Flow of the App:
User enters numbers and operators using the on-screen buttons.

History and Input Display:

The app displays the current input and, if applicable, the calculation history.

Calculate:

When the user presses =, the entered expression is evaluated and the result is displayed.

Clear or Backspace:

Users can clear the entire input or backtrack one character at a time using dedicated buttons.

Switch Theme:

Users can toggle between Light and Dark Mode using the provided switch.

Error Handling:

If an error occurs (e.g., division by zero), the app displays an error message in place of the result.

This project is a great example of using Kotlin and Jetpack Compose to build a simple yet functional mobile app. It demonstrates the fundamentals of app development including UI design, state management, and working with basic algorithms, all while keeping the app modular and easily extendable.

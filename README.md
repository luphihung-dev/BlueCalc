# BlueCalc - COMP1786 Exercise 1

## Overview

BlueCalc is a simple Android calculator application built for COMP1786 Mobile Application Design and Development, Exercise 1. It performs calculations between two numbers at a time and supports the four required operations: Add, Subtract, Multiply and Divide.

## Coursework Requirements Covered

- [x] Graphical user interface
- [x] Two operands only
- [x] Add operation
- [x] Subtract operation
- [x] Multiply operation
- [x] Divide operation
- [x] Input validation
- [x] Division by zero handling
- [x] Android resources/theme/style usage

## Features

- First number input
- Second number input
- Add, Subtract, Multiply and Divide buttons
- Clear/reset button
- Result display
- Visible validation messages
- Themed UI using Android resources and a Compose Material theme

## Validation

BlueCalc validates user input before performing a calculation:

- Empty first number
- Empty second number
- Invalid number format
- Division by zero

Validation prevents crashes and prevents incorrect results from being displayed.

## Technologies Used

- Android Studio
- Kotlin
- Jetpack Compose
- Android resources
- Gradle
- JUnit

## Project Structure

- `MainActivity.kt`: defines the Compose calculator screen, input fields, operation buttons, validation display, result display and clear/reset behaviour.
- `CalculatorEngine.kt`: contains the calculator operation enum, calculation logic and result formatting.
- `Theme.kt`: defines the Compose Material colour scheme using Android colour resources.
- `Type.kt`: defines Compose typography used by the app theme.
- `strings.xml`: stores app text, labels, result messages and validation messages.
- `colors.xml`: stores app colours used by the theme and interface.
- `dimens.xml`: stores spacing, sizing, corner radius and elevation values.
- `themes.xml`: defines the Android application theme.
- `ic_calculator.xml`: provides the calculator icon used in the UI.
- `CalculatorEngineTest.kt`: contains local JUnit tests for calculator logic, formatting, decimal values, negative values and division by zero.
- `BlueCalcInstrumentedTest.kt`: contains the Android instrumented test class.

## Build and Test

For macOS/Linux:

```bash
./gradlew assembleDebug
./gradlew testDebugUnitTest
```

For Windows PowerShell:

```powershell
.\gradlew.bat assembleDebug
.\gradlew.bat testDebugUnitTest
```

If `JAVA_HOME` is not configured, use the JDK bundled with Android Studio or configure `JAVA_HOME` before running Gradle from the terminal.

## How to Run

1. Open the project in Android Studio.
2. Wait for Gradle sync to complete.
3. Select an Android emulator or physical Android device.
4. Run the `app` module.
5. Enter two numbers and choose an operation.

## Manual Testing Checklist

- [ ] Add calculation: `8` + `4` should display `12`.
- [ ] Subtract calculation: `8` - `4` should display `4`.
- [ ] Multiply calculation: `8` x `4` should display `32`.
- [ ] Divide calculation: `8` / `4` should display `2`.
- [ ] Decimal calculation: `2.5` + `1.25` should display `3.75`.
- [ ] Negative number calculation: `-4` x `2` should display `-8`.
- [ ] Empty first number validation: leave the first field empty and choose an operation; the app should show a first-number error.
- [ ] Empty second number validation: leave the second field empty and choose an operation; the app should show a second-number error.
- [ ] Invalid number validation: enter invalid text such as `abc`; the app should show a valid-number error.
- [ ] Division by zero validation: enter `10` / `0`; the app should show a divide-by-zero error.
- [ ] Clear/reset button: after entering values or seeing a result, tap Clear; inputs, errors, selected operation and result should reset.

## Logbook Evidence

Screenshots and relevant code snippets should be included in the COMP1786 Logbook PDF as supporting evidence.

Suggested screenshots:

- Initial screen
- Successful Add calculation
- Successful Subtract calculation
- Successful Multiply calculation
- Successful Divide calculation
- Empty input validation
- Invalid input validation
- Division by zero validation
- Clear/reset state

Suggested code snippets:

- Input validation
- Operation button handling
- Calculation logic
- Result formatting
- Resource/theme usage

## Academic Note

This repository is intended to support a COMP1786 coursework submission. The final assessed submission should follow the official coursework instructions, including the required Logbook PDF and any app or supporting evidence files requested by the module.

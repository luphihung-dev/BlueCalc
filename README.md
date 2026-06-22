# CleanCalc - COMP1786 Exercise 1

## Overview

CleanCalc is a simple Android calculator application built for COMP1786 Mobile Application Design and Development, Exercise 1. The app calculates between two numbers at a time and supports Add, Subtract, Multiply and Divide operations.

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
- Four operation buttons: Add, Subtract, Multiply and Divide
- Clear/reset button
- Result display
- Visible validation messages for invalid input
- Themed UI using Android resources and a Compose Material theme

## Validation

The app checks for:

- Empty first number
- Empty second number
- Invalid number format
- Division by zero

Invalid input is handled safely with visible error messages, so the app does not crash or display an incorrect result.

## Technologies Used

- Android Studio
- Kotlin
- Jetpack Compose
- Android resources
- Gradle
- JUnit

## Project Structure

- `MainActivity.kt`: contains the main Compose calculator screen, input handling, operation button handling, result display and clear/reset behaviour.
- `CalculatorEngine.kt`: contains the calculator operations, calculation logic and result number formatting.
- `Theme.kt`: defines the Compose Material colour scheme using Android colour resources.
- `Type.kt`: defines Compose typography used by the app theme.
- `app/src/main/res/values/strings.xml`: stores user-facing text, labels and validation messages.
- `app/src/main/res/values/colors.xml`: stores app colours used by the theme and UI.
- `app/src/main/res/values/dimens.xml`: stores spacing, sizing, corner radius and elevation values.
- `app/src/main/res/values/themes.xml`: defines the Android application theme.
- `app/src/main/res/drawable/ic_calculator.xml`: provides the calculator icon used in the UI.
- `app/src/main/res/drawable/` and `app/src/main/res/mipmap-*`: contain drawable and launcher icon resources.
- `CalculatorEngineTest.kt`: contains JUnit tests for calculator operations, number formatting, decimal calculations, negative numbers and division by zero.
- `BlueCalcInstrumentedTest.kt`: contains the Android instrumented test class.

## How to Run

1. Open the project in Android Studio.
2. Wait for Gradle sync to complete.
3. Select an Android emulator or physical Android device.
4. Run the `app` module.
5. Enter two numbers and choose an operation.

## Manual Testing Checklist

- [ ] Add calculation
- [ ] Subtract calculation
- [ ] Multiply calculation
- [ ] Divide calculation
- [ ] Decimal number calculation
- [ ] Negative number calculation
- [ ] Empty first number validation
- [ ] Empty second number validation
- [ ] Invalid number validation
- [ ] Division by zero validation
- [ ] Clear/reset button

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

This repository is intended as supporting evidence for COMP1786 coursework. The final assessed submission should follow the official coursework instructions, including the Logbook PDF and required app/supporting evidence files.

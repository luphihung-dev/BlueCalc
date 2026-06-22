# Exercise 1 Logbook Notes: BlueCalc

## 1. Summary

BlueCalc is a single-screen two-number calculator built for Exercise 1. It accepts a first number and second number, validates both inputs, and calculates Add, Subtract, Multiply, or Divide using only those two operands. The UI is implemented with Kotlin and Compose because this project was already a Compose-based Android app.

## 2. Coursework Requirements Checklist

- [x] Simple calculator application with a graphical user interface.
- [x] Calculates between two operands only.
- [x] Supports Add, Subtract, Multiply, and Divide.
- [x] Validates empty first number input.
- [x] Validates empty second number input.
- [x] Validates invalid number format.
- [x] Prevents division by zero.
- [x] Supports integers, decimals, and negative numbers.
- [x] Uses Android resources for strings, colours, dimensions, theme values, and a vector drawable icon.
- [x] Uses a clean light theme with blue primary colour and red error colour.
- [x] Shows inline validation errors in the input fields.
- [x] Shows a prominent result card.
- [x] Arranges operation buttons in a 2x2 grid.
- [x] Shows a visible selected operation state after a successful calculation.
- [x] Clear button resets both inputs, errors, selected operation, and result.
- [x] Keeps calculation logic separate in `CalculatorEngine`.
- [x] Includes local unit tests for calculator logic.

## 3. Screenshots To Capture

- Initial screen.
- Successful Add calculation.
- Successful Subtract or Multiply calculation.
- Successful Divide calculation.
- Empty input validation.
- Invalid input validation.
- Divide by zero validation.
- Clear button after reset.

## 4. Important Code Snippets For Logbook Section 2.2

- Input validation method: `validateInput(...)` in `app/src/main/java/com/example/project_exercise_1/MainActivity.kt`.
- Calculation method: `CalculatorEngine.calculate(...)` in `app/src/main/java/com/example/project_exercise_1/CalculatorEngine.kt`.
- Result formatting method: `CalculatorEngine.formatNumber(...)` in `app/src/main/java/com/example/project_exercise_1/CalculatorEngine.kt`.
- Operation button click handling: `calculate(operation: CalculatorOperation)` in `app/src/main/java/com/example/project_exercise_1/MainActivity.kt`.
- Resource usage examples:
  - Text resources in `app/src/main/res/values/strings.xml`.
  - Colour resources in `app/src/main/res/values/colors.xml`.
  - Dimension resources in `app/src/main/res/values/dimens.xml`.
  - App theme in `app/src/main/res/values/themes.xml`.
  - Calculator vector icon in `app/src/main/res/drawable/ic_calculator.xml`.

## 5. Why Theme, Style, And Resources Were Used

Android resources keep repeated values and user-facing text outside the Kotlin code. This makes the app easier to maintain, easier to explain in coursework, and more consistent visually. Colours, dimensions, strings, and theme values are defined in resource XML files so the UI uses one shared visual system instead of hardcoded values.

## 6. Why Validation Is Important

Validation prevents the app from crashing or showing misleading results when a user leaves a field empty, types text that is not a number, or attempts to divide by zero. Inline errors also help the user understand exactly which input needs correcting.

## 7. Manual Testing Checklist

- Open the app and confirm the title, subtitle, two input fields, four operation buttons, result card, and Clear button are visible.
- Enter `12` and `4`, tap Add, and confirm `12 + 4 = 16`.
- Enter `12` and `4`, tap Subtract, and confirm `12 - 4 = 8`.
- Enter `2.5` and `1.25`, tap Add, and confirm `2.5 + 1.25 = 3.75`.
- Enter `-4` and `2`, tap Multiply, and confirm `-4 x 2 = -8`.
- Enter `12` and `4`, tap Divide, and confirm `12 ÷ 4 = 3`.
- Leave the first field empty, tap an operation, and confirm the first field shows `Please enter the first number`.
- Leave the second field empty, tap an operation, and confirm the second field shows `Please enter the second number`.
- Enter invalid text such as `abc`, tap an operation, and confirm `Please enter a valid number`.
- Enter `10` and `0`, tap Divide, and confirm `Cannot divide by zero`.
- Tap Clear and confirm both fields, errors, selected operation, and result are reset.

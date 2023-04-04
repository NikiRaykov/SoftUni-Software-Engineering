function subtract() {
    const firstInput = Number(document.getElementById('firstNumber').value);
    const secondInput = Number(document.getElementById('secondNumber').value);
  
    let sum = firstInput - secondInput;
    document.getElementById('result').textContent = sum;
}
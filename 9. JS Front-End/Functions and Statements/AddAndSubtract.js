function calculations(num1, num2, num3) {
    const sum = (a, b) => a + b;
    const subtract = (mySum, num) => mySum - num;

    console.log(subtract(sum(num1, num2), num3));
}

calculations(1,
    17,
    30);
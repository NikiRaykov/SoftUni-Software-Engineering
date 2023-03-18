function solve(value) {
    let sum = 0;

    while (value) {
        sum += value % 10;
        value = Math.floor(value / 10);
    }

    console.log(sum);
}

solve(97561);
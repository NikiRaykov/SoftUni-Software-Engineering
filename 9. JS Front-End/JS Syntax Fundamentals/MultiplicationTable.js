function solve(num) {
    let result = 0;

    for (i = 1; i <= 10; i++) {
        result = num * i;

        console.log(num + " X " + i + " = " + result);
    }
}

solve(2);
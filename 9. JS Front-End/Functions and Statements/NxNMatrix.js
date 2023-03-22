function matrix(number) {
    new Array(number).fill(new Array(number).fill(number))
        .forEach(row => console.log(row));
}

matrix(7);
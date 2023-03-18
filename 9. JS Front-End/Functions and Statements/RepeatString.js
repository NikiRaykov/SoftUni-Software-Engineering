function solve(str, n) {
    let repeatedString = '';

    for (i = 0; i < n; i ++) {
        repeatedString += str;
    }

    console.log(repeatedString);
}

solve("abc", 3);
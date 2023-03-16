function solve(year) {
    if ((year % 4 == 0) && (0 != year % 100) || (0 == year % 400)) {
        console.log("yes");
    } else {
        console.log("no");
    }
}

solve(1984);
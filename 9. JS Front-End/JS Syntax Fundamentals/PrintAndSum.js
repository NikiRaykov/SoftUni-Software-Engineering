function solve(startNum, endNum) {
    let sum = 0;
    let s = '';
    for (i = startNum; i <= endNum; i ++) {
        s += `${i} `;
        
        sum += i;
    }

    console.log(s);

    console.log("Sum: " + sum);
}

solve(0, 26);
function rotate(arr, n) {

    for (let index = 0; index < n; index++) {
        arr.push(arr.shift());
    }

    console.log(arr.join(' '))
}

rotate([32, 21, 61, 1], 4);
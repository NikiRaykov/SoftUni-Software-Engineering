function evenAndOddDiff(array) {
    let numArray = array.map(i => Number(i));

    let sumEven = 0; let sumOdd = 0;
    
    for (let index = 0; index < numArray.length; index++) {
        if (numArray[index] % 2 === 0) {
            sumEven += numArray[index];
        } else {
            sumOdd += numArray[index];
        }
    }
    
    console.log(sumEven - sumOdd);
}

evenAndOddDiff([1,2,3,4,5,6])
evenAndOddDiff([3,5,7,9])
evenAndOddDiff([2,4,6,8,10])
function findEvenAndOddNumbers(num) {
    let evenDigit = [];
    let oddDigit = [];
    let lastDigit;

    while (num) {
        
        lastDigit = num % 10;

        if (lastDigit % 2 == 0) {
            evenDigit.push(lastDigit);
        } else {
            oddDigit.push(lastDigit);
        }

        num = Math.floor(num / 10);
    }

    console.log(findSumOfOddNumber(oddDigit), findSumOfEvenNumber(evenDigit));
}

function findSumOfEvenNumber(evenDigit) {
    let sum = 0;
    evenDigit.map(x => sum +=x);

    console.log('Even sum = ' + sum);
}

function findSumOfOddNumber(oddDigit) {
    let sum = 0;
    oddDigit.map(x => sum +=x);

    console.log('Odd sum = ' + sum);
}

findEvenAndOddNumbers(3495892137259234);
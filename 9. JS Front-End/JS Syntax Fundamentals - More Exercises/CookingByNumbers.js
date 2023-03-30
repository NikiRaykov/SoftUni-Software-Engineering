function cook(num, op1, op2, op3, op4, op5) {
    let number = Number(num);

    const list = [op1, op2, op3, op4, op5];

    for (let index = 0; index < list.length; index++) {
       if (list[index] === 'chop') {
            number = number / 2;
            console.log(number);
        } else if (list[index] === 'dice') {
            number = Math.sqrt(number);
            console.log(number);
        } else if (list[index] === 'spice') {
            number = number + 1
            console.log(number);
        } else if (list[index] === 'bake') {
            number = number * 3;
            console.log(number);
        } else if (list[index] === 'fillet') {
            number = number - (number * 0.20);
            console.log(number);
        }
        } 
}

cook('9', 'dice', 'spice', 'chop', 'bake', 'fillet')
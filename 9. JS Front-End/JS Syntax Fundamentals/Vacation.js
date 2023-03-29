function solve(numberOfPeople, typeOfGruop, dayOfWeek) {
    let totaPrice = 0;
    let discount = 0;
    let price = 0;

    switch (typeOfGruop) {
        case 'Students':
            if (dayOfWeek === 'Friday') {
                if (numberOfPeople >= 30) {
                    totaPrice = numberOfPeople * 8.45;
                    discount = totaPrice * (15 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 8.45;
                }
            } else if (dayOfWeek === 'Saturday') {
                if (numberOfPeople >= 30) {
                    totaPrice = numberOfPeople * 9.80;
                    discount = totaPrice * (15 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 9.80;
                }
            } else if (dayOfWeek === 'Sunday') {
                if (numberOfPeople >= 30) {
                    totaPrice = numberOfPeople * 10.46;
                    discount = totaPrice * (15 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 10.46;
                }
            }
            break;
        case 'Business':
            if (dayOfWeek === 'Friday') {
                if (numberOfPeople >= 100) {
                    totaPrice = numberOfPeople * 10.90;
                    discount = (numberOfPeople * 10.90) / 10;
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 10.90;
                }
            } else if (dayOfWeek === 'Saturday') {
                if (numberOfPeople >= 100) {
                    totaPrice = numberOfPeople * 15.60;
                    discount = (numberOfPeople * 15.60) / 10;
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 15.60;
                }
            } else if (dayOfWeek === 'Sunday') {
                if (numberOfPeople >= 100) {
                    totaPrice = numberOfPeople * 16;
                    discount = (numberOfPeople * 16) / 10;
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 16;
                }
            }
            break;
        case 'Regular': 
            if (dayOfWeek === 'Friday') {
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    totaPrice = numberOfPeople * 15;
                    discount = totaPrice * (5 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 15;
                }
            } else if (dayOfWeek === 'Saturday') {
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    totaPrice = numberOfPeople * 20;
                    discount = totaPrice * (5 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 20;
                }
            } else if (dayOfWeek === 'Sunday') {
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    totaPrice = numberOfPeople * 22.50;
                    discount = totaPrice * (5 / 100);
                    price = totaPrice - discount;
                } else {
                    price = numberOfPeople * 22.50;
                }
            }   
            break;   
    }

    console.log(`Total price: ${price.toFixed(2)}`)
}

solve(30,
    "Students",
    "Sunday")

solve(40,
    "Regular",
    "Saturday")
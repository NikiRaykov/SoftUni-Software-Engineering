function solve (product, quantity) {
    let price = 0;

    switch (product) {
        case "water":
            price = quantity * 1.00;
            console.log(price.toFixed(2));
            break;
        case "coffee":
            price = quantity * 1.50;
            console.log(price.toFixed(2));
            break;
        case "coke":
            price = quantity * 1.40;
            console.log(price.toFixed(2));
            break;
        case "snacks":
            price = quantity * 2.00;
            console.log(price.toFixed(2));
            break;
    }
}

solve("coffee", 2);
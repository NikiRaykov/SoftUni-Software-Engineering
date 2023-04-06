function shoppingList(input) {
    let list = input.toString().split(',');
    let products = list[0].split('!');
   

    for (let line of input) {
        if (line === 'Go Shopping') {
            break;
        }
        
        let commandsTokens = line.split(' ');
        let command = commandsTokens[0];
        let product = commandsTokens[1];


        switch(command) {
            case 'Urgent':
                if (!products.includes(product)) {
                    products.unshift(product);
                } 
                break;
            case 'Unnecessary':
                if (products.includes(product)) {
                    delete products[products.indexOf(product)];
                }
                break;
            case 'Correct':
                let newProduct = commandsTokens[2];
                    if (products.includes(product)) {
                        products[products.indexOf(product)] = newProduct;
                    }
                    break;   
            case 'Rearrange':
                    if (products.includes(product)) {
                        delete products[products.indexOf(product)];
                        products.push(product);
                    }
                    break;           
        }
    }

    console.log(products.join(', '));
    //Bread, Salt, Banana, Milk
    
}

shoppingList((["Milk!Pepper!Salt!Water!Banana",

"Urgent Salt",

"Unnecessary Grapes",

"Correct Pepper Onion",

"Rearrange Grapes",

"Correct Tomatoes Potatoes",

"Go Shopping!"]))
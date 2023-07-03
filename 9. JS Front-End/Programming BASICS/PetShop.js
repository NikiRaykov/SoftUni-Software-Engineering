function petShop(input) {

    let dogFoodPrice = 2.50;
    let catFoodPrice = 4;

    let packsOfDogFood = Number(input[0]);
    let packsOfCatFood = Number(input[1]);

    let totalDogFood = packsOfDogFood * dogFoodPrice;
    let totalCatFood = packsOfCatFood * catFoodPrice;

    let totalAmount = totalDogFood + totalCatFood;

    console.log(totalAmount + " lv.")
}

petShop(["5 ",
"4 "])
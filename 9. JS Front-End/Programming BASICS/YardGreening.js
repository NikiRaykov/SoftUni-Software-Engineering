function greening(input) {

    let priceForSquareMeter = 7.61;

    let metersForGreening = Number(input[0]);

    let totalPrice = metersForGreening * priceForSquareMeter;

    let discount = (totalPrice * 18) / 100;

    let totalPriceWithDiscount = totalPrice - discount;

    console.log(`The final price is: ${totalPriceWithDiscount} lv.`)
    console.log(`The discount is: ${discount} lv.`)
}

greening(["550"])
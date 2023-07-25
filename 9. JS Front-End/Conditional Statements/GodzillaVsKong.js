function godzillaVsKong(input) {

    let movieBudget = Number(input[0]);
    let extras = Number(input[1]);
    let extraxClothesPrice = Number(input[2]);
    
    let decoPrice = movieBudget * 0.10;

    let moviePrice;

    if (extras > 150) {
        let clothesPrice = extras * extraxClothesPrice;

        let clothesPriceWithDiscount = clothesPrice - (clothesPrice * 0.10);

        moviePrice = decoPrice + clothesPriceWithDiscount;

    } else {
        let clothesPrice = extras * extraxClothesPrice;
        moviePrice = decoPrice + clothesPrice;
    }
    

    if (moviePrice <= movieBudget) {
        console.log("Action!");
        console.log(`Wingard starts filming with ${(movieBudget - moviePrice).toFixed(2)} leva left.`);
    } else {
        console.log("Not enough money!");
        console.log(`Wingard needs ${(moviePrice - movieBudget).toFixed(2)} leva more.`)
    }

}

godzillaVsKong(["9587.88",
"222",
"55.68"])
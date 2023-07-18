function toyShop(input) {
    let puzzlePrice = 2.60;
    let talkingDollPrice = 3;
    let teddyBearPrice = 4.10;
    let minionPrice = 8.20;
    let truckPrice = 2;

    let vacationPrice = Number(input[0]);
    let puzzles = Number(input[1]);
    let dolls = Number(input[2]);
    let bears = Number(input[3]);
    let minions = Number(input[4]);
    let trucks = Number(input[5]);

    let price = (puzzlePrice * puzzles) + (talkingDollPrice * dolls)
     + (teddyBearPrice * bears) + (minionPrice * minions) + (truckPrice * trucks);

    let toysOrdered = puzzles + dolls + bears + minions + trucks;

    let finalPrice;

    if (toysOrdered >= 50) {
        finalPrice = price - (price * 0.25);
        finalPrice = finalPrice - (finalPrice * 0.10);

        if (finalPrice >= vacationPrice) {
            console.log(`Yes! ${Math.abs((finalPrice - vacationPrice)).toFixed(2)} lv left.`);
        } else {
            console.log(`Not enough money! ${Math.abs((vacationPrice - finalPrice).toFixed(2))} lv needed.`)
        }
    } else {
        finalPrice = price - (price * 0.10);

        if (finalPrice >= vacationPrice) {
            console.log(`Yes! ${Math.abs((finalPrice - vacationPrice)).toFixed(2)} lv left.`);
        } else {
            console.log(`Not enough money! ${Math.abs((vacationPrice - finalPrice).toFixed(2))} lv needed.`)
        }
    }
}

toyShop(["40.8",
"20",
"25",
"30",
"50",
"10"])
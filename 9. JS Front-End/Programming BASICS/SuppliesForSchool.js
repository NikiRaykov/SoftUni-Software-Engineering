function supplies(input) {

    let penPrice = 5.80;
    let markerPrice = 7.20;
    let detergentPricePerLiter = 1.20;

    let pensPackages = Number(input[0]);
    let markersPackages = Number(input[1]);
    let detergentLiters = Number(input[2]);
    let discount = Number(input[3]);
    
    let pensFinalPrice = penPrice * pensPackages;
    let markersFinalPrice = markerPrice * markersPackages;
    let detergentFinalPrice = detergentPricePerLiter * detergentLiters;

    let finalPriceWithoutDiscout = pensFinalPrice + markersFinalPrice + detergentFinalPrice;
    let finalPriceWithDiscount = finalPriceWithoutDiscout  - (finalPriceWithoutDiscout * discount / 100);

    console.log(finalPriceWithDiscount);
}

supplies(["4 ",
"2 ",
"5 ",
"13 "])
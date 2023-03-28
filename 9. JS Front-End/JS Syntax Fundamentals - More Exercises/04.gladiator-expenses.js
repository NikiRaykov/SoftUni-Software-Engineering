function gladiator(lostFightCount, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let aureus = 0;
    let brokenHelmetCount = 0;
    let brokenSwordCount = 0;
    let brokenShieldCount = 0;

    for (let index = 1; index <= lostFightCount; index++) {
       if (index % 2 === 0) {
        brokenHelmetCount++;
        aureus += helmetPrice;    
       }
       
       if (index % 3 === 0) {
        brokenSwordCount++;
        aureus += swordPrice;
        }

        if (index % 2 === 0 && index % 3 === 0) {
            brokenShieldCount++;
            aureus += shieldPrice;
            if (brokenShieldCount % 2 == 0) {
                aureus += armorPrice;
            }
        }
    }

   console.log(`Gladiator expenses: ${aureus.toFixed(2)} aureus`)
}

gladiator(23,
    12.50,
    21.50,
    40,
    200)
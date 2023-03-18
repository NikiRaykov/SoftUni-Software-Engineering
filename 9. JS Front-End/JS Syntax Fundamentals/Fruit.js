function calculateFruitCost(fruitType, weightInGrams, pricePerKilo) {
    // convert weight to kilograms
    const weightInKilo = weightInGrams / 1000;
    
    // calculate total cost
    const totalCost = weightInKilo * pricePerKilo;
    
    // return formatted string
    console.log(`I need $${totalCost.toFixed(2)} to buy ${weightInKilo.toFixed(2)} kilograms ${fruitType}.`);
  }
  
  calculateFruitCost('orange', 2500, 1.80)
  
function checkProductSign(numOne, numTwo, numThree) {
    let negativeCount = 0;
    if (numOne < 0) {
      negativeCount++;
    }
    if (numTwo < 0) {
      negativeCount++;
    }
    if (numThree < 0) {
      negativeCount++;
    }
    if (negativeCount % 2 === 0) {
      console.log("Positive");
    } else {
        console.log("Negative");
    }
  }

  checkProductSign(-6,
    -12,
     14)
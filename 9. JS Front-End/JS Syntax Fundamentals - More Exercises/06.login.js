function login(input) {
    let username = input[0];

    let blockedCount = 0;

    for (let index = 1; index < input.length; index++) {
       var splitString = input[index].split('');
       var reverseArray = splitString.reverse();
       var joinArray = reverseArray.join('');

       if (blockedCount >= 4) {
        console.log(`User ${username} blocked!`)
        return;
    }

       if (username === joinArray) {
        console.log(`User ${username} logged in.`);
       } else {
        console.log(`Incorrect password. Try again.`);
        blockedCount++;
       }
    }
}

login(['sunny','rainy','cloudy','sunny','not sunny'])
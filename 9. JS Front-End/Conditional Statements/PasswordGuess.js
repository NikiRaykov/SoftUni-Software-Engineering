function passwordGuess(input) {

    let secretPass = "s3cr3t!P@ssw0rd";

    let password = input[0];

    if (password == secretPass) {
        console.log("Welcome")
    } else {
        console.log("Wrong password!")
    }
}

passwordGuess(["s3cr3t!P@ssw0rd"])
function passValidator(password) {
    const isValidLenght = (pass) => pass.length >= 6 && pass.length <= 10;
    const hasOnlyLettersAndDigits = (pass) => /^[A-Za-z0-9]*$/.test(pass);
    const hsaMoreThanTwoDigits = (pass) => [...pass.matchAll(/\d/g)].length >= 2;

    let passIsValid = true;

    if (!isValidLenght(password)) {
        console.log("Password must be between 6 and 10 characters");
        passIsValid = false;
    }

    if (!hasOnlyLettersAndDigits(password)) {
        console.log("Password must consist only of letters and digits");
        passIsValid = false;
    }

    if (!hsaMoreThanTwoDigits(password)) {
        console.log("Password must have at least 2 digits");
        passIsValid = false;
    }

    if (passIsValid) {
        console.log("Password is valid")
    }
}

passValidator('Pa$s$s');
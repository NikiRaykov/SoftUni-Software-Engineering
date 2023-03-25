function personInfo(name, lastName, hairColor) {
    let person = {name, lastName, hairColor};
    const myJson = JSON.stringify(person);

    console.log(myJson);
}

personInfo('George', 'Jones', 'Brown')
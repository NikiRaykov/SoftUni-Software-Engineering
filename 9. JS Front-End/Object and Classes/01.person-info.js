function personInfo (firstName, lastName, age) {
    age = Number(age);
    let person = { firstName: firstName, lastName: lastName, age: age }

    return person;
}

console.log(personInfo("George", 
"Smith",
"18"))
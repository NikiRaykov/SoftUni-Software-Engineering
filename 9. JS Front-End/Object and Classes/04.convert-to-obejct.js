function solve(jsonStr) {
    let person = JSON.parse(jsonStr);

    for (const property in person) {
        console.log(`${property}: ${person[property]}`);
    }
}

solve('{"name": "Peter", "age": 35, "town": "Plovdiv"}');
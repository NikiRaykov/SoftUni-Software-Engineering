function solve(input) {
    let person = {};

    for (const line of input) {
        let [ name ] = line.split(', ');
        person[name] = person;
    }

    for (const key in person) {
        console.log(`Name: ${key} -- Personal Number: ${key.length}`)
    }
}

solve([
    'Samuel Jackson',
    'Will Smith',
    'Bruce Willis',
    'Tom Holland'
    ])
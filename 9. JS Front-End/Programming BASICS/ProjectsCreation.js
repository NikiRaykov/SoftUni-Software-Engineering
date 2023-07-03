function projects(input) {

    let architectName = input[0];

    let numberOfProjects = Number(input[1]);

    let hoursNeeded = numberOfProjects * 3;

    console.log(`The architect ${architectName} will need ${hoursNeeded} hours to complete ${numberOfProjects} project/s.`)
}

projects(["George ",
"4 "])
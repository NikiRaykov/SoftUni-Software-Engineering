function vacationBookList(input) {

    let pagesInTheBook = Number(input[0]);
    let pagesReadPerHour = Number(input[1]);
    let daysToReadTheBook = Number(input[2]);

    let hoursToFinishTheBook = pagesInTheBook / pagesReadPerHour;

    let neededHoursPerDayToFinishTheBook = hoursToFinishTheBook / daysToReadTheBook;

    console.log(neededHoursPerDayToFinishTheBook);
}

vacationBookList(["212 ",
"20 ",
"2 "])
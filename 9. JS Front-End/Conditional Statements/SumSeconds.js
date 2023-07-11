function seconds(input){

    let firstRacer = Number(input[0]);
    let secondRacer = Number(input[1]);
    let thirdRacer = Number(input[2]);

    let totalSeconds = firstRacer + secondRacer + thirdRacer;

    let minutes = Math.floor(totalSeconds / 60);
    let seconds = totalSeconds % 60;

    if (seconds < 10) {
        console.log(minutes + ':' + 0 + seconds);
    } else {
        console.log(minutes + ':' + seconds);
    }
}

seconds((["50",
"50",
"49"]))

// Трима спортни състезатели финишират за някакъв брой секунди (между 1 и 50). Да се напише функция, която получава три аргумента - 
// секунди и пресмята сумарното им време във формат "минути:секунди". 
// Секундите да се изведат с водеща нула (2  "02", 7  "07", 35  "35").
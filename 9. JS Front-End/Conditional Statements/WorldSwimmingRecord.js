function swimmingRecord(input) {

    let recordInSeconds = Number(input[0]);
    let meters = Number(input[1]);
    let timeToSwimOneMeterInSeconds = Number(input[2]);

    let seconds = meters * timeToSwimOneMeterInSeconds;
    let addedSeconds = Math.floor((meters / 15)) * 12.5;

    let totalSeconds = seconds + addedSeconds;

    if (recordInSeconds < totalSeconds) {
        console.log(`No, he failed! He was ${Math.abs(recordInSeconds - totalSeconds).toFixed(2)} seconds slower.`)
    } else {
        console.log(`Yes, he succeeded! The new world record is ${totalSeconds.toFixed(2)} seconds.`)
    }
}

swimmingRecord(["55555.67",
"3017",
"5.03"])
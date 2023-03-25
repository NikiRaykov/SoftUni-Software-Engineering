function convertToUpperCase(string){

    // use regular expression to extract all words from the string
    let words = string.match(/\b\w+\b/g);

    // use map function to convert each word to upper case
    let upperCaseWords = words.map(word => word.toUpperCase());

    // join the converted words with comma and space separator
    let result = upperCaseWords.join(", ");

    console.log(result);
}

convertToUpperCase('Hi, how are you?');
function extractText() {
    const listItems = Array.from(document.querySelectorAll('#items > li'));

    const result = document.getElementById('result');

    listItems.forEach((li) => {
        result.textContent += li.textContent + '\n';
    })
}
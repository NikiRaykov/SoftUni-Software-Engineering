function addItem() {
    let ulContainter = document.getElementById('items');
    let input = document.getElementById('newItemText');
    
    const newLi = document.createElement('li');
    newLi.textContent = input.value;

    ulContainter.appendChild(newLi);
    input.value = '';
}
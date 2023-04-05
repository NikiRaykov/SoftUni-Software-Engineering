function addItem() {
    const select = document.getElementById('menu');
    const newItemTextInput = document.getElementById('newItemText');
    const newItemValueInput = document.getElementById('newItemValue');
    
    const newItemTextValue = newItemTextInput.value;
    const newItemValue = newItemValueInput.value;

    let option = document.createElement('OPTION');
    option.textContent = newItemTextValue;
    option.value = newItemValue;
    select.appendChild(option);    

    newItemTextInput.value = '';
    newItemValueInput.value = '';
}

/*Your task is to take values from input fields with ids "newItemText" and "newItemValue". 
Then you should create and append an <option> to the <select> with id "menu". 
In the end you should clear both input fields!
*/
function solve() {

  // We take all text areas from the documents and put them into array
  const [ generateTextArea, buyTextArea ] = Array.from(document.getElementsByTagName('textarea'));

  // We take all buttons
  const [ generateBtn, buyBtn ] = Array.from(document.getElementsByTagName('button'));

  const tBody = document.querySelector('.table > tbody');

  // We atach click event to generate btn
  generateBtn.addEventListener('click', generateHandler);
  buyBtn.addEventListener('click', buyHandler);

  function generateHandler() {
    const data = JSON.parse(generateTextArea.value);
  
    for (const { img, name, price, decFactor } of data) {


      const tableRow = createElement('tr', '', tBody);
      const firstColumnTd = createElement('td', '', tableRow);
      createElement('img', '', firstColumnTd, '', '', { src: img });

      const secondColumnTd = createElement('td', '', tableRow);
      createElement('p', name, secondColumnTd);

      const thirdColumnTd = createElement('td', '', tableRow);
      createElement('p', price, thirdColumnTd);

      const fourthColumnTd = createElement('td', '', tableRow);
      createElement('p', decFactor, fourthColumnTd);

      const fifthColumnTd = createElement('td', '', tableRow);
      createElement('input', '', fifthColumnTd, '', '', { type: 'checkbox' });
    }
  }

  function buyHandler() {
    const checkedInputs = Array.from(document.querySelectorAll('tbody tr input:checked'));
    let boughtItems = [];
      let totalPrice = 0;
      let totalDecFactor = 0;

    for (const input of checkedInputs) {
      const tableRow = input.parentElement.parentElement;
      const [ _firstColumn, secondColumn, thirdColumn, fourthColumn ] = Array.from(tableRow.children);
      let item = secondColumn.children[0].textContent;
      boughtItems.push(item);
      let currentPrice = Number(thirdColumn.children[0].textContent);
      totalPrice += currentPrice;
      let currentDecFactor = Number(fourthColumn.children[0].textContent);
      totalDecFactor += currentDecFactor;
    }

    buyTextArea.value += `Bought furniture: ${boughtItems.join(', ')}\n`;
    buyTextArea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
    buyTextArea.value += `Average decoration factor: ${totalDecFactor / checkedInputs.length}`;

  }

  function createElement(type, content, parentNode, id, classes, attributes) {
    const htmlElement = document.createElement(type);
   
      if (content && type !== 'input') {
        htmlElement.textContent = content;
      }
  
      if (content && type === 'input') {
        htmlElement.value = content;
      }
  
    if (id) {
      htmlElement.id = id;
    }
  
    if (classes) {
      htmlElement.classList.add(...classes);
    }
  
    if (attributes) {
      for (const key in attributes) {
        htmlElement.setAttribute(key, attributes[key]);
      }
    }
  
  
    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }
  
    return htmlElement;
  }
}

/*You will be given some furniture as an array of objects. Each object will have a name, a price, and a decoration factor. 
When the ["Generate"] button is clicked, add a new row to the table for each piece of furniture with image, name,
 price, and decoration factor (code example below). 
When the ["Buy"] button is clicked, get all checkboxes that are marked and show in the result textbox the names of 
the piece of furniture that were checked, separated by a comma and single space 
(", ") in the following format: "Bought furniture: {furniture1}, {furniture2}…".
On the next line, print the total price in the format: 
"Total price: {totalPrice}" (formatted to the second decimal point). 
Finally, print the average decoration factor in the format: "Average decoration factor: {decFactor}" */
function create(words) {
   const content = document.getElementById('content');
  
   // We loop through the String array input
   for (const word of words) { 
      const newDiv = document.createElement('div'); // We create new div using DOM api
      
      const newParagraph = document.createElement('p'); // We create new paragraph

      newParagraph.textContent = word; // We set the text in the paragraph to the word

      newParagraph.style.display = 'none'; // We hide the text content in the paragraph 

      newDiv.appendChild(newParagraph); // We append the paragraph inside the div section

      content.appendChild(newDiv); // We append the div into the whole content

      // We use anonymous function 
      newDiv.addEventListener('click', () => {
         newParagraph.style.display = 'block';
      });
   }

}



/*
You will receive an array of strings. For each string, create a div with a paragraph with the 
string in it. Each paragraph is initially hidden (display:none). 
Add a click event listener to each div 
that displays the hidden paragraph. Finally, you should append all 
divs to the element with an id "content".
*/
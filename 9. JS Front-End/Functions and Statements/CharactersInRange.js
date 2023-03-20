function charactersInRange(firstChar, secondChar) {
    const getFirstCharAsciiCode = (char) => char.charCodeAt(0);

   let firstCharAscii = getFirstCharAsciiCode(firstChar);
   let secondCharAscii = getFirstCharAsciiCode(secondChar);
    
   let minAscii = Math.min(firstCharAscii, secondCharAscii);
   let maxAscii = Math.max(firstCharAscii, secondCharAscii);
   let chars = [];

   for (let index = minAscii + 1; index < maxAscii; index ++) {
        chars.push(String.fromCharCode(index));
   }

   return chars.join(' ');
}

console.log(charactersInRange('#',
':'))
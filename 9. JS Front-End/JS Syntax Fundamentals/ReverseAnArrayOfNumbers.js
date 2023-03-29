function reverseNumber(n, array) {
   let newArray = array.slice(0, n).reverse().join(' ');

   console.log(newArray)
}

reverseNumber(2, [66, 43, 75, 89, 47])
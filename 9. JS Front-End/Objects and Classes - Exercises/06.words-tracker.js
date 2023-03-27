function findWords(input) {
     let wordsNeeded = input.shift().split(' ');

     let words = {};

     for (const word of wordsNeeded) {
          let count = input.filter((w) => w === word).length;
          words[word] = count;
     }

     let sortedWords = Object.entries(words)
          .sort((wordA, wordB) => {
               let [ _nameA, countA ] = wordA;
               let [ _nameB, countB ] = wordB;
               
               return countB - countA;
          });

          for (const [ word, count ] of sortedWords) {
               console.log(`${word} - ${count}`);
          }
}

findWords([
     'this sentence', 
     'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
     ])

findWords([
     'is the', 
     'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence'])     
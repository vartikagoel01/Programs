const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Enter a sentence: ', function(sentence) {
  const reversedSentence = reverseWords(sentence);
  console.log('Reversed Sentence:', reversedSentence);

  rl.question('Enter numbers separated by spaces for sorting (e.g., 5 2 8 1 9 3): ', function(inputNumbers) {
    const numbers = inputNumbers.split(' ').map(function(str) {
      return parseInt(str);
    });
    const sortedDescending = sortDescending(numbers);
    console.log('Sorted Descending:', sortedDescending);

    rl.close();
  });
});

function reverseWords(sentence) {
  const words = sentence.split(' ');
  const reversedWords = words.map(function(word) {
    return reverseString(word);
  });
  return reversedWords.join(' ');
}

function reverseString(str) {
  let reversed = '';
  for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
  }
  return reversed;
}

function sortDescending(arr) {
  return arr.sort(function(a, b) {
    return b - a;
  });
}

   

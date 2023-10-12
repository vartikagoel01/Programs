function reverseWords(sentence) {
    return sentence.split(/\s+/).map(reverseString).join(' ');
   }
   function reverseString(str) {
    return str.split('').reverse().join('');
   }
   const inputSentence = prompt("Enter a sentence:");
   const reversedSentence = reverseWords(inputSentence);
   console.log("Reversed Sentence:", reversedSentence);
   // B. Perform sorting of an array in descending order.
   function descendingSort(arr) {
    return arr.slice().sort((a, b) => b - a);
   }
   const inputArray = prompt("Enter an array of numbers separated by spaces (e.g., 5 2 9 1 5 6):")
    .split(' ')
    .map(Number);
   if (Array.isArray(inputArray) && inputArray.every(Number.isFinite)) {
    const sortedArray = descendingSort(inputArray);
    console.log("Sorted Array in Descending Order:", sortedArray);
   } else {
    console.log("Invalid input. Please enter valid numbers separated by spaces.");
   }
   

public static String scrambleWord(String word){
  /* To be implemented in part (a) */
  for(int i=0;i<word.length - 1;i++) //i only want to go to the second to last letter, if I go any further there will be bounds errors on checking the letter after
  {
    //create a new string to be the new word
    String newWord = "";
    //if the current letter AND the next letter meet the criteria
    if(word.equals(""))
      return newWord; //since it can be an empty string, eliminate all bounds errors before they even happen
    else if(word.substring(i,i+1).equals("A") && !word.substring(i+1,i+2).equals("A")) //all letters are uppercase
      newWord = newWord + word.substring(i+1,i+2) + word.substring(i,i+1);
    else //there's nothing to worry about
      newWord = newWord + word.substring(i,i+1);
  }

  return newWord;
}


public static void scrambleOrRemove(List<String> wordList){
  /* To be implemented in part (b) */
  //tradition for loop because I DO care about position, and I need to remove things
  for(int i=wordList.length-1;i>=0;i--)
  {
    //worst case scenario - I need to remove the string
    if(wordList.get(i).equals(scrambleWord(wordList.get(i)))) //the word is equal the the scrambled word, a.k.a. nothing was scrambled
      wordList.remove(i); //get rid of the word
    else //if I can just set the space equal to the scrambled version of the word at that space
      wordList.set(i, scrambleWord(wordList.get(i)));
  }

  //void method so no return line here
}

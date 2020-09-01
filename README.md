# AsyncTask Implementaion  

1.You are provided with a HeavyWork class that contains a static methodvgetArrayNumbers( int n). This method takes a long time to execute.  
Import the provided Java file by simply dragging the file into the src folder under your project package.  
2.We use an AsyncTask to execute this method in a background thread. We do not use the main thread to generate the numbers.  
The UI should be manipulated by the only main thread.  
3.We use a SeekBar to set the complexity of the heavy work. The SeekBar maximum should be set to 10. Also note, the TextView showing the selected complexity number which
is displayed to the right of the “Select Complexity” label, this number should be updated whenever the user moves the SeekBar. The selected number defines the
number n of getArrayNumbers( int n) method in the background AsyncTask.  
4.Tapping on the “Generate Number AsyncTask” button should start the execution of a background AsyncTask and compute the minimum, maximum, and average of all the
numbers returned as an ArrayList by the getArrayNumbers() method. For example, if the complexity was set to 5, the getArrayNumbers() method will return an ArrayList
of 5 numbers. The minimum, maximum, and average of these 5 numbers should be computed and displayed in the TextViews. While these numbers are being generated,

public class Main {
  public static void main(String[] args) {
    
double[ ] data = {10.0, 20.0, 5.0, 15.0, 25.0, 30.0, 8.0};
//create a StatsCalculator object
StatsCalculator myCalculator = new StatsCalculator(data);
 
myCalculator.print();
myCalculator.sortData();
myCalculator.printSorted();
myCalculator.printFiveNumberSummary();
System.out.println("\nThe mean is " + myCalculator.calculateMean());


double[ ] newData = {1,2,3,4,5,6};

//create a StatsCalculator object
StatsCalculator myNewCalculator = new StatsCalculator(newData);

myNewCalculator.print();
myNewCalculator.sortData();
myNewCalculator.printSorted();
myNewCalculator.printFiveNumberSummary();
System.out.println("\nThe mean is " + myNewCalculator.calculateMean());

  
  }
}

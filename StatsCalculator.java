import java.util.Arrays;

public class StatsCalculator {
  // store private array of doubles
  private double[] values;
  // store private array of sorted values
  private double[] sortedValues;
  //store private array of outliers
  private double[] outliers;

  //default contructor: makes an array of size 20 full of 0s
  public StatsCalculator() {
    values = new double[20];
    sortedValues = values;
  }

  //overloaded constructor that sets instance variables equal to the parameter
  public StatsCalculator(double[] param) {
    values = param;
    sortedValues = param;
  }

  //method that finds the outliers and stores them in an array
  public void findOutliers(){
  
  int numOutliers = 0;
  double[] temp = Arrays.copyOf(values, values.length);
  double interquartileRange = this.calculateThirdQuartile() - this.calculateFirstQuartile();
    
    for(double data: values){
      if(data<(this.calculateFirstQuartile()-1.5*interquartileRange) || data>(this.calculateThirdQuartile()+1.5*interquartileRange)){
      numOutliers ++;
      }
    }
    outliers = new double[numOutliers];
  for(int i = 0; i<values.length; i++){
    if(values[i]<(this.calculateFirstQuartile()-1.5*interquartileRange) || values[i]>(this.calculateThirdQuartile()+1.5*interquartileRange)){
      for(int y = 0; y<outliers.length; y++){
        outliers[y]=temp[i];
      }
  }
  }
  }

  //method that sorts the data
  public void sortData() {
  sortedValues = Arrays.copyOf(values, values.length);
  Arrays.sort(sortedValues);
  }

  //method that returns the maximum value 
  public double calculateMax() {
    double maxValue = values[0];
    for (int i = 0; i < values.length; i++) {
      if (values[i] > maxValue) {
        maxValue = values[i];
      }
    }
    return maxValue;
  }

  //method that returns the minimum value
  public double calculateMin() {
    double minValue = values[0];
    for (int i = 0; i < values.length; i++) {
      if (values[i] < minValue) {
        minValue = values[i];
      }
    }
    return minValue;
  }

  //method that returns the first quartile
  public double calculateFirstQuartile() {
    sortData();
    double firstQuartile = sortedValues[(int) (sortedValues.length * 0.25)];
    return firstQuartile;
  }

  //method that returns the third quartile
  public double calculateThirdQuartile() {
    sortData();
    double thirdQuartile = sortedValues[(int) (sortedValues.length * 0.75)];
    return thirdQuartile;
  }

  //method that returns the median
  public double calculateMedian() {
    sortData();
    double median = 0;
    if (sortedValues.length % 2 == 0) {
      median = sortedValues[(sortedValues.length) / 2];
    } else {
      median = sortedValues[(sortedValues.length - 1) / 2];
    }
    return median;
  }

  //method that returns the sum
  public double calculateSum() {
    double valuesSum = 0;
    for (int i = 0; i < values.length; i++) {
      valuesSum += values[i];
    }
    return valuesSum;
  }

  //method that returns the mean
  public double calculateMean() {
    double mean = calculateSum() / values.length;
    return mean;
  }

  //method that prints data
  public void print() {
    System.out.print("Your data is: ");
    for (double unsorted : values) {
      System.out.print(unsorted + " ");
    }
    System.out.println();
  }

  //method that prints sorted data
  public void printSorted() {
    System.out.print("Your sorted data is: ");
    sortData();
    for (double sorted : sortedValues) {
      System.out.print(sorted + " ");
    }
    System.out.println();
  }

  //method that prints outlier array
  public void printOutliers(){
    System.out.print("Your outliers are: ");
    findOutliers();
    for(double outs: outliers){
      System.out.print(outs + " ");
    }
    System.out.println();
  }

  //method that prints a five number summary
  public void printFiveNumberSummary(){
    System.out.println("The five number summary is: ");
    System.out.println("\tMinimum: " + this.calculateMin());
    System.out.println("\tFirst Quartile: " + this.calculateFirstQuartile());
    System.out.println("\tMedian: " + this.calculateMedian());
    System.out.println("\tThird Quartile: " + this.calculateThirdQuartile());
    System.out.println("\tMaximum: " + this.calculateMax());
    System.out.print("\t");
    this.printOutliers();
  }
  

}

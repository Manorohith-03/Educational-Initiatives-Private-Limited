import java.util.Scanner;

public class WeatherStation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            WeatherData weatherData = new WeatherData();

            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
            weatherData.registerObserver(currentDisplay);

            System.out.println("Enter temperature: ");
            float temperature = scanner.nextFloat();
            System.out.println("Enter humidity: ");
            float humidity = scanner.nextFloat();
            System.out.println("Enter pressure: ");
            float pressure = scanner.nextFloat();

            weatherData.setMeasurements(temperature, humidity, pressure);
        }
    }
}

/* Sample Input:
    Enter temperature: 80
    Enter humidity: 65
    Enter pressure: 30.4
    
Output:
    Current conditions: 80.0F degrees and 65.0% humidity
 */
package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index>=0)
			observers.remove(index);
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++){
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float temperature,  float humidity, float pressure){
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

}

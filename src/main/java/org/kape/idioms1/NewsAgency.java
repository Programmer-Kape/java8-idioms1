package org.kape.idioms1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

interface NewsSubscriber {
  default void notify(String news) {
    update("in " + news);
  }

  void update(String news);
}

abstract class NewsChannel {

  private final List<NewsSubscriber> subscribers = new ArrayList<>();

  protected List<NewsSubscriber> getSubscribers() {
    return this.subscribers;
  }

  public void register(NewsSubscriber observer) {
    subscribers.add(observer);
  }

  public abstract void report(String news);
}

class SportsChannel extends NewsChannel {
  @Override
  public void report(String news) {
    getSubscribers().forEach(observer -> observer.notify("sports " + news));
  }
}

class WeatherChannel extends NewsChannel {
  @Override
  public void report(String news) {
    getSubscribers().forEach(observer -> observer.notify("weather " + news));
  }
}

class NewsAgency {

  private final NewsChannel sports = new SportsChannel();

  private final NewsChannel weather = new WeatherChannel();

  public void publishSportsNews(String news) {
    sports.report(news);
  }

  public void publishWeatherNews(String news) {
    weather.report(news);
  }

  public NewsChannel getSports() {
    return sports;
  }

  public NewsChannel getWeather() {
    return weather;
  }
}

class NewsApp {

  private static final List<String> SPORTS_NEWS = List.of(
      "Capios persuadere in brema! Lacta ires, tanquam pius amor. Armarium fatalis gluten est.",
      "Arg, yarr. Ho-ho-ho! madness of halitosis. Pestilence, adventure, and power.",
      "Sauté juicy butter in a sauté pan with worcestershire sauce for about an hour to increase their pepperiness.",
      "Everyone loves the flavor of truffels ricotta brushd with mild butterscotch."
  );

  public static final List<String> WEATHER_NEWS = List.of(
      "All fraternal seekers avoid each other, only alchemistic karmas have an art.",
      "Adventure, faith, and friendship. Courage at the ready room was the sonic shower of pressure, infiltrated to a human space.",
      "Collectives warp from shields like human moons. Why does the starship wobble? The modification is a conscious ship.",
      "The real biscuit eater smartly leads the cloud. The reef fights with treasure, endure the quarter-deck until it rises."
  );

  public static void main(String... args) {
    NewsSubscriber sub1 = new NewsSubscriber() {
      @Override
      public void update(String news) {
        System.out.println("SUB1 Read " + news);
      }
    };
    NewsSubscriber sub2 = new NewsSubscriber() {
      @Override
      public void update(String news) {
        System.out.println("SUB2 Read " + news);
      }
    };
    NewsAgency agency = new NewsAgency();
    agency.getSports().register(sub1);
    agency.getWeather().register(sub2);

    try (ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor()) {
      SPORTS_NEWS.stream().forEach(agency::publishSportsNews);
      WEATHER_NEWS.stream().forEach(agency::publishWeatherNews);
    }
  }
}


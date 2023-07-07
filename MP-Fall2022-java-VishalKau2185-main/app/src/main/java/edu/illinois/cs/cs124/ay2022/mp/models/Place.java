package edu.illinois.cs.cs124.ay2022.mp.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Model storing information about a place retrieved from the backend server.
 *
 * You will need to understand some of the code in this file and make changes starting with MP1.
 */
@SuppressWarnings("unused")
public final class Place {
  /*
   * The Jackson JSON serialization library that we are using requires an empty constructor.
   * So don't remove this!
   */
  public Place() {}

  public Place(
      final String setId,
      final String setName,
      final double setLatitude,
      final double setLongitude,
      final String setDescription) {
    id = setId;
    name = setName;
    latitude = setLatitude;
    longitude = setLongitude;
    description = setDescription;
  }

  // ID of the place
  private String id;

  public String getId() {
    return id;
  }

  // Name of the person who submitted this favorite place
  private String name;

  public String getName() {
    return name;
  }

  // Latitude and longitude of the place
  private double latitude = 300;

  public double getLatitude() {
    return latitude;
  }

  private double longitude = 300;

  public double getLongitude() {
    return longitude;
  }

  // Description of the place
  private String description;

  public String getDescription() {
    return description;
  }


  public static List<Place> search(final List<Place> places, final String search) {
    // Check if arguments are null
    if (places == null || search == null) {
      throw new IllegalArgumentException();
    }
    // trim given string and make it lowercase
    String tSearch = search.trim();
    tSearch = tSearch.toLowerCase();

    // if either argument is empty return passed list
    if (tSearch.equals("") || places.size() == 0) {
      return places;
    }

    // output list
    List<Place> result = new ArrayList<Place>();

    // loop through each place description
    for (int i = 0; i < places.size(); i++) {
      String des = places.get(i).getDescription();
      des = des.toLowerCase();

      //System.out.println("Description String Before: " + des);

      String newDes = "";
      int ns = 0;
      for (int j = 0; j < des.length(); j++) {
        if (Character.isAlphabetic(des.charAt(j)) || Character.isDigit(des.charAt(j))) {
          newDes += des.charAt(j);
          ns = 0;
        } else if (des.charAt(j) == ' ' && ns == 0) {
          newDes += " ";
          ns = 1;
        } else if (des.charAt(j) == '.' || des.charAt(j) == '!' || des.charAt(j) == '?'
            || des.charAt(j) == ',' || des.charAt(j) == ':' || des.charAt(j) == ';') {
          newDes += "";
        } else if (des.charAt(j) == '/') {
          newDes += " ";
        }
      }

      //System.out.println("Description String After: " + newDes);

      // split description string by whitespace
      String[] array = newDes.split(" ");

      // loop through word array and check if any word equals the target
      for (int k = 0; k < array.length; k++) {
        if (array[k].equals(tSearch)) {
          result.add(places.get(i));
          break;
        }
      }
    }
    return result;
  }
}

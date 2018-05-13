package de.tschritter;

class Bonus {

  static <T, Q> T add(T a, Q b) {
    Object result;
    int intA = 0;
    int intB = 0;
    if (a instanceof String) {
      intA = Integer.parseInt((String) a);
    } else if (a instanceof Integer) {
      intA = (Integer) a;
    }
    if (b instanceof String) {
      intB = Integer.parseInt((String) b);
    } else if (b instanceof Integer) {
      intB = (Integer) b;
    }
    result = intA + intB;
    if (a instanceof String) {
      result = result.toString();
    }
    //noinspection unchecked
    return (T) result;

  }
}

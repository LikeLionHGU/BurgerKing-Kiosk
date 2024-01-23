package kiosk;

import java.util.List;
import java.util.ArrayList;

public class Additional {

  private List<Integer> waitingNumber;

  public void initWaitingNumber() {
    waitingNumber = new ArrayList<>();
    waitingNumber.add(0, 1);
  }

  public Additional() {
    waitingNumber = new ArrayList<>();
    waitingNumber.add(0, 1);
  }

  public int addOrderNumber() {
    int randomNumber;
    boolean checkDuplicate = true;
    randomNumber = (int) (Math.random() * 100) + 1;

    while (checkDuplicate) {
      randomNumber = (int) (Math.random() * 100) + 1;

      if (waitingNumber.contains(randomNumber)) {
        continue;
      } else {
        checkDuplicate = false;
      }
    }

    waitingNumber.add(randomNumber);
    int lastNum = waitingNumber.get(waitingNumber.size() - 1);

    return lastNum;
  }

  public List<Integer> getWaitingNumber() {
    return waitingNumber;
  }
}

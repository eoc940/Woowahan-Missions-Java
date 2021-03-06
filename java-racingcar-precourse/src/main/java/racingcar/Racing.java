package racingcar;

import java.util.*;

public class Racing {

    static final String TRIAL_RESULT = "실행 결과";
    static final String PRINT_WINNERS = "최종 우승자: ";
    static final String DASH = "-";
    static final String SPACE_COLON_SPACE = " : ";
    static final String COMMA_SPACE = ", ";

    Input input = new Input();
    Error error = new Error();

    private List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private void printMove(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print(DASH);
        }
    }

    private int getWinnerPosition(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : carList) {
            carPosition.add(car.getPosition());
        }
        return Collections.max(carPosition);
    }

    private List<String> getWinnersList(List<Car> carList, int winnerPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    // view 클래스로 따로 만들었어야 함

    private void tryOneGame(List<Car> carList) {
        for (Car car : carList) {
            car.tryMove();
            System.out.print(car.getName() + SPACE_COLON_SPACE);
            printMove(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printWinnersName(List<String> winners) {
        System.out.print(PRINT_WINNERS);
        String result = String.join(COMMA_SPACE, winners);
        System.out.println(result);
    }

    private void printRacingGameResult(List<Car> carList, int trial) {
        System.out.println();
        System.out.println(TRIAL_RESULT);
        for (int i = 0; i < trial; i++) {
            tryOneGame(carList);
        }
        List<String> winnersList = getWinnersList(carList, getWinnerPosition(carList));
        printWinnersName(winnersList);
    }

    public void play(Scanner scanner) {
        try {
            List<String> carNameList = input.getCarNameList(scanner);
            error.checkSameCarName(carNameList);
            error.checkCarNameLength(carNameList);
            String trial = input.getTrial(scanner);
            error.checkTrialIsInteger(trial);
            int trialNumber = Integer.parseInt(trial);
            error.checkTrialLessThanOne(trialNumber);
            List<Car> carList = makeCars(carNameList);
            printRacingGameResult(carList, trialNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
        }
    }


}
